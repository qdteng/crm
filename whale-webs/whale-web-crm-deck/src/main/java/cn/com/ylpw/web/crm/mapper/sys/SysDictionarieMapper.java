package cn.com.ylpw.web.crm.mapper.sys;

import org.apache.ibatis.annotations.Mapper;

import cn.com.ylpw.web.crm.entity.sys.SysDictionarie;
@Mapper
public interface SysDictionarieMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDictionarie record);

    int insertSelective(SysDictionarie record);

    SysDictionarie selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDictionarie record);

    int updateByPrimaryKey(SysDictionarie record);
}