package cn.com.ylpw.web.crm.model.search;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
/**
 * @ClassName: Customers
 * @Description:esSearch 中的  customerGroup 原型
 * @author LT
 * @date 2017年10月30日 上午10:05:02
 */
@Document(indexName = "activty_user_url_maps", type = "activty_user_url_maps", 
shards = 1, replicas = 0, refreshInterval = "2s" )
public class ActivtyUserUrlMaps implements Serializable {
	
	public ActivtyUserUrlMaps()  {
		
	}
	private static final long serialVersionUID = 1L;
	
	@Id
	@Field(type = FieldType.text, store = true)
	private String id;
	//活动Id
	private Long activtyId ;
	//228请求CRM 的url中城市code如  BJ
	@Field(type=FieldType.keyword)
	private String reqCity ;
	//228请求CRM 的url中投放位置key如  dbce141a-9fc2-4ab2-ac59-9bfecbca3673
	@Field(type=FieldType.keyword)
	private String reqPostKey;
	//投放的用户 useridTokens
	@Field(type=FieldType.keyword)
	private String  useridToken ;
	//crm系统的用户ID
	private Long  userid ;
	//crm系统的用户ID
	private Long  pwsysId ;
	//生成的短连接 :例如 ：game.2.cn/b4D0m
	@Field(type=FieldType.keyword)
	private String simpleUrl ;
	//crm实际的活动链接  例如 ： http://game.2.cn/active/dazhuanpan/6.html?userid=Ge7wQ1wsLBXpPcUteqNFOg==
	@Field(type=FieldType.keyword)
	private String remoteUrl ;
	//投放228的图片路径
	@Field(type=FieldType.keyword)
	private String imgurl;
	//投放结束时间
	private Long timeOut ;
	//广告投放端 IOS  Android    PC    WAP
	@Field(type=FieldType.keyword)
	private String triggerType;
	//是否暂停投放
	private Boolean  stop; 
	
	public String getSimpleUrl() {
		return simpleUrl;
	}
	public void setSimpleUrl(String simpleUrl) {
		this.simpleUrl = simpleUrl;
	}
	public String getRemoteUrl() {
		return remoteUrl;
	}
	public void setRemoteUrl(String remoteUrl) {
		this.remoteUrl = remoteUrl;
	}
	public Long getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(Long timeOut) {
		this.timeOut = timeOut;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public Long getActivtyId() {
		return activtyId;
	}
	public void setActivtyId(Long activtyId) {
		this.activtyId = activtyId;
	}
	public String getReqCity() {
		return reqCity;
	}
	public void setReqCity(String reqCity) {
		this.reqCity = reqCity;
	}
	public String getReqPostKey() {
		return reqPostKey;
	}
	public void setReqPostKey(String reqPostKey) {
		this.reqPostKey = reqPostKey;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUseridToken() {
		return useridToken;
	}
	public void setUseridToken(String useridToken) {
		this.useridToken = useridToken;
	}
	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}
	public Boolean getStop() {
		return stop;
	}
	public void setStop(Boolean stop) {
		this.stop = stop;
	}
	public String getTriggerType() {
		return triggerType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getPwsysId() {
		return pwsysId;
	}
	public void setPwsysId(Long pwsysId) {
		this.pwsysId = pwsysId;
	}
	
	
}
