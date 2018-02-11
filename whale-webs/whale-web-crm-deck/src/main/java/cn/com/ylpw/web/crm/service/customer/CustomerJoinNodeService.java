package cn.com.ylpw.web.crm.service.customer;

import cn.com.ylpw.web.crm.entity.customer.TCustomerJoinNote;
import cn.com.ylpw.web.crm.service.BaseService;


public interface CustomerJoinNodeService extends  BaseService<TCustomerJoinNote> {

	/**
	 * <p>添加会员标签</p>
	 * @author LT
	 * @date 2017年5月17日 上午9:30:03
	 * @return void
	 * @param customerId
	 * @param nodeName
	 */
	void addNode(Long customerId, String nodeName);


}
