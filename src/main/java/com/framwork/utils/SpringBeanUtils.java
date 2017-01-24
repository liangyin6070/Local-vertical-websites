package com.framwork.utils;

import org.springframework.web.context.WebApplicationContext;
/**
 * 
 * @description spring工具类
 * @author ldw
 * @datetime 2017年1月24日 上午10:44:00
 */
public class SpringBeanUtils {

	public static WebApplicationContext ctx = null;
	
	public static <T> T getBean(Class<T> requiredType) {
		return ctx.getBean(requiredType);
	}
}
