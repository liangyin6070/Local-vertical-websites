package com.framwork.core.spring;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * 
 * @class com.framwork.core.spring.BaseRestController
 * @author ldw
 * @date 2017年1月8日 下午11:44:44
 * @description 基础controller抽象类
 */
public abstract class BaseRestController {
	
	public static final String MSG = "msg";
	
	public static final String SUCCESS = "success";
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateConvertEditor());
	}
	/*
	 * 获取提交的参数
	 */
	public Object getObject(HttpServletRequest req, String keyName) {
		if (req.getAttribute(keyName) != null) {
			return req.getAttribute(keyName);
		} else if (req.getParameter(keyName) != null) {
			return req.getParameter(keyName);
		} else if (getSession(req).getAttribute(keyName) != null) {
			return getSession(req).getAttribute(keyName);
		}
		return null;
	}

	/*
	 * 获取session
	 */
	public HttpSession getSession(HttpServletRequest req) {
		return req.getSession();
	}

	/**
	 * 获取访问者IP
	 * 
	 * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。
	 * 
	 * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)，
	 * 如果还不存在则调用Request .getRemoteAddr()。
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}
	/**
	 * 获取user-agent
	 * @param request
	 * @return
	 */
	public String getUserAgent(HttpServletRequest request) {
		String userAgent = "";
		userAgent = request.getHeader("user-agent");
		return userAgent.substring(userAgent.indexOf("(")+1, userAgent.indexOf(")"));
	}
	/**
	 * 获取访问url
	 * @param request
	 * @return
	 */
	public String getServerUrl(HttpServletRequest request) {
		return request.getRequestURI();
	}
}
