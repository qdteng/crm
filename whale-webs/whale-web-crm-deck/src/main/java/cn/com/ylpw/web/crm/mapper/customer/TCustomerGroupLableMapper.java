package cn.com.ylpw.web.crm.mapper.customer;

import org.apache.ibatis.annotations.Mapper;

import cn.com.ylpw.web.crm.entity.customer.TCustomerGroupLable;
@Mapper
public interface TCustomerGroupLableMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCustomerGroupLable record);

    int insertSelective(TCustomerGroupLable record);

    TCustomerGroupLable selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCustomerGroupLable record);

    int updateByPrimaryKey(TCustomerGroupLable record);

	void deleteByGroupId(Long id);
}