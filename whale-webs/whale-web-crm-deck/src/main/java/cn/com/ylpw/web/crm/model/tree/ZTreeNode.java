package cn.com.ylpw.web.crm.model.tree;

import java.util.ArrayList;
import java.util.List;

public class ZTreeNode {
	
	private boolean hasChildren;
	private boolean hasProperty = false;
	private boolean isParent;
	private String  name="" ;
	private String  id= "" ;
	private List<ZTreeNode> children = new ArrayList<ZTreeNode>();
	private String ppid = "" ;
	
	public boolean isHasChildren() {
		return hasChildren;
	}
	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
	public boolean getIsHasProperty() {
		return hasProperty;
	}
	public void setIsHasProperty(boolean hasProperty) {
		this.hasProperty = hasProperty;
	}
	public boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(boolean isParent) {
		this.isParent = isParent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public List<ZTreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<ZTreeNode> children) {
		this.children = children;
	}
	public String getPpid() {
		return ppid;
	}
	public void setPpid(String ppid) {
		this.ppid = ppid;
	}
	
}
