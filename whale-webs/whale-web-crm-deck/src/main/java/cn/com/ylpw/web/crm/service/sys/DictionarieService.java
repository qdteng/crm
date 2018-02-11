package cn.com.ylpw.web.crm.service.sys;

import cn.com.ylpw.web.crm.entity.sys.SysDictionarie;
import cn.com.ylpw.web.crm.service.BaseService;

/**
 * @ClassName: DictionarieService
 * @Description:数据字典
 * @author LT
 * @date 2017年6月14日 上午11:40:29
 */
public interface DictionarieService extends  BaseService<SysDictionarie> {

	/***
	 * <p>批量删除</p>
	 * @author LT
	 * @date 2017年4月19日 上午9:10:21
	 * @return void
	 * @param ids
	 
	 */
	int deleteBatch(Long[] ids);
	
	
}
