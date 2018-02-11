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

import cn.com.ylpw.web.crm.entity.order.TAddress;
import cn.com.ylpw.web.crm.entity.order.TPaymentTypes;
import cn.com.ylpw.web.crm.model.RedisKeys;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import cn.com.ylpw.web.crm.service.other.PaymentTypesService;
import cn.com.ylpw.web.crm.util.RedisUtilBasic;

@Transactional
@Service("paymentTypesServiceImpl")
public class PaymentTypesServiceImpl   extends BaseServiceImpl<TPaymentTypes> implements PaymentTypesService {
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentTypesServiceImpl.class);
	@Override
	protected Class setClass() {
		return TPaymentTypes.class;
	}
	
	@Override
	public int  insertSelectiveBatch(List<TPaymentTypes> saveObj) {
		return super.getBaseDao().getSqlSession().insert(super.getMapperKey("insertBatchSelective"), saveObj) ;
	}

	@Resource(name = "redisUtil")
	private RedisUtilBasic redisUtil;

	@Override
	public void batchOrlc2Mysql(List<TPaymentTypes> saveObj) {
		Boolean isError=  false ; 
		try {
			if (this.insertSelectiveBatch(saveObj) < 1) {
				isError = true;
			}
		} catch (Exception e) {
			logger.error("TPaymentTypes 保存失败..."+JSONObject.toJSONString(saveObj),e);
			isError= true ; 
		}
		
		if (isError){
			Map<String , List <TPaymentTypes>> errs = new HashMap<String , List <TPaymentTypes>>() ;
			if (null != redisUtil.get(RedisKeys.SAVEPAYMENTTYPESERROR)){
				errs = (Map<String, List<TPaymentTypes>>) redisUtil.get(RedisKeys.SAVEPAYMENTTYPESERROR);
			}
			errs.put(new Date().getTime()+"", saveObj);
			redisUtil.set(RedisKeys.SAVEPAYMENTTYPESERROR, errs);
			logger.info("TPaymentTypes 保存失败 ， 存入redis {} 条 待处理 " , saveObj.size());
		}
		
	}
	
}
