package cn.com.ylpw.web.crm.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.com.ylpw.web.crm.entity.BaseEntity;

public class TShortageRecord extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long customersid;

    private String productName;

    private BigDecimal productPirce;

    private Integer productCount;

    private String productTypea;

    private String productTypeb;

    private String performer;

    private String cityName;


    public Long getCustomersid() {
        return customersid;
    }

    public void setCustomersid(Long customersid) {
        this.customersid = customersid;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public BigDecimal getProductPirce() {
        return productPirce;
    }

    public void setProductPirce(BigDecimal productPirce) {
        this.productPirce = productPirce;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getProductTypea() {
        return productTypea;
    }

    public void setProductTypea(String productTypea) {
        this.productTypea = productTypea == null ? null : productTypea.trim();
    }

    public String getProductTypeb() {
        return productTypeb;
    }

    public void setProductTypeb(String productTypeb) {
        this.productTypeb = productTypeb == null ? null : productTypeb.trim();
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer == null ? null : performer.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }
}