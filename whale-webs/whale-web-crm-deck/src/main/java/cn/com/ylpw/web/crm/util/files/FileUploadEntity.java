package cn.com.ylpw.web.crm.util.files;

/**
 * @ClassName: UploadFile
 * @Description:文件上传返回VO
 * @author LT
 * @date 2016年9月15日 下午3:16:41
 */
public class FileUploadEntity {
	
	  /**
	   * @ClassName:  
	   * @Description: 文件类型 ： 
	   * @author LT
	   * @date 2016年9月13日 下午7:36:18
	   */
	  public enum FileType {  
		  /**
		   * 图片 
		   */
		 img("图片"),
		 /**
		   * flash
		   */
		 flash("flash"),
		 /**
		   * 媒体
		   */
		 media("媒体"),
		  /**
		   * 其他
		   */
		  other("其他");
		  private String  text;  
		  
		  FileType(String text){  
			  this.text = text;  
		  }
		  public String getText() {
			  return text;
		  }
		  
		  public void setText(String text) {
			  this.text = text;
		  }
	  }
	  
	  
	  
	//文件类型  文件类型 0图片 1 其他
    private int type;
    //文件路径
    private String path;
    //原文件名
    private String name;
    //引用文件名
    private String refName;
    //文件大小
    private Long size;
    //文件后缀
    private String suffix;
    //文件唯一编码
    private String no;
    //操作人
    private Long optUser;
    //是否web项目目录下（ webroot下）
    private Boolean isweblod;
    //文件相对路径
    private String relativePath;
    //上传错误信息
    private String errorMsg  ;
    
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type ;
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

    public Long getOptUser() {
        return optUser;
    }

    public void setOptUser(Long optUser) {
        this.optUser = optUser;
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

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}

