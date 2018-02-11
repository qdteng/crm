/**
 * <p>Title: PayApplication.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016, zj7687362@gmail.com All Rights Reserved. </p>
 * <p>Company: www.jcore.cn</p>
 * @author 张嘉杰
 * @date 2016年12月26日 下午5:13:41
 */
package cn.com.ylpw.web.crm.quarz;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cn.com.ylpw.web.crm.util.RedisUtilBasic;

@EnableScheduling
@EnableTransactionManagement // 启动事务
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableAutoConfiguration
@MapperScan("cn.com.ylpw.web.crm.mapper")
@EnableEurekaClient
public class CRMQuarzCustomerGroupApplication extends SpringBootServletInitializer {

	public static  String  arg =null ;
	private static final Logger log = LoggerFactory.getLogger(CRMQuarzCustomerGroupApplication.class);
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CRMQuarzCustomerGroupApplication.class);
	}

	@Resource(name = "redisUtil")
	private RedisUtilBasic redisUtil;

	public static void main(String[] args) throws Exception {
		
		try {
			for(String str :args){
				if (str.contains("type=")){
					arg = str.split("=")[1] ;
				}
			}
		} catch (Exception e) {
			log.info("加载主题失败");
			e.printStackTrace();
		}
		log.info("运行主题:{}" ,arg );
		
		SpringApplication.run(CRMQuarzCustomerGroupApplication.class, args);

	}

}
