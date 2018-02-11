package cn.com.ylpw.web.crm.mapper.customer;

import java.util.List;

import cn.com.ylpw.web.crm.entity.customer.TCustomerGrade;


public interface TCustomerGradeMapper {

	/**
	 * <p>查询可用的会员等级</p>
	 * @author LT
	 * @date 2017年6月27日 上午10:13:16
	 * @return List<TCustomerGrade>
	 * @return
	 */
	List<TCustomerGrade> findUsableGrade();
	
	
}
