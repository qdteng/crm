package cn.com.ylpw.web.crm.entity.order;

import java.io.Serializable;
import java.util.Date;

import cn.com.ylpw.web.crm.entity.BaseEntity;

public class TAddress extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long customersid;

    private String name;

    private String address;

    private String zip;

    private String tel;

    private String phone;

    private Integer psnum;

    private Date lastPstime;

    private Integer idDefault;
    
    private Long cityid ;
    private Long areaid ;
    private Long provinceid ;

    
    private String cityName ;
    private String provName ;
    private String areaName ;
    
    
    
    public Long getCustomersid() {
        return customersid;
    }

    public void setCustomersid(Long customersid) {
        this.customersid = customersid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getPsnum() {
        return psnum;
    }

    public void setPsnum(Integer psnum) {
        this.psnum = psnum;
    }

    public Date getLastPstime() {
        return lastPstime;
    }

    public void setLastPstime(Date lastPstime) {
        this.lastPstime = lastPstime;
    }

    public Integer getIdDefault() {
        return idDefault;
    }

    public void setIdDefault(Integer idDefault) {
        this.idDefault = idDefault;
    }

	public Long getCityid() {
		return cityid;
	}

	public void setCityid(Long cityid) {
		this.cityid = cityid;
	}

	public Long getAreaid() {
		return areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public Long getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(Long provinceid) {
		this.provinceid = provinceid;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvName() {
		return provName;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

}