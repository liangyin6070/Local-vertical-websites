package com.framwork.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 通用分页模型
 * @author 刘德伟
 *
 * @param <T>
 */
public class Page<T> {
	
	private int pageNo;//第几页
	private int pageSize;//每页数据量
	private Map<String, Object> where = new HashMap<String, Object>();//查询条件and
	private Map<String, Object[]> whereIn =  new HashMap<String, Object[]>();//查询条件or
	private String sort = null;// 排序字段名
	private String order = "asc";// 按什么排序(asc,desc)
	private List<T> result = new ArrayList<T>();//结果集
	private Long total;//总共数据量
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public int getPageNo() {
		if(pageNo <= 0) {
			return 1;
		}
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Map<String, Object> getWhere() {
		return where;
	}
	public void setWhere(Map<String, Object> where) {
		this.where = where;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	public Map<String, Object[]> getWhereIn() {
		return whereIn;
	}
	public void setWhereIn(Map<String, Object[]> whereIn) {
		this.whereIn = whereIn;
	}
}
