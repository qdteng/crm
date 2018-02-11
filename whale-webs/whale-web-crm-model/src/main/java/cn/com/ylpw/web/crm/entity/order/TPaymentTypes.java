package cn.com.ylpw.web.crm.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import cn.com.ylpw.web.crm.entity.BaseEntity;

public class TPaymentTypes  extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long customersid;

    private String type;

    private String cardNo;

    private BigDecimal sumPrice;

    private Integer payCount;

    private Date lastTime;

    private Long  ordersid ;
    
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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public Integer getPayCount() {
		return payCount;
	}

	public void setPayCount(Integer payCount) {
		this.payCount = payCount;
	}

	public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
    }


    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

	public Long getOrdersid() {
		return ordersid;
	}

	public void setOrdersid(Long ordersid) {
		this.ordersid = ordersid;
	}
}