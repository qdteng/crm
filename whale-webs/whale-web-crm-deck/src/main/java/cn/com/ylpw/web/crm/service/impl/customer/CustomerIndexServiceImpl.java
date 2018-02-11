package cn.com.ylpw.web.crm.service.impl.customer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ylpw.web.crm.entity.customer.TCustomerIndex;
import cn.com.ylpw.web.crm.service.customer.CustomerIndexService;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import cn.com.ylpw.web.crm.util.SessionUtils;

@Transactional
@Service("customerIndexServiceImpl")
public class CustomerIndexServiceImpl extends BaseServiceImpl<TCustomerIndex> implements CustomerIndexService {

	@Override
	protected Class setClass() {
		return TCustomerIndex.class;
	}

	@Override
	public List<Map<String, Object>> findByParam(Map<String, Object> searchParam) {
		return this.getBaseDao().getSqlSession().selectList(super.getMapperKey("findByParam"), searchParam);
	}

	public int updateByPrimaryKeySelective(TCustomerIndex record) {
		return super.updateByPrimaryKeySelective(record);
	}

	@Override
	public void upOpen(List<Map<String, Object>> list, String rfmval, String recencyval, String activeval, Long id) {
		TCustomerIndex ci = null;
		for (Map<String, Object> ciMap : list) {
			ci = this.selectByPrimaryKey(Long.valueOf(ciMap.get("ID").toString()));
			if (id == ci.getId()) {
				if (null != ci.getIsOpen() && 1 == ci.getIsOpen()) {
					ci.setIsOpen(0);
				} else {
					ci.setIsOpen(1);
				}
			}
			if (1 == ci.getMtype()) {
				ci.setScale(BigDecimal.valueOf(Double.valueOf(rfmval)));
			}
			if (2 == ci.getMtype()) {
				ci.setScale(BigDecimal.valueOf(Double.valueOf(recencyval)));
			}
			if (3 == ci.getMtype()) {
				ci.setScale(BigDecimal.valueOf(Double.valueOf(activeval)));
			}
			ci.setUpdateId(SessionUtils.currentUser().getId());
			ci.setUpdateName(SessionUtils.currentUser().getName());
			ci.setUpdateTime(new Date());
			this.updateByPrimaryKeySelective(ci);
		}
	}

}
