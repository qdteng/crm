package cn.com.ylpw.web.crm.service.sys;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationInfo;

import cn.com.ylpw.web.crm.entity.sys.SysUser;
import cn.com.ylpw.web.crm.model.sys.SysUserGrid;
import cn.com.ylpw.web.crm.util.Page;

 /**
  * @ClassName: SysUserService
  * @Description: 用户管理-业务层
  * @author zhaohb
  * @date 2017-3-14 下午3:38:59
  */
public interface SysUserService {
	
	void save(SysUser sysUser);
    
    void update(SysUser sysUser);
	
	void delete(SysUser sysUser);
	
	SysUser findById(Long id);
    
	Page<SysUserGrid> findAll(SysUser sysUser, Page<SysUserGrid> page);
	
	SysUser findByAccCode(String accCode);

    /**
      * @Title: shiroLogin
      * @Description: 账号登陆验证
      * @param accCode  账号
      * @param decPwd   密码（密文）
      * @param ip       IP地址
      * @return
      * @throws AuthenticationException
      * 
      * @author zhaohb
      * @date 2017-3-14 下午3:39:41
      */
    SysUser shiroLogin(String accCode, String decPwd, String ip) throws AuthenticationException;
    
    /**
      * @Title: shiroAuthorizationInfo
      * @Description: 加载用户权限资源
      * @param sysUser  用户实体
      * @return
      * 
      * @author zhaohb
      * @date 2017-3-14 下午3:40:26
      */
    AuthorizationInfo shiroAuthorizationInfo(SysUser sysUser);
    
    /**
      * @Title: countByRoleId
      * @Description: 查询角色下拥有用户数（角色删除条件：角色下无用户）
      * @param sysRoleId
      * @return
      * 
      * @author zhaohb
      * @date 2017-3-30 上午9:33:46
      */
    Integer countByRoleId(Long sysRoleId);
	
}
