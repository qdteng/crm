package cn.com.ylpw.web.crm.entity.customer;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.com.ylpw.web.crm.entity.BaseEntity;

/**
 * @ClassName: TCustomerIndexRecency
 * @Description:消费激励策略
 * @author LT
 * @date 2017年6月2日 上午11:27:46
 */
public class TCustomerIndexRecency  extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;


    private Long indexId;
    //金额
    private BigDecimal monetary;
    //对应成长值
    private Integer mindex;
    //规则类型(1每消费2一次性消费3.每充值4一次性充值)
    private Integer mtype;
    //是否启用（默认：是 1：是，0：否）
    private Integer isEnable;


    public Long getIndexId() {
        return indexId;
    }

    public void setIndexId(Long indexId) {
        this.indexId = indexId;
    }

    public BigDecimal getMonetary() {
        return monetary;
    }

    public void setMonetary(BigDecimal monetary) {
        this.monetary = monetary;
    }

    public Integer getMindex() {
        return mindex;
    }

    public void setMindex(Integer mindex) {
        this.mindex = mindex;
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

}