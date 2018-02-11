package cn.com.ylpw.web.crm.mapper.customer;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.ylpw.web.crm.entity.customer.TCustomers;

public interface TCustomersMapper {
	
	public List<Long>  findUsersByIds(Map<String,Object > searchParam);
	
	
	/**
	 * <p>更新用户成长值</p>
	 * @author LT
	 * @date 2017年6月22日 下午1:56:59
	 * @return int
	 * @param record
	 * @return
	 */
	int updateCustomerIndexs(TCustomers record);


	/**
	 * <p>查询需要更新用户等级的用户数量</p>
	 * @author LT
	 * @date 2017年6月27日 上午11:16:52
	 * @return
	 */
	public Long findExistsGradeForUpdate( Map <String ,Object> param );

	/**
	 * <p>根据成长值更新用户等级</p>
	 * @author LT
	 * @date 2017年6月27日 上午11:30:07
	 * @return
	 */
	public Long updateGradeByIndex( Map <String ,Object> param );
	/**
	 * <p>根据用户一般动态分组查询用户ID</p>
	 * @author LT
	 * @date 2017年6月28日 上午10:24:07
	 * @return List<Long>
	 * @param searchParam
	 * @return
	 */
	public List<Map<String,Object>>  findUsersByNormalGroup(Map<String,Object > searchParam);

	/***
	 * <p>标签分组查询用户信息</p>
	 * @author LT
	 * @date 2017年6月29日 上午9:05:09
	 * @return List<Long>
	 * @param searchParam
	 * @return
	 */
	public List<Map<String,Object>>   findUsersByLableGroup(Map<String, Object> searchParam);


	/***
	 * <p>减去用户过期的积分</p>
	 * @author LT
	 * @date 2017年9月1日 上午9:18:00
	 * @return Integer
	 * @param tmpCus
	 * @return
	 */
	public Integer updateIntegral2minus(TCustomers tmpCus);


	/***
	 * <p>查询大于Maxid的指定等级用户数量</p>
	 * @author LT
	 * @date 2017年9月27日 上午9:43:09
	 * @return Long
	 * @param gradeId
	 * @param currentMaxid
	 * @return
	 
	 */
	public Long findCustomersSizeByGradeId(@Param("gradeid") Long gradeid,@Param("maxid")  Long maxid);


	/**
	 * <p>获取最后更新等级Id 的用户信息</p>
	 * @author LT
	 * @date 2017年12月14日 下午5:39:14
	 * @return Long
	 * @param gradeId
	 * @return
	 */
	public Long findLastDayUpdateByGradeId(@Param("gradeId") Long gradeId);
	
}