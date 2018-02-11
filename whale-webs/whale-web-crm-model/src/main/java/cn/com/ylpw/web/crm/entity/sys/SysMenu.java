package cn.com.ylpw.web.crm.entity.sys;

import java.io.Serializable;
import java.util.Date;

import cn.com.ylpw.web.crm.entity.BaseEntity;

public class SysMenu extends BaseEntity implements Serializable {
 
  /**
   * 
   */
  private static final long serialVersionUID = -3283990407930595146L;
  
  
 
  private Long pid;
  private String name;
  private String url;
  protected Integer status;
  private Integer ord;
  
  
  public Long getPid() {
    return pid;
  }
  public void setPid(Long pid) {
    this.pid = pid;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }
  public Integer getOrd() {
    return ord;
  }
  public void setOrd(Integer ord) {
    this.ord = ord;
  }


}
