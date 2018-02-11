package cn.com.ylpw.web.crm.service.impl.other;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;

import cn.com.ylpw.web.crm.entity.customer.TCustomers;
import cn.com.ylpw.web.crm.entity.order.TEWallet;
import cn.com.ylpw.web.crm.model.RedisKeys;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import cn.com.ylpw.web.crm.service.other.EWalletService;
import cn.com.ylpw.web.crm.util.RedisUtilBasic;

@Transactional
@Service("eWalletServiceImpl")
public class EWalletServiceImpl   extends BaseServiceImpl<TEWallet> implements EWalletService {
	
	private static final Logger logger = LoggerFactory.getLogger(EWalletServiceImpl.class);
	@Override
	protected Class setClass() {
		return TEWallet.class;
	}
	
	
	@Override
	public int  insertSelectiveBatch(List<TEWallet> saveObj) {
		return super.getBaseDao().getSqlSession().insert(super.getMapperKey("insertBatchSelective"), saveObj) ;
	}

	@Resource(name = "redisUtil")
	private RedisUtilBasic redisUtil;


	@Override
	public void batchOrlc2Mysql(List<TEWallet> saveObj) {
		Boolean isError=  false ; 
		try {
			if (this.insertSelectiveBatch(saveObj) < 1) {
				isError = true;
			} 
		} catch (Exception e) {
			
			logger.error("TEwallet 保存失败..."+JSONObject.toJSONString(saveObj),e);
			isError= true ; 
		}
		
		if (isError){
			Map<String , List <TEWallet>> errs = new HashMap<String , List <TEWallet>>() ;
			if (null != redisUtil.get(RedisKeys.SAVEEWALLETERROR)){
				errs = (Map<String, List<TEWallet>>) redisUtil.get(RedisKeys.SAVEEWALLETERROR);
			}
			errs.put(new Date().getTime()+"", saveObj);
			
			redisUtil.set(RedisKeys.SAVEEWALLETERROR, errs);
			logger.info("ewallet 保存失败 ， 存入redis {} 条 待处理 " , saveObj.size());
		}
		
	}
	
}
