package cn.com.ylpw.web.crm.entity.customer;

import java.io.Serializable;

import cn.com.ylpw.web.crm.entity.BaseEntity;

public class TCustomerGroup extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**分组名称*/
	private java.lang.String name;
	/**分组说明*/
	private java.lang.String remark;
	/**分组类别_1一般分组2标签分组*/
	private java.lang.String gclass;
	/**分组类型_1动态分组2静态分组*/
	private java.lang.String type;
	/**分组-最近交易*/
	private java.lang.String grPayDay;
	/**分组-最近交易-自定义*/
	private java.lang.String grPayDayCustom;
	/**分组-交易次数*/
	private java.lang.String grPaymentNum;
	/**分组-交易次数-自定义*/
	private java.lang.String grPaymentNumCustom;
	/**分组-累计金额*/
	private java.lang.String grSumprice;
	/**分组-累计金额-自定义*/
	private java.lang.String grSumpriceCustom;
	/**分组-平均客单价*/
	private java.lang.String grUnitPrice;
	/**分组-平均客单价-自定义*/
	private java.lang.String grUnitPriceCustom;
	/**分组-会员等级*/
	private java.lang.String grCustomerLavel;
	/**分组-地区筛选-省*/
	private java.lang.String grAddrProv;
	/**分组-地区筛选-市*/
	private java.lang.String grAddrCity;
	/**分组-下单终端*/
	private java.lang.String grClient;
	/**分组-票品*/
	private java.lang.String grProname;
	/**分组-类目A*/
	private java.lang.String grClassa;
	/**分组-类目B*/
	private java.lang.String grClassb;
	/**分组-商品件数*/
	private java.lang.String grPronum;
	/**分组-执行状态*/
	private java.lang.Integer executeStatus;
	/**分组-导出分组zip包路径*/
	private java.lang.Long exportFile;
	/**分组-执行状态*/
	private java.lang.Integer exportStatus;

	//用户数量
	private Integer cusNum;
	
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getGclass() {
        return gclass;
    }

    public void setGclass(String gclass) {
        this.gclass = gclass == null ? null : gclass.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getGrPayDay() {
        return grPayDay;
    }

    public void setGrPayDay(String grPayDay) {
        this.grPayDay = grPayDay == null ? null : grPayDay.trim();
    }

    public String getGrPayDayCustom() {
        return grPayDayCustom;
    }

    public void setGrPayDayCustom(String grPayDayCustom) {
        this.grPayDayCustom = grPayDayCustom == null ? null : grPayDayCustom.trim();
    }

    public String getGrPaymentNum() {
        return grPaymentNum;
    }

    public void setGrPaymentNum(String grPaymentNum) {
        this.grPaymentNum = grPaymentNum == null ? null : grPaymentNum.trim();
    }

    public String getGrPaymentNumCustom() {
        return grPaymentNumCustom;
    }

    public void setGrPaymentNumCustom(String grPaymentNumCustom) {
        this.grPaymentNumCustom = grPaymentNumCustom == null ? null : grPaymentNumCustom.trim();
    }

    public String getGrSumprice() {
        return grSumprice;
    }

    public void setGrSumprice(String grSumprice) {
        this.grSumprice = grSumprice == null ? null : grSumprice.trim();
    }

    public String getGrSumpriceCustom() {
        return grSumpriceCustom;
    }

    public void setGrSumpriceCustom(String grSumpriceCustom) {
        this.grSumpriceCustom = grSumpriceCustom == null ? null : grSumpriceCustom.trim();
    }

    public String getGrUnitPrice() {
        return grUnitPrice;
    }

    public void setGrUnitPrice(String grUnitPrice) {
        this.grUnitPrice = grUnitPrice == null ? null : grUnitPrice.trim();
    }

    public String getGrUnitPriceCustom() {
        return grUnitPriceCustom;
    }

    public void setGrUnitPriceCustom(String grUnitPriceCustom) {
        this.grUnitPriceCustom = grUnitPriceCustom == null ? null : grUnitPriceCustom.trim();
    }

    public String getGrCustomerLavel() {
        return grCustomerLavel;
    }

    public void setGrCustomerLavel(String grCustomerLavel) {
        this.grCustomerLavel = grCustomerLavel == null ? null : grCustomerLavel.trim();
    }

    public String getGrAddrProv() {
        return grAddrProv;
    }

    public void setGrAddrProv(String grAddrProv) {
        this.grAddrProv = grAddrProv == null ? null : grAddrProv.trim();
    }

    public String getGrAddrCity() {
        return grAddrCity;
    }

    public void setGrAddrCity(String grAddrCity) {
        this.grAddrCity = grAddrCity == null ? null : grAddrCity.trim();
    }

    public String getGrClient() {
        return grClient;
    }

    public void setGrClient(String grClient) {
        this.grClient = grClient == null ? null : grClient.trim();
    }

    public String getGrProname() {
        return grProname;
    }

    public void setGrProname(String grProname) {
        this.grProname = grProname == null ? null : grProname.trim();
    }

    public String getGrClassa() {
        return grClassa;
    }

    public void setGrClassa(String grClassa) {
        this.grClassa = grClassa == null ? null : grClassa.trim();
    }

    public String getGrClassb() {
        return grClassb;
    }

    public void setGrClassb(String grClassb) {
        this.grClassb = grClassb == null ? null : grClassb.trim();
    }

    public String getGrPronum() {
        return grPronum;
    }

    public void setGrPronum(String grPronum) {
        this.grPronum = grPronum == null ? null : grPronum.trim();
    }

	public Integer getCusNum() {
		return cusNum;
	}

	public void setCusNum(Integer cusNum) {
		this.cusNum = cusNum;
	}

	public java.lang.Integer getExecuteStatus() {
		return executeStatus;
	}

	public void setExecuteStatus(java.lang.Integer executeStatus) {
		this.executeStatus = executeStatus;
	}

	public java.lang.Long getExportFile() {
		return exportFile;
	}

	public void setExportFile(java.lang.Long exportFile) {
		this.exportFile = exportFile;
	}

	public java.lang.Integer getExportStatus() {
		return exportStatus;
	}

	public void setExportStatus(java.lang.Integer exportStatus) {
		this.exportStatus = exportStatus;
	}
    
}