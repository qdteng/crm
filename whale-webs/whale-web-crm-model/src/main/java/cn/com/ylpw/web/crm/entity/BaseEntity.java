package cn.com.ylpw.web.crm.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity  implements Serializable{

	private Long id;
	private cn.com.ylpw.web.crm.entity.Enums.isDel isDel;
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

	public cn.com.ylpw.web.crm.entity.Enums.isDel getIsDel() {
		return isDel;
	}

	public void setIsDel(cn.com.ylpw.web.crm.entity.Enums.isDel isDel) {
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
