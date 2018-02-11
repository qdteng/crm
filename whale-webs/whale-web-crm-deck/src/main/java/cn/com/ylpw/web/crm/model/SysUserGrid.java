package cn.com.ylpw.web.crm.model;

import cn.com.ylpw.web.crm.entity.sys.SysUser;


public class SysUserGrid extends SysUser {

  /**
   * 
   */
  private static final long serialVersionUID = 2818133770015055561L;
  
  private String sysRoleName;//角色名称
  private String statusShow;//状态显示名称
  
  public String getSysRoleName() {
    return sysRoleName;
  }
  public void setSysRoleName(String sysRoleName) {
    this.sysRoleName = sysRoleName;
  }
  public String getStatusShow() {
    if(new Integer(1).equals(this.status)) {
      this.statusShow = "正常";
    } else if(new Integer(0).equals(this.status)) {
      this.statusShow = "锁定";
    }
    return statusShow;
  }
  public void setStatusShow(String statusShow) {
    this.statusShow = statusShow;
  }
  
}
