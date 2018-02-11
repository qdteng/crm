package cn.com.ylpw.web.crm.mapper.customer;

import java.util.List;

import cn.com.ylpw.web.crm.entity.customer.TCustomerPropertys;

public interface TCustomerPropertysMapper {
	/**
	 * <p>标签分组的id ， 查询分组下的属性</p>
	 * @author LT
	 * @date 2017年6月28日 上午10:08:41
	 * @return List<TCustomerPropertys>
	 * @param groupid
	 * @return
	 */
	List<TCustomerPropertys>   findProperytsByGroupId(Long  groupid) ; 
	
}