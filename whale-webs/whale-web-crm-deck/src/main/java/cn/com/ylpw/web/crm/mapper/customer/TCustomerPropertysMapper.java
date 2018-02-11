package cn.com.ylpw.web.crm.mapper.customer;

import cn.com.ylpw.web.crm.entity.customer.TCustomerPropertys;

public interface TCustomerPropertysMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCustomerPropertys record);

    int insertSelective(TCustomerPropertys record);

    TCustomerPropertys selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCustomerPropertys record);

    int updateByPrimaryKey(TCustomerPropertys record);

	void deleteByLableId(Long id);
}