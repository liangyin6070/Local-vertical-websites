package com.liupro.web.manage.service;

import java.util.List;
import java.util.Map;

import com.liupro.web.manage.model.SystemUser;
/**
 * 
 * @description 用户管理业务接口
 * @author ldw
 * @datetime 2016年12月26日 上午9:33:54
 */
public interface SystemUserServiceI {
	public SystemUser selectByUserName(String userName);

	SystemUser getById(Integer id);

	void deleteById(Integer id);

	void editUser(SystemUser user);

	int insertUser(SystemUser user);
	
	List<SystemUser> findByPage(Map<String, Object> params);
	
	long count(Map<String, Object> params);
}
