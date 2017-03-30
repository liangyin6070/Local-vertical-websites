package com.framwork.security;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.framwork.enums.SessionKeyEnum;
import com.framwork.utils.MD5Utils;
import com.liupro.web.manage.model.SystemUser;
import com.liupro.web.manage.service.SystemResourceServiceI;
import com.liupro.web.manage.service.SystemRoleServiceI;
import com.liupro.web.manage.service.SystemUserServiceI;
/**
 * 
 * @description 自定义的指定Shiro验证用户登录的类 
 * @author ldw
 * @datetime 2016年12月23日 上午9:51:02
 */
public class LoginRealm extends AuthorizingRealm {
	
	private static Logger log = LoggerFactory.getLogger(LoginRealm.class);
	
	@Autowired
	@Qualifier("userService")
	private SystemUserServiceI userService;
	@Autowired
	@Qualifier("roleService")
	private SystemRoleServiceI roleService;
	@Autowired
	@Qualifier("resourceService")
	private SystemResourceServiceI resourceService;
	/**
	 * 为当前登录的Subject授予角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		if(StringUtils.isBlank(username)) {
			throw new AuthorizationException("未登录");
		}
		SystemUser user = userService.selectByUserName(username);
		if(user == null || user.getIsLocked()) {
			throw new AuthorizationException("用户不存在或者用户被锁定");
		}
		SimpleAuthorizationInfo authc = new SimpleAuthorizationInfo(); 
		authc.setRoles(roleService.findRolesByUserName(username));//设置分配给用户的角色值
		authc.setStringPermissions(resourceService.findPermissionsByUserName(username));//设置分配给用户的权限
		return authc;
	}
	/**
	 * 登陆验证Subject
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();//登陆账号
		String pwd = new String(((UsernamePasswordToken)token).getPassword());//密码
		SystemUser user = userService.selectByUserName(username);
		if(user == null) {
			//账号不存在
			throw new UnknownAccountException("账号不存在");
		}
		if(user.getIsLocked()) {
			//账号锁定
			throw new LockedAccountException("账号被锁定");
		}
		//密码加盐再MD5进行判定
		String newPwd = MD5Utils.GetMD5Code(pwd + user.getToken());
		if(!newPwd.equals(user.getUserPwd())) {
			//密码不匹配
			throw new IncorrectCredentialsException("密码不匹配");
		}
		setSession(SessionKeyEnum.key_admin.getKey(), user);//设置到session中
		SimpleAuthenticationInfo auth = new SimpleAuthenticationInfo(user.getUserName(), pwd, getName());
		return auth;
	}

    /** 
     * 将一些数据放到ShiroSession中,以便于其它地方使用 
     * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到 
     */  
    public void setSession(Object key, Object value){  
        Subject currentUser = SecurityUtils.getSubject();  
        if(null != currentUser){  
            Session session = currentUser.getSession(); 
            log.info("Session默认超时时间为[" + session.getTimeout() + "]毫秒");  
            if(null != session){  
                session.setAttribute(key, value);  
            }  
        }  
    }
    
	public SystemUserServiceI getUserService() {
		return userService;
	}
	public void setUserService(SystemUserServiceI userService) {
		this.userService = userService;
	}
	public SystemRoleServiceI getRoleService() {
		return roleService;
	}
	public void setRoleService(SystemRoleServiceI roleService) {
		this.roleService = roleService;
	}
	public SystemResourceServiceI getResourceService() {
		return resourceService;
	}
	public void setResourceService(SystemResourceServiceI resourceService) {
		this.resourceService = resourceService;
	} 
    
    
}
