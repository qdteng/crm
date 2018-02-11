package cn.com.ylpw.web.crm.base.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;

@Controller
public class UeditorController {
	private static final Logger logger = LoggerFactory.getLogger(UeditorController.class);
	@RequestMapping("/ueditorController")
	public void  ueditorController(HttpServletRequest request,  HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding( "utf-8" );
			response.setHeader("Content-Type" , "text/html");
			String rootPath =request.getServletContext().getRealPath( "/" );
			response.getWriter().write( new ActionEnter( request, rootPath ).exec() );
		} catch (Exception e) {
			logger.error("ueditorController 插件错误",e);
			e.printStackTrace();
		}
	}

}
