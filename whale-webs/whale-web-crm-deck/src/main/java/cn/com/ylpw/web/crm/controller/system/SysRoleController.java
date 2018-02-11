package cn.com.ylpw.web.crm.controller.system;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import cn.com.ylpw.web.crm.base.constants.RolePermEnum;
import cn.com.ylpw.web.crm.entity.sys.SysRole;
import cn.com.ylpw.web.crm.entity.sys.SysUser;
import cn.com.ylpw.web.crm.model.SysRolePermForm;
import cn.com.ylpw.web.crm.model.sys.SysRoleGrid;
import cn.com.ylpw.web.crm.model.tree.TreeNode;
import cn.com.ylpw.web.crm.service.sys.SysRoleService;
import cn.com.ylpw.web.crm.service.sys.SysUserService;
import cn.com.ylpw.web.crm.util.Page;
import cn.com.ylpw.web.crm.util.SessionUtils;
import cn.com.ylpw.web.crm.util.SpringUtils;

 /**
  * @ClassName: SysRoleController
  * @Description: 角色管理-控制器
  * @author zhaohb
  * @date 2017-3-14 下午2:58:55
  */
@Controller("sysRoleController")
@RequestMapping("/sysrole")
public class SysRoleController {
  
  @Autowired
  private SysRoleService sysRoleService;
  
  @Autowired
  private SysUserService sysUserService;
	
  /**
    * @Title: show
    * @Description: 角色管理页
    * @param model
    * @param sysRole    查询条件（备用）
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午3:06:31
    */
  @RequestMapping("/show.do")
  public String show(Model model, SysRole sysRole, Page<SysRoleGrid> page) {
    page = sysRoleService.findAll(sysRole, page);
    model.addAttribute("page", page);
    model.addAttribute("bi_env", SpringUtils.environment());
    return "/sysrole/show";
  }
  
  /**
    * @Title: save
    * @Description: 创建角色
    * @param sysRole    角色实体
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午2:59:22
    */
  @RequestMapping(value="/save.do", method=RequestMethod.POST, produces = "text/plain;charset=utf-8")
  public String save(SysRole sysRole) {
    SysUser sysUser = SessionUtils.currentUser();
    sysRole.setCreateId(sysUser.getId());
    sysRole.setCreateName(sysUser.getAccCode());
    sysRoleService.save(sysRole);
    return "redirect:/sysrole/show.do";
  }
  
  /**
    * @Title: edit
    * @Description: 编辑角色
    * @param sysRole    角色实体
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午3:00:12
    */
  @RequestMapping(value="/edit.do", method=RequestMethod.POST, produces = "text/plain;charset=utf-8")
  public String edit(SysRole sysRole) {
    SysUser sysUser = SessionUtils.currentUser();
    sysRole.setUpdateId(sysUser.getId());
    sysRole.setUpdateName(sysUser.getAccCode());
    sysRoleService.update(sysRole);
    return "redirect:/sysrole/show.do";
  }
  
  /**
    * @Title: del
    * @Description: 删除角色
    * @param sysRole    角色实体
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午3:02:19
    */
  @RequestMapping(value="/del.do", produces = "text/plain;charset=utf-8")
  public String del(SysRole sysRole, RedirectAttributes redirectAttributes) {
    if(sysUserService.countByRoleId(sysRole.getId())==0){
      sysRoleService.delete(sysRole);
    }else{
      redirectAttributes.addFlashAttribute("delErrorMsg", "该角色下存在用户，删除失败！");
    }
    return "redirect:/sysrole/show.do";
  }
  
  /**
    * @Title: savePerm
    * @Description: 角色授权
    * @param sysRolePermForm    权限表单
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午3:02:51
    */
  @RequestMapping(value="/savePerm.do", method=RequestMethod.POST, produces = "text/plain;charset=utf-8")
  public String savePerm(SysRolePermForm sysRolePermForm) {
    sysRoleService.savePerm(sysRolePermForm);
    return "redirect:/sysrole/show.do";
  }
  
  /**
    * @Title: uniqueName
    * @Description: 角色名称唯一性校验
    * @param name   角色名称
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-17 上午10:38:51
    */
  @RequestMapping(value="/uniqueName.do")
  public @ResponseBody String uniqueName(String name) {
    Integer num = sysRoleService.countRoleByName(name);
    if(null != num && num > 0) return "N";
    return "Y";
  }
  
  /**
    * @Title: findPerm
    * @Description: 获取角色权限，范围（销售渠道、推广方式、商品类别）
    * @param sysRole
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午3:03:37
    */
  @RequestMapping(value="/findPerm.do")
  @ResponseBody
  public SysRolePermForm findPerm(SysRole sysRole) {
    SysRolePermForm sysRolePermForm = new SysRolePermForm();
    SysRole tSysRole = sysRoleService.findById(sysRole.getId());
    if (null != tSysRole) {
      sysRolePermForm = sysRoleService.findBasePerm(tSysRole);
    }
    return sysRolePermForm;
  }
  
  /**
    * @Title: tFconfigTree
    * @Description: 角色分站城市树-角色管理
    * @param sysRoleId  角色编码
    * @return
    * 
    * @author zhaohb
    * @date 2017-3-14 下午3:05:33
    */
  @RequestMapping(value="/tFconfigTree.do")
  @ResponseBody
  public List<TreeNode> tFconfigTree(Long sysRoleId) {
    List<TreeNode> nodes = Lists.newArrayList();
    TreeNode allNode = new TreeNode("0", "全部", "-1", 0);
    allNode.setCheckstate(0);
    List<Map<String, Object>> list = sysRoleService.findAllTFconfig();
    TreeNode lNode = null, fNode = null;
    String roleFconfigIds = "";
    if (null != sysRoleId) {
      roleFconfigIds = com.google.common.base.Joiner.on("|").join(sysRoleService.findPerm(RolePermEnum.SYS_ROLE_FCONFIG, sysRoleId));
    }
    Set<String> largeIds = Sets.newHashSet(), largeFilialeIds = Sets.newHashSet();
    String largId = null, filialeId = null, largFilialeId;
    for (Map<String, Object> l : list) {
      largId = l.get("ID").toString();
      if (!largeIds.contains(largId)) {
        lNode = new TreeNode(largId, l.get("NAME").toString(), largId, 0);
        for (Map<String, Object> fi : list) {
          filialeId = fi.get("FILIALE_ID").toString();
          largFilialeId = String.format("%s_%s", largId, filialeId);
          if (largId.equals(fi.get("ID").toString())
              && !largeFilialeIds.contains(largFilialeId)) {
            fNode = new TreeNode(largFilialeId, fi.get("FILIALE_NAME").toString(), filialeId, 0);
            for (Map<String, Object> f : list) {
              if(largId.equals(f.get("ID").toString()) 
                  && filialeId.equals(f.get("FILIALE_ID").toString())) {
                fNode.getChildNodes().add(new TreeNode(String.format("%s_%s", largFilialeId, f.get("FCONFIGID").toString()), f.get("CITYNAME").toString(), f.get("FCONFIGID").toString(), (f.get("FCONFIGID").toString().matches(roleFconfigIds)?1:0)));
              }
            }
            lNode.getChildNodes().add(fNode);
            largeFilialeIds.add(largFilialeId);
          }
        }
        allNode.getChildNodes().add(lNode);
        largeIds.add(largId);
      }
    }
    nodes.add(allNode);
    return nodes;
  }
  
}
