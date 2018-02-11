package cn.com.ylpw.web.crm.mapper.customer;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.com.ylpw.web.crm.entity.customer.TCustomerGradeRight;
@Mapper
public interface TCustomerGradeRightMapper {
	int insert(TCustomerGradeRight cgr);

    int insertSelective(TCustomerGradeRight cgr);
    
    int deleteByPrimaryKey(TCustomerGradeRight cgr);
    
    List<Map<String, Object>> findByCustomerGradeid(Long customerGradeid);
    
    TCustomerGradeRight selectByPrimaryKey(Long id);
}
