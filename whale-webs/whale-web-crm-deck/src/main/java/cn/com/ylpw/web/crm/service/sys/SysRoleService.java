package cn.com.ylpw.web.crm.service.sys;

import java.util.List;
import java.util.Map;

import cn.com.ylpw.web.crm.base.constants.RolePermEnum;
import cn.com.ylpw.web.crm.entity.sys.SysRole;
import cn.com.ylpw.web.crm.model.SysRolePermForm;
import cn.com.ylpw.web.crm.model.sys.SysRoleGrid;
import cn.com.ylpw.web.crm.util.Page;

 /**
  * @ClassName: SysRoleService
  * @Description: 角色管理-业务层
  * @author zhaohb
  * @date 2017-3-14 下午3:31:14
  */
public interface SysRoleService {
	
	void save(SysRole sysRole);
	
	void update(SysRole sysRole);
    
    void delete(SysRole sysRole);
	
	SysRole findById(Long id);
    
    List<SysRoleGrid> findAll(SysRole sysRole);
	
	Page<SysRoleGrid> findAll(SysRole sysRole, Page<SysRoleGrid> page);
    
    /**
      * @Title: countRoleByName
      * @Description: 按角色名称查询记录条数
      * @param name    角色名称
      * @return
      * 
      * @author zhaohb
      * @date 2017-3-17 上午10:31:39
      */
    Integer countRoleByName(String name);
	
	
	/**
	  * @Title: findAllTFconfig
	  * @Description: 角色权限：全部分站城市树节点
	  * @return
	  * 
	  * @author zhaohb
	  * @date 2017-3-14 下午3:34:35
	  */
	List<Map<String, Object>> findAllTFconfig();
	
	/**
	  * @Title: savePerm
	  * @Description: 角色授权
	  * @param sysRolePermForm   权限表单
	  * @return
	  * 
	  * @author zhaohb
	  * @date 2017-3-14 下午3:35:41
	  */
	boolean savePerm(SysRolePermForm sysRolePermForm);
	
	/**
	  * @Title: findBasePerm
	  * @Description: 获取角色权限，范围（销售渠道、推广方式、商品类别）
	  * @param sysRole 角色实体
	  * @return
	  * 
	  * @author zhaohb
	  * @date 2017-3-14 下午3:36:43
	  */
	SysRolePermForm findBasePerm(SysRole sysRole);
	
	/**
	  * @Title: findPerm
	  * @Description: 获取角色相关业务权限点
	  * @param rolePermEnum    业务权限标识
	  * @param sysRoleId       角色ID
	  * @return
	  * 
	  * @author zhaohb
	  * @date 2017-3-14 下午3:37:20
	  */
	List<Object> findPerm(RolePermEnum rolePermEnum, Long sysRoleId);
	
}
