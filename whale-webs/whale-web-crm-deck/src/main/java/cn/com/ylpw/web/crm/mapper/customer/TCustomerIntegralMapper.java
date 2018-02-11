package cn.com.ylpw.web.crm.mapper.customer;

import cn.com.ylpw.web.crm.entity.customer.TCustomerIntegral;

public interface TCustomerIntegralMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCustomerIntegral record);

    int insertSelective(TCustomerIntegral record);

    TCustomerIntegral selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCustomerIntegral record);

    int updateByPrimaryKey(TCustomerIntegral record);
}