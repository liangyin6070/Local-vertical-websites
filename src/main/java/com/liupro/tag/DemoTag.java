package com.liupro.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 
 * @description 自定义标签demo
 * @author ldw
 * @datetime 2016年12月21日 下午4:54:23
 */
public class DemoTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		this.getJspContext().getOut().write("这是标签demo");;
	}
}
