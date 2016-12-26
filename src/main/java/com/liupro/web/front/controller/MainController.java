package com.liupro.web.front.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framwork.core.spring.BaseRestController;
/**
 * 
 * @description 前端首页
 * @author ldw
 * @datetime 2016年12月21日 下午3:38:48
 */
@Controller
public class MainController extends BaseRestController {

	private static Logger log = LoggerFactory.getLogger(MainController.class);
	/**
	 * 跳转到首页
	 * @return
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String toIndex() {
		return "/front/index";
	}
	
}
