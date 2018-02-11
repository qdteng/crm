package cn.com.ylpw.web.crm.service.customer;

import java.util.Map;

import cn.com.ylpw.web.crm.entity.customer.TCustomerGrade;
import cn.com.ylpw.web.crm.service.BaseService;


public interface CustomerGradeService extends  BaseService<TCustomerGrade> {

	Boolean saveOrUpdate(TCustomerGrade cg, String [] quanyi, Map<String,Object> searchParam);
	
	Boolean isUse(Long cgId);
}
