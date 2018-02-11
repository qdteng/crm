package cn.com.ylpw.web.crm.entity.sys;

import java.io.Serializable;

import cn.com.ylpw.web.crm.entity.BaseEntity;
/**
 * @ClassName: SysDictionarie
 * @Description:数据字典
 * @author LT
 * @date 2017年6月14日 上午11:40:29
 
 */
public class SysDictionarie extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	private String code;

    private String name;

    private String remark;
    
    private Long pid;
    
    private Integer orderNum;
    

    public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

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
		this.remark = remark;
	}


}