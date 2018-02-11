package cn.com.ylpw.web.crm.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import cn.com.ylpw.web.crm.entity.BaseEntity;

public class TOrdersInfo extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long customersid;
	//订单来源 1:电话,2:网络,3:票务前台用户,4:票务前台票点,5,特殊录入订单，50:联盟,60:乐票通,70:IOS,80:ANDROID,90:WAPAP
    private Integer orderSource;

    //配送地址ID
    private Long addressid ; 
    
    //订单状态
	private String orderStatus;
	//支付状态
    private String payStatus;
    //订单金额
    private BigDecimal orderSumprice;
    //订单商品
    private String pros;
    //商品数量
    private Integer prosNum;
    //涉及品类
    private String proTypes;
    //涉及品类-大类
    private String proTypesa;
    //演出城市
    private String proCity;
    //涉及艺人、团体
    private String artistsIntroduced;
    //购买方式
    private String shopingType;
    //下单时间
    private Date createTime;
    //支付时间
    private Date payTime;
    //物流到达时间
    private Date psTime;
    //退票原因
    private String refRemark;
    //是否恶意退票(1是0否)
    private Integer refMalice;
    //实际支付金额(用户点支付时到账的金额)(页面不展现，但已保存)
    private BigDecimal sjzfPrice;
    //退款金额
    private BigDecimal refunPrice;

    
    public Integer getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(Integer orderSource) {
		this.orderSource = orderSource;
	}
	

    public BigDecimal getRefunPrice() {
		return refunPrice;
	}

	public void setRefunPrice(BigDecimal refunPrice) {
		this.refunPrice = refunPrice;
	}

	public BigDecimal getSjzfPrice() {
		return sjzfPrice;
	}

	public void setSjzfPrice(BigDecimal sjzfPrice) {
		this.sjzfPrice = sjzfPrice;
	}

	public Long getCustomersid() {
        return customersid;
    }

    public void setCustomersid(Long customersid) {
        this.customersid = customersid;
    }


    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public BigDecimal getOrderSumprice() {
        return orderSumprice;
    }

    public void setOrderSumprice(BigDecimal orderSumprice) {
        this.orderSumprice = orderSumprice;
    }

    public String getPros() {
        return pros;
    }

    public void setPros(String pros) {
        this.pros = pros == null ? null : pros.trim();
    }

    public Integer getProsNum() {
        return prosNum;
    }

    public void setProsNum(Integer prosNum) {
        this.prosNum = prosNum;
    }

    public String getProTypes() {
        return proTypes;
    }

    public void setProTypes(String proTypes) {
        this.proTypes = proTypes == null ? null : proTypes.trim();
    }

    public String getProCity() {
        return proCity;
    }

    public void setProCity(String proCity) {
        this.proCity = proCity == null ? null : proCity.trim();
    }

    public String getArtistsIntroduced() {
        return artistsIntroduced;
    }

    public void setArtistsIntroduced(String artistsIntroduced) {
        this.artistsIntroduced = artistsIntroduced == null ? null : artistsIntroduced.trim();
    }

    public String getShopingType() {
        return shopingType;
    }

    public void setShopingType(String shopingType) {
        this.shopingType = shopingType == null ? null : shopingType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getPsTime() {
        return psTime;
    }

    public void setPsTime(Date psTime) {
        this.psTime = psTime;
    }

    public String getRefRemark() {
        return refRemark;
    }

    public void setRefRemark(String refRemark) {
        this.refRemark = refRemark == null ? null : refRemark.trim();
    }

    public Integer getRefMalice() {
        return refMalice;
    }

    public void setRefMalice(Integer refMalice) {
        this.refMalice = refMalice;
    }

	public String getProTypesa() {
		return proTypesa;
	}

	public void setProTypesa(String proTypesa) {
		this.proTypesa = proTypesa;
	}

	public Long getAddressid() {
		return addressid;
	}

	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}
}