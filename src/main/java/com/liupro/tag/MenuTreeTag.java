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
import org.springframework.beans.factory.annotation.Autowired;

import com.liupro.web.manage.model.SystemResource;
import com.liupro.web.manage.service.SystemResourceServiceI;
import com.liupro.web.manage.vo.SystemResourceVo;

/**
 * 
 * @description 后台管理菜单栏TAG
 * @author ldw
 * @datetime 2016年12月27日 上午10:01:12
 */
public class MenuTreeTag extends SimpleTagSupport {

	private static Logger log = LoggerFactory.getLogger(MenuTreeTag.class);
	
	@Autowired
	private SystemResourceServiceI resourceService;

	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public void doTag() throws JspException, IOException {
		List<SystemResource> resources = resourceService.findListByUserId(userId);
		List<SystemResourceVo> res = createMenuTree(resources);

		JspWriter out = this.getJspContext().getOut();
		out.write("<div data-options=\"region:'west',split:true,title:'系统菜单栏'\" style=\"width:250px;\">");
		out.write("<div id=\"accordion_left\" class=\"easyui-accordion\" fit=true>");
		for (SystemResourceVo vo : res) {
			List<SystemResourceVo> childs = vo.getChilds();
			out.write("<div title=\"" + vo.getName() + "\">");
			if (!childs.isEmpty()) {
				for (SystemResourceVo child : childs) {
					out.write("<a class=\"menu-item\" href=\"#\" onclick=\"addTab('" + child.getName() + "','"
							+ child.getUrl() + "');\">" + child.getName() + "</a>");
				}
			}
			out.write("</div>");
		}
		out.write("</div></div>");
	}

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
