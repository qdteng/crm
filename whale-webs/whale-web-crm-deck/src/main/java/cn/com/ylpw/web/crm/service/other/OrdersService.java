package cn.com.ylpw.web.crm.service.other;

import java.util.List;
import java.util.Map;

import cn.com.ylpw.web.crm.entity.order.TOrdersInfo;
import cn.com.ylpw.web.crm.service.BaseService;


public interface OrdersService extends  BaseService<TOrdersInfo> {

	int insertSelectiveBatch(List<TOrdersInfo> saveObj);

	void batchOrlc2Mysql(List<TOrdersInfo> saveObj);

	/***
	 * <p>查询订单总计信息</p>
	 * @author LT
	 * @date 2017年5月25日 下午2:03:57
	 * @return Map<String,Object>
	 * @param string
	 * @param searchParam
	 * @return
	 */
	Map<String, Object> findTotalInfo(String string, Map<String, Object> searchParam);
	
	
}
