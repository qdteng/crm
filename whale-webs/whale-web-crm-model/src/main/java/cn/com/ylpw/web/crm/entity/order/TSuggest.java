package cn.com.ylpw.web.crm.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.com.ylpw.web.crm.entity.BaseEntity;

public class TSuggest extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -6211643632049093681L;


	private Long customersid;


    private String type;

    private Integer ordersId;

    private String description;

    private String solveDesc;


    public Long getCustomersid() {
        return customersid;
    }

    public void setCustomersid(Long customersid) {
        this.customersid = customersid;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getSolveDesc() {
        return solveDesc;
    }

    public void setSolveDesc(String solveDesc) {
        this.solveDesc = solveDesc == null ? null : solveDesc.trim();
    }
}