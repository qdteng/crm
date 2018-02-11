package cn.com.ylpw.web.crm.mapper.customer;

import cn.com.ylpw.web.crm.entity.customer.TCustomerIndexRecency;

public interface TCustomerIndexRecencyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCustomerIndexRecency record);

    int insertSelective(TCustomerIndexRecency record);

    TCustomerIndexRecency selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCustomerIndexRecency record);

    int updateByPrimaryKey(TCustomerIndexRecency record);
}