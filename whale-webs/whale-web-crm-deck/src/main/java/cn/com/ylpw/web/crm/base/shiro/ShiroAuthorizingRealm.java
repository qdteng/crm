package cn.com.ylpw.web.crm.base.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

import cn.com.ylpw.web.crm.entity.sys.SysMenu;
import cn.com.ylpw.web.crm.entity.sys.SysUser;
import cn.com.ylpw.web.crm.model.sys.SysMenuNode;
import cn.com.ylpw.web.crm.service.sys.SysMenuService;
import cn.com.ylpw.web.crm.service.sys.SysUserService;
import cn.com.ylpw.web.crm.util.EncryptUtils;
import cn.com.ylpw.web.crm.util.SessionUtils;

 /**
  * @ClassName: BiAuthorizingRealm
  * @Description: 安全框架，权限控制类
  * @author zhaohb
  * @date 2017-3-3 下午1:50:40
  */
public class ShiroAuthorizingRealm extends AuthorizingRealm {
  
    private static final Logger logger = LoggerFactory.getLogger(ShiroAuthorizingRealm.class);
	
    @Autowired
	private SysUserService sysUserService;
    
    @Autowired
    private SysMenuService sysMenuService;
	
	/** 
     * 权限认证；判断某用户是否有该权限  
     */  
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	    logger.info(String.format("装载账号权限点：%s", SessionUtils.currentUser().getAccCode()));
		// 获取当前登录的账号,等价于(String)principals.fromRealm(this.getName()).iterator().next()
        //String acc = (String) super.getAvailablePrincipal(principals);
	    Long id = (Long) super.getAvailablePrincipal(principals); 
        SysUser sysUser = sysUserService.findById(id);
		if(sysUser == null) throw new AuthorizationException();
        return sysUserService.shiroAuthorizationInfo(sysUser);
	}
	
	/** 
     * 登录认证判断; 
     */  
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
		//获取基于用户名和密码的令牌  
        //实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的  
        //两个token的引用都是一样的,本例中是org.apache.shiro.authc.UsernamePasswordToken@33799a1e  
        UsernamePasswordToken authcToken = (UsernamePasswordToken)token;  
//        logger.info("验证当前Subject时获取到token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        
        String accCode = authcToken.getUsername();
        String pwd = String.valueOf(authcToken.getPassword());
		return doAuthenticationLoginCheck(accCode , pwd, authcToken.getHost());//登录校验
	}

	/**
	 * 进行登录校验，并做登录日志操作
	 * @param accCode
	 * @param pwd
	 * @return
	 * @throws Exception 
	 */
	private AuthenticationInfo doAuthenticationLoginCheck(String accCode, String pwd, String ip) {
        logger.info(String.format("账号登陆shiro认证：%s【%s】", accCode , pwd));
		String decPwd = null;
		try {
			decPwd = EncryptUtils.aesDecrypt(pwd.substring(0, pwd.length()-16), pwd.substring(pwd.length()-16));
		} catch(Exception e) {
			logger.error("账号密码解密错误:" , e);
			throw new AuthenticationException();
		}
		SysUser sysUser = sysUserService.shiroLogin(accCode, EncryptUtils.md5Encrypt(decPwd), ip);
		if (null != sysUser) {
			AuthenticationInfo authInfo = new SimpleAuthenticationInfo(sysUser.getId(), pwd, sysUser.getAccCode());
			SessionUtils.setSessionValue(SessionUtils.SESSION_USER, sysUser); //放进入用户信息
			List<SysMenu> menus = sysMenuService.findByRoleId(SessionUtils.currentUser().getSysRoleId());
		    List<SysMenuNode> menuNodes = Lists.newArrayList();
		    SysMenuNode node = null;
		    for (SysMenu menu : menus) {
		      if (menu.getPid().equals(0l)) {//一级节点
		        node = new SysMenuNode(menu);
		        for (SysMenu m : menus) {
		          if (m.getPid().equals(menu.getId())) {//二级节点
		            node.getChildrens().add(new SysMenuNode(m));
		          }
		        }
		        menuNodes.add(node);
		      }
		    }
		    SessionUtils.setSessionValue(SessionUtils.SESSION_MENUS, menuNodes);
		    logger.info(String.format("账号登陆shiro认证成功：%s", accCode));
			return authInfo;
		}
		throw new AuthenticationException();
	}

	public SysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

}
