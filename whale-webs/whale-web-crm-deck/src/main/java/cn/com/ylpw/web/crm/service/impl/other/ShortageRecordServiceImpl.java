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

import cn.com.ylpw.web.crm.entity.order.TShortageRecord;
import cn.com.ylpw.web.crm.model.RedisKeys;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import cn.com.ylpw.web.crm.service.other.ShortageRecordService;
import cn.com.ylpw.web.crm.util.RedisUtilBasic;

@Transactional
@Service("shortageRecordServiceImpl")
public class ShortageRecordServiceImpl   extends BaseServiceImpl<TShortageRecord> implements ShortageRecordService {
	
	private static final Logger logger = LoggerFactory.getLogger(ShortageRecordServiceImpl.class);
	@Override
	protected Class setClass() {
		return TShortageRecord.class;
	}
	
	@Override
	public int  insertSelectiveBatch(List<TShortageRecord> saveObj) {
		return super.getBaseDao().getSqlSession().insert(super.getMapperKey("insertBatchSelective"), saveObj) ;
	}

	@Resource(name = "redisUtil")
	private RedisUtilBasic redisUtil;

	@Override
	public void batchOrlc2Mysql(List<TShortageRecord> saveObj) {
		Boolean isError=  false ; 
		try {
			if (this.insertSelectiveBatch(saveObj) < 1) {
				isError = true;
			}
		} catch (Exception e) {
			logger.error("TShortageRecord 保存失败..."+JSONObject.toJSONString(saveObj),e);
			isError= true ; 
		}
		
		if (isError){
			Map<String , List <TShortageRecord>> errs = new HashMap<String , List <TShortageRecord>>() ;
			if (null != redisUtil.get(RedisKeys.SAVESHORTAGERECORDERROR)){
				errs = (Map<String, List<TShortageRecord>>) redisUtil.get(RedisKeys.SAVESHORTAGERECORDERROR);
			}
			errs.put(new Date().getTime()+"", saveObj);
			redisUtil.set(RedisKeys.SAVESHORTAGERECORDERROR, errs);
			logger.info("TShortageRecord 保存失败 ， 存入redis {} 条 待处理 " , saveObj.size());
		}
		
	}
	
}
