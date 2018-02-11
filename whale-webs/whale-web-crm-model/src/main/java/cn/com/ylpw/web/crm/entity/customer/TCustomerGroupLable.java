package cn.com.ylpw.web.crm.entity.customer;

import java.io.Serializable;

import cn.com.ylpw.web.crm.entity.BaseEntity;

public class TCustomerGroupLable extends BaseEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private Long lableId;

    private Long groupId;


    public Long getLableId() {
        return lableId;
    }

    public void setLableId(Long lableId) {
        this.lableId = lableId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

}