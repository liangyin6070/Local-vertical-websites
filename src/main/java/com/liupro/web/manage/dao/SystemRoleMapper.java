package com.liupro.web.manage.dao;

import java.util.List;

import com.liupro.web.manage.model.SystemRole;
/**
 * 
 * @description 
 * @author ldw
 * @datetime 2016年12月23日 下午3:01:23
 */
public interface SystemRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemRole record);

    int insertSelective(SystemRole record);

    SystemRole selectByPrimaryKey(Integer id);

    List<String> selectByUserName(String userName);
    
    int updateByPrimaryKeySelective(SystemRole record);

    int updateByPrimaryKey(SystemRole record);
}