package cn.com.ylpw.web.crm.mapper.customer;

import cn.com.ylpw.web.crm.entity.customer.TCustomerJoinNote;
public interface TCustomerJoinNoteMapper {
	int insert(TCustomerJoinNote cjn);

    int insertSelective(TCustomerJoinNote cjn);
    
    int deleteByPrimaryKey(Long id);
}
