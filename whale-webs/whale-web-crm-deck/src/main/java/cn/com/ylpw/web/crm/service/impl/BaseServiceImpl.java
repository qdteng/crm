package cn.com.ylpw.web.crm.service.impl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import cn.com.ylpw.web.crm.mapper.BaseDao;
import cn.com.ylpw.web.crm.service.BaseService;
import cn.com.ylpw.web.crm.util.Page;  

/**
 * @ClassName: BaseServiceImpl
 * @Description:
 * @author LT
 * @date 2017年4月19日 上午9:10:39
 * @param <T>
 */
@Service  
public abstract  class BaseServiceImpl <T> implements BaseService<T>{  
	private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
	
	protected  abstract Class setClass()  ;
	
	protected String getMapperKey(String key){
		return setClass().getName().replaceFirst("entity", "mapper")+this.baseDao.get_MAPPER() +"."+key ;
	}
    @Autowired
    private BaseDao<T, Serializable> baseDao;  
      
    public BaseDao<T, Serializable> getBaseDao() {  
        return baseDao;  
    }  
    public void setBaseDao(BaseDao<T, Serializable> baseDao) {  
        this.baseDao = baseDao;  
    }  
  
    public int insert(T entity) {  
        return baseDao.insert(entity);  
    }  
    public int insertSelective(T record) {  
        return baseDao.insertSelective(record);  
    }  
    public int updateByPrimaryKey(T record) {  
        return baseDao.updateByPrimaryKey(record);  
    }  
    public int updateByPrimaryKeySelective(T record) {  
        return baseDao.updateByPrimaryKeySelective(record);  
    }  
    public int deleteByPrimaryKey(Long id) {  
        return baseDao.deleteByPrimaryKey(id,setClass() );  
    }  
    
    public T selectByPrimaryKey(Long id ) {  
        return baseDao.selectByPrimaryKey(id,setClass() );  
    }  
   
    
	public PageInfo<Map<String,Object>>  pageFindModel(String mapperKey,Page<Map<String,Object>> page, Object searParam) {
		
		try {
			return baseDao.pageFindModel(mapperKey,  page , searParam,setClass() );
		} catch ( Exception e) {
			logger.error("",e);
		} 
		return null ;
	}
	
	
	public int batchDel(Long[] ids) {
		Map<String, Object> parma = new HashMap<String, Object>();
		parma.put("ids", ids);
		int num = baseDao.getSqlSession().delete(getMapperKey("batchDel"), parma);
		return num;
	}
	
	
}  