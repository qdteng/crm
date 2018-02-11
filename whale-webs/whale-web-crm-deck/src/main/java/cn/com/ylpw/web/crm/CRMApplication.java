package cn.com.ylpw.web.crm;

import java.util.HashMap;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import cn.com.ylpw.web.crm.util.IPAddressKowalski;
import cn.com.ylpw.web.crm.util.PropertyFiles;


@EnableEurekaClient
@EnableTransactionManagement // 启动事务
@MapperScan("cn.com.ylpw.web.crm.mapper")
@EnableElasticsearchRepositories
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableRedisHttpSession
public class CRMApplication  extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(CRMApplication.class);
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		try {
			System.out.print("tomcat 启动端口 ：=================>"+IPAddressKowalski.getTomcatPort());
			HashMap<String, Object> props = new HashMap<>();
			props.put("server.port", IPAddressKowalski.getTomcatPort());
			application.properties(props);
			System.setProperty("server.port", IPAddressKowalski.getTomcatPort()+"");
		} catch (Exception e) {
			System.out.println("tomcat 启动端口获取错误...");
			e.printStackTrace();
		}
		
        return application.sources(CRMApplication.class);
    }
	
	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
	    return new Jackson2ObjectMapperBuilderCustomizer() {
	        @SuppressWarnings("deprecation")
			@Override
	        public void customize(Jackson2ObjectMapperBuilder builder) {
	            builder.dateFormat(new ISO8601DateFormat());        
	        }
	    };
	}
    

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CRMApplication.class, args);
	}
	
	@Bean("properyFiles")
	public PropertyFiles propertyFiles() {
	    return  new PropertyFiles();
	}
	
	
	
}
