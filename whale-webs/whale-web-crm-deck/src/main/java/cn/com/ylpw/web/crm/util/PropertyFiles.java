package cn.com.ylpw.web.crm.util;

import org.springframework.beans.factory.annotation.Value;

public class PropertyFiles {

	//活动程序的服务器地址 
	@Value("${www.server.path}")
	public  String   wwwServerPath ;
	 
	//活动程序的静态资源路径
	@Value("${www.server.static.path}")
	public  String   wwwServerStaticPath ;
	
	//CRM文件上传的根目录
	@Value("${file.filePathForDisk}")
	private  String  filePathForDisk ;
	

	public String getWwwServerPath() {
		return wwwServerPath;
	}

	public void setWwwServerPath(String wwwServerPath) {
		this.wwwServerPath = wwwServerPath;
	}

	public String getWwwServerStaticPath() {
		return wwwServerStaticPath;
	}

	public void setWwwServerStaticPath(String wwwServerStaticPath) {
		this.wwwServerStaticPath = wwwServerStaticPath;
	}

	public String getFilePathForDisk() {
		return filePathForDisk;
	}

	public void setFilePathForDisk(String filePathForDisk) {
		this.filePathForDisk = filePathForDisk;
	}
	
}
