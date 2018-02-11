package cn.com.ylpw.web.crm.mapper;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.ylpw.web.crm.util.Page;  
  
@Repository("baseDao")  
public class BaseDao<T, PK extends Serializable> extends SqlSessionDaoSupport implements Serializable {  
      
    private static final long serialVersionUID = 7623507504198633838L;  
  
    public String getPOSTFIX() {
		return POSTFIX;
	}

	public String get_MAPPER() {
		return _MAPPER;
	}

	private final String POSTFIX = "cn.com.ylpw.web.crm.mapper.";  
  
    private final String _INSERT = ".insert";  
  
    private final String _INSERTSELECTIVE = ".insertSelective";  
  
    private final String _SELECTBYPRIMARYKEY = ".selectByPrimaryKey";  
  
    private final String _UPDATEBYPRIMARYKEY = ".updateByPrimaryKey";  
  
    private final String _UPDATEBYPRIMARYKEYSELECTIVE = ".updateByPrimaryKeySelective";  
  
    private final String _DELETEBYPRIMARYKEY = ".deleteByPrimaryKey";
    private final String _MAPPER = "Mapper";
    
    
    
    
    @Autowired  
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);  
    }  
    /*GenericsUtils为工具类，请见下方代码 
          泛型获得XXXEntity，将其转换为XXXEntityDao，具体操作替换掉Entity变成XXXDao，对应Mapper.xml中的namespace命名 
        */  
      
    public int insert(T entity) {  
        return getSqlSession().insert( entity.getClass().getName().replaceFirst("entity", "mapper")+_MAPPER+ _INSERT, entity);  
    }  
      
      
    public int insertSelective(T record) {  
        return getSqlSession().insert(  
        		record.getClass().getName().replaceFirst("entity", "mapper")+_MAPPER+_INSERTSELECTIVE, record);  
    }  
  
    public T selectByPrimaryKey(PK id,Class entity  ) {
        return getSqlSession().selectOne( entity.getName().replaceFirst("entity", "mapper")+_MAPPER+ _SELECTBYPRIMARYKEY, id);  
    }  
  
      
    public int updateByPrimaryKey(T record ) {  
        return getSqlSession().update( record.getClass().getName().replaceFirst("entity", "mapper")+_MAPPER+ _UPDATEBYPRIMARYKEY, record);  
    }   
  
    public int updateByPrimaryKeySelective(T record) {  
        return getSqlSession().update(  
        		record.getClass().getName().replaceFirst("entity", "mapper")+_MAPPER+_UPDATEBYPRIMARYKEYSELECTIVE, record);  
    }  
  
    public int deleteByPrimaryKey(PK id,Class entity) {  
        return getSqlSession().delete(  
        		entity.getName().replaceFirst("entity", "mapper")+_MAPPER+ _DELETEBYPRIMARYKEY, id);  
    }
    
    
    @SuppressWarnings({ "rawtypes", "unchecked" })  
    public <M> PageInfo<M> pageFindModel(String statementKey,  Page<Map<String,Object>> page , Object parameter,Class entity) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {  
        Map params = new HashMap();  
        if (parameter != null) {  
            if (parameter instanceof Map) {  
                params.putAll((Map) parameter);  
            } else {  
                Map parameterObject = PropertyUtils.describe(parameter);  
                params.putAll(parameterObject);  
            }  
        }  
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        
        List<M> list = getSqlSession().selectList(entity.getName().replaceFirst("entity", "mapper")+_MAPPER+"."+statementKey, params);  
        PageInfo<M> pageInfo = new PageInfo(list);  
        page.setData(list);
        page.setTotal(pageInfo.getTotal());
        return pageInfo;  
    }  
    @SuppressWarnings({ "rawtypes", "unchecked" })  
    public <M> PageInfo<M> pageFindModel(String statementKey,  Page<Map<String,Object>> page ,
    		Object parameter,Class entity,Boolean iscount) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {  
    	Map params = new HashMap();  
    	if (parameter != null) {  
    		if (parameter instanceof Map) {  
    			params.putAll((Map) parameter);  
    		} else {  
    			Map parameterObject = PropertyUtils.describe(parameter);  
    			params.putAll(parameterObject);  
    		}  
    	}  
    	PageHelper.startPage(page.getPageNo(), page.getPageSize(),iscount);
    	
    	List<M> list = getSqlSession().selectList(entity.getName().replaceFirst("entity", "mapper")+_MAPPER+"."+statementKey, params);  
    	PageInfo<M> pageInfo = new PageInfo(list);  
    	page.setData(list);
    	page.setTotal(pageInfo.getTotal());
    	return pageInfo;  
    }
    
    
    public Object findOneObject(String mapperKey, Object  searchParam,Class entity)throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
		 Map params = new HashMap();  
	        if (searchParam != null) {  
	            if (searchParam instanceof Map) {  
	                params.putAll((Map) searchParam);  
	            } else {  
	                Map parameterObject = PropertyUtils.describe(searchParam);  
	                params.putAll(parameterObject);  
	            }  
	        }
	        
		return getSqlSession().selectOne(entity.getName().replaceFirst("entity", "mapper")+_MAPPER+"."+mapperKey, params);
	}
  
      
}  