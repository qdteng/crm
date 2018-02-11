package cn.com.ylpw.web.crm.mapper.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Mapper;
import cn.com.ylpw.web.crm.base.constants.RolePermEnum;
import cn.com.ylpw.web.crm.entity.sys.SysRole;
import cn.com.ylpw.web.crm.model.sys.SysRoleGrid;

@Mapper
public interface SysRoleMapper {
	
	void save(SysRole sysRole);
    
    void update(SysRole SysRole);
    
    void delete(SysRole SysRole);

    SysRole findById(Long id);
	
	List<SysRoleGrid> findAll(SysRole sysRole);

    Integer countRoleByName(@Param("name")String name);
	
	
	List<Map<String, Object>> findAllTFconfig();
	
	List<Long> findNewRolePerms(@Param("perm")RolePermEnum rolePermEnum, @Param("sysRoleId")Long sysRoleId, @Param("permIds")String permIds);
	
	void updateRolePerms(@Param("perm")RolePermEnum rolePermEnum, @Param("sysRoleId")Long sysRoleId, @Param("permIds")String permIds, @Param("isValid")Integer isValid);
	
	void saveNewPerm(@Param("perm")RolePermEnum rolePermEnum, @Param("sysRoleId")Long sysRoleId, @Param("permId")Long permId, @Param("isValid")Integer isValid);

    List<Object> findRolePerm(@Param("perm")RolePermEnum rolePermEnum, @Param("sysRoleId")Long sysRoleId, @Param("isValid")Integer isValid);

    void deletePermsByRoleId(@Param("perm")RolePermEnum rolePermEnum, @Param("sysRoleId")Long sysRoleId);
    
}
