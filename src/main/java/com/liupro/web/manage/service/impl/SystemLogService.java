package com.liupro.web.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liupro.web.manage.dao.SystemLogMapper;
import com.liupro.web.manage.model.SystemLog;
import com.liupro.web.manage.service.SystemLogServiceI;
/**
 * 
 * @description 
 * @author ldw
 * @datetime 2016年12月23日 下午4:08:13
 */
@Service("logService")
public class SystemLogService implements SystemLogServiceI{

	@Autowired
	private SystemLogMapper logMapper;
	
	@Transactional(rollbackFor=Exception.class)
	public int insertLog(SystemLog log) {
		return logMapper.insertSelective(log);
	}
}
