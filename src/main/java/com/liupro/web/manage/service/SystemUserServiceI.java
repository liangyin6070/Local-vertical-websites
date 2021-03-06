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
	/**
	 * 
	 * @param userName
	 * @return
	 */
	public SystemUser selectByUserName(String userName);
	/**
	 * 
	 * @param id
	 * @return
	 */
	SystemUser getById(Integer id);
	/**
	 * 
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * 
	 * @param user
	 */
	void editUser(SystemUser user);
	/**
	 * 
	 * @param user
	 * @return
	 */
	int insertUser(SystemUser user);
	/**
	 * 
	 * @param params
	 * @return
	 */
	long count(Map<String, Object> params);
	/**
	 * 
	 * @param user
	 * @return
	 */
	public List<SystemUser> selectPage(SystemUser user);
}
