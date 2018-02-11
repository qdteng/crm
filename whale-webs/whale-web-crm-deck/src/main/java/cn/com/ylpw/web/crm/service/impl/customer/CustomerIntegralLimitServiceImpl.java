package cn.com.ylpw.web.crm.service.impl.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ylpw.web.crm.entity.customer.TCustomerIntegralLimit;
import cn.com.ylpw.web.crm.entity.order.TAddress;
import cn.com.ylpw.web.crm.service.customer.CustomerIntegralLimitService;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;

@Transactional
@Service("customerIntegralLimitServiceImpl")
public class CustomerIntegralLimitServiceImpl  extends BaseServiceImpl<TCustomerIntegralLimit>
implements CustomerIntegralLimitService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerIntegralLimitServiceImpl.class);
	@Override
	protected Class setClass() {
		return TAddress.class;
	}
	
	@Override
	public TCustomerIntegralLimit findCurrentCustomerIntegralLimit() {
		return this.getBaseDao().getSqlSession().selectOne("findCurrentCustomerIntegralLimit", TCustomerIntegralLimit.class) ;
	}
	
	@Override
	public void saveLimit(TCustomerIntegralLimit customerIntegralLimit) {
		logger.info("将已有限制规则设置为逻辑删除状态");
		this.getBaseDao().getSqlSession().update("updateLimit2Off");
		customerIntegralLimit.setCurrent(1);
		logger.info("保存限制...");
		super.insertSelective(customerIntegralLimit);
	}

	
}
