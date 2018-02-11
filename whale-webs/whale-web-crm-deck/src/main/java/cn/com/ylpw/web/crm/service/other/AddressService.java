package cn.com.ylpw.web.crm.service.other;

import java.util.List;

import cn.com.ylpw.web.crm.entity.order.TAddress;
import cn.com.ylpw.web.crm.service.BaseService;


public interface AddressService extends  BaseService<TAddress> {

	int insertSelectiveBatch(List<TAddress> saveObj);

	void batchOrlc2Mysql(List<TAddress> saveObj);
	
	
}
