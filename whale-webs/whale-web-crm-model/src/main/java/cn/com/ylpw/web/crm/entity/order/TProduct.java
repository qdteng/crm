package cn.com.ylpw.web.crm.entity.order;

import cn.com.ylpw.web.crm.entity.BaseEntity;

public class TProduct extends BaseEntity {

    private String name;

    private String status;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}