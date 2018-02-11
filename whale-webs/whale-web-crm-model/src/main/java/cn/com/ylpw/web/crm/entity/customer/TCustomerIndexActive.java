package cn.com.ylpw.web.crm.entity.customer;

import java.io.Serializable;

import cn.com.ylpw.web.crm.entity.BaseEntity;
/**
 * @ClassName: TCustomerIndexActive
 * @Description:会员活跃策略
 * @author LT
 * @date 2017年6月2日 上午11:26:54
 */
public class TCustomerIndexActive  extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//策略ID
    private Long indexId;
    //次数
    private Integer anum;
    //对应成长值
    private Integer aindex;
    //类型(1.每日签到成长值2.连续签到3.每次分享成长值4.最多可分享次数5.每次订阅成长值6.每天阅次数受益上限7.领卡成功)
    private Integer atype;
    //是否启用（默认：是 1：是，0：否）
    private Integer isEnable;


    public Long getIndexId() {
        return indexId;
    }

    public void setIndexId(Long indexId) {
        this.indexId = indexId;
    }

    public Integer getAnum() {
        return anum;
    }

    public void setAnum(Integer anum) {
        this.anum = anum;
    }

    public Integer getAindex() {
        return aindex;
    }

    public void setAindex(Integer aindex) {
        this.aindex = aindex;
    }

    public Integer getAtype() {
        return atype;
    }

    public void setAtype(Integer atype) {
        this.atype = atype;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }


}