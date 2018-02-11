/**
 * <p>Title: UserServiceImpl.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017, zj7687362@gmail.com All Rights Reserved. </p>
 * <p>Company: www.jcore.cn</p>
 * @author 张嘉杰
 * @date 2017年2月21日 下午6:07:10
 */
package cn.com.ylpw.web.crm.service.impl.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ylpw.web.crm.entity.customer.TCustomerPropertys;
import cn.com.ylpw.web.crm.service.customer.CustomerPropertysService;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;

@Transactional
@Service("customerPropertysImpl")
public class CustomerPropertysImpl extends BaseServiceImpl<TCustomerPropertys> implements CustomerPropertysService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerPropertysImpl.class);

	@Override
	protected Class setClass() {
		return TCustomerPropertys.class;
	}

	@Override
	public TCustomerPropertys getPropertysByLableId(Long lableId) {
		
		TCustomerPropertys props  =  super.getBaseDao().getSqlSession().selectOne(super.getMapperKey("getPropertysByLableId"), lableId);
		
		return props;
	}
	

	public int insertSelective(TCustomerPropertys record){
		return super.insertSelective(record) ;
	}

	public TCustomerPropertys selectByPrimaryKey(Long id){
		return super.selectByPrimaryKey(id) ;
	}

	public int updateByPrimaryKeySelective(TCustomerPropertys record){
		return super.updateByPrimaryKeySelective(record) ; 
	}

	@Override
	public int update(TCustomerPropertys propertys) {
		return super.updateByPrimaryKey(propertys) ;
	}
	
	

}
