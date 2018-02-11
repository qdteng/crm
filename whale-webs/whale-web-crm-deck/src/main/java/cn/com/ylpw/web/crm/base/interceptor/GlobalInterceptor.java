package cn.com.ylpw.web.crm.base.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Joiner;

import cn.com.ylpw.core.tools.Globals;
import cn.com.ylpw.web.crm.service.sys.SysMenuService;
import cn.com.ylpw.web.crm.util.SessionUtils;

public class GlobalInterceptor implements HandlerInterceptor {
  
    private static final Logger logger = LoggerFactory.getLogger(GlobalInterceptor.class);
  
    private SysMenuService sysMenuService;
    
    public GlobalInterceptor(SysMenuService sysMenuService) {
      this.sysMenuService = sysMenuService;
    }
    
    public static final String WHITE_LIST = ".*/*((login)|(toLogin)|(register)).do";
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	    String path = request.getServletPath();
	    if (!path.matches(WHITE_LIST)&&!path.equals(Globals.HEALTH_PATH)) {//排除白名单外路径
	      if (200 == response.getStatus()) {
	    	  
	        //1.验证账号是否登录。
            if (null == SessionUtils.currentUser()) {
            	
                if(null!=request.getParameter("vs")){
                	response.setStatus(400);
                    response.getOutputStream().print("-1");
                }else {
                	response.sendRedirect(request.getContextPath()+"/login.do")	;
                }
                logger.info("用户会话，已失效！重定向登陆！ ip : {} " , request.getRemoteAddr());
                return false;
            }else if(path.contains("/validateSession")||path.contains("/executeStatus")){
            	return true ;
            }
            //2.访问菜单权限验证。
            String allMenusUrl = Joiner.on("|").skipNulls().join(sysMenuService.findAllMenusUrl());
            if (path.matches(allMenusUrl)) {
              if (!SecurityUtils.getSubject().isPermitted(String.format(SessionUtils.PERM_MENUS, path))) {
                logger.info(String.format("403 用户【%s】无权限访问菜单：%s！", SessionUtils.currentUser().getAccCode(), path));
                response.sendRedirect(request.getContextPath()+"/403.html");
                return false;
              }
            }
	      }
	    }
	    return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

}