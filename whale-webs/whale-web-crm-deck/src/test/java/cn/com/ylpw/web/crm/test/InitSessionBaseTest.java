package cn.com.ylpw.web.crm.test;



import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.request.RequestContextListener;

import cn.com.ylpw.web.crm.entity.sys.SysUser;
import cn.com.ylpw.web.crm.service.sys.SysUserService;
import cn.com.ylpw.web.crm.util.SessionUtils;
@SpringBootTest
@Configuration
public class InitSessionBaseTest {
	
	private static final Logger log = LoggerFactory.getLogger(InitSessionBaseTest.class);
	
	@Autowired
	SysUserService adminService ; 
	
	protected MockHttpServletRequest request =null ;
	protected  HttpSession session = null ;
	@Before 
	public void before(){ 
		log.info("初始化session");
		
		RequestContextListener listener = new RequestContextListener(); 
		ServletContext context = new MockServletContext() ;
		request = new MockHttpServletRequest(); 
		listener.requestInitialized(new ServletRequestEvent(context, request));
		
		SysUser  sysUser = adminService.findById(1l) ;
		
		session = new MockHttpSession(); 
		 //放进入用户信息
		session.setAttribute(SessionUtils.SESSION_USER, sysUser); 
		request.setSession(session); 
		
	}
}
