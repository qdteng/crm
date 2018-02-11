<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
    <%@ page import="com.baidu.ueditor.upload.Uploader"%>
    <%@page import="com.ylpw.utils.DateUtils"%>
	<%@page import="java.util.Date"%>

    <%
    request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
    Uploader up = new Uploader(request);

    //设置存储路径
    String savePath = "upload/Image/"+DateUtils.formatDate(new Date(),"yyyyMM");
    up.setSavePath(savePath);
    
    String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
    up.setAllowFiles(fileType);
    up.setMaxSize(10000); //单位KB
    up.upload();
    response.getWriter().print("{'original':'"+up.getOriginalName()+"','url':'"+up.getUrl()+"','state':'"+up.getState()+"'}");
    //response.getWriter().print("{'original':'"+up.getOriginalName()+"','url':'"+up.getUrl()+"','title':'"+up.getTitle()+"','state':'"+up.getState()+"'}");
    %>
