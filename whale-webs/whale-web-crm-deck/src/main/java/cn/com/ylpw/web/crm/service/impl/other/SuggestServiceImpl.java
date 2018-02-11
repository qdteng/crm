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

import cn.com.ylpw.web.crm.entity.order.TSuggest;
import cn.com.ylpw.web.crm.model.RedisKeys;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import cn.com.ylpw.web.crm.service.other.SuggestService;
import cn.com.ylpw.web.crm.util.RedisUtilBasic;

@Transactional
@Service("suggestServiceImpl")
public class SuggestServiceImpl   extends BaseServiceImpl<TSuggest> implements SuggestService {
	
	private static final Logger logger = LoggerFactory.getLogger(SuggestServiceImpl.class);
	@Override
	protected Class setClass() {
		return TSuggest.class;
	}
	
	@Override
	public int  insertSelectiveBatch(List<TSuggest> saveObj) {
		return super.getBaseDao().getSqlSession().insert(super.getMapperKey("insertBatchSelective"), saveObj) ;
	}

	@Resource(name = "redisUtil")
	private RedisUtilBasic redisUtil;

	@Override
	public void batchOrlc2Mysql(List<TSuggest> saveObj) {
		Boolean isError=  false ; 
		try {
			if (this.insertSelectiveBatch(saveObj) < 1) {
				isError = true;
			}
		} catch (Exception e) {
			logger.error("TSuggest 保存失败..."+JSONObject.toJSONString(saveObj),e);
			isError= true ; 
		}
		
		if (isError){
			Map<String , List <TSuggest>> errs = new HashMap<String , List <TSuggest>>() ;
			if (null != redisUtil.get(RedisKeys.SAVESUGGESTERROR)){
				errs = (Map<String, List<TSuggest>>) redisUtil.get(RedisKeys.SAVESUGGESTERROR);
			}
			errs.put(new Date().getTime()+"", saveObj);
			redisUtil.set(RedisKeys.SAVESUGGESTERROR, errs);
			logger.info("TSuggest 保存失败 ， 存入redis {} 条 待处理 " , saveObj.size());
		}
	}
	
}
