package cn.com.ylpw.web.crm.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.ylpw.web.crm.entity.sys.SysRole;
import cn.com.ylpw.web.crm.entity.sys.SysUser;
import cn.com.ylpw.web.crm.model.sys.SysRoleGrid;
import cn.com.ylpw.web.crm.model.sys.SysUserGrid;
import cn.com.ylpw.web.crm.service.sys.SysRoleService;
import cn.com.ylpw.web.crm.service.sys.SysUserService;
import cn.com.ylpw.web.crm.util.Page;
import cn.com.ylpw.web.crm.util.SessionUtils;

 /**
  * @ClassName: SysUserController
  * @Description: 用户管理-控制器
  * @author zhaohb
  * @date 2017-3-14 下午3:07:42
  */
@Controller("sysUserController")
@RequestMapping("/sysuser")
public class SysUserController {
  
  @Autowired
  private SysUserService sysUserService;
  
  @Autowired
  private SysRoleService sysRoleService;
	
  /**
    * @Title: show
    * @Description: 用户管理页
    * @param model
    * @param sysUser 用户实体 ，查询条件参数
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午3:08:52
    */
  @RequestMapping("/show.do")
  public String show(Model model, SysUser sysUser, Page<SysUserGrid> page) {
    page = sysUserService.findAll(sysUser, page);
    List<SysRoleGrid> roles = sysRoleService.findAll(new SysRole());
    model.addAttribute("roles", roles);
    model.addAttribute("sysUser", sysUser);
    model.addAttribute("page", page);
    return "/sysuser/show";
  }
  
  /**
    * @Title: save
    * @Description: 创建用户
    * @param sysUser 用户实体
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午3:09:30
    */
  @RequestMapping(value="/save.do", method=RequestMethod.POST, produces = "text/plain;charset=utf-8")
  public String save(SysUser sysUser) {
    SysUser cSysUser = SessionUtils.currentUser();
    sysUser.setCreateId(cSysUser.getId());
    sysUser.setCreateName(cSysUser.getAccCode());
    sysUserService.save(sysUser);
    return "redirect:/sysuser/show.do";
  }
  
  /**
    * @Title: edit
    * @Description: 编辑用户
    * @param sysUser    用户实体
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午3:10:00
    */
  @RequestMapping(value="/edit.do", method=RequestMethod.POST, produces = "text/plain;charset=utf-8")
  public String edit(SysUser sysUser) {
    SysUser cSysUser = SessionUtils.currentUser();
    sysUser.setUpdateId(cSysUser.getId());
    sysUser.setUpdateName(cSysUser.getAccCode());
    sysUserService.update(sysUser);
    return "redirect:/sysuser/show.do";
  }
  
  /**
    * @Title: editStatus
    * @Description: 修改用户状态（锁定、解锁）
    * @param id     用户Id
    * @param type   类型（1：锁定、2：解锁）
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午3:10:19
    */
  @RequestMapping(value="/editStatus.do", produces = "text/plain;charset=utf-8")
  public String editStatus(Long id, String type) {
    if (null != type && type.matches("1|2")) {
      SysUser cSysUser = SessionUtils.currentUser();
      SysUser sysUser = new SysUser();
      sysUser.setId(id);
      sysUser.setStatus("2".equals(type)?1:0);
      sysUser.setUpdateId(cSysUser.getId());
      sysUser.setUpdateName(cSysUser.getAccCode());
      sysUserService.update(sysUser);
    }
    return "redirect:/sysuser/show.do";
  }
  
  /**
    * @Title: del
    * @Description: 删除用户
    * @param sysUser    用户实体
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午3:12:40
    */
  @RequestMapping(value="/del.do", produces = "text/plain;charset=utf-8")
  public String del(SysUser sysUser) {
    sysUserService.delete(sysUser);
    return "redirect:/sysuser/show.do";
  }
  
  /**
    * @Title: uniqueAccCode
    * @Description: 创建用户，账号唯一性校验
    * @param accCode    账号
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午4:56:57
    */
  @RequestMapping(value="/uniqueAccCode.do")
  public @ResponseBody String uniqueAccCode(String accCode) {
    SysUser sysUser = sysUserService.findByAccCode(accCode);
    if(null != sysUser) return "N";
    return "Y";
  }
  
}
