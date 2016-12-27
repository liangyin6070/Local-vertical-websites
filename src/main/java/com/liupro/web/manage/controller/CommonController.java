package com.liupro.web.manage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framwork.core.spring.BaseRestController;
/**
 * 
 * @description 
 * @author ldw
 * @datetime 2016年12月27日 上午9:49:56
 */
@Controller
public class CommonController extends BaseRestController {
	
	private static Logger log = LoggerFactory.getLogger(CommonController.class);
	
	@RequestMapping(value="/common/blank",method=RequestMethod.GET)
	public String toBlank() {
		return "/admin/blank";
	}
}
