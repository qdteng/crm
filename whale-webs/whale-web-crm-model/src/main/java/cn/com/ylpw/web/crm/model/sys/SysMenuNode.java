package cn.com.ylpw.web.crm.model.sys;

import java.util.List;

import com.google.common.collect.Lists;

import cn.com.ylpw.web.crm.entity.sys.SysMenu;

public class SysMenuNode extends SysMenu {
  
  /**
   * 
   */
  private static final long serialVersionUID = -7633795458742653661L;
  
  public SysMenuNode(){}
  
  public SysMenuNode(SysMenu sysMenu){
    this.setId(sysMenu.getId());
    this.setPid(sysMenu.getPid());
    this.setName(sysMenu.getName());
    this.setUrl(sysMenu.getUrl());
  }
  
  List<SysMenuNode> childrens = Lists.newArrayList();

  public List<SysMenuNode> getChildrens() {
    return childrens;
  }

  public void setChildrens(List<SysMenuNode> childrens) {
    this.childrens = childrens;
  }
  
}
