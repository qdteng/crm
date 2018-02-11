package cn.com.ylpw.web.crm.entity.test;

import java.math.BigDecimal;
import java.util.Date;

import cn.com.ylpw.web.crm.entity.BaseEntity;
/**   
 * @Title: Entity
 * @Description: 访客管理
 * @author L.T.auto
 * @date 2018-01-23 10:46:59
 * @version V1.0   
 */
@SuppressWarnings("serial")
public class GuestEntity extends BaseEntity implements java.io.Serializable {
		/**姓名*/
		private java.lang.String name;
		/**性别*/
		private java.lang.Integer sex;
		/**账户金额*/
		private BigDecimal mon;
	
	public java.lang.String getName(){
		return this.name;
	}

	public void setName(java.lang.String name){
		this.name = name;
	}
	public java.lang.Integer getSex(){
		return this.sex;
	}

	public void setSex(java.lang.Integer sex){
		this.sex = sex;
	}
	public BigDecimal getMon(){
		return this.mon;
	}

	public void setMon(BigDecimal mon){
		this.mon = mon;
	}
}
