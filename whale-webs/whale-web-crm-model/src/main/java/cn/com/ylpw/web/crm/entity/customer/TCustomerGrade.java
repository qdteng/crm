package cn.com.ylpw.web.crm.entity.customer;

import java.io.Serializable;

import cn.com.ylpw.web.crm.entity.BaseEntity;

public class TCustomerGrade extends BaseEntity implements Serializable {

    private String gname;

    private Integer ibegin;

    private Integer iend;

    private Integer gtype;

    private Integer gnum;

    private Integer isEnable;

    //会员等级的积分倍数
    private Float integralMultiple ;
    

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public Integer getIbegin() {
        return ibegin;
    }

    public void setIbegin(Integer ibegin) {
        this.ibegin = ibegin;
    }

    public Integer getIend() {
        return iend;
    }

    public void setIend(Integer iend) {
        this.iend = iend;
    }

    public Integer getGtype() {
        return gtype;
    }

    public void setGtype(Integer gtype) {
        this.gtype = gtype;
    }

    public Integer getGnum() {
        return gnum;
    }

    public void setGnum(Integer gnum) {
        this.gnum = gnum;
    }


    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

	public Float getIntegralMultiple() {
		return integralMultiple;
	}

	public void setIntegralMultiple(Float integralMultiple) {
		this.integralMultiple = integralMultiple;
	}

}