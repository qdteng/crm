package cn.com.ylpw.web.crm.base.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfiguration {
  
  private static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
  
  @Bean(name="biAuthorizingRealm")
  public ShiroAuthorizingRealm getBiAuthorizingRealm() {
    return new ShiroAuthorizingRealm();
  }
  
  @Bean(name="lifecycleBeanPostProcessor")
  public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
      return new LifecycleBeanPostProcessor();
  }
  
//  @Bean(name="cacheManager")
//  public org.apache.shiro.cache.MemoryConstrainedCacheManager getMemoryConstrainedCacheManager() {  
//    return new org.apache.shiro.cache.MemoryConstrainedCacheManager();  
//  }
  
  @Bean(name="ehCacheManager")
  public EhCacheManager ehCacheManager(){  
     System.out.println("ShiroConfiguration.getEhCacheManager()");  
     EhCacheManager cacheManager = new EhCacheManager();  
     cacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");  
     return cacheManager;  
 
  }  
  
  
  
  @Bean(name="securityManager")
  public org.apache.shiro.web.mgt.DefaultWebSecurityManager getDefaultWebSecurityManager() {
    org.apache.shiro.web.mgt.DefaultWebSecurityManager defaultWebSecurityManager = new org.apache.shiro.web.mgt.DefaultWebSecurityManager();
    defaultWebSecurityManager.setRealm(getBiAuthorizingRealm());
    defaultWebSecurityManager.setCacheManager(ehCacheManager());
    return defaultWebSecurityManager;
  }
  
  @Bean(name="shiroFilter")
  public org.apache.shiro.spring.web.ShiroFilterFactoryBean getShiroFilterFactoryBean() {
    org.apache.shiro.spring.web.ShiroFilterFactoryBean shiroFilterFactoryBean = new org.apache.shiro.spring.web.ShiroFilterFactoryBean();
    shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
    shiroFilterFactoryBean.setLoginUrl("/login.do");
    shiroFilterFactoryBean.setSuccessUrl("/welcome.do");
    shiroFilterFactoryBean.setUnauthorizedUrl("/error/403.do");
//    filterChainDefinitionMap.put("/**", "anon");
    shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    return shiroFilterFactoryBean;
  }

}
