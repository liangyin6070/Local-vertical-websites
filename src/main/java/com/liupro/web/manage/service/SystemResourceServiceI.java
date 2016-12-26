package com.liupro.web.manage.service;

import java.util.Set;

public interface SystemResourceServiceI {
	public Set<String> findPermissionsByUserName(String userName);
}
