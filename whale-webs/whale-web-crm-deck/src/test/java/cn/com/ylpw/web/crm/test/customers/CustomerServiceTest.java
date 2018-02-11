package cn.com.ylpw.web.crm.test.customers;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

import cn.com.ylpw.core.tools.DateTool;
import cn.com.ylpw.web.crm.model.RedisKeys;
import cn.com.ylpw.web.crm.service.customer.CustomerService;
import cn.com.ylpw.web.crm.test.InitSessionBaseTest;
import cn.com.ylpw.web.crm.util.Page;
import cn.com.ylpw.web.crm.util.RedisUtilBasic;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest extends InitSessionBaseTest {
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceTest.class);
	  
	@Autowired
	CustomerService customerService ; 
	@Autowired
	private RedisUtilBasic redisUtil ;
    @org.junit.Test
    public void saveTest() {
//    	 TCustomers cus = new TCustomers() ;
//    	 cus.setNickname("测试1");
//    	 cus.setType(0);
//    	 customerService.insertSelective(cus);
    	
    	
    	try {
			redisUtil.set(RedisKeys.LAST_UPDATE_CUSTOMER_DATE,DateTool.parseDate("2017-07-26 8:50:00", "yyyy-MM-dd HH:mm:ss") );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    @org.junit.Test
    public void selectByPageTest() {
    	Map<String ,Object> searchParam = new HashMap<String ,Object>();
    	PageInfo<Map<String,Object>>  pageInfo =customerService.pageFindModel("findAll", new Page(), searchParam);
    	System.out.println(JSONObject.toJSONString(pageInfo));
    }
    
  

}