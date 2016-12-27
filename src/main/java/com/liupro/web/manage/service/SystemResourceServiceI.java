package com.liupro.web.manage.service;

import java.util.List;
import java.util.Set;

import com.liupro.web.manage.model.SystemResource;

public interface SystemResourceServiceI {
	public Set<String> findPermissionsByUserName(String userName);
	
	public List<SystemResource> findListByUserId(Integer userId);
}
