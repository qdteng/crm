package cn.com.ylpw.web.crm.service.customer;

import cn.com.ylpw.web.crm.entity.customer.TCustomerIntegralLimit;
import cn.com.ylpw.web.crm.service.BaseService;


public interface CustomerIntegralLimitService extends  BaseService<TCustomerIntegralLimit> {

	TCustomerIntegralLimit findCurrentCustomerIntegralLimit();

	/***
	 * <p>保存积分限制</p>
	 * @author LT
	 * @date 2017年8月29日 上午10:41:30
	 * @return void
	 * @param customerIntegralLimit
	 */
	void saveLimit(TCustomerIntegralLimit customerIntegralLimit);
	
	
}
