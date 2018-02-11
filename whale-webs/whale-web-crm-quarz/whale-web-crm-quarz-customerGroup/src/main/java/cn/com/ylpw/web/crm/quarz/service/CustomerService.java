package cn.com.ylpw.web.crm.quarz.service;

import java.util.List;

import cn.com.ylpw.web.crm.entity.customer.TCustomers;


public interface CustomerService extends  BaseService<TCustomers> {

	/**
	 * <p>取大于maxIds 的 size 条 customer的id</p>
	 * @author LT
	 * @date 2017年6月23日 下午1:39:28
	 * @return List<Long>
	 * @param maxIds
	 * @param size
	 * @return
	 */
	List<Long> findCustomerIdsByMaxId(Long maxIds, Long size);

	
}
