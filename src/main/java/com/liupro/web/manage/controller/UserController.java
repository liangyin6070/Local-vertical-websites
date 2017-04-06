package com.liupro.web.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liupro.web.manage.model.SystemUser;
import com.liupro.web.manage.service.SystemUserServiceI;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.framwork.base.BaseRestController;
import com.framwork.utils.ResponseUtils;

/**
 * 
 * @description 用户管理MVC
 * @author ldw
 * @datetime 2016年12月23日 下午3:59:41
 */
@Controller
public class UserController extends BaseRestController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private SystemUserServiceI userService;
	/**
	 * 跳转到用户列表页
	 * @return
	 */
	@RequiresRoles("admin")//超级管理员角色
	@RequiresPermissions("user:toList")//权限限制
	@RequestMapping(value="/manage/admin/user/toList", method=RequestMethod.GET)
	public String toList() {
		return "/webpage/admin/system/user";
	}
	/**
	 * 异步获取用户列表信息
	 * @param request
	 * @param response
	 */
	@RequiresRoles("admin")//超级管理员角色
	@RequiresPermissions("user:ajaxList")//权限限制
	@RequestMapping(value="/manage/admin/user/ajaxList", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject ajaxList(HttpServletRequest request, HttpServletResponse response, 
			Integer page, Integer rows) {
		JSONObject result = new JSONObject();
		SystemUser user = new SystemUser();
		user.setPageNo(page);
		user.setPageSize(rows);
		List<SystemUser> users = userService.selectPage(user);
		int count = user.getTotal();
		result.put("total", count);
		result.put("rows", (JSONArray)JSONArray.toJSON(users));
		//ResponseUtils.renderJson(response, result.toJSONString());
		return result;
	}
	/**
	 * 新增用户
	 * @param request
	 * @param response
	 */
	@RequiresRoles("admin")//超级管理员角色
	@RequiresPermissions("user:add")//权限限制
	@RequestMapping(value="/manage/admin/user/add", method=RequestMethod.POST)
	public void addUser(HttpServletRequest request, HttpServletResponse response, SystemUser user) {
		JSONObject result = new JSONObject();
		
		try {
			userService.insertUser(user);
			result.put("success",true);
			result.put("msg", "用户新增成功");
		} catch (Exception e) {
			logger.error("新增用户失败", e);
			result.put(SUCCESS, false);
			result.put(MSG, "新增失败");
		}
		
		ResponseUtils.renderJson(response, result.toJSONString());
	}
	/**
	 * 删除用户
	 */
	@RequiresRoles("admin")//超级管理员角色
	@RequiresPermissions("user:delete")//权限限制
	@RequestMapping(value="/manage/admin/user/delete", method=RequestMethod.POST)
	public void deleteUser(HttpServletRequest request, HttpServletResponse response, String ids) {
		JSONObject result = new JSONObject();
		try {
			if(StringUtils.isNotBlank(ids)) {
				String[] deleteIds = ids.split(",");
				for (String id : deleteIds) {
					userService.deleteById(Integer.parseInt(id));
				}
			}
			result.put(SUCCESS, true);
			result.put(MSG, "删除成功");
		} catch(Exception e) {
			logger.error("用户删除失败", e);
			result.put(SUCCESS, false);
			result.put(MSG, "删除失败");
		}
		ResponseUtils.renderJson(response, result.toJSONString());
	}
	/**
	 * 编辑用户
	 */
	@RequiresRoles("admin")//超级管理员角色
	@RequiresPermissions("user:edit")//权限限制
	@RequestMapping(value="/manage/admin/user/edit", method=RequestMethod.POST)
	public void editUser(HttpServletRequest request, HttpServletResponse response, SystemUser user) {
		JSONObject result = new JSONObject();
		try {
			userService.editUser(user);
			result.put(SUCCESS, true);
			result.put(MSG, "编辑成功");
		} catch(Exception e) {
			logger.error("用户编辑失败", e);
			result.put(SUCCESS, false);
			result.put(MSG, "编辑失败");
		}
		ResponseUtils.renderJson(response, result.toJSONString());
	}
}
