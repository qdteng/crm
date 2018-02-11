package cn.com.ylpw.web.crm.entity.sys;

import java.io.Serializable;
import java.util.Date;

import cn.com.ylpw.web.crm.entity.BaseEntity;

public class SysRole  extends BaseEntity implements Serializable {
 
  /**
   * 
   */
  private static final long serialVersionUID = -3283990407930595146L;
  
  private String name;
  private Integer ord;
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Integer getOrd() {
    return ord;
  }
  public void setOrd(Integer ord) {
    this.ord = ord;
  }

}
