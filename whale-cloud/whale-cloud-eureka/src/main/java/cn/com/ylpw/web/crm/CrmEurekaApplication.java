package cn.com.ylpw.web.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CrmEurekaApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CrmEurekaApplication.class, args);
	}
	
	
}
