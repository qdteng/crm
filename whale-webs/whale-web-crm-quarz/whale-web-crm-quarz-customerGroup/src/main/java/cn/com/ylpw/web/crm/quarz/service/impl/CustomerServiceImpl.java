package cn.com.ylpw.web.crm.quarz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.ylpw.web.crm.entity.customer.TCustomers;
import cn.com.ylpw.web.crm.quarz.service.CustomerService;

@Transactional
@Service("customerServiceImpl")
public class CustomerServiceImpl extends BaseServiceImpl<TCustomers> implements CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Override
	protected Class setClass() {
		return TCustomers.class;
	}
	
	

	@Override
	public List<Long> findCustomerIdsByMaxId(Long maxIds, Long size) {
		
		Map<String,Object> searchParam = new HashMap<String,Object>() ;
		searchParam.put("maxid", maxIds);
		
		PageHelper.startPage(1, size.intValue(),false);
		
		return  super.getBaseDao().getSqlSession().selectList(super.getMapperKey("findCustomerIdsByMaxId"), searchParam);
	}


	

}
