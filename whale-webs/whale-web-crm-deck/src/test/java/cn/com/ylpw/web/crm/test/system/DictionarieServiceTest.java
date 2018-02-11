package cn.com.ylpw.web.crm.test.system;

import java.util.Date;
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

import cn.com.ylpw.web.crm.entity.sys.SysDictionarie;
import cn.com.ylpw.web.crm.service.sys.DictionarieService;
import cn.com.ylpw.web.crm.test.InitSessionBaseTest;
import cn.com.ylpw.web.crm.util.Contact;
import cn.com.ylpw.web.crm.util.Page;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DictionarieServiceTest extends InitSessionBaseTest {
	
	private static final Logger log = LoggerFactory.getLogger(DictionarieServiceTest.class);
	  
	@Autowired
	DictionarieService dictionarieService ; 
	
    @org.junit.Test
    public void saveDicTest() {
    	 SysDictionarie dic = new SysDictionarie() ;
    	 dic.setCode("1");
    	 dic.setCreateTime(new Date());
    	 dic.setName("测试");
    	 dic.setRemark("测试字典描述");
    	 dictionarieService.insertSelective(dic);
    }
    
    @org.junit.Test
    public void selectDicTest() {
    	dictionarieService.selectByPrimaryKey(1l);
    }
    
    @org.junit.Test
    public void selectByPageTest() {
    	Map<String ,Object> searchParam = new HashMap<String ,Object>();
    	searchParam.put("code", "1");
    	PageInfo<Map<String,Object>>  pageInfo =dictionarieService.pageFindModel("findAll", new Page(), searchParam);
    	System.out.println(JSONObject.toJSONString(pageInfo));
    }
    
    
    
    @org.junit.Test
    public void initCacheDicTest() {
    	System.out.println(JSONObject.toJSONString(Contact.initDicCache()));
    }
    
    
  

}