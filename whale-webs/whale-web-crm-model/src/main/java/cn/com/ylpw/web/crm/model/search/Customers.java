package cn.com.ylpw.web.crm.model.search;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
/**
 * @ClassName: Customers
 * @Description:esSearch 中的  customer 原型
 * @author LT
 * @date 2017年10月30日 上午10:05:02
 */
@Document(indexName = "customer", type = "customer", shards = 1, replicas = 0, refreshInterval = "-1")
public class Customers implements Serializable {
	
	public Customers()  {
		final String emptyStr= "" ;
		
		this.cuSource =emptyStr ;
		this.cuStatus="0";
		this.truename=emptyStr;
		this.age=0;
		this.username=emptyStr;
		this.phone=emptyStr;
		this.email=emptyStr;
		this.paymentTypes=emptyStr;
		this.orderProducts=emptyStr;
		this.orderProductTypes=emptyStr;
		this.orderProductTypesa=emptyStr;
		this.orderProCitys=emptyStr;
		this.orderArtistsIntroduced=emptyStr;
		this.payTotalPrice=0.0;
		this.refCount= 0;
		this.eWalletTotalPrice=0.0 ;
		this.lastPayDate=null;
		this.traderTotalPriceInYear=0.0;
		this.traderTotalCountInYear=0.0;
		this.traderTotalPrice= 0.0;
		this.buyProductTotalCount=0.0;
		this.failureTransactionTotalPrice=0.0;
		this.traderAvgPrice=0.0;
		this.payCount=0;
		this.refPrice=0.0;
		this.cancelTotal=0l;
		this.gradeId=0l;
		this.createDate=null;
		this.orderSource=emptyStr;
		this.yxpb=0;
		this.pwsysId =0l;
	}
	public Customers(Long id, Long pwsysId) {
		this.id=id ;
		this.pwsysId= pwsysId;
	}
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	// 会员-来源
	private String cuSource;
	// 状态 0预会员、1正式会员
	private String cuStatus;

	// 用户真实名称
	private String truename;
	
	// 用户真实名称
	private Integer age;

	// 用户名\登录名
	private String username;

	private String phone ; 
	private String email ;
	
	// 用户用过的所有的支付方式
	@Field(type=FieldType.text)
	private String paymentTypes;
	
	// 用户所有交易过的商品名称
	@Field(type=FieldType.text)
	private String orderProducts;

	// 用户交易过的所有商品类别
	@Field(type=FieldType.text)
	private String orderProductTypes;
	
	// 用户交易过的所有商品类别A
	@Field(type=FieldType.text)
	private String orderProductTypesa;

	// 用户交易过的所有演出城市
	@Field(type=FieldType.text)
	private String orderProCitys;

	// 用户交易过的所有艺人和团体
	@Field(type=FieldType.text)
	private String orderArtistsIntroduced;

	// 用户支付的总金额
	
	private Double payTotalPrice;

	// 用户退票次数
	private Integer refCount;

	// 用户电子钱包充值的总金额
	private Double eWalletTotalPrice;

	// 最近一次交易时间
	private Date lastPayDate;
	// 本年度交易总金额
	private Double traderTotalPriceInYear;
	// 本年度交易总次数
	private Double traderTotalCountInYear;
	// 累计交易总金额
	private Double traderTotalPrice;
	// 购买票品总数
	private Double buyProductTotalCount;
	// 交易关闭金额
	private Double failureTransactionTotalPrice;
	//平均客单价 = 累计交易总金额/ 购买票品总数
	private Double  traderAvgPrice ; 
	//用户交易次数
	private Integer payCount ;
	
	
	//用户退款金额
	private  Double refPrice ;
	//用户取消订单数
	private Long cancelTotal;
	//等级ID
	private Long gradeId ;
	
	//入会时间
	private Date createDate;
	//下单终端
	private String orderSource ;
	//营销屏蔽0：未屏蔽，1：屏蔽',
	private Integer  yxpb; 
	
	private Long pwsysId; 
	
	//pwsysId 加密后的字符串
	@Field(type=FieldType.text)
	private String  useridToken ;
	
	
	/*******2017.12.19*******/
	//用户性别 男 女
	private String  sex ;
	//证件号
	private String card ;
	//用户证件类型（1 身份证 2 军官证 3 护照）
	private Integer cardtype ;
	//用户类别（1 个人用户 2 企业用户 3 集团用户 4 关系用户 5 团购客户）
    private Integer usertype;
    //用户昵称
    private String nickname;
    //用户标签
    @Field(type=FieldType.text)
    private String lables;    
    /*******2017.12.19*******/    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCuSource() {
		return cuSource;
	}

	public void setCuSource(String cuSource) {
		this.cuSource = cuSource;
	}

	public String getCuStatus() {
		return cuStatus;
	}

	public void setCuStatus(String cuStatus) {
		this.cuStatus = cuStatus;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(String orderProducts) {
		this.orderProducts = orderProducts;
	}

	public String getOrderProductTypes() {
		return orderProductTypes;
	}

	public void setOrderProductTypes(String orderProductTypes) {
		this.orderProductTypes = orderProductTypes;
	}

	public String getOrderProCitys() {
		return orderProCitys;
	}

	public void setOrderProCitys(String orderProCitys) {
		this.orderProCitys = orderProCitys;
	}

	public String getOrderArtistsIntroduced() {
		return orderArtistsIntroduced;
	}

	public void setOrderArtistsIntroduced(String orderArtistsIntroduced) {
		this.orderArtistsIntroduced = orderArtistsIntroduced;
	}

	public Double getPayTotalPrice() {
		return payTotalPrice;
	}

	public void setPayTotalPrice(Double payTotalPrice) {
		this.payTotalPrice = payTotalPrice;
	}

	public Integer getRefCount() {
		return refCount;
	}

	public void setRefCount(Integer refCount) {
		this.refCount = refCount;
	}

	public Double geteWalletTotalPrice() {
		return eWalletTotalPrice;
	}

	public void seteWalletTotalPrice(Double eWalletTotalPrice) {
		this.eWalletTotalPrice = eWalletTotalPrice;
	}

	public Date getLastPayDate() {
		return lastPayDate;
	}

	public void setLastPayDate(Date lastPayDate) {
		this.lastPayDate = lastPayDate;
	}

	public Double getTraderTotalPriceInYear() {
		return traderTotalPriceInYear;
	}

	public void setTraderTotalPriceInYear(Double traderTotalPriceInYear) {
		this.traderTotalPriceInYear = traderTotalPriceInYear;
	}

	public Double getTraderTotalCountInYear() {
		return traderTotalCountInYear;
	}

	public void setTraderTotalCountInYear(Double traderTotalCountInYear) {
		this.traderTotalCountInYear = traderTotalCountInYear;
	}

	public Double getTraderTotalPrice() {
		return traderTotalPrice;
	}

	public void setTraderTotalPrice(Double traderTotalPrice) {
		this.traderTotalPrice = traderTotalPrice;
	}

	public Double getBuyProductTotalCount() {
		return buyProductTotalCount;
	}

	public void setBuyProductTotalCount(Double buyProductTotalCount) {
		this.buyProductTotalCount = buyProductTotalCount;
	}

	public Double getFailureTransactionTotalPrice() {
		return failureTransactionTotalPrice;
	}

	public void setFailureTransactionTotalPrice(Double failureTransactionTotalPrice) {
		this.failureTransactionTotalPrice = failureTransactionTotalPrice;
	}

	public Double getTraderAvgPrice() {
		return traderAvgPrice;
	}

	public void setTraderAvgPrice(Double traderAvgPrice) {
		this.traderAvgPrice = traderAvgPrice;
	}

	public Integer getPayCount() {
		return payCount;
	}

	public void setPayCount(Integer payCount) {
		this.payCount = payCount;
	}

	public String getOrderProductTypesa() {
		return orderProductTypesa;
	}

	public void setOrderProductTypesa(String orderProductTypesa) {
		this.orderProductTypesa = orderProductTypesa;
	}

	public String getPaymentTypes() {
		return paymentTypes;
	}

	public void setPaymentTypes(String paymentTypes) {
		this.paymentTypes = paymentTypes;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getRefPrice() {
		return refPrice;
	}

	public void setRefPrice(Double refPrice) {
		this.refPrice = refPrice;
	}

	public Long getCancelTotal() {
		return cancelTotal;
	}

	public void setCancelTotal(Long cancelTotal) {
		this.cancelTotal = cancelTotal;
	}

	public Long getGradeId() {
		return gradeId;
	}

	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	public Integer getYxpb() {
		return yxpb;
	}

	public void setYxpb(Integer yxpb) {
		this.yxpb = yxpb;
	}

	public Long getPwsysId() {
		return pwsysId;
	}

	public void setPwsysId(Long pwsysId) {
		this.pwsysId = pwsysId;
	}

	public String getUseridToken() {
		return useridToken;
	}

	public void setUseridToken(String useridToken) {
		this.useridToken = useridToken;
	}
	public Integer getCardtype() {
		return cardtype;
	}
	public void setCardtype(Integer cardtype) {
		this.cardtype = cardtype;
	}
	public Integer getUsertype() {
		return usertype;
	}
	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getLables() {
		return lables;
	}
	public void setLables(String lables) {
		this.lables = lables;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}

}
