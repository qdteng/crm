package cn.com.ylpw.web.crm.mapper.customer;

import cn.com.ylpw.web.crm.entity.customer.TCustomerIndexActive;

public interface TCustomerIndexActiveMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCustomerIndexActive record);

    int insertSelective(TCustomerIndexActive record);

    TCustomerIndexActive selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCustomerIndexActive record);

    int updateByPrimaryKey(TCustomerIndexActive record);
}