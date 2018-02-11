package cn.com.ylpw.web.crm.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import cn.com.ylpw.web.crm.entity.BaseEntity;

public class TEWallet extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long customersid;

    private BigDecimal payPrice;


    private Long orderId;

    private BigDecimal beforePrice;

    private BigDecimal afterPrice;
    
    private Long ewalletprepaidId;
    private Long paymentId;
    
    private Integer flag ;

    public Long getCustomersid() {
        return customersid;
    }

    public void setCustomersid(Long customersid) {
        this.customersid = customersid;
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

	public Long getEwalletprepaidId() {
		return ewalletprepaidId;
	}

	public void setEwalletprepaidId(Long ewalletprepaidId) {
		this.ewalletprepaidId = ewalletprepaidId;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
}