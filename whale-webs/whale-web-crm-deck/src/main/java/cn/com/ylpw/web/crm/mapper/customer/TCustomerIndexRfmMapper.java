package cn.com.ylpw.web.crm.mapper.customer;

import cn.com.ylpw.web.crm.entity.customer.TCustomerIndexRfm;

public interface TCustomerIndexRfmMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCustomerIndexRfm record);

    int insertSelective(TCustomerIndexRfm record);

    TCustomerIndexRfm selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCustomerIndexRfm record);

    int updateByPrimaryKey(TCustomerIndexRfm record);
}