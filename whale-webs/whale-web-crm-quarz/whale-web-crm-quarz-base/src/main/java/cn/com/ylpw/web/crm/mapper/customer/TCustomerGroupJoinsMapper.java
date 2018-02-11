package cn.com.ylpw.web.crm.mapper.customer;

import cn.com.ylpw.web.crm.entity.customer.TCustomerGroupJoins;

public interface TCustomerGroupJoinsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCustomerGroupJoins record);

    int insertSelective(TCustomerGroupJoins record);

    TCustomerGroupJoins selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCustomerGroupJoins record);

    int updateByPrimaryKey(TCustomerGroupJoins record);
}