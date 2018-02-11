package cn.com.ylpw.web.crm.service.impl.customer;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ylpw.web.crm.entity.customer.TCustomerGrade;
import cn.com.ylpw.web.crm.entity.customer.TCustomerGradeRight;
import cn.com.ylpw.web.crm.mapper.customer.TCustomerGradeRightMapper;
import cn.com.ylpw.web.crm.service.customer.CustomerGradeService;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import cn.com.ylpw.web.crm.util.SessionUtils;

@Transactional
@Service("customerGradeServiceImpl")
public class CustomerGradeServiceImpl   extends BaseServiceImpl<TCustomerGrade> implements CustomerGradeService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerGradeServiceImpl.class);
	
	@Autowired
	private TCustomerGradeRightMapper customerGradeRightMapper;
	
	@Override
	protected Class setClass() {
		return TCustomerGrade.class;
	}
	@Override
	public Boolean saveOrUpdate(TCustomerGrade cg, String[] quanyi, Map<String,Object> searchParam) {
		if(2==cg.getGtype()){
			if(null != searchParam.get("visibleTwo") && !"".equals(searchParam.get("visibleTwo").toString())){
				cg.setGnum(Integer.parseInt((searchParam.get("visibleTwo").toString())));
			}
		}
		if(3==cg.getGtype()){
			if(null != searchParam.get("visibleThree") && !"".equals(searchParam.get("visibleThree").toString())){
				cg.setGnum(Integer.parseInt((searchParam.get("visibleThree").toString())));
			}
		}
		if(null != cg.getId()){
			cg.setUpdateId(SessionUtils.currentUser().getId());
			cg.setUpdateName(SessionUtils.currentUser().getName());
			cg.setUpdateTime(new Date());
			this.getBaseDao().updateByPrimaryKeySelective(cg);
		}else{
			cg.setCreateTime(new Date());
			cg.setCreateId(SessionUtils.currentUser().getId());
			cg.setCreateName(SessionUtils.currentUser().getName());
			this.getBaseDao().insertSelective(cg);//新建会员等级信息
		}
		
		if(null != quanyi && quanyi.length > 0){
			List<Map<String, Object>> cgrList = customerGradeRightMapper.findByCustomerGradeid(cg.getId());
			if(null != cgrList && cgrList.size() > 0){
				for(Map<String, Object> cgrMap : cgrList){
					customerGradeRightMapper.deleteByPrimaryKey(customerGradeRightMapper.selectByPrimaryKey(Long.parseLong(cgrMap.get("ID").toString())));
				}
			}
			for(String quyi : quanyi){
				TCustomerGradeRight cgr = new TCustomerGradeRight();
				cgr.setCustomerGradeId(cg.getId());
				cgr.setCreateTime(new Date());
				cgr.setCreateId(SessionUtils.currentUser().getId());
				if(null != quyi && !"".equals(quyi)){
					cgr.setDictionarieId(Long.parseLong(quyi));
				}
				customerGradeRightMapper.insert(cgr);
				//this.getBaseDao().getSqlSession().insert(this.getBaseDao().getPOSTFIX()+"TCustomerGradeRight"+this.getBaseDao().get_MAPPER()+".insertSelective", cgr);
			}
		}
		return true;
	}
	@Override
	public Boolean isUse(Long cgId) {
		List<Map<String, Object>> list = super.getBaseDao().getSqlSession().selectList(super.getMapperKey("isUse"), cgId);
		if(null != list && list.size() > 0) {
			return true;
		}
		return false;
	}
}
