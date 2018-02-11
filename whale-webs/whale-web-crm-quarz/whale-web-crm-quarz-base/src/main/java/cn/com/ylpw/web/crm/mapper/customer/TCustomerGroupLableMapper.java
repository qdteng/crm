package cn.com.ylpw.web.crm.mapper.customer;

import cn.com.ylpw.web.crm.entity.customer.TCustomerGroupLable;

public interface TCustomerGroupLableMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCustomerGroupLable record);

    int insertSelective(TCustomerGroupLable record);

    TCustomerGroupLable selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCustomerGroupLable record);

    int updateByPrimaryKey(TCustomerGroupLable record);

	void deleteByGroupId(Long id);
}