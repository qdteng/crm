package cn.com.ylpw.web.crm.service.impl.customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ylpw.web.crm.entity.customer.TCustomerGradeRight;
import cn.com.ylpw.web.crm.service.customer.CustomerGradeRightService;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;

@Transactional
@Service("customerGradeRightServiceImpl")
public class CustomerGradeRightServiceImpl extends BaseServiceImpl<TCustomerGradeRight> implements CustomerGradeRightService{

	@Override
	protected Class setClass() {
		return TCustomerGradeRight.class;
	}

	@Override
	public List<Map<String, Object>> findByCustomerGradeid(Long id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("customerGradeid", id);
		List<Map<String, Object>> list = this.getBaseDao().getSqlSession()
				.selectList(super.getMapperKey("findByCustomerGradeid"), param);
		return list;
	}

}
