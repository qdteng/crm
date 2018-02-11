package cn.com.ylpw.web.crm.service.customer;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.com.ylpw.web.crm.entity.customer.TCustomerGroup;
import cn.com.ylpw.web.crm.model.CustomerLableGroup;
import cn.com.ylpw.web.crm.util.Page;

/***
 * @ClassName: CustomerGroupService
 * @Description: 切面注入的类
 * @author LT
 * @date 2017年6月13日 上午9:52:18
 */
public interface CustomerGroupService   {
	
    public int insertSelective(TCustomerGroup record);  
    public TCustomerGroup selectByPrimaryKey(Long id);  
    public int updateByPrimaryKeySelective(TCustomerGroup record);  
    public int deleteByPrimaryKey(Long   id);
    public PageInfo<Map<String,Object>> pageFindModel(String mapperKey,Page<Map<String,Object>> page , Object searParam);
    /**
     * <p>批量删除方法</p>
     * @author LT
     * @date 2017年6月13日 上午10:00:20
     * @return int
     * @param ids
     * @return
     */
	int batchDel(Long[] ids);
	/**
	 * <p>保存标签分组</p>
	 * @author LT
	 * @date 2017年6月13日 上午10:00:38
	 * @return void
	 * @param lableGroup
	 */
	void saveLableGroup(CustomerLableGroup lableGroup);

	/**
	 * <p>更新标签分组</p>
	 * @author LT
	 * @date 2017年6月5日 下午5:34:31
	 * @return void
	 * @param lableGroup
	 */
	void updateLableGroup(CustomerLableGroup lableGroup);
	/**
	 * <p>标签ID查询会员标签分组</p>
	 * @author LT
	 * @date 2017年6月30日 下午5:14:15
	 * @return List<TCustomerGroup>
	 * @param id
	 * @return
	 */
	public List<TCustomerGroup> selectGroupsByLableId(Long lableid);
	
	/**
	 * <p>用户分组导出用户</p>
	 * @author LT
	 * @date 2017年7月4日 下午2:04:45
	 * @return void
	 * @param groupid
	 */
	public List<String[]> findCustomerByGroupId(Long groupid ,  Map<String,String> filename);
	
	/**
	 * <p>校验当前用户分组是否正在其他应用中做计算</p>
	 * @author LT
	 * @date 2017年10月25日 下午3:36:39
	 * @return boolean
	 * @param groupid
	 * @return
	 */
	boolean validateIsDoing(Long groupid );
	
	/**
	 * <p>校验当前用户分组是否正在其他应用中做计算</p>
	 * @author LT
	 * @date 2017年10月25日 下午3:36:39
	 * @return boolean
	 * @param groupid
	 * @return
	 */
	boolean isUse(Long groupid );
	
	/**
	 * <p>会员分组列表页执行状态定时查询</p>
	 * @author WY
	 * @date 2017年12月8日 下午2:04:45
	 * @return List<Map<String, Object>>
	 * @param groupIds
	 */
	public List<Map<String, Object>> findStaticByIds(String[] groupIds);
	
	/**
	 * <p>会员分组列表页执行状态定时查询</p>
	 * @author WY
	 * @date 2017年12月8日 下午2:04:45
	 * @return List<Map<String, Object>>
	 * @param groupIds
	 */
	public List<Map<String, Object>> findExportStaticByIds(String[] groupIds);
	
	/***
	 * <p>更新TFile TCustomerGroup</p>
	 * @author WY
	 * @date 2017年12月15日 下午16:52:12
	 * @return 
	 * @param Map<String,Object> resultMap, Long groupId
	 * @return
	 */
	void updateCustomerGroup(Long groupId);
}
