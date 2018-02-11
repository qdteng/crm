package cn.com.ylpw.web.crm.entity.customer;

import java.math.BigDecimal;
import java.util.Date;

import cn.com.ylpw.web.crm.entity.BaseEntity;
import cn.com.ylpw.web.crm.model.search.Customers;

public class TCustomers extends BaseEntity   {
	
	public TCustomers(){}
	
	public TCustomers(Customers esObject){
		super.setId(esObject.getId());
		this.pwsysId=esObject.getPwsysId();
		this.truename =esObject.getTruename();
		this.phone = esObject.getPhone() ;
		this.username = esObject.getUsername() ;
	}
	private Long pwsysId;
	
	private Long sys1Id;
	
	private Long sys2Id;
	
	private Long sys3Id;

	
	private static final long serialVersionUID = 1L;
	//用户真实名称, 票点/联盟 名称
    private String truename;
    private String password;
    //用户性别 1 男 2女
    private String sex;
    private String email;
    //用户出生日期
    private Date regdate;
    //用户昵称
    private String nickname;
    //用户证件类型（1 身份证 2 军官证 3 护照）
    private Short cardtype;
    private String card;
    //用户类别（1 个人用户 2 企业用户 3 集团用户 4 关系用户 5 团购客户）
    private Short usertype;
    
    private Long discountdetailid;
    //用户最后登录IP
    private String ip;
    //用户邮箱是否验证（1 是 0 否
    private Short regemail;

    private String phone;

    private String tel;
    //用户积分
    private Integer integral;
    //用户登录次数
    private Integer num;
    //用户购买次数
    private Integer buynum;
    //用户恶意退票次数
    private Integer malice;
    //用户备注
    private String info;
    //逻辑删除（1 删除锁定状态 0  有效）
    private Short status;
    //增加时间,票点/联盟 增加时间
    private Date createtime;
    //最后修改时间,票点/联盟 最后修改时间
    private Date lasttime;
    //最后修改人,票点/联盟 最后修改人
    private String lastuser;
    
    private Integer discountid;
    //用户预存款
    private BigDecimal renewal;
    
    private String renewalpwd;

    private String olduserid;

    private String oldmark;

    private String unionuserid;

    private Integer fconfigid;

    private String tnumber;

    private Short levels;

    private BigDecimal amount;

    private String lname;

    private String adress;

    private Short effect;

    private String code;

    private Integer uniondiscount;

    private Integer thirddiscount;

    private Integer userdiscount;

    private Integer cityid;

    private Integer type;

    private String legalperson;

    private Date businessdate;

    private BigDecimal starcapital;
    //票点/联盟 员工数量 2011-08-13 dj添加
    private Integer employeenum;
    //票点/联盟 资产总额（单位：万元） 2011-08-13 dj添加
    private BigDecimal asset;
    
    private String yyzzurl;

    private String sfzurl;
    //联盟用户登陆用户名
    private String username;
    //籍贯
    private String nativeplace;
    //用户所在城市
    private String customercity;
    //资料来源
    private String datasource;
    //客户来源  1:电话 2:网络 3:网点 4:邮件 5:短信
    private Short customersource;
    //所属行业
    private String industry;
    //职位
    private String position;
    //收入水平
    private String incomelevels;
    //家庭月收入范围
    private String incomerange;
    //购买目的  1:自用 2:公司 3:赠送 4:其它
    private Short buypurpose;
    //购买频率
    private String buyfrequency;
    //喜欢价位
    private String ticketprice;
    //全家关注明星
    private String attentionstar;
    //婚姻状况 1:已婚 2:未婚
    private Short maritalstatus;
    //有无子女 1:有 2:无
    private Short ischildren;
    //子女生日
    private String childrenbirthday;
    //是否上网 1:是 2:否
    private Short isinternet;
    //关注节目  1:演唱会  2:音乐会  2:话剧舞台剧  4:舞蹈芭蕾  5:戏曲综艺  6:儿童亲子  7:休闲娱乐  8:体育赛事(多个关注间以,号分割)
    private String attentiontype;
    //兴趣爱好  1:明星  2:音乐  3:影视  4:运动(多个关注间以,号分割)
    private String interests;
    //其他兴趣爱好
    private String interestsother;
    //生日
    private String birthday;
    //票点赊销累计金额
    private Integer currentamount;
    //学历
    private String education;
    //
    private BigDecimal unionsettlementdiscount;

    private Short isrenewal;

    private Short regphone;

    private Short regsafetyinfo;
    //用户最后登录时间(每次登录时更新)
    private Date lastlogintime;

    private String uniontype;

    private String discounttype;

    private Date limitstarttime;

    private Date limitendtime;
    //来源流水
    private Integer spreadtypeid;
    //第三方注册来源【10：web，20：后台电话注册，30:wap， 40：安卓， 50：ios， 60：WEB联盟 70:WAP联盟】
    private Integer registeredsource;
    //注册手机系统  1：android 2：ios 
    private Short phoneSys;
    //注册手机型号
    private String phoneModel;
    //注册手机系统版本
    private String phoneVersion;
    //注册客户端系统版本
    private String clientVersion;
    //注册渠道名称
    private Long channelId;
    //用户头像
    private String headimg;
    //设备推送token
    private String devicetoken;
    //最后一次登录手机设备类型，1:Android, 2:ios
    private Short lastloginphonetype;
    
    private String accsFlag;

    private String unionkey;
    
    private String errorChannelName;
    //IOS客户端IDFA
    private String iosIdfa;
    //用户最后一次登登录渠道
    private String lastLoginChannel;
    //是否支付宝实名认证用户
    private Integer ifalipay;
    //推广方式 ：8:联盟跳转、9:联盟平台、10:CPS
    private Short spreadway;
    //用户等级
    private String gradeName;
    //用户等级表ID
    private Long gradeId;
    //最后一次更新等级的时间
    private Date gradeUpdateLast;
    //会员活跃成长值
    private Double activeIndex;
    //RFM成长值
    private Double rfmIndex;
    //消费激励成长值
    private Double recencyIndex;
    //成长值
    private Double cindex;
    //成长值更新时间
    private Date cindexUpddate;
    //营销屏蔽，0：未屏蔽，1：屏蔽
    private Integer shield;
    
    //会员系统来源-具体类型见数据字典-CUSTOMER_SYS_SOURCE
    private String  sysSource;
    //微博账号
    private String  weiboNo;
    //用户积分系统计算可用的
    private  Long crmIntegralSys;
    //用户积分 CRM 操作可用的
    private  Long crmIntegralOpt;
    //积分启用禁用方式1启用0禁用
    private  int crmIntegralStatus;
    
    //CRM用户积分 系统消耗积分
    private  Long crmIntegralConsume;
    
    
    private  Long crmIntegralUsable ;
    
    private String qqNum;//QQ号
    
    private String constellation;//星座
    
    //pwSysId 加密后的字符串
    private String  useridToken ;
    
    
    public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public String getQqNum() {
		return qqNum;
	}

	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}

	public String getWeiboNo() {
		return weiboNo;
	}

	public void setWeiboNo(String weiboNo) {
		this.weiboNo = weiboNo;
	}

	public String getWeixinNo() {
		return weixinNo;
	}

	public void setWeixinNo(String weixinNo) {
		this.weixinNo = weixinNo;
	}

	//微信账号
    private String  weixinNo;
    
    
	public String getSysSource() {
		return sysSource;
	}

	public void setSysSource(String sysSource) {
		this.sysSource = sysSource;
	}

	public Integer getShield() {
		return shield;
	}

	public void setShield(Integer shield) {
		this.shield = shield;
	}

	public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename == null ? null : truename.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Short getCardtype() {
        return cardtype;
    }

    public void setCardtype(Short cardtype) {
        this.cardtype = cardtype;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }

    public Short getUsertype() {
        return usertype;
    }

    public void setUsertype(Short usertype) {
        this.usertype = usertype;
    }

    public Long getDiscountdetailid() {
        return discountdetailid;
    }

    public void setDiscountdetailid(Long discountdetailid) {
        this.discountdetailid = discountdetailid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Short getRegemail() {
        return regemail;
    }

    public void setRegemail(Short regemail) {
        this.regemail = regemail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getBuynum() {
        return buynum;
    }

    public void setBuynum(Integer buynum) {
        this.buynum = buynum;
    }

    public Integer getMalice() {
        return malice;
    }

    public void setMalice(Integer malice) {
        this.malice = malice;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public String getLastuser() {
        return lastuser;
    }

    public void setLastuser(String lastuser) {
        this.lastuser = lastuser == null ? null : lastuser.trim();
    }

    public Integer getDiscountid() {
        return discountid;
    }

    public void setDiscountid(Integer discountid) {
        this.discountid = discountid;
    }

    public BigDecimal getRenewal() {
        return renewal;
    }

    public void setRenewal(BigDecimal renewal) {
        this.renewal = renewal;
    }

    public String getRenewalpwd() {
        return renewalpwd;
    }

    public void setRenewalpwd(String renewalpwd) {
        this.renewalpwd = renewalpwd == null ? null : renewalpwd.trim();
    }

    public String getOlduserid() {
        return olduserid;
    }

    public void setOlduserid(String olduserid) {
        this.olduserid = olduserid == null ? null : olduserid.trim();
    }

    public String getOldmark() {
        return oldmark;
    }

    public void setOldmark(String oldmark) {
        this.oldmark = oldmark == null ? null : oldmark.trim();
    }

    public String getUnionuserid() {
        return unionuserid;
    }

    public void setUnionuserid(String unionuserid) {
        this.unionuserid = unionuserid == null ? null : unionuserid.trim();
    }

    public Integer getFconfigid() {
        return fconfigid;
    }

    public void setFconfigid(Integer fconfigid) {
        this.fconfigid = fconfigid;
    }

    public String getTnumber() {
        return tnumber;
    }

    public void setTnumber(String tnumber) {
        this.tnumber = tnumber == null ? null : tnumber.trim();
    }

    public Short getLevels() {
        return levels;
    }

    public void setLevels(Short levels) {
        this.levels = levels;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname == null ? null : lname.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public Short getEffect() {
        return effect;
    }

    public void setEffect(Short effect) {
        this.effect = effect;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getUniondiscount() {
        return uniondiscount;
    }

    public void setUniondiscount(Integer uniondiscount) {
        this.uniondiscount = uniondiscount;
    }

    public Integer getThirddiscount() {
        return thirddiscount;
    }

    public void setThirddiscount(Integer thirddiscount) {
        this.thirddiscount = thirddiscount;
    }

    public Integer getUserdiscount() {
        return userdiscount;
    }

    public void setUserdiscount(Integer userdiscount) {
        this.userdiscount = userdiscount;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLegalperson() {
        return legalperson;
    }

    public void setLegalperson(String legalperson) {
        this.legalperson = legalperson == null ? null : legalperson.trim();
    }

    public Date getBusinessdate() {
        return businessdate;
    }

    public void setBusinessdate(Date businessdate) {
        this.businessdate = businessdate;
    }

    public BigDecimal getStarcapital() {
        return starcapital;
    }

    public void setStarcapital(BigDecimal starcapital) {
        this.starcapital = starcapital;
    }

    public Integer getEmployeenum() {
        return employeenum;
    }

    public void setEmployeenum(Integer employeenum) {
        this.employeenum = employeenum;
    }

    public BigDecimal getAsset() {
        return asset;
    }

    public void setAsset(BigDecimal asset) {
        this.asset = asset;
    }

    public String getYyzzurl() {
        return yyzzurl;
    }

    public void setYyzzurl(String yyzzurl) {
        this.yyzzurl = yyzzurl == null ? null : yyzzurl.trim();
    }

    public String getSfzurl() {
        return sfzurl;
    }

    public void setSfzurl(String sfzurl) {
        this.sfzurl = sfzurl == null ? null : sfzurl.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace == null ? null : nativeplace.trim();
    }

    public String getCustomercity() {
        return customercity;
    }

    public void setCustomercity(String customercity) {
        this.customercity = customercity == null ? null : customercity.trim();
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource == null ? null : datasource.trim();
    }

    public Short getCustomersource() {
        return customersource;
    }

    public void setCustomersource(Short customersource) {
        this.customersource = customersource;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getIncomelevels() {
        return incomelevels;
    }

    public void setIncomelevels(String incomelevels) {
        this.incomelevels = incomelevels == null ? null : incomelevels.trim();
    }

    public String getIncomerange() {
        return incomerange;
    }

    public void setIncomerange(String incomerange) {
        this.incomerange = incomerange == null ? null : incomerange.trim();
    }

    public Short getBuypurpose() {
        return buypurpose;
    }

    public void setBuypurpose(Short buypurpose) {
        this.buypurpose = buypurpose;
    }

    public String getBuyfrequency() {
        return buyfrequency;
    }

    public void setBuyfrequency(String buyfrequency) {
        this.buyfrequency = buyfrequency == null ? null : buyfrequency.trim();
    }

    public String getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(String ticketprice) {
        this.ticketprice = ticketprice == null ? null : ticketprice.trim();
    }

    public String getAttentionstar() {
        return attentionstar;
    }

    public void setAttentionstar(String attentionstar) {
        this.attentionstar = attentionstar == null ? null : attentionstar.trim();
    }

    public Short getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(Short maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public Short getIschildren() {
        return ischildren;
    }

    public void setIschildren(Short ischildren) {
        this.ischildren = ischildren;
    }

    public String getChildrenbirthday() {
        return childrenbirthday;
    }

    public void setChildrenbirthday(String childrenbirthday) {
        this.childrenbirthday = childrenbirthday == null ? null : childrenbirthday.trim();
    }

    public Short getIsinternet() {
        return isinternet;
    }

    public void setIsinternet(Short isinternet) {
        this.isinternet = isinternet;
    }

    public String getAttentiontype() {
        return attentiontype;
    }

    public void setAttentiontype(String attentiontype) {
        this.attentiontype = attentiontype == null ? null : attentiontype.trim();
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests == null ? null : interests.trim();
    }

    public String getInterestsother() {
        return interestsother;
    }

    public void setInterestsother(String interestsother) {
        this.interestsother = interestsother == null ? null : interestsother.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public Integer getCurrentamount() {
        return currentamount;
    }

    public void setCurrentamount(Integer currentamount) {
        this.currentamount = currentamount;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public BigDecimal getUnionsettlementdiscount() {
        return unionsettlementdiscount;
    }

    public void setUnionsettlementdiscount(BigDecimal unionsettlementdiscount) {
        this.unionsettlementdiscount = unionsettlementdiscount;
    }

    public Short getIsrenewal() {
        return isrenewal;
    }

    public void setIsrenewal(Short isrenewal) {
        this.isrenewal = isrenewal;
    }

    public Short getRegphone() {
        return regphone;
    }

    public void setRegphone(Short regphone) {
        this.regphone = regphone;
    }

    public Short getRegsafetyinfo() {
        return regsafetyinfo;
    }

    public void setRegsafetyinfo(Short regsafetyinfo) {
        this.regsafetyinfo = regsafetyinfo;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getUniontype() {
        return uniontype;
    }

    public void setUniontype(String uniontype) {
        this.uniontype = uniontype == null ? null : uniontype.trim();
    }

    public String getDiscounttype() {
        return discounttype;
    }

    public void setDiscounttype(String discounttype) {
        this.discounttype = discounttype == null ? null : discounttype.trim();
    }

    public Date getLimitstarttime() {
        return limitstarttime;
    }

    public void setLimitstarttime(Date limitstarttime) {
        this.limitstarttime = limitstarttime;
    }

    public Date getLimitendtime() {
        return limitendtime;
    }

    public void setLimitendtime(Date limitendtime) {
        this.limitendtime = limitendtime;
    }

    public Integer getSpreadtypeid() {
        return spreadtypeid;
    }

    public void setSpreadtypeid(Integer spreadtypeid) {
        this.spreadtypeid = spreadtypeid;
    }

    public Integer getRegisteredsource() {
        return registeredsource;
    }

    public void setRegisteredsource(Integer registeredsource) {
        this.registeredsource = registeredsource;
    }

    public Short getPhoneSys() {
        return phoneSys;
    }

    public void setPhoneSys(Short phoneSys) {
        this.phoneSys = phoneSys;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel == null ? null : phoneModel.trim();
    }

    public String getPhoneVersion() {
        return phoneVersion;
    }

    public void setPhoneVersion(String phoneVersion) {
        this.phoneVersion = phoneVersion == null ? null : phoneVersion.trim();
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion == null ? null : clientVersion.trim();
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public String getDevicetoken() {
        return devicetoken;
    }

    public void setDevicetoken(String devicetoken) {
        this.devicetoken = devicetoken == null ? null : devicetoken.trim();
    }

    public Short getLastloginphonetype() {
        return lastloginphonetype;
    }

    public void setLastloginphonetype(Short lastloginphonetype) {
        this.lastloginphonetype = lastloginphonetype;
    }

    public String getAccsFlag() {
        return accsFlag;
    }

    public void setAccsFlag(String accsFlag) {
        this.accsFlag = accsFlag == null ? null : accsFlag.trim();
    }

    public String getUnionkey() {
        return unionkey;
    }

    public void setUnionkey(String unionkey) {
        this.unionkey = unionkey == null ? null : unionkey.trim();
    }

    public String getErrorChannelName() {
        return errorChannelName;
    }

    public void setErrorChannelName(String errorChannelName) {
        this.errorChannelName = errorChannelName == null ? null : errorChannelName.trim();
    }

    public String getIosIdfa() {
        return iosIdfa;
    }

    public void setIosIdfa(String iosIdfa) {
        this.iosIdfa = iosIdfa == null ? null : iosIdfa.trim();
    }

    public String getLastLoginChannel() {
        return lastLoginChannel;
    }

    public void setLastLoginChannel(String lastLoginChannel) {
        this.lastLoginChannel = lastLoginChannel == null ? null : lastLoginChannel.trim();
    }

    public Integer getIfalipay() {
        return ifalipay;
    }

    public void setIfalipay(Integer ifalipay) {
        this.ifalipay = ifalipay;
    }

    public Short getSpreadway() {
        return spreadway;
    }

    public void setSpreadway(Short spreadway) {
        this.spreadway = spreadway;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName == null ? null : gradeName.trim();
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Double getCindex() {
        return cindex;
    }

    public void setCindex(Double cindex) {
        this.cindex = cindex;
    }

    public Date getCindexUpddate() {
        return cindexUpddate;
    }

    public void setCindexUpddate(Date cindexUpddate) {
        this.cindexUpddate = cindexUpddate;
    }

	public Double getActiveIndex() {
		return activeIndex;
	}

	public void setActiveIndex(Double activeIndex) {
		this.activeIndex = activeIndex;
	}

	public Double getRfmIndex() {
		return rfmIndex;
	}

	public void setRfmIndex(Double rfmIndex) {
		this.rfmIndex = rfmIndex;
	}

	public Double getRecencyIndex() {
		return recencyIndex;
	}

	public void setRecencyIndex(Double recencyIndex) {
		this.recencyIndex = recencyIndex;
	}
	

	public Date getGradeUpdateLast() {
		return gradeUpdateLast;
	}

	public void setGradeUpdateLast(Date gradeUpdateLast) {
		this.gradeUpdateLast = gradeUpdateLast;
	}

	public Long getCrmIntegralSys() {
		return crmIntegralSys;
	}

	public void setCrmIntegralSys(Long crmIntegralSys) {
		this.crmIntegralSys = crmIntegralSys;
	}

	public Long getCrmIntegralOpt() {
		return crmIntegralOpt;
	}

	public void setCrmIntegralOpt(Long crmIntegralOpt) {
		this.crmIntegralOpt = crmIntegralOpt;
	}

	public int getCrmIntegralStatus() {
		return crmIntegralStatus;
	}

	public void setCrmIntegralStatus(int crmIntegralStatus) {
		this.crmIntegralStatus = crmIntegralStatus;
	}

	public Long getCrmIntegralConsume() {
		return crmIntegralConsume;
	}

	public void setCrmIntegralConsume(Long crmIntegralConsume) {
		this.crmIntegralConsume = crmIntegralConsume;
	}

	public Long getCrmIntegralUsable() {
		return crmIntegralUsable;
	}

	public void setCrmIntegralUsable(Long crmIntegralUsable) {
		this.crmIntegralUsable = crmIntegralUsable;
	}

	public Long getPwsysId() {
		return pwsysId;
	}

	public void setPwsysId(Long pwsysId) {
		this.pwsysId = pwsysId;
	}

	public Long getSys1Id() {
		return sys1Id;
	}

	public void setSys1Id(Long sys1Id) {
		this.sys1Id = sys1Id;
	}

	public Long getSys2Id() {
		return sys2Id;
	}

	public void setSys2Id(Long sys2Id) {
		this.sys2Id = sys2Id;
	}

	public Long getSys3Id() {
		return sys3Id;
	}

	public void setSys3Id(Long sys3Id) {
		this.sys3Id = sys3Id;
	}

	public String getUseridToken() {
		return useridToken;
	}

	public void setUseridToken(String useridToken) {
		this.useridToken = useridToken;
	}
}