package cn.com.ylpw.web.crm.base;

 /**
  * @ClassName: BiExceptionMessage
  * @Description: Bi系统异常信息管理中心，枚举类
  * @author zhaohb
  * @date 2017-3-3 下午1:51:35
  */
public enum ExceptionMessage {
	
	LOGIN_SUCCESS("1001","登录成功"),
	LOGIN_ACC_OR_PWD_ERROR("1002","账户或密码错误"), 
	LOGIN_ACC_DISABLED("1003","该账号已被禁用"),
	LOGIN_FAILED("1004","登录失败");
	
	ExceptionMessage(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	private String code = null;
	private String message = null;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}