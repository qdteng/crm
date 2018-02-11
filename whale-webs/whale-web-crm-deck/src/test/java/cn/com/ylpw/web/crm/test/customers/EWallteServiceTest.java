package cn.com.ylpw.web.crm.test.customers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.MapUtils;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;

import cn.com.ylpw.web.crm.entity.order.TEWallet;
import cn.com.ylpw.web.crm.service.other.EWalletService;
import cn.com.ylpw.web.crm.test.InitSessionBaseTest;
import cn.com.ylpw.web.crm.util.DateUtils;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EWallteServiceTest extends InitSessionBaseTest {
	
	private static final Logger log = LoggerFactory.getLogger(EWallteServiceTest.class);
	  
	@Autowired
	EWalletService eWalletService ; 
	
    @org.junit.Test
    public void saveBatchTest() {
    	List <JSONObject> objectList = JSONObject.parseObject("[{\"CUSTOMERSID\":54569024,\"CREATEDATE\":1462962320000,\"CHONGZHI_XIAOFEI_JINE\":680,\"ID\":112328862,\"CAOZUOHOU_JINE\":680,\"CAOZUOQIAN_JINE\":0},{\"CUSTOMERSID\":51430936,\"CREATEDATE\":1464237832000,\"CHONGZHI_XIAOFEI_JINE\":11,\"ID\":122149071,\"CAOZUOHOU_JINE\":77,\"CAOZUOQIAN_JINE\":66}]", List.class);
    	List<TEWallet> saveObject  = new ArrayList<TEWallet>(); 
    	for (JSONObject  jsonObj : objectList){
    		java.util.Map mapObj  = jsonObj.toJavaObject(java.util.Map.class);
    		TEWallet ewall  = new TEWallet() ;
    		ewall.setId(MapUtils.getLong(mapObj, "ID"));
    		ewall.setCustomersid(MapUtils.getLong(mapObj, "CUSTOMERSID"));
    		ewall.setOrderId(MapUtils.getLong(mapObj, "ORDERSID"));
    		ewall.setCreateTime( DateUtils.longToDate(null!=mapObj.get("CREATEDATE")?Long.parseLong(mapObj.get("CREATEDATE").toString()):null)    );
    		ewall.setAfterPrice(new BigDecimal(null!=mapObj.get("CAOZUOHOU_JINE") ? mapObj.get("CAOZUOHOU_JINE").toString() :"0"));
    		ewall.setBeforePrice(new BigDecimal(null!=mapObj.get("CAOZUOQIAN_JINE") ? mapObj.get("CAOZUOQIAN_JINE").toString() :"0"));
    		ewall.setPayPrice(new BigDecimal(null!=mapObj.get("CHONGZHI_XIAOFEI_JINE") ? mapObj.get("CHONGZHI_XIAOFEI_JINE").toString() :"0"));
    		saveObject.add(ewall);
    	}
    	eWalletService.insertSelectiveBatch(saveObject) ;
    }
    
    
  

}