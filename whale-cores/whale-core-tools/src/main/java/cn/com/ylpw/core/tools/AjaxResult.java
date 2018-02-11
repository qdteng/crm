package cn.com.ylpw.core.tools;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class AjaxResult {
	
	
	 public enum ResultCode implements Serializable{
		   
		 	success("操作成功"),
		   
		   error("操作失败");
		   
		   private String  text;  
	        
		   ResultCode(String text){  
	            this.text = text;  
	        }
			public String getText() {
				return text;
			}

			public void setText(String text) {
				this.text = text;
			}
	   }  
	 
	// 标记成功失败，默认0：成功，1：失败，2：失败
	private ResultCode code = ResultCode.success;

	// 返回的中文消息
	private String message;
	
	private Map<String,Object> values = new HashMap<String,Object>() ;
	
	public Map<String,Object> putVal(String key , Object val) {
		values.put(key, val) ;
		return  values;
	}
	
	public Map<String,Object> getValues() {
		return  values;
	}
	public ResultCode getCode() {
		return code;
	}

	public void setCode(ResultCode code) {
		this.code = code;
	}

	public String getMessage() {
		return StringUtils.isBlank(message)?this.code.getText():message ;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	// 添加错误，用于alertError
	public AjaxResult addError (String message) {
		
		this.code = ResultCode.error ;
		this.message = message;
		return this;
	}

	public static AjaxResult Instance(){
		 return new AjaxResult(); 
	}

	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
