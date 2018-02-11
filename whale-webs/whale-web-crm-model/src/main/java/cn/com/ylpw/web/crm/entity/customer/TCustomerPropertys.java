package cn.com.ylpw.web.crm.entity.customer;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.com.ylpw.core.tools.DateTool;
import cn.com.ylpw.web.crm.entity.BaseEntity;

public class TCustomerPropertys extends BaseEntity implements Serializable  {

	private static final long serialVersionUID = 1L;

	/**所属标签*/
	private java.lang.Long lableId;
	/**基本-性别*/
	private java.lang.String baSex;
	/**基本-学历*/
	private java.lang.String baEducation;
	/**基本-年龄*/
	private java.lang.String baAge;
	/**基本-星座*/
	private java.lang.String baConstellation;
	/**基本-省*/
	private java.lang.String baProvince;
	/**基本-市*/
	private java.lang.String baCity;
	/**基本-收入水平*/
	private java.lang.String baIncomeLevel;
	/**基本-婚姻状况*/
	private java.lang.String baMaritalStatus;
	/**基本-有无子女*/
	private java.lang.String baChildren;
	/**基本-注册IP省*/
	private java.lang.String baIpProvince;
	/**基本-注册IP市*/
	private java.lang.String baIpCity;
	/**基本-注册开始时间*/
	private java.util.Date baRegTimeStart;
	/**基本-注册结束时间*/
	private java.util.Date baRegTimeEnd;
	/**基本-注册来源渠道*/
	private java.lang.String baRegSourceChannel;
	/**基本-注册平台*/
	private java.lang.String baRegistrationPlatform;
	/**交易-订单来源*/
	private java.lang.String paOrderSource;
	/**交易-交易商品名称*/
	private java.lang.String paTradeName;
	/**交易-交易商品类别A*/
	private java.lang.String paCommodityClassa;
	/**交易-交易商品类别B*/
	private java.lang.String paCommodityClassb;
	/**交易-演出城市省*/
	private java.lang.String paPerInProvince;
	/**交易-演出城市市*/
	private java.lang.String paPerInCity;
	/**交易-涉及艺人及团体*/
	private java.lang.String paInvolvingArtistGroups;
	/**交易-订单状态*/
	private java.lang.String paOrderStatus;
	/**交易-异常状态*/
	private java.lang.String paAbnormalState;
	/**交易-异常原因*/
	private java.lang.String paAbnormalCause;
	/**交易-支付方式*/
	private java.lang.String paPaymentMethod;
	/**交易-支付开始时间*/
	private java.util.Date paPaymentStartTime;
	/**交易-支付结束时间*/
	private java.util.Date paPaymentEndTime;
	/**交易-支付总金额*/
	private java.lang.String paTotalPayment;
	/**交易-是否恶意退票*/
	private java.lang.String paMaliciousRefund;
	/**交易-退票次数*/
	private java.lang.String paNumberRefunds;
	/**交易-配送省*/
	private java.lang.String paDisProvince;
	/**交易-配送市*/
	private java.lang.String paDisCity;
	/**交易-配送累计次数*/
	private java.lang.String paDisCount;
	/**交易-电子钱包充值金额*/
	private java.lang.String paEwalletRechargeAmount;
	/**交易-电子钱包充值开始时间*/
	private java.util.Date paEwalletRechargeStart;
	/**交易-电子钱包充值结束时间*/
	private java.util.Date paEwalletRechargeEnd;
	/**会员-会员等级*/
	private java.lang.String meMembershipLevel;
	/**会员-会员状态*/
	private java.lang.String meMemberStatus;
	/**会员-会员来源*/
	private java.lang.String meMemberSource;
	/**会员-现有积分*/
	private java.lang.String meExistingIntegral;
	/**会员-最近一次交易开始时间*/
	private java.util.Date meLastTradingStart;
	/**会员-最近一次交易结束时间*/
	private java.util.Date meLastTradingEnd;
	/**会员-本年度交易总额*/
	private java.lang.String meYearTotalVolume;
	/**会员-本年度交易总次数*/
	private java.lang.String meYearTotalNumber;
	/**会员-累计交易总金额*/
	private java.lang.String meTransactionTotal;
	/**会员-购买票品总数*/
	private java.lang.String meBuyTotal;
	/**会员-交易关闭金额*/
	private java.lang.String meClosingAmount;
	/**会员-成长值*/
	private java.lang.String meGrowthValue;
	/**会员-上次升级开始时间*/
	private java.util.Date meUpgradeTimeStart;
	/**会员-上次上级结束时间*/
	private java.util.Date meUpgradeTimeEnd;
	/**会员-签到总次数*/
	private java.lang.String meSignInTotal;
	/**会员-最后一次签到区间-开始*/
	private java.util.Date meLastSignStart;
	/**会员-最后一次签到区间-结束*/
	private java.util.Date meLastSignEnd;
	/**会员-分享总次数*/
	private java.lang.String meShareTotalNumber;
	/**会员-最后一次分享时间区间s*/
	private java.util.Date meLastTimeShareSatrt;
	/**会员-最后一次分享时间区间e*/
	private java.util.Date meLastTimeShareEnd;
	/**会员-订阅总次数*/
	private java.lang.String meSubscriptionTotal;
	/**会员-最后一次订阅时间区间s*/
	private java.util.Date meLastSubscriptionStart;
	/**会员-最后一次订阅时间区间e*/
	private java.util.Date meLastSubscriptionEnd;
	/**行为-浏览终端*/
	private java.lang.String beBrowserTerminal;
	/**行为-浏览商品名称*/
	private java.lang.String beTrackingProName;
	/**行为-浏览商品类别_大*/
	private java.lang.String beTraProClassa;
	/**行为-浏览商品类别_小*/
	private java.lang.String beTraProClassb;
	/**行为-浏览演出城市_省*/
	private java.lang.String beBrowseProvince;
	/**行为-浏览演出城市_市*/
	private java.lang.String beBrowseCity;
	/**行为-浏览涉及艺人团体*/
	private java.lang.String beBrowseGroupsActor;
	/**行为-购买-商品名称*/
	private java.lang.String beBrowseProName;
	/**行为-购买-订单来源*/
	private java.lang.String beTrackingOrderSource;
	/**行为-购买-订单提交时间区间s*/
	private java.util.Date beTraOrderSubIntervals;
	/**行为-购买-订单提交时间区间e*/
	private java.util.Date beTraOrderSubIntervale;
	/**行为-购买-送货方式*/
	private java.lang.String beTraDeliveryMode;
	/**行为-购买-支付环节*/
	private java.lang.String bePaymentLink;
	/**行为-购买-电子钱包*/
	private java.lang.String beEwalletUseing;
	/**行为-购买-支付方式*/
	private java.lang.String beTraPaymentMode;
	/**行为-购买-支付是否成功*/
	private java.lang.String bePaymentSuccess;
	/**行为-搜索-提交时间区间S*/
	private java.util.Date beSubTimes;
	/**行为-搜索-提交时间区间E*/
	private java.util.Date beSubTimee;
	/**行为-搜索-关键词*/
	private java.lang.String beKeywordSearch;
	/**行为-搜索-搜索页*/
	private java.lang.String beInsideSearchPage;
	/**行为-搜索-落地页*/
	private java.lang.String beLandingPage;
	/**行为-专题-访问时间开始时间*/
	private Date beAccessStime;
	/**行为-专题-访问时间结束时间*/
	private Date beAccessEtime;
	
	/**行为-专题-站内/站外*/
	private java.lang.String beInOutStation;
	/**行为-专题-站外来源*/
	private java.lang.String beExoticSource;
	/**行为-专题-广告关键词*/
	private java.lang.String beAdKeyword;
	/**行为-分享-开始时间*/
	private Date beShareStime;
	/**行为-分享-结束时间*/
	private Date beShareEtime;
	/**行为-分享-商品名称*/
	private java.lang.String beCommodityName;
	/**行为-分享-渠道*/
	private java.lang.String beSharingChannels;
	/**行为-缺货登记--时间S*/
	private java.lang.String beRegistrationTimes;
	/**行为-缺货登记--时间E*/
	private java.lang.String beRegistrationTimee;
	/**行为-缺货登记-商品*/
	private java.lang.String beRegisteredGoods;
	/**行为-缺货登记-数量*/
	private java.lang.String beRegisteredQuantity;
	/**行为-缺货登记--商品大类*/
	private java.lang.String beCommodityClassa;
	/**行为-缺货登记-商品子类*/
	private java.lang.String beCommodityClassb;
	/**行为-缺货登记-演出城市省*/
	private java.lang.String beOutStockProvince;
	/**行为-缺货登记-演出城市市*/
	private java.lang.String beOutStockCity;
	/**行为-缺货登记-涉及艺人及团体*/
	private java.lang.String beOutOfStockGroups;
	/**沟通-类型*/
	private java.lang.String coCommunicationType;
	/**沟通-时间区间s*/
	private java.util.Date coTimeStart;
	/**沟通-时间区间e*/
	private java.util.Date coTimeEnd;
	/**沟通-次数*/
	private java.lang.String coCount;
	/**沟通-结果*/
	private java.lang.String coResult;
	/**沟通-频率*/
	private java.lang.String coFrequency;
	/**沟通-打开链接点击率*/
	private java.lang.String coClickRate;
	/**沟通-订单转化率*/
	private java.lang.String coOrderConversionRate;
	/**沟通-主题关键词*/
	private java.lang.String coComKeywords;
    
    
    public Long getLableId() {
        return lableId;
    }

    public void setLableId(Long lableId) {
        this.lableId = lableId;
    }

    public String getBaSex() {
        return baSex;
    }

    public void setBaSex(String baSex) {
        this.baSex = baSex == null ? null : baSex.trim();
    }

    public String getBaEducation() {
        return baEducation;
    }

    public void setBaEducation(String baEducation) {
        this.baEducation = baEducation == null ? null : baEducation.trim();
    }

    public String getBaAge() {
        return baAge;
    }

    public void setBaAge(String baAge) {
        this.baAge = baAge == null ? null : baAge.trim();
    }

    public String getBaConstellation() {
        return baConstellation;
    }

    public void setBaConstellation(String baConstellation) {
        this.baConstellation = baConstellation == null ? null : baConstellation.trim();
    }

    public String getBaProvince() {
        return baProvince;
    }

    public void setBaProvince(String baProvince) {
        this.baProvince = baProvince == null ? null : baProvince.trim();
    }

    public String getBaCity() {
        return baCity;
    }

    public void setBaCity(String baCity) {
        this.baCity = baCity == null ? null : baCity.trim();
    }

    public String getBaIncomeLevel() {
        return baIncomeLevel;
    }

    public void setBaIncomeLevel(String baIncomeLevel) {
        this.baIncomeLevel = baIncomeLevel == null ? null : baIncomeLevel.trim();
    }

    public String getBaMaritalStatus() {
        return baMaritalStatus;
    }

    public void setBaMaritalStatus(String baMaritalStatus) {
        this.baMaritalStatus = baMaritalStatus == null ? null : baMaritalStatus.trim();
    }

    public String getBaChildren() {
        return baChildren;
    }

    public void setBaChildren(String baChildren) {
        this.baChildren = baChildren == null ? null : baChildren.trim();
    }

    public String getBaIpProvince() {
        return baIpProvince;
    }

    public void setBaIpProvince(String baIpProvince) {
        this.baIpProvince = baIpProvince == null ? null : baIpProvince.trim();
    }

    public String getBaIpCity() {
        return baIpCity;
    }

    public void setBaIpCity(String baIpCity) {
        this.baIpCity = baIpCity == null ? null : baIpCity.trim();
    }
    
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getBaRegTimeStart() {
        return baRegTimeStart;
    }

    public void setBaRegTimeStart(Date baRegTimeStart) {
        this.baRegTimeStart = baRegTimeStart;
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getBaRegTimeEnd() {
        return baRegTimeEnd;
    }

    public void setBaRegTimeEnd(Date baRegTimeEnd) {
        this.baRegTimeEnd = baRegTimeEnd;
    }

    public String getBaRegSourceChannel() {
        return baRegSourceChannel;
    }

    public void setBaRegSourceChannel(String baRegSourceChannel) {
        this.baRegSourceChannel = baRegSourceChannel == null ? null : baRegSourceChannel.trim();
    }

    public String getBaRegistrationPlatform() {
        return baRegistrationPlatform;
    }

    public void setBaRegistrationPlatform(String baRegistrationPlatform) {
        this.baRegistrationPlatform = baRegistrationPlatform == null ? null : baRegistrationPlatform.trim();
    }

    public String getPaOrderSource() {
        return paOrderSource;
    }

    public void setPaOrderSource(String paOrderSource) {
        this.paOrderSource = paOrderSource == null ? null : paOrderSource.trim();
    }

    public String getPaTradeName() {
        return paTradeName;
    }

    public void setPaTradeName(String paTradeName) {
        this.paTradeName = paTradeName == null ? null : paTradeName.trim();
    }

    public String getPaCommodityClassa() {
        return paCommodityClassa;
    }

    public void setPaCommodityClassa(String paCommodityClassa) {
        this.paCommodityClassa = paCommodityClassa == null ? null : paCommodityClassa.trim();
    }

    public String getPaCommodityClassb() {
        return paCommodityClassb;
    }

    public void setPaCommodityClassb(String paCommodityClassb) {
        this.paCommodityClassb = paCommodityClassb == null ? null : paCommodityClassb.trim();
    }

    public String getPaPerInProvince() {
        return paPerInProvince;
    }

    public void setPaPerInProvince(String paPerInProvince) {
        this.paPerInProvince = paPerInProvince == null ? null : paPerInProvince.trim();
    }

    public String getPaPerInCity() {
        return paPerInCity;
    }

    public void setPaPerInCity(String paPerInCity) {
        this.paPerInCity = paPerInCity == null ? null : paPerInCity.trim();
    }

    public String getPaInvolvingArtistGroups() {
        return paInvolvingArtistGroups;
    }

    public void setPaInvolvingArtistGroups(String paInvolvingArtistGroups) {
        this.paInvolvingArtistGroups = paInvolvingArtistGroups == null ? null : paInvolvingArtistGroups.trim();
    }

    public String getPaOrderStatus() {
        return paOrderStatus;
    }

    public void setPaOrderStatus(String paOrderStatus) {
        this.paOrderStatus = paOrderStatus == null ? null : paOrderStatus.trim();
    }

    public String getPaAbnormalState() {
        return paAbnormalState;
    }

    public void setPaAbnormalState(String paAbnormalState) {
        this.paAbnormalState = paAbnormalState == null ? null : paAbnormalState.trim();
    }

    public String getPaAbnormalCause() {
        return paAbnormalCause;
    }

    public void setPaAbnormalCause(String paAbnormalCause) {
        this.paAbnormalCause = paAbnormalCause == null ? null : paAbnormalCause.trim();
    }

    public String getPaPaymentMethod() {
        return paPaymentMethod;
    }

    public void setPaPaymentMethod(String paPaymentMethod) {
        this.paPaymentMethod = paPaymentMethod == null ? null : paPaymentMethod.trim();
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getPaPaymentStartTime() {
        return paPaymentStartTime;
    }

    public void setPaPaymentStartTime(Date paPaymentStartTime) {
        this.paPaymentStartTime = paPaymentStartTime;
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getPaPaymentEndTime() {
        return paPaymentEndTime;
    }

    public void setPaPaymentEndTime(Date paPaymentEndTime) {
        this.paPaymentEndTime = paPaymentEndTime;
    }

    public String getPaTotalPayment() {
        return paTotalPayment;
    }

    public void setPaTotalPayment(String paTotalPayment) {
        this.paTotalPayment = paTotalPayment == null ? null : paTotalPayment.trim();
    }

    public String getPaMaliciousRefund() {
        return paMaliciousRefund;
    }

    public void setPaMaliciousRefund(String paMaliciousRefund) {
        this.paMaliciousRefund = paMaliciousRefund == null ? null : paMaliciousRefund.trim();
    }

    public String getPaNumberRefunds() {
        return paNumberRefunds;
    }

    public void setPaNumberRefunds(String paNumberRefunds) {
        this.paNumberRefunds = paNumberRefunds == null ? null : paNumberRefunds.trim();
    }

    public String getPaDisProvince() {
        return paDisProvince;
    }

    public void setPaDisProvince(String paDisProvince) {
        this.paDisProvince = paDisProvince == null ? null : paDisProvince.trim();
    }

    public String getPaDisCity() {
        return paDisCity;
    }

    public void setPaDisCity(String paDisCity) {
        this.paDisCity = paDisCity == null ? null : paDisCity.trim();
    }

    public String getPaDisCount() {
        return paDisCount;
    }

    public void setPaDisCount(String paDisCount) {
        this.paDisCount = paDisCount == null ? null : paDisCount.trim();
    }

    public String getPaEwalletRechargeAmount() {
        return paEwalletRechargeAmount;
    }

    public void setPaEwalletRechargeAmount(String paEwalletRechargeAmount) {
        this.paEwalletRechargeAmount = paEwalletRechargeAmount == null ? null : paEwalletRechargeAmount.trim();
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getPaEwalletRechargeStart() {
        return paEwalletRechargeStart;
    }

    public void setPaEwalletRechargeStart(Date paEwalletRechargeStart) {
        this.paEwalletRechargeStart = paEwalletRechargeStart;
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getPaEwalletRechargeEnd() {
        return paEwalletRechargeEnd;
    }

    public void setPaEwalletRechargeEnd(Date paEwalletRechargeEnd) {
        this.paEwalletRechargeEnd = paEwalletRechargeEnd;
    }

    public String getMeMembershipLevel() {
        return meMembershipLevel;
    }

    public void setMeMembershipLevel(String meMembershipLevel) {
        this.meMembershipLevel = meMembershipLevel == null ? null : meMembershipLevel.trim();
    }

    public String getMeMemberStatus() {
        return meMemberStatus;
    }

    public void setMeMemberStatus(String meMemberStatus) {
        this.meMemberStatus = meMemberStatus == null ? null : meMemberStatus.trim();
    }

    public String getMeMemberSource() {
        return meMemberSource;
    }

    public void setMeMemberSource(String meMemberSource) {
        this.meMemberSource = meMemberSource == null ? null : meMemberSource.trim();
    }

    public String getMeExistingIntegral() {
        return meExistingIntegral;
    }

    public void setMeExistingIntegral(String meExistingIntegral) {
        this.meExistingIntegral = meExistingIntegral == null ? null : meExistingIntegral.trim();
    }

   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getMeLastTradingStart() {
        return meLastTradingStart;
    }

    public void setMeLastTradingStart(Date meLastTradingStart) {
        this.meLastTradingStart = meLastTradingStart;
    }
    
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getMeLastTradingEnd() {
        return meLastTradingEnd;
    }

    public void setMeLastTradingEnd(Date meLastTradingEnd) {
        this.meLastTradingEnd = meLastTradingEnd;
    }

    public String getMeYearTotalVolume() {
        return meYearTotalVolume;
    }

    public void setMeYearTotalVolume(String meYearTotalVolume) {
        this.meYearTotalVolume = meYearTotalVolume == null ? null : meYearTotalVolume.trim();
    }

    public String getMeYearTotalNumber() {
        return meYearTotalNumber;
    }

    public void setMeYearTotalNumber(String meYearTotalNumber) {
        this.meYearTotalNumber = meYearTotalNumber == null ? null : meYearTotalNumber.trim();
    }

    public String getMeTransactionTotal() {
        return meTransactionTotal;
    }

    public void setMeTransactionTotal(String meTransactionTotal) {
        this.meTransactionTotal = meTransactionTotal == null ? null : meTransactionTotal.trim();
    }

    public String getMeBuyTotal() {
        return meBuyTotal;
    }

    public void setMeBuyTotal(String meBuyTotal) {
        this.meBuyTotal = meBuyTotal == null ? null : meBuyTotal.trim();
    }

    public String getMeClosingAmount() {
        return meClosingAmount;
    }

    public void setMeClosingAmount(String meClosingAmount) {
        this.meClosingAmount = meClosingAmount == null ? null : meClosingAmount.trim();
    }

    public String getMeGrowthValue() {
        return meGrowthValue;
    }

    public void setMeGrowthValue(String meGrowthValue) {
        this.meGrowthValue = meGrowthValue == null ? null : meGrowthValue.trim();
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getMeUpgradeTimeStart() {
        return meUpgradeTimeStart;
    }

    public void setMeUpgradeTimeStart(Date meUpgradeTimeStart) {
        this.meUpgradeTimeStart = meUpgradeTimeStart;
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getMeUpgradeTimeEnd() {
        return meUpgradeTimeEnd;
    }

    public void setMeUpgradeTimeEnd(Date meUpgradeTimeEnd) {
        this.meUpgradeTimeEnd = meUpgradeTimeEnd;
    }

    public String getMeSignInTotal() {
        return meSignInTotal;
    }

    public void setMeSignInTotal(String meSignInTotal) {
        this.meSignInTotal = meSignInTotal == null ? null : meSignInTotal.trim();
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getMeLastSignStart() {
        return meLastSignStart;
    }

    public void setMeLastSignStart(Date meLastSignStart) {
        this.meLastSignStart = meLastSignStart;
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getMeLastSignEnd() {
        return meLastSignEnd;
    }

    public void setMeLastSignEnd(Date meLastSignEnd) {
        this.meLastSignEnd = meLastSignEnd;
    }

    public String getMeShareTotalNumber() {
        return meShareTotalNumber;
    }

    public void setMeShareTotalNumber(String meShareTotalNumber) {
        this.meShareTotalNumber = meShareTotalNumber == null ? null : meShareTotalNumber.trim();
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getMeLastTimeShareSatrt() {
        return meLastTimeShareSatrt;
    }

    public void setMeLastTimeShareSatrt(Date meLastTimeShareSatrt) {
        this.meLastTimeShareSatrt = meLastTimeShareSatrt;
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getMeLastTimeShareEnd() {
        return meLastTimeShareEnd;
    }

    public void setMeLastTimeShareEnd(Date meLastTimeShareEnd) {
        this.meLastTimeShareEnd = meLastTimeShareEnd;
    }

    public String getMeSubscriptionTotal() {
        return meSubscriptionTotal;
    }

    public void setMeSubscriptionTotal(String meSubscriptionTotal) {
        this.meSubscriptionTotal = meSubscriptionTotal == null ? null : meSubscriptionTotal.trim();
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getMeLastSubscriptionStart() {
        return meLastSubscriptionStart;
    }

    public void setMeLastSubscriptionStart(Date meLastSubscriptionStart) {
        this.meLastSubscriptionStart = meLastSubscriptionStart;
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getMeLastSubscriptionEnd() {
        return meLastSubscriptionEnd;
    }

    public void setMeLastSubscriptionEnd(Date meLastSubscriptionEnd) {
        this.meLastSubscriptionEnd = meLastSubscriptionEnd;
    }

    public String getBeBrowserTerminal() {
        return beBrowserTerminal;
    }

    public void setBeBrowserTerminal(String beBrowserTerminal) {
        this.beBrowserTerminal = beBrowserTerminal == null ? null : beBrowserTerminal.trim();
    }

    public String getBeTrackingProName() {
        return beTrackingProName;
    }

    public void setBeTrackingProName(String beTrackingProName) {
        this.beTrackingProName = beTrackingProName == null ? null : beTrackingProName.trim();
    }

    public String getBeTraProClassa() {
        return beTraProClassa;
    }

    public void setBeTraProClassa(String beTraProClassa) {
        this.beTraProClassa = beTraProClassa == null ? null : beTraProClassa.trim();
    }

    public String getBeTraProClassb() {
        return beTraProClassb;
    }

    public void setBeTraProClassb(String beTraProClassb) {
        this.beTraProClassb = beTraProClassb == null ? null : beTraProClassb.trim();
    }

    public String getBeBrowseProvince() {
        return beBrowseProvince;
    }

    public void setBeBrowseProvince(String beBrowseProvince) {
        this.beBrowseProvince = beBrowseProvince == null ? null : beBrowseProvince.trim();
    }

    public String getBeBrowseCity() {
        return beBrowseCity;
    }

    public void setBeBrowseCity(String beBrowseCity) {
        this.beBrowseCity = beBrowseCity == null ? null : beBrowseCity.trim();
    }

    public String getBeBrowseGroupsActor() {
        return beBrowseGroupsActor;
    }

    public void setBeBrowseGroupsActor(String beBrowseGroupsActor) {
        this.beBrowseGroupsActor = beBrowseGroupsActor == null ? null : beBrowseGroupsActor.trim();
    }

    public String getBeBrowseProName() {
        return beBrowseProName;
    }

    public void setBeBrowseProName(String beBrowseProName) {
        this.beBrowseProName = beBrowseProName == null ? null : beBrowseProName.trim();
    }

    public String getBeTrackingOrderSource() {
        return beTrackingOrderSource;
    }

    public void setBeTrackingOrderSource(String beTrackingOrderSource) {
        this.beTrackingOrderSource = beTrackingOrderSource == null ? null : beTrackingOrderSource.trim();
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getBeTraOrderSubIntervals() {
        return beTraOrderSubIntervals;
    }

    public void setBeTraOrderSubIntervals(Date beTraOrderSubIntervals) {
        this.beTraOrderSubIntervals = beTraOrderSubIntervals;
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getBeTraOrderSubIntervale() {
        return beTraOrderSubIntervale;
    }

    public void setBeTraOrderSubIntervale(Date beTraOrderSubIntervale) {
        this.beTraOrderSubIntervale = beTraOrderSubIntervale;
    }

    public String getBeTraDeliveryMode() {
        return beTraDeliveryMode;
    }

    public void setBeTraDeliveryMode(String beTraDeliveryMode) {
        this.beTraDeliveryMode = beTraDeliveryMode == null ? null : beTraDeliveryMode.trim();
    }

    public String getBePaymentLink() {
        return bePaymentLink;
    }

    public void setBePaymentLink(String bePaymentLink) {
        this.bePaymentLink = bePaymentLink == null ? null : bePaymentLink.trim();
    }

    public String getBeEwalletUseing() {
        return beEwalletUseing;
    }

    public void setBeEwalletUseing(String beEwalletUseing) {
        this.beEwalletUseing = beEwalletUseing == null ? null : beEwalletUseing.trim();
    }

    public String getBeTraPaymentMode() {
        return beTraPaymentMode;
    }

    public void setBeTraPaymentMode(String beTraPaymentMode) {
        this.beTraPaymentMode = beTraPaymentMode == null ? null : beTraPaymentMode.trim();
    }

    public String getBePaymentSuccess() {
        return bePaymentSuccess;
    }

    public void setBePaymentSuccess(String bePaymentSuccess) {
        this.bePaymentSuccess = bePaymentSuccess == null ? null : bePaymentSuccess.trim();
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getBeSubTimes() {
        return beSubTimes;
    }

    public void setBeSubTimes(Date beSubTimes) {
        this.beSubTimes = beSubTimes;
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getBeSubTimee() {
        return beSubTimee;
    }

    public void setBeSubTimee(Date beSubTimee) {
        this.beSubTimee = beSubTimee;
    }

    public String getBeKeywordSearch() {
        return beKeywordSearch;
    }

    public void setBeKeywordSearch(String beKeywordSearch) {
        this.beKeywordSearch = beKeywordSearch == null ? null : beKeywordSearch.trim();
    }

    public String getBeInsideSearchPage() {
        return beInsideSearchPage;
    }

    public void setBeInsideSearchPage(String beInsideSearchPage) {
        this.beInsideSearchPage = beInsideSearchPage == null ? null : beInsideSearchPage.trim();
    }

    public String getBeLandingPage() {
        return beLandingPage;
    }

    public void setBeLandingPage(String beLandingPage) {
        this.beLandingPage = beLandingPage == null ? null : beLandingPage.trim();
    }


    public String getBeInOutStation() {
        return beInOutStation;
    }

    public void setBeInOutStation(String beInOutStation) {
        this.beInOutStation = beInOutStation == null ? null : beInOutStation.trim();
    }

    public String getBeExoticSource() {
        return beExoticSource;
    }

    public void setBeExoticSource(String beExoticSource) {
        this.beExoticSource = beExoticSource == null ? null : beExoticSource.trim();
    }

    public String getBeAdKeyword() {
        return beAdKeyword;
    }

    public void setBeAdKeyword(String beAdKeyword) {
        this.beAdKeyword = beAdKeyword == null ? null : beAdKeyword.trim();
    }


    public String getBeCommodityName() {
        return beCommodityName;
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getBeAccessStime() {
		return beAccessStime;
	}

	public void setBeAccessStime(Date beAccessStime) {
		this.beAccessStime = beAccessStime;
	}
	//@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
	public Date getBeAccessEtime() {
		return beAccessEtime;
	}

	public void setBeAccessEtime(Date beAccessEtime) {
		this.beAccessEtime = beAccessEtime;
	}
	//@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
	public Date getBeShareStime() {
		return beShareStime;
	}
	
	public void setBeShareStime(Date beShareStime) {
		this.beShareStime = beShareStime;
	}
	//@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
	public Date getBeShareEtime() {
		return beShareEtime;
	}

	public void setBeShareEtime(Date beShareEtime) {
		this.beShareEtime = beShareEtime;
	}

	public void setBeCommodityName(String beCommodityName) {
        this.beCommodityName = beCommodityName == null ? null : beCommodityName.trim();
    }

    public String getBeSharingChannels() {
        return beSharingChannels;
    }

    public void setBeSharingChannels(String beSharingChannels) {
        this.beSharingChannels = beSharingChannels == null ? null : beSharingChannels.trim();
    }

    public String getBeRegistrationTimes() {
        return beRegistrationTimes;
    }

    public void setBeRegistrationTimes(String beRegistrationTimes) {
        this.beRegistrationTimes = beRegistrationTimes == null ? null : beRegistrationTimes.trim();
    }

    public String getBeRegistrationTimee() {
        return beRegistrationTimee;
    }

    public void setBeRegistrationTimee(String beRegistrationTimee) {
        this.beRegistrationTimee = beRegistrationTimee == null ? null : beRegistrationTimee.trim();
    }

    public String getBeRegisteredGoods() {
        return beRegisteredGoods;
    }

    public void setBeRegisteredGoods(String beRegisteredGoods) {
        this.beRegisteredGoods = beRegisteredGoods == null ? null : beRegisteredGoods.trim();
    }

    public String getBeRegisteredQuantity() {
        return beRegisteredQuantity;
    }

    public void setBeRegisteredQuantity(String beRegisteredQuantity) {
        this.beRegisteredQuantity = beRegisteredQuantity == null ? null : beRegisteredQuantity.trim();
    }

    public String getBeCommodityClassa() {
        return beCommodityClassa;
    }

    public void setBeCommodityClassa(String beCommodityClassa) {
        this.beCommodityClassa = beCommodityClassa == null ? null : beCommodityClassa.trim();
    }

    public String getBeCommodityClassb() {
        return beCommodityClassb;
    }

    public void setBeCommodityClassb(String beCommodityClassb) {
        this.beCommodityClassb = beCommodityClassb == null ? null : beCommodityClassb.trim();
    }

    public String getBeOutStockProvince() {
        return beOutStockProvince;
    }

    public void setBeOutStockProvince(String beOutStockProvince) {
        this.beOutStockProvince = beOutStockProvince == null ? null : beOutStockProvince.trim();
    }

    public String getBeOutStockCity() {
        return beOutStockCity;
    }

    public void setBeOutStockCity(String beOutStockCity) {
        this.beOutStockCity = beOutStockCity == null ? null : beOutStockCity.trim();
    }

    public String getBeOutOfStockGroups() {
        return beOutOfStockGroups;
    }

    public void setBeOutOfStockGroups(String beOutOfStockGroups) {
        this.beOutOfStockGroups = beOutOfStockGroups == null ? null : beOutOfStockGroups.trim();
    }

    public String getCoCommunicationType() {
        return coCommunicationType;
    }

    public void setCoCommunicationType(String coCommunicationType) {
        this.coCommunicationType = coCommunicationType == null ? null : coCommunicationType.trim();
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getCoTimeStart() {
        return coTimeStart;
    }

    public void setCoTimeStart(Date coTimeStart) {
        this.coTimeStart = coTimeStart;
    }
   //@JsonDeserialize(using=CustomDateDeserialize.class) 
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTool.YMDHMS, timezone = "GMT+8")
    public Date getCoTimeEnd() {
        return coTimeEnd;
    }

    public void setCoTimeEnd(Date coTimeEnd) {
        this.coTimeEnd = coTimeEnd;
    }

    public String getCoCount() {
        return coCount;
    }

    public void setCoCount(String coCount) {
        this.coCount = coCount == null ? null : coCount.trim();
    }

    public String getCoResult() {
        return coResult;
    }

    public void setCoResult(String coResult) {
        this.coResult = coResult == null ? null : coResult.trim();
    }

    public String getCoFrequency() {
        return coFrequency;
    }

    public void setCoFrequency(String coFrequency) {
        this.coFrequency = coFrequency == null ? null : coFrequency.trim();
    }

    public String getCoClickRate() {
        return coClickRate;
    }

    public void setCoClickRate(String coClickRate) {
        this.coClickRate = coClickRate == null ? null : coClickRate.trim();
    }

    public String getCoOrderConversionRate() {
        return coOrderConversionRate;
    }

    public void setCoOrderConversionRate(String coOrderConversionRate) {
        this.coOrderConversionRate = coOrderConversionRate == null ? null : coOrderConversionRate.trim();
    }

    public String getCoComKeywords() {
        return coComKeywords;
    }

    public void setCoComKeywords(String coComKeywords) {
        this.coComKeywords = coComKeywords == null ? null : coComKeywords.trim();
    }
}