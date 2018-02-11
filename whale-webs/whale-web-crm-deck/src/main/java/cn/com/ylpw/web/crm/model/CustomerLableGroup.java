package cn.com.ylpw.web.crm.model;
/***
 * @ClassName: CustomerLableGroup
 * @Description:标签分组
 * @author LT
 * @date 2017年6月5日 上午11:13:45
 */
public class CustomerLableGroup {
	
	private  Long groupId ;
	//标签ID
	private Long []  lableIds ; 
	//分组姓名
	private String name;  
	//分组说明
	private String  remark;
	//分组类型
	private String  type ;
	
	
	public Long[] getLableIds() {
		return lableIds;
	}
	public void setLableIds(Long[] lableIds) {
		this.lableIds = lableIds;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
	
}
