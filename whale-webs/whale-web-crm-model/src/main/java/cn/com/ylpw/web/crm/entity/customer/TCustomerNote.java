package cn.com.ylpw.web.crm.entity.customer;

import java.io.Serializable;

import cn.com.ylpw.web.crm.entity.BaseEntity;

public class TCustomerNote  extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

    private String remark;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

}