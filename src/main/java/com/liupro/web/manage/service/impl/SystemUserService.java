package com.liupro.web.manage.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.framwork.utils.MD5Utils;
import com.framwork.utils.WebParamUtils;
import com.liupro.web.manage.dao.SystemResourceMapper;
import com.liupro.web.manage.dao.SystemRoleMapper;
import com.liupro.web.manage.dao.SystemUserMapper;
import com.liupro.web.manage.model.SystemUser;
import com.liupro.web.manage.service.SystemUserServiceI;
/**
 * 
 * @description 用户表业务层
 * @author ldw
 * @datetime 2016年12月23日 下午2:21:42
 */
@Service("userService")
public class SystemUserService implements SystemUserServiceI{

	@Autowired
	private SystemUserMapper userMapper;
	@Autowired
	private SystemRoleMapper roleMapper;
	@Autowired
	private SystemResourceMapper resourceMapper;
	/**
	 * 根据账号查询
	 * @param userName
	 * @return
	 */
	@Override
	public SystemUser selectByUserName(String userName) {
		return userMapper.selectByUserName(userName);
	}
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public int insertUser(SystemUser user) {
		user.setToken(WebParamUtils.generateVerifyCode(6));
		user.setUserPwd(MD5Utils.GetMD5Code(user.getUserPwd()+user.getToken()));
		return userMapper.insertSelective(user);
	}
	/**
	 * 编辑用户
	 * @param user
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void editUser(SystemUser user) {
		userMapper.updateByPrimaryKeySelective(user);
	}
	/**
	 * 根据主键获取用户
	 * @param id
	 * @return
	 */
	@Override
	public SystemUser getById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
	/**
	 * 根据主键删除用户
	 * @param id
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteById(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 分页获取用户列表
	 */
	@Override
	public List<SystemUser> findByPage(Map<String, Object> params) {
		return userMapper.findByPage(params);
	}
	/**
	 * 获取用户数量
	 */
	@Override
	public long count(Map<String, Object> params) {
		return userMapper.count(params);
	}
}
