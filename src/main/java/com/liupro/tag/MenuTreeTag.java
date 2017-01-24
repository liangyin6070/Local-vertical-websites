package com.liupro.tag;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.framwork.utils.SpringBeanUtils;
import com.liupro.web.manage.model.SystemResource;
import com.liupro.web.manage.model.SystemUser;
import com.liupro.web.manage.service.SystemResourceServiceI;
import com.liupro.web.manage.service.SystemUserServiceI;
import com.liupro.web.manage.service.impl.SystemResourceService;
import com.liupro.web.manage.service.impl.SystemUserService;
import com.liupro.web.manage.vo.SystemResourceVo;

/**
 * 
 * @description 后台管理菜单栏TAG
 * @author ldw
 * @datetime 2016年12月27日 上午10:01:12
 */
public class MenuTreeTag extends SimpleTagSupport {

	private static Logger log = LoggerFactory.getLogger(MenuTreeTag.class);

	private SystemResourceServiceI resourceService;
	private SystemUserServiceI userService;
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public void doTag() throws JspException, IOException {
		resourceService = SpringBeanUtils.getBean(SystemResourceService.class);
		userService = SpringBeanUtils.getBean(SystemUserService.class);
		List<SystemResource> resources = resourceService.findListByUserId(userId);
		List<SystemResourceVo> res = createMenuTree(resources);
		SystemUser user = userService.getById(userId);
		JspWriter out = this.getJspContext().getOut();
		out.write(createLeftTreeHtml(res, user));
//		out.write("<div data-options=\"region:'west',split:true,title:'系统菜单栏'\" style=\"width:250px;\">");
//		out.write("<div id=\"accordion_left\" class=\"easyui-accordion\" fit=true>");
//		for (SystemResourceVo vo : res) {
//			List<SystemResourceVo> childs = vo.getChilds();
//			out.write("<div title=\"" + vo.getName() + "\">");
//			if (!childs.isEmpty()) {
//				for (SystemResourceVo child : childs) {
//					out.write("<a class=\"menu-item\" href=\"#\" onclick=\"addTab('" + child.getName() + "','"
//							+ child.getUrl() + "');\">" + child.getName() + "</a>");
//				}
//			}
//			out.write("</div>");
//		}
//		out.write("</div></div>");
//		out.flush();
//		out.close();
	}
	
	/**
	 * 生成左边菜单栏
	 * @param res
	 * @param user
	 * @return
	 */
	public String createLeftTreeHtml(List<SystemResourceVo> res, SystemUser user) {
		StringBuilder HTML = new StringBuilder();
		HTML.append("<nav class=\"navbar-default navbar-static-side\" role=\"navigation\">")
			.append("<div class=\"nav-close\"><i class=\"fa fa-times-circle\"></i></div>")
			.append("<div class=\"sidebar-collapse\">")
			.append("<ul class=\"nav\" id=\"side-menu\">")
			.append("<li class=\"nav-header\">")
			.append("<div class=\"dropdown profile-element\">")
			.append("<span><img alt=\"image\" class=\"img-circle\" src=\""+ user.getHeadImg() +"\" /></span>")
			.append("<a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"#\">")
			.append("<span class=\"clear\">")
			.append("<span class=\"block m-t-xs\"><strong class=\"font-bold\">"+user.getUserName()+"</strong></span>")
			.append("<span class=\"text-muted text-xs block\">"+user.getReailName()+"<b class=\"caret\"></b></span></span></a>")
			.append("<ul class=\"dropdown-menu animated fadeInRight m-t-xs\">")
			.append("<li><a class=\"J_menuItem\" href=\"form_avatar.html\">修改头像</a></li>")
			.append("<li><a class=\"J_menuItem\" href=\"profile.html\">个人资料</a></li>")
			.append("<li><a class=\"J_menuItem\" href=\"contacts.html\">联系我们</a></li>")
			.append("<li><a class=\"J_menuItem\" href=\"mailbox.html\">信箱</a></li>")
			.append("<li class=\"divider\"></li><li><a href=\"login.html\">安全退出</a></li>")
			.append("</ul></div><div class=\"logo-element\">ZM+</div></li> ");
		
		for (SystemResourceVo vo : res) {
			List<SystemResourceVo> childs = vo.getChilds();
			HTML.append("<li><a href=\"#\"><i class=\"fa fa-envelope\"></i><span class=\"nav-label\">").append(vo.getName())
				.append("</span><span class=\"fa arrow\"></span></a>");
			if (!childs.isEmpty()) {
				HTML.append("<ul class=\"nav nav-second-level\">");
				for (SystemResourceVo child : childs) {
					HTML.append("<li><a class=\"J_menuItem\" href=\"/leaner"+child.getUrl()+"\">"+child.getName()+"</a></li>");
				}
				HTML.append("</ul>");
			}
			HTML.append("</li>");
		}
		HTML.append("</ul></div></nav>");
		return HTML.toString();
	}
	
	/**
	 * 生成树形结构
	 * @param resources
	 * @return
	 */
	public List<SystemResourceVo> createMenuTree(List<SystemResource> resources) {
		List<SystemResourceVo> res = new ArrayList<SystemResourceVo>();
		for(SystemResource resource : resources) {
			if(resource.getPid() == 0) {
				SystemResourceVo vo = new SystemResourceVo();
				try {
					BeanUtils.copyProperties(vo, resource);
					recursive(resources, vo);
				} catch (IllegalAccessException e) {
					log.error("", e);
				} catch (InvocationTargetException e) {
					log.error("", e);
				}
				
				res.add(vo);
			}
		}
		return res;
	}

	public void recursive(List<SystemResource> resources, SystemResourceVo vo) throws IllegalAccessException, InvocationTargetException {
		List<SystemResourceVo> childs = new ArrayList<SystemResourceVo>();
		
		for(SystemResource resource : resources) {
			if(resource.getPid() == vo.getId()) {
				SystemResourceVo child = new SystemResourceVo();
				BeanUtils.copyProperties(child, resource);
				childs.add(child);
			}
		}
		vo.setChilds(childs);
	}
}
