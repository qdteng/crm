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

import cn.com.ylpw.web.crm.entity.order.TOrdersInfo;
import cn.com.ylpw.web.crm.model.RedisKeys;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import cn.com.ylpw.web.crm.service.other.OrdersService;
import cn.com.ylpw.web.crm.util.RedisUtilBasic;

@Transactional
@Service("ordersServiceImpl")
public class OrdersServiceImpl   extends BaseServiceImpl<TOrdersInfo> implements OrdersService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrdersServiceImpl.class);
	@Override
	protected Class setClass() {
		return TOrdersInfo.class;
	}
	
	
	@Override
	public int  insertSelectiveBatch(List<TOrdersInfo> saveObj) {
		return super.getBaseDao().getSqlSession().insert(super.getMapperKey("insertBatchSelective"), saveObj) ;
	}

	@Resource(name = "redisUtil")
	private RedisUtilBasic redisUtil;


	@Override
	public void batchOrlc2Mysql(List<TOrdersInfo> saveObj) {
		Boolean isError=  false ; 
		try {
			if (this.insertSelectiveBatch(saveObj) < 1) {
				isError = true;
			} 
		} catch (Exception e) {
			logger.error("TOrdersInfo 保存失败...",e);
			isError= true ; 
		}
		
		if (isError){
			Map<String , List <TOrdersInfo>> errs = new HashMap<String , List <TOrdersInfo>>() ;
			if (null != redisUtil.get(RedisKeys.SAVEORDERSERROR)){
				errs = (Map<String, List<TOrdersInfo>>) redisUtil.get(RedisKeys.SAVEORDERSERROR);
			}
			errs.put(new Date().getTime()+"", saveObj);
			
			redisUtil.set(RedisKeys.SAVEORDERSERROR, errs);
			logger.info("TOrdersInfo 保存失败 ， 存入redis {} 条 待处理 " , saveObj.size());
			
			throw new RuntimeException("TOrdersInfo 批量操作失败,抛出异常");
			
		}
		
	}


	@Override
	public Map<String, Object> findTotalInfo(String string, Map<String, Object> searchParam) {
		
		
		List<Map<String, Object>> list =  super.getBaseDao().getSqlSession().selectList(super.getMapperKey("findOrderTotal"), searchParam);
		if (null!=list&&list.size()>0){
			return  list.get(0); 
		}
		
		return null ;
	}
	
}
