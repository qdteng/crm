package cn.com.ylpw.web.crm.model;

import cn.com.ylpw.web.crm.entity.sys.SysRole;

public class SysRoleGrid extends SysRole {
  
  
  /**
   * 
   */
  private static final long serialVersionUID = 8660104044305692781L;
  
  private String wmMenus;//角色对应菜单
  private String wmMenuIds;//角色对应菜单Ids
  private String wmMenuNames;//角色对应菜单Names
  
public String getWmMenuIds() {
    wmMenuIds = (null != wmMenus)? wmMenus.substring(0, wmMenus.indexOf("|")):null;
    return wmMenuIds;
  }
  public void setWmMenuIds(String wmMenuIds) {
    this.wmMenuIds = wmMenuIds;
  }
  public String getWmMenuNames() {
    wmMenuNames = (null != wmMenus)? wmMenus.substring(wmMenus.indexOf("|")+1):null;
    return wmMenuNames;
  }
  public void setWmMenuNames(String wmMenuNames) {
    this.wmMenuNames = wmMenuNames;
  }
  public String getWmMenus() {
    return wmMenus;
  }
  public void setWmMenus(String wmMenus) {
    this.wmMenus = wmMenus;
  }
  
}
