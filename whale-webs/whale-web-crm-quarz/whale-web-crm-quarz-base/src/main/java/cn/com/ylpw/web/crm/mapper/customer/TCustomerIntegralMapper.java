package cn.com.ylpw.web.crm.mapper.customer;

import java.util.List;
import java.util.Map;

import cn.com.ylpw.web.crm.entity.customer.TCustomerIntegral;

public interface TCustomerIntegralMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCustomerIntegral record);

    int insertSelective(TCustomerIntegral record);

    TCustomerIntegral selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCustomerIntegral record);

    int updateByPrimaryKey(TCustomerIntegral record);

    
	int batchSave(List<TCustomerIntegral> list);

	/***
	 * <p>根据规则1查询无效积分</p>
	 * @author LT
	 * @date 2017年9月1日 上午10:44:01
	 * @return List<TCustomerIntegral>
	 * @param searchParam
	 * @return
	 
	 */
	List<TCustomerIntegral> findIntegralByTimeLimit1(Map<String, Object> searchParam);
	
	int batchUpdate2dis(List<Long> ids);

	/***
	 * <p>根据规则2查询无效积分</p>
	 * @author LT
	 * @date 2017年9月1日 上午10:44:01
	 * @return List<TCustomerIntegral>
	 * @param searchParam
	 * @return
	 */
	List<TCustomerIntegral> findIntegralByTimeLimit2(Map<String, Object> searchParam);
	
	/***
	 * <p>根据规则3查询无效积分</p>
	 * @author LT
	 * @date 2017年9月1日 上午10:44:01
	 * @return List<TCustomerIntegral>
	 * @param searchParam
	 * @return
	 */
	List<TCustomerIntegral> findIntegralByTimeLimit3(Map<String, Object> searchParam);
}