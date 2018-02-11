package cn.com.ylpw.web.crm.service.customer;

import cn.com.ylpw.web.crm.entity.customer.TCustomerIndexRecency;
import cn.com.ylpw.web.crm.service.BaseService;

public interface CustomerIndexRecencyService extends BaseService<TCustomerIndexRecency> {
	void saveOrUpdateRecency( Integer isEnableXF, Integer isEnableCZ, String monetary1, String monetary2,
			String mindex1, String mindex2, String[] monetarys1, String[] monetarys2, String[] mindexs1, String[] mindexs2, Long indexId);
}
