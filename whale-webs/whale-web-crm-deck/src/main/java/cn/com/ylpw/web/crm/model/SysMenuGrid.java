package cn.com.ylpw.web.crm.model;

import java.util.Date;

public class SysMenuGrid   {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7633795458742653661L;

	 
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
	  
	private String pname;// 上级名称
	private String statusShow;// 状态显示名称
	private Integer childrenNum;// 子节点数

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getStatusShow() {
		if (new Integer(1).equals(this.status)) {
			this.statusShow = "显示";
		} else if (new Integer(0).equals(this.status)) {
			this.statusShow = "隐藏";
		}
		return statusShow;
	}

	public void setStatusShow(String statusShow) {
		this.statusShow = statusShow;
	}

	public Integer getChildrenNum() {
		return childrenNum;
	}

	public void setChildrenNum(Integer childrenNum) {
		this.childrenNum = childrenNum;
	}
	

	private Long id;
	private Integer isDel;
	private Long createId;
	private String createName;
	private Date createTime;
	private Long updateId;
	private String updateName;
	private Date updateTime;
	 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	protected Integer getIsDel() {
		return isDel;
	}

	protected void setIsDel( Integer isDel) {
		this.isDel = isDel;
	}

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	

}
