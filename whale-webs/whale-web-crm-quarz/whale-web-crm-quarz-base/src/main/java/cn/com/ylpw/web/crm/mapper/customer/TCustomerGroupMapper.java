package cn.com.ylpw.web.crm.mapper.customer;

import java.util.List;
import java.util.Map;

import cn.com.ylpw.web.crm.entity.customer.TCustomerGroup;

public interface TCustomerGroupMapper {

	/**
	 * <p>查询动态分组 </p>
	 * @author LT
	 * @date 2017年6月28日 上午8:58:20
	 * @return List<TCustomerGroup>
	 * @param gclass 1一般分组2标签分组 
	 * @return
	 */
	List<TCustomerGroup> findDynamicGroupByClass(int gclass);
	
	TCustomerGroup selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(TCustomerGroup record);

    int updateByPrimaryKey(TCustomerGroup record);
	
	/**
	 * <p>查会员分组标签</p>
	 * @author WY
	 * @date 2017年12月14日 下午2:14:45
	 * @return List<Map<String, Object>>
	 * @param id
	 */
	List<Map<String, Object>> findNoteById(Long groupId);
	
	int updateForExport(TCustomerGroup record);
}