package cn.com.ylpw.web.crm.entity.customer;

import java.io.Serializable;

import cn.com.ylpw.web.crm.entity.BaseEntity;

public class TCustomerLable extends BaseEntity implements Serializable  {

	private static final long serialVersionUID = 1L;

	private String name;

    private Integer isEnable;

    private Long pid;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }


}