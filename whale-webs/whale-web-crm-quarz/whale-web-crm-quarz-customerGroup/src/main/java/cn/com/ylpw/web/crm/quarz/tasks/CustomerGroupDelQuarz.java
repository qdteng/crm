package cn.com.ylpw.web.crm.quarz.tasks;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.com.ylpw.web.crm.quarz.service.CustomerService;
import cn.com.ylpw.web.crm.quarz.util.RedisUtil;

@Component
@Configurable
public class CustomerGroupDelQuarz {

	private static final Logger log = LoggerFactory.getLogger(CustomerGroupDelQuarz.class);

	@Autowired
	CustomerService customerService;

	@Resource(name = "redisUtil")
	private RedisUtil redisUtil;

	
    @Scheduled(cron = "*/5 * * * * ?")
	public  void excute_1() throws Exception {
    	log.info("5ssss");
	}

}
