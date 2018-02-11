package cn.com.ylpw.web.crm.model;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerEntity {
    private BigDecimal customersid;

    private String truename;

    private String password;

    private String sex;

    private String email;

    private Date regdate;

    private String nickname;

    private Short cardtype;

    private String card;

    private Short usertype;

    private BigDecimal discountdetailid;

    private String ip;

    private Short regemail;

    private String phone;

    private String tel;

    private Integer integral;

    private Integer num;

    private Integer buynum;

    private Integer malice;

    private String info;

    private Short status;

    private Date createtime;

    private Date lasttime;

    private String lastuser;

    private BigDecimal discountid;

    private BigDecimal renewal;

    private String renewalpwd;

    private String olduserid;

    private String oldmark;

    private String unionuserid;

    private BigDecimal fconfigid;

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

    private BigDecimal cityid;

    private Integer type;

    private String legalperson;

    private Date businessdate;

    private BigDecimal starcapital;

    private Integer employeenum;

    private BigDecimal asset;

    private String yyzzurl;

    private String sfzurl;

    private String username;

    private String tel2;

    private String nativeplace;

    private String customercity;

    private String datasource;

    private Short customersource;

    private String industry;

    private String position;

    private String incomelevels;

    private String incomerange;

    private Short buypurpose;

    private String buyfrequency;

    private String ticketprice;

    private String attentionstar;

    private Short maritalstatus;

    private Short ischildren;

    private String childrenbirthday;

    private Short isinternet;

    private String attentiontype;

    private String interests;

    private String interestsother;

    private String birthday;

    private BigDecimal currentamount;

    private String education;

    private BigDecimal unionsettlementdiscount;

    private Short isrenewal;

    private Short regphone;

    private Short regsafetyinfo;

    private Date lastlogintime;

    private String uniontype;

    private String discounttype;

    private Date limitstarttime;

    private Date limitendtime;

    private BigDecimal spreadtypeid;

    private Integer registeredsource;

    private Short phoneSys;

    private String phoneModel;

    private String phoneVersion;

    private String clientVersion;

    private Short channelId;

    private Short channelId2;

    private String headimg;

    private String devicetoken;

    public BigDecimal getCustomersid() {
        return customersid;
    }

    public void setCustomersid(BigDecimal customersid) {
        this.customersid = customersid;
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

    public BigDecimal getDiscountdetailid() {
        return discountdetailid;
    }

    public void setDiscountdetailid(BigDecimal discountdetailid) {
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

    public BigDecimal getDiscountid() {
        return discountid;
    }

    public void setDiscountid(BigDecimal discountid) {
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

    public BigDecimal getFconfigid() {
        return fconfigid;
    }

    public void setFconfigid(BigDecimal fconfigid) {
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

    public BigDecimal getCityid() {
        return cityid;
    }

    public void setCityid(BigDecimal cityid) {
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

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2 == null ? null : tel2.trim();
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

    public BigDecimal getCurrentamount() {
        return currentamount;
    }

    public void setCurrentamount(BigDecimal currentamount) {
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

    public BigDecimal getSpreadtypeid() {
        return spreadtypeid;
    }

    public void setSpreadtypeid(BigDecimal spreadtypeid) {
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

    public Short getChannelId() {
        return channelId;
    }

    public void setChannelId(Short channelId) {
        this.channelId = channelId;
    }

    public Short getChannelId2() {
        return channelId2;
    }

    public void setChannelId2(Short channelId2) {
        this.channelId2 = channelId2;
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
}