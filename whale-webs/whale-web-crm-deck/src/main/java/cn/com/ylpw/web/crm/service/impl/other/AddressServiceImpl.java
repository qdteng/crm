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
import cn.com.ylpw.web.crm.entity.order.TEWallet;
import cn.com.ylpw.web.crm.entity.order.TLeTong;
import cn.com.ylpw.web.crm.model.RedisKeys;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import cn.com.ylpw.web.crm.service.other.AddressService;
import cn.com.ylpw.web.crm.service.other.LeTongService;
import cn.com.ylpw.web.crm.util.RedisUtilBasic;

@Transactional
@Service("addressServiceImpl")
public class AddressServiceImpl   extends BaseServiceImpl<TAddress> implements AddressService {
	
	private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);
	@Override
	protected Class setClass() {
		return TAddress.class;
	}
	
	@Override
	public int  insertSelectiveBatch(List<TAddress> saveObj) {
		return super.getBaseDao().getSqlSession().insert(super.getMapperKey("insertBatchSelective"), saveObj) ;
	}

	@Resource(name = "redisUtil")
	private RedisUtilBasic redisUtil;

	@Override
	public void batchOrlc2Mysql(List<TAddress> saveObj) {
		Boolean isError=  false ; 
		try {
			if (this.insertSelectiveBatch(saveObj) < 1) {
				isError = true;
			}
		} catch (Exception e) {
			logger.error("TADDRESS 保存失败..."+JSONObject.toJSONString(saveObj),e);
			isError= true ; 
		}
		
		if (isError){
			Map<String , List <TAddress>> errs = new HashMap<String , List <TAddress>>() ;
			if (null != redisUtil.get(RedisKeys.SAVEADDRESSERROR)){
				errs = (Map<String, List<TAddress>>) redisUtil.get(RedisKeys.SAVEADDRESSERROR);
			}
			errs.put(new Date().getTime()+"", saveObj);
			redisUtil.set(RedisKeys.SAVEADDRESSERROR, errs);
			logger.info("TADDRESS 保存失败 ， 存入redis {} 条 待处理 " , saveObj.size());
		}
		
	}
	
}
