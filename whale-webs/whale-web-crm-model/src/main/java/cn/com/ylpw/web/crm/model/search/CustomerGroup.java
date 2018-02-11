package cn.com.ylpw.web.crm.model.search;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
/**
 * @ClassName: Customers
 * @Description:esSearch 中的  customerGroup 原型
 * @author LT
 * @date 2017年10月30日 上午10:05:02
 */
public class CustomerGroup implements Serializable {
	
	public CustomerGroup()  {
		
	}
	

	public CustomerGroup(Long groupId )  {
		this.groupId = groupId;
	}
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * <p>用于动态生成或删除索引</p>
	 * @author LT
	 * @date 2017年12月1日 下午2:57:05
	 * @return String
	 * @return
	 */
	public   String getIndexName(){
		return "customer_group_"+this.getGroupId();
	}
	 @Id
	 @Field(type = FieldType.text, store = true)
	 private String id;
	//分组ID
	private Long groupId ;
	//用户ID
	private Long customersId ;
	
	//来源系统ID
	private Long pwsysId ;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Long getCustomersId() {
		return customersId;
	}
	public void setCustomersId(Long customersId) {
		this.customersId = customersId;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}


	public Long getPwsysId() {
		return pwsysId;
	}


	public void setPwsysId(Long pwsysId) {
		this.pwsysId = pwsysId;
	}
	
}
