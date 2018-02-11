package cn.com.ylpw.web.crm.service.sys;

import java.util.List;

import cn.com.ylpw.web.crm.entity.sys.SysMenu;
import cn.com.ylpw.web.crm.model.sys.SysMenuGrid;
import cn.com.ylpw.web.crm.util.Page;

 /**
  * @ClassName: SysMenuService
  * @Description: 菜单管理-业务层
  * @author zhaohb
  * @date 2017-3-14 下午3:43:16
  */
public interface SysMenuService {
	
	void save(SysMenu sysMenu);
    
    void update(SysMenu sysMenu);
    
	void delete(SysMenu sysMenu);
	
	SysMenu findById(Long id);

    List<SysMenuGrid> findAll(SysMenu sysMenu);
	
	Page<SysMenuGrid> findAll(SysMenu sysMenu, Page<SysMenuGrid> page);
	
	/**
	  * @Title: findByRoleId
	  * @Description: 用户登陆，菜单（左侧菜单、角色菜单授权）
	  * @param sysRoleId  角色ID
	  * @return
	  * 
	  * @author zhaohb
	  * @date 2017-3-14 下午3:43:44
	  */
	List<SysMenu> findByRoleId(Long sysRoleId);
	
	/**
	  * @Title: findAllMenusUrl
	  * @Description: 获取BI系统，全部菜单的有效URL（二级菜单）
	  * @return
	  * 
	  * @author zhaohb
	  * @date 2017-3-15 下午1:26:21
	  */
	List<String> findAllMenusUrl();
	
}
