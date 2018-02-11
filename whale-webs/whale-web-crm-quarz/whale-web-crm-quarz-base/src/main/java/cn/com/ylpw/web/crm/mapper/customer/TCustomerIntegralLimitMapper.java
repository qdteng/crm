package cn.com.ylpw.web.crm.mapper.customer;

import java.util.List;

import cn.com.ylpw.web.crm.entity.customer.TCustomerIntegralLimit;

public interface TCustomerIntegralLimitMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCustomerIntegralLimit record);

    int insertSelective(TCustomerIntegralLimit record);

    TCustomerIntegralLimit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCustomerIntegralLimit record);

    int updateByPrimaryKey(TCustomerIntegralLimit record);
    /**
     * <p>当前积分限制规则</p>
     * @author LT
     * @date 2017年8月31日 下午2:01:08
     * @return TCustomerIntegralLimit
     * @return
     */
	TCustomerIntegralLimit findCurrentCustomerIntegralLimit();

	/**
	 * <p>查询所有用户积分限制</p>
	 * @author LT
	 * @date 2017年8月31日 下午3:59:41
	 * @return List<TCustomerIntegralLimit>
	 * @return
	 */
	List<TCustomerIntegralLimit> findAllLimit();
	
}