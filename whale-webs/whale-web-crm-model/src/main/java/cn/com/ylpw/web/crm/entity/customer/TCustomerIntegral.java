package cn.com.ylpw.web.crm.entity.customer;

import java.util.Date;

public class TCustomerIntegral {
    private Long id;

    private Long updateId;

    private String updateName;

    private Date createTime;

    private Integer optType;

    private Long customerId;

    private Long integralLimitId;

    private Long integral;
    
    private Long useable;
    
    private Long istatus;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        this.updateName = updateName == null ? null : updateName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOptType() {
        return optType;
    }

    public void setOptType(Integer optType) {
        this.optType = optType;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getIntegralLimitId() {
        return integralLimitId;
    }

    public void setIntegralLimitId(Long integralLimitId) {
        this.integralLimitId = integralLimitId;
    }

    public Long getIntegral() {
        return integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }

	public Long getUseable() {
		return useable;
	}

	public void setUseable(Long useable) {
		this.useable = useable;
	}

	public Long getIstatus() {
		return istatus;
	}

	public void setIstatus(Long istatus) {
		this.istatus = istatus;
	}
}