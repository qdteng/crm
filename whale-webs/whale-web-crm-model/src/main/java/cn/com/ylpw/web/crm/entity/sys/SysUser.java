package cn.com.ylpw.web.crm.entity.sys;

import java.io.Serializable;

import cn.com.ylpw.web.crm.entity.BaseEntity;

public class SysUser extends BaseEntity implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -5613249330639119811L;
	
  private Long id;
  private Long sysRoleId;
  private String name;
  private String accCode;
  private String pwd;
  private String phone;
  protected Integer status;
  private String remarks;

  
  public Long getSysRoleId() {
    return sysRoleId;
  }
  public void setSysRoleId(Long sysRoleId) {
    this.sysRoleId = sysRoleId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getAccCode() {
    return accCode;
  }
  public void setAccCode(String accCode) {
    this.accCode = accCode;
  }
  public String getPwd() {
    return pwd;
  }
  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }
  public String getRemarks() {
    return remarks;
  }
  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
