package cn.com.ylpw.web.crm.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import cn.com.ylpw.web.crm.entity.BaseEntity;

public class TLeTong extends BaseEntity implements Serializable{

    private Long customersid;

    private String cardno;

    private BigDecimal payPrice;


    private Long orderId;

    private BigDecimal beforePrice;

    private BigDecimal afterPrice;


    public Long getCustomersid() {
        return customersid;
    }

    public void setCustomersid(Long customersid) {
        this.customersid = customersid;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getBeforePrice() {
        return beforePrice;
    }

    public void setBeforePrice(BigDecimal beforePrice) {
        this.beforePrice = beforePrice;
    }

    public BigDecimal getAfterPrice() {
        return afterPrice;
    }

    public void setAfterPrice(BigDecimal afterPrice) {
        this.afterPrice = afterPrice;
    }
}