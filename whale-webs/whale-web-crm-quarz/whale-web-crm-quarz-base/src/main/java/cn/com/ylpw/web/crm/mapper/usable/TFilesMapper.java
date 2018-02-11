package cn.com.ylpw.web.crm.mapper.usable;

import java.util.Map;

import cn.com.ylpw.web.crm.entity.usable.TFiles;

public interface TFilesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TFiles record);

    int insertSelective(TFiles record);

    TFiles selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TFiles record);

    int updateByPrimaryKey(TFiles record);
    
    void batchDelByIds(Map<String, Object> paramMap);
}