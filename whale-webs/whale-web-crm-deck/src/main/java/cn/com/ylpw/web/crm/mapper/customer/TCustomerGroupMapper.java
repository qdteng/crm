package cn.com.ylpw.web.crm.mapper.customer;

import java.util.List;
import java.util.Map;

import cn.com.ylpw.web.crm.entity.customer.TCustomerGroup;

public interface TCustomerGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCustomerGroup record);

    int insertSelective(TCustomerGroup record);

    TCustomerGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCustomerGroup record);

    int updateByPrimaryKey(TCustomerGroup record);
    
    /**
     * <p>删除分组信息 时 删除 相关分组标签 </p>
     * @author LT
     * @date 2017年6月30日 下午4:12:46
     * @return int
     * @param param
     * @return
     */
    int deleteGroupLableByGroupIdForBatch(Map<String,Object> param);
    /**
     * <p>删除分组信息时删除分组用户关联表</p>
     * @author LT
     * @date 2017年6月30日 下午4:24:31
     * @return int
     * @param param
     * @return
     */
    int deleteGroupCustomersByGroupIdForBatch(Map<String,Object> param);

    /***
     * <p>标签ID获取会员标签分组信息</p>
     * @author LT
     * @date 2017年6月30日 下午5:16:15
     * @return List<TCustomerGroup>
     * @param lableid
     * @return
     */
	List<TCustomerGroup> findGroupByLableId(Long lableid);
    
	/***
     * <p>删除分组前验证该分组是否被触发、推送、投发引用</p>
     * @author Wangyang
     * @date 2017年11月2日 下午1:16:15
     * @return List<Map<String, Object>>
     * @param cgID
     * @return
     */
	List<Map<String, Object>> isUse(Long cgID);
	
	/**
	 * <p>会员分组列表页执行状态定时查询</p>
	 * @author WY
	 * @date 2017年12月8日 下午2:14:45
	 * @return List<Map<String, Object>>
	 * @param ids
	 */
	List<Map<String, Object>> findStaticByIds(String[] ids);
	
	int updateForExport(TCustomerGroup record);
}