package cn.com.ylpw.web.crm.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.com.ylpw.web.crm.base.ExceptionMessage;
import cn.com.ylpw.web.crm.entity.sys.SysUser;
import cn.com.ylpw.web.crm.service.sys.SysUserService;
import cn.com.ylpw.web.crm.util.EncryptUtils;
import cn.com.ylpw.web.crm.util.IPUtils;
import cn.com.ylpw.web.crm.util.SessionUtils;

 /**
  * @ClassName: LogonController
  * @Description:账号 登陆、退出控制器
  * @author zhaohb
  * @date 2017-3-3 下午1:54:35
  */
@Controller("logonController")
public class LogonController {
  
  private static final Logger logger = LoggerFactory.getLogger(LogonController.class);
  
  @Autowired
  private SysUserService sysUserService;
	
  @RequestMapping("/")
  public String index() {
	  if(null!=SessionUtils.currentUser()){
		  return "redirect:/welcome.do";
	  }
    return "redirect:/login.do";
  }
  
  //登陆页
  @RequestMapping(value="/login.do",method=RequestMethod.GET)
  public String login(HttpServletResponse response) {
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    SessionUtils.setSessionValue(SessionUtils.AES_KEY, EncryptUtils.randomAES16Key());
    return "/logon";
  }
  
  //登陆成功-首页
  @RequestMapping("/welcome.do")
  public String welcome() {
    return "/index";
  }
  
  //账户登录
  @RequestMapping(value="/login.do", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
  public String logon(HttpServletRequest request, RedirectAttributes redirectAttributes, SysUser sysUser) {
      logger.info(String.format("账号登录:%s", sysUser.getAccCode()));
      Object validCode = SessionUtils.getSessionValue(SessionUtils.AES_KEY);
      ExceptionMessage message = null;
      if (null != validCode) {
          Subject subject = null;
          try{
              String pwd = sysUser.getPwd() + validCode;
              subject = SessionUtils.subject();
//              SecurityUtils.getSubject().getSession().setTimeout(SessionUtils.TIME_OUT);//Session 过期时间，建议：可以放在框架初始化完毕后处理。
              subject.login(new UsernamePasswordToken(sysUser.getAccCode(), pwd, IPUtils.fetchRealIPv4Addr(request)));
              logger.info(String.format("登录成功:%s", sysUser.getAccCode()));
              return "redirect:/welcome.do";
          } catch(UnknownAccountException | IncorrectCredentialsException uae) {
             message = ExceptionMessage.LOGIN_ACC_OR_PWD_ERROR;
          } catch(LockedAccountException le) {
             message = ExceptionMessage.LOGIN_ACC_DISABLED;
          } catch(AuthenticationException ae) {
             message = ExceptionMessage.LOGIN_FAILED;
          }
      } else {
         message = ExceptionMessage.LOGIN_FAILED;
      }
      logger.error(String.format("登录异常:%s（%s）", message.getMessage(), sysUser.getAccCode()));
      redirectAttributes.addFlashAttribute("accCode", sysUser.getAccCode());
      redirectAttributes.addFlashAttribute("errorMessage", message.getMessage());
      return "redirect:/login.do";
  }
  
  //账户退出
  @RequestMapping(value="/exit.do")
  public String exit() {
      SessionUtils.exit();
      return "redirect:/login.do";
  }
  
  //修改密码-页
  @RequestMapping(value="/toEditPwd.do")
  public String toEditPwd() {
     return "/sysuser/editPwd";
  }
  
  //保存密码修改
  @RequestMapping(value="/editPwd.do", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
  public String editPwd(RedirectAttributes redirectAttributes, SysUser sysUser, String oldPwd) {
    String message = null;  
    SysUser curSysUser = SessionUtils.currentUser();
    if (null == curSysUser) {
      message = "账号为空,请重新登录";
    }
    if (StringUtils.isEmpty(oldPwd)) {
      message = "请输入旧密码";
    }
    if(!curSysUser.getPwd().equals(EncryptUtils.md5Encrypt(oldPwd))) {
      message = "旧密码错误";
    }
    if (null == message) {
      sysUser.setId(curSysUser.getId());
      sysUser.setPwd(EncryptUtils.md5Encrypt(sysUser.getPwd()));
      sysUserService.update(sysUser);
      message = "SUCCESS";
    }
    redirectAttributes.addFlashAttribute("message", message);
    return "redirect:/toEditPwd.do";
  }
  
  @RequestMapping(value="/403.html")
  public String error403() {
    return "/errors/403";
  }
  
  @RequestMapping(value="/404.html")
  public String error404() {
    return "/errors/404";
  }
  
  @RequestMapping(value="/500.html")
  public String error500() {
    return "/errors/500";
  }
  
}
