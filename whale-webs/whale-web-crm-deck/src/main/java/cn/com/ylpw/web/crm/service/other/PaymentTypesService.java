package cn.com.ylpw.web.crm.service.other;

import java.util.List;

import cn.com.ylpw.web.crm.entity.order.TPaymentTypes;
import cn.com.ylpw.web.crm.service.BaseService;


public interface PaymentTypesService extends  BaseService<TPaymentTypes> {

	int insertSelectiveBatch(List<TPaymentTypes> saveObj);

	void batchOrlc2Mysql(List<TPaymentTypes> saveObj);
	
	
}
