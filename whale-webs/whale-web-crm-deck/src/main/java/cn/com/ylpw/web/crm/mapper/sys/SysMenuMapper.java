package cn.com.ylpw.web.crm.mapper.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Mapper;

import cn.com.ylpw.web.crm.entity.sys.SysMenu;
import cn.com.ylpw.web.crm.model.sys.SysMenuGrid;

@Mapper
public interface SysMenuMapper {
	
	void save(SysMenu sysMenu);
    
    void update(SysMenu sysMenu);
    
    void delete(SysMenu sysMenu);

    SysMenu findById(Long id);
	
	List<SysMenuGrid> findAll(SysMenu sysMenu);
	
	List<SysMenu> findByRoleId(@Param("roleId")Long roleId);
	
	List<String> findAllMenusUrl();
	
}
