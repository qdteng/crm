package cn.com.ylpw.web.crm.mapper.customer;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.com.ylpw.web.crm.entity.customer.TCustomerNote;

@Mapper
public interface TCustomerNoteMapper {
	
	int insert(TCustomerNote cn);

    int insertSelective(TCustomerNote cn);
    
	List<Map<String, Object>> findByParams(Map<String, Object> paramMap);
}
