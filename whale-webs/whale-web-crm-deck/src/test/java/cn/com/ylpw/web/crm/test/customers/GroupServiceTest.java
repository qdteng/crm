package cn.com.ylpw.web.crm.test.customers;

import java.util.Date;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.ylpw.web.crm.entity.customer.TCustomerGroup;
import cn.com.ylpw.web.crm.service.customer.CustomerGroupService;
import cn.com.ylpw.web.crm.test.InitSessionBaseTest;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupServiceTest extends InitSessionBaseTest {
	
	private static final Logger log = LoggerFactory.getLogger(GroupServiceTest.class);
	  
	@Autowired
	CustomerGroupService customerGroupService ; 
	
    @org.junit.Test
    public void saveBatchTest() {
    	TCustomerGroup cg  = new TCustomerGroup() ; 
    	cg.setName( new Date().toGMTString());
    	cg.setGclass("1");
    	cg.setType("2");
    	customerGroupService.insertSelective(cg);
    }
    
    
  

}