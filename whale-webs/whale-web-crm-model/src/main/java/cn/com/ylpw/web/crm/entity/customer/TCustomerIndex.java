package cn.com.ylpw.web.crm.entity.customer;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.com.ylpw.web.crm.entity.BaseEntity;
/**
 * @ClassName: TCustomerIndex
 * @Description:策略设置
 * @author LT
 * @date 2017年6月2日 上午11:27:02
 */
public class TCustomerIndex extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	//占百分比
	private BigDecimal scale;
	//策略类型(1RFM2消费策略3.会员活跃策略)
    private Integer mtype;
	//是否启用（默认：是 1：是，0：否）
    private Integer isEnable;
	//描述
    private String remark;
	//开关(1开0关)
    private Integer isOpen;


    public BigDecimal getScale() {
        return scale;
    }

    public void setScale(BigDecimal scale) {
        this.scale = scale;
    }

    public Integer getMtype() {
        return mtype;
    }

    public void setMtype(Integer mtype) {
        this.mtype = mtype;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }
     
}