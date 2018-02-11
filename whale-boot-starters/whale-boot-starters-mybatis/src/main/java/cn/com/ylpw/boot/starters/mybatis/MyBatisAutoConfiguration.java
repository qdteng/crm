/**
 *    Copyright 2015-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package cn.com.ylpw.boot.starters.mybatis;

import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.ClassPathMapperScanner;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

/**
 * {@link EnableAutoConfiguration Auto-Configuration} for Mybatis. Contributes a
 * {@link SqlSessionFactory} and a {@link SqlSessionTemplate}.
 *
 * If {@link org.mybatis.spring.annotation.MapperScan} is used, or a
 * configuration file is specified as a property, those will be considered,
 * otherwise this auto-configuration will attempt to register mappers based on
 * the interface definitions in or under the root auto-configuration package.
 *
 * @author Eddú Meléndez
 * @author Josh Long
 * @author Kazuki Shimizu
 * @author Eduardo Macarrón
 */
@org.springframework.context.annotation.Configuration
@ConditionalOnBean(DataSource.class)
@ConditionalOnProperty(prefix = "spring.mybatis", name = "enabled", havingValue = "true", matchIfMissing = true)
public class MyBatisAutoConfiguration {

  private static final Logger logger = LoggerFactory.getLogger(MyBatisAutoConfiguration.class);

    @Bean
	@ConditionalOnMissingBean
	public MyBatisProperties myBatisProperties() {
		return new MyBatisProperties();
	}
  
  
  @Bean
  @ConditionalOnMissingBean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
    SqlSessionFactoryBean factory = new SqlSessionFactoryUpdateConfigurationBean();
    factory.setDataSource(dataSource);
//    factory.setVfs(SpringBootVFS.class);
//    if (StringUtils.hasText(this.myBatisProperties().getConfigLocation())) {
//      factory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//    }
//    Configuration configuration = this.properties.getConfiguration();
//    if (configuration == null && !StringUtils.hasText(this.properties.getConfigLocation())) {
//      configuration = new Configuration();
//    }
//    if (configuration != null && !CollectionUtils.isEmpty(this.configurationCustomizers)) {
//      for (ConfigurationCustomizer customizer : this.configurationCustomizers) {
//        customizer.customize(configuration);
//      }
//    }
//    factory.setConfiguration(configuration);
    
   
//    if (!ObjectUtils.isEmpty(this.interceptors)) {
//      factory.setPlugins(this.interceptors);
//    }
//    if (this.databaseIdProvider != null) {
//      factory.setDatabaseIdProvider(this.databaseIdProvider);
//    }
    if (StringUtils.hasLength(this.myBatisProperties().getTypeAliasesPackage())) {
      factory.setTypeAliasesPackage(this.myBatisProperties().getTypeAliasesPackage());
    }
//    if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
//      factory.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
//    }
    if (!ObjectUtils.isEmpty(this.myBatisProperties().resolveMapperLocations())) {
      factory.setMapperLocations(this.myBatisProperties().resolveMapperLocations());
    }

    // 分页插件
    PageHelper pageHelper = new PageHelper();
    Properties properties = new Properties();
    properties.setProperty("reasonable", "true");
    properties.setProperty("supportMethodsArguments", "true");
    properties.setProperty("returnPageInfo", "check");
    properties.setProperty("params", "count=countSql");
    properties.setProperty("pageSizeZero", "true");
    properties.setProperty("returnPageInfo", "none");
    pageHelper.setProperties(properties);
    factory.setPlugins(new Interceptor[]{ pageHelper  });
    
    if (this.myBatisProperties().getConfigurationProperties() != null) {
        factory.setConfigurationProperties(this.myBatisProperties().getConfigurationProperties());
        logger.info("mybatis ConfigurationProperties : {} " ,this.myBatisProperties().getConfigurationProperties());
     }
    
    return factory.getObject();
  }


  /**
   * This will just scan the same base package as Spring Boot does. If you want
   * more power, you can explicitly use
   * {@link org.mybatis.spring.annotation.MapperScan} but this will get typed
   * mappers working correctly, out-of-the-box, similar to using Spring Data JPA
   * repositories.
   */
  public static class AutoConfiguredMapperScannerRegistrar
      implements BeanFactoryAware, ImportBeanDefinitionRegistrar, ResourceLoaderAware {

    private BeanFactory beanFactory;

    private ResourceLoader resourceLoader;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

      logger.debug("Searching for mappers annotated with @Mapper");

      ClassPathMapperScanner scanner = new ClassPathMapperScanner(registry);

      try {
        if (this.resourceLoader != null) {
          scanner.setResourceLoader(this.resourceLoader);
        }

        List<String> packages = AutoConfigurationPackages.get(this.beanFactory);
        if (logger.isDebugEnabled()) {
          for (String pkg : packages) {
            logger.debug("Using auto-configuration base package '{}'", pkg);
          }
        }
	    
        scanner.setAnnotationClass(Mapper.class);
        scanner.registerFilters();
        scanner.doScan(StringUtils.toStringArray(packages));
      } catch (IllegalStateException ex) {
        logger.debug("Could not determine auto-configuration package, automatic mapper scanning disabled.", ex);
      }
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
      this.beanFactory = beanFactory;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
      this.resourceLoader = resourceLoader;
    }
  }

  /**
   * {@link org.mybatis.spring.annotation.MapperScan} ultimately ends up
   * creating instances of {@link MapperFactoryBean}. If
   * {@link org.mybatis.spring.annotation.MapperScan} is used then this
   * auto-configuration is not needed. If it is _not_ used, however, then this
   * will bring in a bean registrar and automatically register components based
   * on the same component-scanning path as Spring Boot itself.
   */
  @org.springframework.context.annotation.Configuration
  @Import({ AutoConfiguredMapperScannerRegistrar.class })
  @ConditionalOnMissingBean(MapperFactoryBean.class)
  public static class MapperScannerRegistrarNotFoundConfiguration {

    @PostConstruct
    public void afterPropertiesSet() {
      logger.debug("No {} found.", MapperFactoryBean.class.getName());
    }
  }

}
