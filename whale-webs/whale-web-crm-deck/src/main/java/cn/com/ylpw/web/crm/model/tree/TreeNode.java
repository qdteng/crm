package cn.com.ylpw.web.crm.model.tree;

import java.util.List;

import com.google.common.collect.Lists;

public class TreeNode {
  
  private String id;
  private String text;
  private String value;
  private Integer checkstate = 0;
  private boolean hasChildren;
  private String isexpand = "true";
  private boolean showcheck = true;
  private List<TreeNode> childNodes = Lists.newArrayList();
  
  public TreeNode(){
  }
  
  public TreeNode(String id, String text, String value, Integer checkstate) {
    this.id=id;
    this.text=text;
    this.value=value;
    this.checkstate=checkstate;
  }
  
  public TreeNode(String id, String text, String value, Integer checkstate, List<TreeNode> childNodes) {
    this.id=id;
    this.text=text;
    this.value=value;
    this.checkstate=checkstate;
    this.childNodes=childNodes;
  }
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }
  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }
  public Integer getCheckstate() {
    return checkstate;
  }
  public void setCheckstate(Integer checkstate) {
    this.checkstate = checkstate;
  }
  public boolean isHasChildren() {
    hasChildren = (null != childNodes && !childNodes.isEmpty())?true:false;
    return hasChildren;
  }
  public void setHasChildren(boolean hasChildren) {
    this.hasChildren = hasChildren;
  }
  public String getIsexpand() {
    return isexpand;
  }
  public void setIsexpand(String isexpand) {
    this.isexpand = isexpand;
  }
  public boolean isShowcheck() {
    return showcheck;
  }
  public void setShowcheck(boolean showcheck) {
    this.showcheck = showcheck;
  }
  public List<TreeNode> getChildNodes() {
    return childNodes;
  }
  public void setChildNodes(List<TreeNode> childNodes) {
    this.childNodes = childNodes;
  }

}
