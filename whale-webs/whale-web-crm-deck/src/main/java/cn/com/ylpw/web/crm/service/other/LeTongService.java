package cn.com.ylpw.web.crm.service.other;

import java.util.List;

import cn.com.ylpw.web.crm.entity.order.TLeTong;
import cn.com.ylpw.web.crm.service.BaseService;


public interface LeTongService extends  BaseService<TLeTong> {

	int insertSelectiveBatch(List<TLeTong> saveObj);

	void batchOrlc2Mysql(List<TLeTong> saveObj);
	
	
}
