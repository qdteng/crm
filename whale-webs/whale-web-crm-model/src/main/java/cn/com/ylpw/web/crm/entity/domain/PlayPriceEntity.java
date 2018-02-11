package cn.com.ylpw.web.crm.entity.domain;

import java.math.BigDecimal;
import java.util.Date;

import cn.com.ylpw.web.crm.entity.BaseEntity;
/**   
 * @Title: Entity
 * @Description: 剧目票价
 * @author L.T.auto
 * @date 2018-01-25 11:37:23
 * @version V1.0   
 */
@SuppressWarnings("serial")
public class PlayPriceEntity extends BaseEntity implements java.io.Serializable {
		/**剧目票价Id*/
		private java.lang.String priceId;
		/**原价*/
		private BigDecimal originalPrice;
		/**政府补贴金额*/
		private BigDecimal discountPrice;
		/**售价*/
		private BigDecimal salePrice;
		/**票价简述*/
		private java.lang.String saleDesc;
		/**可获得积分数*/
		private java.lang.Integer getScore;
		/**创建人*/
		private java.lang.Integer createUser;
		/**最后修改人*/
		private java.lang.Integer lastModifyUser;
		/**最后修改时间*/
		private java.util.Date lastModifyTime;
		/**绑定的228票价ID*/
		private java.lang.Integer bindYlid;
	
	public java.lang.String getPriceId(){
		return this.priceId;
	}

	public void setPriceId(java.lang.String priceId){
		this.priceId = priceId;
	}
	public BigDecimal getOriginalPrice(){
		return this.originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice){
		this.originalPrice = originalPrice;
	}
	public BigDecimal getDiscountPrice(){
		return this.discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice){
		this.discountPrice = discountPrice;
	}
	public BigDecimal getSalePrice(){
		return this.salePrice;
	}

	public void setSalePrice(BigDecimal salePrice){
		this.salePrice = salePrice;
	}
	public java.lang.String getSaleDesc(){
		return this.saleDesc;
	}

	public void setSaleDesc(java.lang.String saleDesc){
		this.saleDesc = saleDesc;
	}
	public java.lang.Integer getGetScore(){
		return this.getScore;
	}

	public void setGetScore(java.lang.Integer getScore){
		this.getScore = getScore;
	}
	public java.lang.Integer getCreateUser(){
		return this.createUser;
	}

	public void setCreateUser(java.lang.Integer createUser){
		this.createUser = createUser;
	}
	public java.lang.Integer getLastModifyUser(){
		return this.lastModifyUser;
	}

	public void setLastModifyUser(java.lang.Integer lastModifyUser){
		this.lastModifyUser = lastModifyUser;
	}
	public java.util.Date getLastModifyTime(){
		return this.lastModifyTime;
	}

	public void setLastModifyTime(java.util.Date lastModifyTime){
		this.lastModifyTime = lastModifyTime;
	}
	public java.lang.Integer getBindYlid(){
		return this.bindYlid;
	}

	public void setBindYlid(java.lang.Integer bindYlid){
		this.bindYlid = bindYlid;
	}
}
