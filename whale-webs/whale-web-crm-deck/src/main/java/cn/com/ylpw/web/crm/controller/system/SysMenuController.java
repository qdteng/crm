package cn.com.ylpw.web.crm.controller.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;

import cn.com.ylpw.core.tools.AjaxResult;
import cn.com.ylpw.web.crm.base.constants.RolePermEnum;
import cn.com.ylpw.web.crm.entity.sys.SysMenu;
import cn.com.ylpw.web.crm.entity.sys.SysUser;
import cn.com.ylpw.web.crm.model.sys.SysMenuGrid;
import cn.com.ylpw.web.crm.model.tree.TreeNode;
import cn.com.ylpw.web.crm.service.sys.SysMenuService;
import cn.com.ylpw.web.crm.service.sys.SysRoleService;
import cn.com.ylpw.web.crm.util.Page;
import cn.com.ylpw.web.crm.util.SessionUtils;

 /**
  * @ClassName: SysMenuController
  * @Description: 菜单管理-控制器
  * @author zhaohb
  * @date 2017-3-14 下午3:14:30
  */
@Controller("sysMenuController")
@RequestMapping("/sysmenu")
public class SysMenuController {
  
	/**
	 * Logger for this class
	 */
  private static final Logger logger = LoggerFactory.getLogger(SysMenuController.class);
  @Autowired
  private SysMenuService sysMenuService;
  
  @Autowired
  private SysRoleService sysRoleService;
  
  /**
    * @Title: show
    * @Description: 菜单管理页
    * @param model
    * @param sysMenu    菜单实体 查询条件（备用）
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午3:15:04
    */
  @RequestMapping("/show.do")
  public String show(Model model, SysMenu sysMenu, Page<SysMenuGrid> page) {
    page = sysMenuService.findAll(sysMenu, page);
    SysMenu tSysMenu = null;
    List<SysMenu> topMenus = Lists.newArrayList();
    tSysMenu = new SysMenu();
    tSysMenu.setId(0l);
    tSysMenu.setName("无");
    topMenus.add(tSysMenu);
    SysMenu topSysMenu = new SysMenu();
    topSysMenu.setPid(0l);
    for (SysMenuGrid menu : sysMenuService.findAll(topSysMenu)) {
        tSysMenu = new SysMenu();
        tSysMenu.setId(menu.getId());
        tSysMenu.setName(menu.getName());
        topMenus.add(tSysMenu);
    }
    model.addAttribute("page", page);
    model.addAttribute("topMenus", topMenus);
    return "/sysmenu/show";
  }
  
  /**
    * @Title: save
    * @Description: 创建菜单
    * @param sysMenu    菜单实体
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午3:15:56
    */
  @RequestMapping(value="/save.do")
  @ResponseBody
  public AjaxResult save(SysMenu sysMenu) {
	AjaxResult  ajaxResult = AjaxResult.Instance();
	
    try { 
		SysUser sysUser = SessionUtils.currentUser();
		sysMenu.setCreateId(sysUser.getId());
		sysMenu.setCreateName(sysUser.getAccCode());
		sysMenuService.save(sysMenu);
	} catch (Exception e) {
		e.printStackTrace();
		logger.error("菜单添加错误",e);
		ajaxResult.addError("添加失败");
	}
    
    return  ajaxResult; 
  }
  
  /**
    * @Title: edit
    * @Description: 编辑菜单
    * @param sysMenu    菜单实体
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午3:17:56
    */
  @RequestMapping(value="/edit.do"  )
  @ResponseBody
  public AjaxResult edit(SysMenu sysMenu) {
	  AjaxResult  ajaxResult = AjaxResult.Instance();
   try {
	    SysUser sysUser = SessionUtils.currentUser();
	    sysMenu.setUpdateId(sysUser.getId());
	    sysMenu.setUpdateName(sysUser.getAccCode());
	    sysMenuService.update(sysMenu);
   }catch (Exception e) {
		e.printStackTrace();
		logger.error("菜单修改错误",e);
		ajaxResult.addError("添加失败");
	}
    return  ajaxResult; 
  }
  
  /**
    * @Title: editStatus
    * @Description:  修改菜单状态（显示、隐藏）
    * @param id     菜单ID
    * @param type   类型（1：锁定、2：解锁）
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午3:16:19
    */
  @RequestMapping(value="/editStatus.do", produces = "text/plain;charset=utf-8")
  public String editStatus(Long id, String type) {
    if (null != type && type.matches("1|2")) {
      SysUser sysUser = SessionUtils.currentUser();
      SysMenu sysMenu = new SysMenu();
      sysMenu.setId(id);
      sysMenu.setStatus("2".equals(type)?1:0);
      sysMenu.setUpdateId(sysUser.getId());
      sysMenu.setUpdateName(sysUser.getAccCode());
      sysMenuService.update(sysMenu);
    }
    return "redirect:/sysmenu/show.do";
  }
  
  /**
    * @Title: del
    * @Description: 删除菜单
    * @param sysMenu    菜单实体
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午3:18:35
    */
  @RequestMapping(value="/del.do")
  @ResponseBody
  public  AjaxResult  del(SysMenu sysMenu) {
	AjaxResult  ajaxResult = AjaxResult.Instance();
    sysMenuService.delete(sysMenu);
    
    return ajaxResult;
  }
  
  /**
    * @Title: tree
    * @Description: 角色管理，授权窗口，菜单授权树
    * @param sysRoleId  角色ID
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午3:19:08
    */
  @RequestMapping(value="/tree.do")
  @ResponseBody
  public List<TreeNode> tree(Long sysRoleId) {
    List<TreeNode> nodes = Lists.newArrayList();
    TreeNode allNode = new TreeNode("0", "全部", "-1", 0);
    allNode.setCheckstate(0);
    SysMenu sysMenu = new SysMenu();
    sysMenu.setStatus(1);
    List<SysMenuGrid> menus = sysMenuService.findAll(sysMenu);
    TreeNode node = null;
    String roleMenuIds = "";
    if (null != sysRoleId) {
      roleMenuIds = com.google.common.base.Joiner.on("|").join(sysRoleService.findPerm(RolePermEnum.SYS_ROLE_MENU, sysRoleId));
    }
    for (SysMenuGrid menu : menus) {
      if (new Long(0).equals(menu.getPid())) {
        node = new TreeNode(menu.getId().toString(), menu.getName(), menu.getId().toString(), (menu.getId().toString().matches(roleMenuIds)?1:0));
        for (SysMenuGrid zmenu : menus) {
          if (menu.getId().equals(zmenu.getPid())) {
            node.getChildNodes().add(new TreeNode(zmenu.getId().toString(), zmenu.getName(), zmenu.getId().toString(), (zmenu.getId().toString().matches(roleMenuIds)?1:0)));
          }
        }
        allNode.getChildNodes().add(node);
      }
    }
    nodes.add(allNode);
    return nodes;
  }
  
}
