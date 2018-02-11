package cn.com.ylpw.web.crm.model;

import cn.com.ylpw.web.crm.entity.sys.SysRole;

public class SysRolePermForm extends SysRole {
  
  /**
   * 
   */
  private static final long serialVersionUID = 4450096457505266690L;
  
  private String menuIds;//菜单权限
  
  public String getMenuIds() {
    return menuIds;
  }
  public void setMenuIds(String menuIds) {
    this.menuIds = menuIds;
  }
  
}
