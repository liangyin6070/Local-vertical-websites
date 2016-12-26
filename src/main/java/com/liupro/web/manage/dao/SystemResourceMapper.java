package com.liupro.web.manage.dao;

import java.util.List;

import com.liupro.web.manage.model.SystemResource;
/**
 * 
 * @description 
 * @author ldw
 * @datetime 2016年12月23日 下午3:21:52
 */
public interface SystemResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemResource record);

    int insertSelective(SystemResource record);

    SystemResource selectByPrimaryKey(Integer id);

    List<String> findPermissionsByUserName(String userName);
    
    int updateByPrimaryKeySelective(SystemResource record);

    int updateByPrimaryKey(SystemResource record);
}