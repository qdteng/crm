package cn.com.ylpw.web.crm.mapper.customer;

import cn.com.ylpw.web.crm.entity.customer.TCustomerIndex;

public interface TCustomerIndexMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCustomerIndex record);

    int insertSelective(TCustomerIndex record);

    TCustomerIndex selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCustomerIndex record);

    int updateByPrimaryKey(TCustomerIndex record);
}