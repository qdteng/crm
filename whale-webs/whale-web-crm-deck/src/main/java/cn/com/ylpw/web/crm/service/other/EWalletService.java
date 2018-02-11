package cn.com.ylpw.web.crm.service.other;

import java.util.List;

import cn.com.ylpw.web.crm.entity.customer.TCustomers;
import cn.com.ylpw.web.crm.entity.order.TEWallet;
import cn.com.ylpw.web.crm.service.BaseService;


public interface EWalletService extends  BaseService<TEWallet> {

	int insertSelectiveBatch(List<TEWallet> saveObj);

	void batchOrlc2Mysql(List<TEWallet> saveObj);
	
	
}
