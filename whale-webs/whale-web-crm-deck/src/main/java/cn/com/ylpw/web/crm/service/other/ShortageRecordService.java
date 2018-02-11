package cn.com.ylpw.web.crm.service.other;

import java.util.List;

import cn.com.ylpw.web.crm.entity.order.TShortageRecord;
import cn.com.ylpw.web.crm.service.BaseService;


public interface ShortageRecordService extends  BaseService<TShortageRecord> {

	int insertSelectiveBatch(List<TShortageRecord> saveObj);

	void batchOrlc2Mysql(List<TShortageRecord> saveObj);
	
	
}
