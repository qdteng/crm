
package cn.com.ylpw.web.crm.quarz.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.com.ylpw.web.crm.util.Page;

public interface BaseService<T> {

    public int insert(T record);  
    public int insertSelective(T record);  
    public T selectByPrimaryKey(Long id);  
    public int updateByPrimaryKey(T record);  
    public int updateByPrimaryKeySelective(T record);  
    public int deleteByPrimaryKey(Long   id);
    public PageInfo<Map<String,Object>> pageFindModel(String mapperKey,Page<Map<String,Object>> page , Object searParam);
}
