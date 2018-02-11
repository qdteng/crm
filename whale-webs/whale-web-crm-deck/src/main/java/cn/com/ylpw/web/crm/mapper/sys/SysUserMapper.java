package cn.com.ylpw.web.crm.mapper.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Mapper;

import cn.com.ylpw.web.crm.entity.sys.SysUser;
import cn.com.ylpw.web.crm.model.sys.SysUserGrid;

@Mapper
public interface SysUserMapper {
	
	void save(SysUser sysUser);
    
    void update(SysUser sysUser);
    
    void delete(SysUser sysUser);

    SysUser findById(Long id);
	
	List<SysUserGrid> findAll(SysUser sysUser);
	
	SysUser findBySysUser(SysUser sysUser);
	
	Integer countByRoleId(@Param("sysRoleId") Long sysRoleId);
	
}
