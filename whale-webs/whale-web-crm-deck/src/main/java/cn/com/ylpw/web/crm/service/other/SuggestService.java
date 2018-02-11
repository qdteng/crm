package cn.com.ylpw.web.crm.service.other;

import java.util.List;

import cn.com.ylpw.web.crm.entity.order.TSuggest;
import cn.com.ylpw.web.crm.service.BaseService;


public interface SuggestService extends  BaseService<TSuggest> {

	int insertSelectiveBatch(List<TSuggest> saveObj);

	void batchOrlc2Mysql(List<TSuggest> saveObj);
	
	
}
