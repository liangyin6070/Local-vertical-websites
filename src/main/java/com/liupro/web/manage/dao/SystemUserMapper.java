package com.liupro.web.manage.dao;

import java.util.List;
import java.util.Map;

import com.liupro.web.manage.model.SystemUser;
/**
 * 
 * @description 用户表DAO，不需要实现
 * @author ldw
 * @datetime 2016年12月23日 下午2:20:24
 */
public interface SystemUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemUser record);

    int insertSelective(SystemUser record);

    SystemUser selectByPrimaryKey(Integer id);

    SystemUser selectByUserName(String userName);
    
    int updateByPrimaryKeySelective(SystemUser record);

    int updateByPrimaryKey(SystemUser record);
    
	List<SystemUser> findByPage(Map<String, Object> params);
	
	long count(Map<String, Object> params);

	List<SystemUser> selectPage(SystemUser user);
}