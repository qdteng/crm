package cn.com.ylpw.web.crm.service.customer;

import java.util.List;
import java.util.Map;

import cn.com.ylpw.web.crm.entity.customer.TCustomerIndex;
import cn.com.ylpw.web.crm.service.BaseService;

public interface CustomerIndexService extends BaseService<TCustomerIndex> {

	List<Map<String, Object>> findByParam(Map<String, Object> searchParam);

	/***
	 *  *
	 * <p>
	 * 更新开关
	 * </p>
	 *  * @author WY  * @date 2017年6月6日 下午5:10:21  * @return void  * @param ids
	 *  
	 */
	void upOpen(List<Map<String, Object>> list, String rfmval, String recencyval, String activeval, Long id);

	public int updateByPrimaryKeySelective(TCustomerIndex record);
	
	
}
