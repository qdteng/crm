package cn.com.ylpw.web.crm.service.customer;

import cn.com.ylpw.web.crm.entity.customer.TCustomerIndexRfm;
import cn.com.ylpw.web.crm.service.BaseService;

public interface CustomerIndexRfmService extends BaseService<TCustomerIndexRfm>{
	void saveOrUpdateRfm(String[] recency, String[] rindex, String[] frequency, String[] findex, String[] monetary, String[] mindex, String[] isLoss, String[] id, Long indexId);
}
