package cn.com.ylpw.web.crm.quarz.service;

import java.util.List;

import cn.com.ylpw.web.crm.entity.sys.SysDictionarie;

/**
 * @ClassName: DictionarieService
 * @Description:数据字典
 * @author LT
 * @date 2017年6月14日 上午11:40:29
 */
public interface DictionarieService extends  BaseService<SysDictionarie> {

	/**
	 * <p>根据省的CODE获取城市ID</p>
	 * @author LT
	 * @date 2017年6月14日 上午11:43:59
	 * @return List<Long>
	 * @param provCode
	 * @return
	 */
	List <Integer> findCityIdsByProvCode(String  provCode) ;

	
	/**
	 * <p>商品大类A 的code 获取 商品类别B</p>
	 * @author LT
	 * @date 2017年6月14日 下午2:15:18
	 * @return List<String>
	 * @param typeaCode
	 * @return
	 */
	List <String> findProTypebByTypea(String  typeaCode);

	
	List<String> findCityNamesByCityIds(List<Integer> findCityIdsByProvCode);
}
