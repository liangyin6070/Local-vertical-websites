package com.liupro.web.manage.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liupro.web.manage.dao.SystemRoleMapper;
import com.liupro.web.manage.model.SystemRole;
import com.liupro.web.manage.service.SystemRoleServiceI;
/**
 * 
 * @description 角色表业务层
 * @author ldw
 * @datetime 2016年12月23日 下午3:18:31
 */
@Service("roleService")
public class SystemRoleService implements SystemRoleServiceI{

	@Autowired
	private SystemRoleMapper roleMapper;
	/**
	 * 根据用户账号获取角色值
	 * @param userName
	 * @return
	 */
	@Override
	public Set<String> findRolesByUserName(String userName) {
		List<String> roles = roleMapper.selectByUserName(userName);
		Set<String> result = new HashSet<String>();
		for (String role : roles) {
			if(null!= role && !result.contains(role)) {
				result.add(role);
			}
		}
		return result;
	}
	/**
	 * 分页获取角色列表
	 */
	@Override
	public List<SystemRole> findByPage(Map<String, Object> params) {
		return roleMapper.findByPage(params);
	}
	
}
