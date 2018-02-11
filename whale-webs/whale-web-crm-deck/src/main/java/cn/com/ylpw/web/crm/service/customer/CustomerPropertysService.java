package cn.com.ylpw.web.crm.service.customer;

import cn.com.ylpw.web.crm.entity.customer.TCustomerPropertys;

public interface CustomerPropertysService {

	/**
	 *  *
	 * <p>
	 * 标签ID获取属性信息
	 * </p>
	 *  * @author LT  * @date 2017年5月27日 下午1:20:31  * @return TCustomerPropertys
	 *  * @param lableId  * @return
	 */
	TCustomerPropertys getPropertysByLableId(Long lableId);

	public int insertSelective(TCustomerPropertys record);

	public TCustomerPropertys selectByPrimaryKey(Long id);

	public int updateByPrimaryKeySelective(TCustomerPropertys record);

	
	int update(TCustomerPropertys propertys);  
	
}
