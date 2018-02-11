<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="javax.servlet.ServletContext"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<% 
    //仅做示例用，请自行修改
	//String path = "upload";
	String path = "upload/Image/";
	String imgStr ="";
	String realpath = getRealPath(request,path)+"/"+path;
	String dir = "";//T.L 上级目录
	List<File> files = getFiles(realpath,new ArrayList<File>());
	for(File file :files ){
		//imgStr+=file.getPath().replace(getRealPath(request,path),"")+"ue_separate_ue";
		//System.out.println(file.getName()+"-------"+file.getParent());
		//imgStr+=path.substring(path.lastIndexOf("/")+1,path.length())+"/"+file.getName()+"ue_separate_ue";
		
		dir = file.getParent().substring(file.getParent().lastIndexOf("\\")+1);//T.L 加入上级目录
//		dir = file.getParent().substring(file.getParent().lastIndexOf("/")+1);//T.L 公网上要用此路径(linux系统)
		if("Image".equals(dir)){
			dir="";
		}
		imgStr+=path+dir+"/"+file.getName()+"ue_separate_ue";
	}
	if(imgStr!=""){
        imgStr = imgStr.substring(0,imgStr.lastIndexOf("ue_separate_ue")).replace(File.separator, "/").trim();
    }
	//System.out.println(imgStr);
	out.print(imgStr);		
%>
<%!
public List getFiles(String realpath, List files) {
	
	File realFile = new File(realpath);
	if (realFile.isDirectory()) {
		File[] subfiles = realFile.listFiles();
		for(File file :subfiles ){
			if(file.isDirectory()){
				getFiles(file.getAbsolutePath(),files);
			}else{
				if(!getFileType(file.getName()).equals("")) {
					files.add(file);
				}
			}
		}
	}
	return files;
}

public String getRealPath(HttpServletRequest request,String path){
	//ServletContext application = request.getSession().getServletContext();
	//String str = application.getRealPath(request.getServletPath());
	//return new File(str).getParent();
	String realPath = request.getRealPath("/");
	return new File(realPath).toString();
}

public String getFileType(String fileName){
	String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
	Iterator<String> type = Arrays.asList(fileType).iterator();
	while(type.hasNext()){
		String t = type.next();
		if(fileName.endsWith(t)){
			return t;
		}
	}
	return "";
}
%>