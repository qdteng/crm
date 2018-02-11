package cn.com.ylpw.web.crm.entity.usable;

import java.io.Serializable;

import cn.com.ylpw.web.crm.entity.BaseEntity;

public class TFiles extends BaseEntity implements Serializable  {

    private String type;

    private String path;

    private String name;

    private String refName;

    private Long size;

    private String suffix;

    private String no;

    private Boolean isweblod;

    private String relativePath;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName == null ? null : refName.trim();
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? null : suffix.trim();
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public Boolean getIsweblod() {
        return isweblod;
    }

    public void setIsweblod(Boolean isweblod) {
        this.isweblod = isweblod;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath == null ? null : relativePath.trim();
    }

}