package com.liupro.web.manage.model;

import java.io.Serializable;

import org.jeecgframework.poi.excel.annotation.Excel;

public class Demo implements Serializable {

	@Excel(name="id")
	private Integer id;
	@Excel(name="name")
	private String name;
	@Excel(name="address")
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
