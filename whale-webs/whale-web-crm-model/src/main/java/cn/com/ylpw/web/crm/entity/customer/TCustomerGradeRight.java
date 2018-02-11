package cn.com.ylpw.web.crm.entity.customer;

import java.util.Date;

public class TCustomerGradeRight {
    private Long id;

    private Long customerGradeId;

    private Long dictionarieId;

    private Long createId;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerGradeId() {
        return customerGradeId;
    }

    public void setCustomerGradeId(Long customerGradeId) {
        this.customerGradeId = customerGradeId;
    }

    public Long getDictionarieId() {
        return dictionarieId;
    }

    public void setDictionarieId(Long dictionarieId) {
        this.dictionarieId = dictionarieId;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}