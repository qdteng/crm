package cn.com.ylpw.web.crm.service.customer;

import java.util.List;
import java.util.Map;

import cn.com.ylpw.web.crm.entity.customer.TCustomerGradeRight;
import cn.com.ylpw.web.crm.service.BaseService;

public interface CustomerGradeRightService extends  BaseService<TCustomerGradeRight>{
	
	/***
	 * <p>查询会员权益信息</p>
	 * @author WY
	 * @date 2017年5月24日 下午4:17:20
	 * @return List<Map<String,Object>>
	 * @param id
	 * @return
	 */
	List<Map<String,Object>> findByCustomerGradeid(Long id);
}
