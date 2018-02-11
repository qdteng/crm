package cn.com.ylpw.web.crm.entity.customer;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.com.ylpw.web.crm.entity.BaseEntity;
/**
 * @ClassName: TCustomerIndexRfm
 * @Description:RFM等级成长值策略
 * @author LT
 * @date 2017年6月2日 上午11:28:40
 */
public class TCustomerIndexRfm extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    private Long indexId;
    //最近一次消费(单位：天)
    private Integer recency;
    //最近一次消费成长值
    private Integer rindex;
    //消费频率（单位：次）
    private Integer frequency;
    //消费频率成长值
    private Integer findex;
    //消费金额（单位：元）
    private BigDecimal monetary;
    //消费金额成长值
    private Integer mindex;
    //负增长(默认0 ，0否1是)
    private Integer isLoss;

    
    public Long getIndexId() {
        return indexId;
    }

    public void setIndexId(Long indexId) {
        this.indexId = indexId;
    }

    public Integer getRecency() {
        return recency;
    }

    public void setRecency(Integer recency) {
        this.recency = recency;
    }

    public Integer getRindex() {
        return rindex;
    }

    public void setRindex(Integer rindex) {
        this.rindex = rindex;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getFindex() {
        return findex;
    }

    public void setFindex(Integer findex) {
        this.findex = findex;
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

    public Integer getIsLoss() {
        return isLoss;
    }

    public void setIsLoss(Integer isLoss) {
        this.isLoss = isLoss;
    }

}