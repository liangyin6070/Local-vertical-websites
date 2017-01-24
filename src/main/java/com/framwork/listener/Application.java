package com.framwork.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.framwork.utils.SpringBeanUtils;
/**
 * 
 * @description 应用启动上下文监听器,初始化springbean
 * @author ldw
 * @datetime 2017年1月24日 上午10:41:28
 */
public class Application implements ServletContextListener{

	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		logger.info("上下文销毁:"+event.getServletContext().getServerInfo());
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		if(SpringBeanUtils.ctx == null) {
			SpringBeanUtils.ctx = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		}
	}

}
