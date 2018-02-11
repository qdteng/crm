package cn.com.ylpw.web.crm.mapper.order;

import java.util.List;
import java.util.Map;

public interface TOrdersInfoMapper {
	
	List<Map<String,Object>> findOrdersByCustomerIdAndFRMIndex(Map<String,Object> searchParam);
	
}