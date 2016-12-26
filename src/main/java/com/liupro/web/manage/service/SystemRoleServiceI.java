package com.liupro.web.manage.service;

import java.util.Set;

public interface SystemRoleServiceI {

	Set<String> findRolesByUserName(String userName);

}
