package cn.com.ylpw.web.crm.service.customer;

import java.util.Map;

import cn.com.ylpw.web.crm.entity.customer.TCustomerIndexActive;
import cn.com.ylpw.web.crm.service.BaseService;

public interface CustomerIndexActiveService extends BaseService<TCustomerIndexActive>{
	void saveOrUpdateActive(Map<String,Object> searchParam, String[] aindexs, String[] anums, Long indexId);
}
