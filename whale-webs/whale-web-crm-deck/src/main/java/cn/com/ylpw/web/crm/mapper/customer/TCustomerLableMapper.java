package cn.com.ylpw.web.crm.mapper.customer;

import cn.com.ylpw.web.crm.entity.customer.TCustomerLable;

public interface TCustomerLableMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCustomerLable record);

    int insertSelective(TCustomerLable record);

    TCustomerLable selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCustomerLable record);

    int updateByPrimaryKey(TCustomerLable record);
}