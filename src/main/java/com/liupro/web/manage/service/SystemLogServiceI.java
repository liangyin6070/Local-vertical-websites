package com.liupro.web.manage.service;

import com.liupro.web.manage.model.SystemLog;
/**
 * 
 * @description 日志管理业务层接口
 * @author ldw
 * @datetime 2017年1月23日 下午2:00:26
 */
public interface SystemLogServiceI {
	/**
	 * 新增日志
	 * @param log
	 * @return
	 */
	public int insertLog(SystemLog log);
}
