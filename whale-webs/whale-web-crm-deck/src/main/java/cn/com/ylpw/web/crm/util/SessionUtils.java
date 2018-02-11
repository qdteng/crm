package cn.com.ylpw.web.crm.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.com.ylpw.web.crm.base.constants.RolePermEnum;
import cn.com.ylpw.web.crm.entity.sys.SysRole;
import cn.com.ylpw.web.crm.entity.sys.SysUser;
import cn.com.ylpw.web.crm.model.SysRolePermForm;
import cn.com.ylpw.web.crm.service.sys.SysRoleService;

 /**
  * @ClassName: SessionUtils
  * @Description: 用户会话工具类，提供session级别数据信息存储，获取，及当前用户信息获取。
  * @author zhaohb
  * @date 2017-3-16 下午4:07:45
  */
public class SessionUtils {
	
    private static final Logger logger = LoggerFactory.getLogger(SessionUtils.class);
    
	public final static String AES_KEY = "BI_AES_KEY";
	public final static Long TIME_OUT = 30*60*1000l;
	public final static String SESSION_USER = "SESSION_USER";
	public final static String SESSION_MENUS = "SESSION_MENUS";
	public final static String PERM_MENUS = "menu:url:%s";
	
	public static Subject subject() {
      return SecurityUtils.getSubject();
    }
	
	/**
	  * @Title: currentUser
	  * @Description: 获取当前用户信息
	  * @return
	  * 
	  * @author zhaohb
	  * @date 2017-3-16 下午4:09:57
	  */
	public static SysUser currentUser() {
	  Object obj = getSessionValue(SessionUtils.SESSION_USER);
      if (null != obj) {
          return (SysUser) obj;
      }
      return null;
    }
	

    /**
      * @Title: currentRolePerms
      * @Description: 获取当前用户角色权限
      * @return     权限实体
      * 
      * @author zhaohb
      * @date 2017-3-17 上午10:13:23
      */
    public static SysRolePermForm currentRolePerms() {
      SysRoleService sysRoleService = (SysRoleService) SpringUtils.getBean("sysRoleService");
      SysRole sysRole = new SysRole();
      sysRole.setId(currentUser().getSysRoleId());
      SysRolePermForm sysRolePermForm = sysRoleService.findBasePerm(sysRole);//1.基础权限（销售渠道、推广方式、商品类别）
      sysRolePermForm.setMenuIds(com.google.common.base.Joiner.on(",").join(sysRoleService.findPerm(RolePermEnum.SYS_ROLE_MENU, sysRole.getId())));//2.菜单权限
      return sysRolePermForm;
    }
	
	/**
	  * @Title: exit
	  * @Description: 用户退出系统，注销信息
	  * 
	  * @author zhaohb
	  * @date 2017-3-16 下午4:10:24
	  */
	public static void exit() {
      Subject subject = SessionUtils.subject();
      if(null != subject){
        if(subject.isAuthenticated()){
          logger.info(String.format("账号退出:%s", SessionUtils.currentUser().getAccCode()));
          subject.logout(); //注销当前系统的对象
        }
      }
    }
	
	/**
	  * @Title: setSessionValue
	  * @Description: 会话存储，实体信息
	  * @param key     键
	  * @param value   值
	  * 
	  * @author zhaohb
	  * @date 2017-3-16 下午4:11:06
	  */
	public static void setSessionValue(Object key, Object value) {
        Subject subject = SessionUtils.subject();
        if(null != subject){
            Session session = subject.getSession();
            if(null != session){
              session.setAttribute(key, value);
              if (session.getTimeout() != TIME_OUT.longValue()) {
                session.setTimeout(TIME_OUT);
              }
            }
        } else {
          logger.info("当前用户已经失效，放不了session值！");
        }
    }
    
	/**
	  * @Title: getSessionValue
	  * @Description: 会话获取，实体信息
	  * @param key     键
	  * @return
	  * 
	  * @author zhaohb
	  * @date 2017-3-16 下午4:11:55
	  */
//	public static Object getSessionValue(Object key) {
//        Subject subject = SessionUtils.subject();
//        if(null != subject){
//            Session session = subject.getSession();
//            if(null != session){
//                return session.getAttribute(key);
//            }
//        }
//        logger.info("当前用户已经失效，取不了session值！");
//        return null; 
//   }
	
	/***
	 * <p>可用于测试的</p>
	 * @author LT
	 * @date 2017年11月27日 下午3:11:08
	 * @return Object
	 * @param key
	 * @return
	 */
	public static Object getSessionValue(Object key) {
		
		return getSession().getAttribute( key.toString());
	}

	
	public static HttpServletRequest getRequest(){
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		return request ; 
	}
	
	public static HttpSession getSession(){
		if (null!=getRequest().getSession()&&null!=getRequest().getSession()){
			return getRequest().getSession() ; 
		}
		return null ; 
	}
	
	
}
