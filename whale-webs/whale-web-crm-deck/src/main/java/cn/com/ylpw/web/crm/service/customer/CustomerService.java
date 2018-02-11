package cn.com.ylpw.web.crm.service.customer;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.com.ylpw.web.crm.entity.customer.TCustomerIntegral;
import cn.com.ylpw.web.crm.entity.customer.TCustomers;
import cn.com.ylpw.web.crm.model.importVO.TCustomersImportVO;
import cn.com.ylpw.web.crm.service.BaseService;
import cn.com.ylpw.web.crm.util.Page;


public interface CustomerService extends  BaseService<TCustomers> {

	int updShieldBatch(Long[] ids);
	
	int importCustomerInfo(List<TCustomersImportVO> importCustomerInfoList, List<Map<String, Object>> ordersource);
	/***
	 * <p>查询会员信息</p>
	 * @author LT
	 * @date 2017年5月16日 下午2:17:20
	 * @return Map<String,Object>
	 * @param id
	 * @return
	 */
	Map<String,Object> findCustomerInfo(Long id);
	
	/**
	 * 分页查询
	 */
	public PageInfo<Map<String,Object>> pageFindModel(Page<Map<String,Object>> page , Map<String,Object> searParam);

	/**
	 * <p>更新用户积分操作</p>
	 * @author LT
	 * @date 2017年8月30日 下午4:18:08
	 * @return void
	 * @param customer
	 * @param customerIntegral
	 */
	void updateIntegral(TCustomers customer, TCustomerIntegral customerIntegral);

	/**
	 * <p>用户积分禁用</p>
	 * @author LT
	 * @date 2017年8月30日 下午5:46:44
	 * @return void
	 * @param ids
	 */
	int updIntegral2Dis(Long[] ids, Integer status);
	
	/**
	 * <p>用户积分清零</p>
	 * @author LT
	 * @date 2017年8月30日 下午5:46:57
	 * @return void
	 * @param ids
	 */
	int updIntegral2Clear(Long[] ids);
	
	
    public int insert(TCustomers record);  
    public int insertSelective(TCustomers record);  
    public int updateByPrimaryKey(TCustomers record);  
    public int updateByPrimaryKeySelective(TCustomers record);  
    public int deleteByPrimaryKey(Long   id);
    
    
	
}
