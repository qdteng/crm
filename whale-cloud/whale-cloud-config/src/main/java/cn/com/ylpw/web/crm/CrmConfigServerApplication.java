package cn.com.ylpw.web.crm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class CrmConfigServerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CrmConfigServerApplication.class, args);
	}
	
	private static final Logger logger = LoggerFactory.getLogger(CrmConfigServerApplication.class);
	 
	
}

