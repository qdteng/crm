package cn.com.ylpw.web.crm.model.importVO;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.jeecgframework.poi.excel.annotation.Excel;

public class TCustomersImportVO implements Serializable{

	private static final long serialVersionUID = 3757997087925085572L;
	
	@NotNull
	@Excel(name="会员来源")
    private String customerSource;
	
	@Excel(name="昵称")
    private String nickName;
	
	@Excel(name="姓名")
    private String name;
	
	@Excel(name="性别")
    private String sex;
	
	@Excel(name="手机号")
    private String phone;
	
	@Excel(name="邮箱")
    private String email;
	
	@Excel(name="微博号")
    private String weiboNo;
	
	@Excel(name="微信号")
    private String weCheatNo;
	
	@Excel(name="证件号")
    private String cardNo;
	
	@Excel(name="会员标签")
    private String customerSign;

	public String getCustomerSource() {
		return customerSource;
	}

	public void setCustomerSource(String customerSource) {
		this.customerSource = customerSource;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getWeiboNo() {
		return weiboNo;
	}

	public void setWeiboNo(String weiboNo) {
		this.weiboNo = weiboNo;
	}

	public String getWeCheatNo() {
		return weCheatNo;
	}

	public void setWeCheatNo(String weCheatNo) {
		this.weCheatNo = weCheatNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCustomerSign() {
		return customerSign;
	}

	public void setCustomerSign(String customerSign) {
		this.customerSign = customerSign;
	}
	
}
