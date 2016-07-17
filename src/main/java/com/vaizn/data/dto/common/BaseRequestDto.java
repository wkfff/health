package com.vaizn.data.dto.common;

import java.io.Serializable;


public class BaseRequestDto implements Serializable {

	private static final long serialVersionUID = 1250458072909621887L;
	
	private String dbAdapter;
	//页码 默认为1
	private int pageNum = 1;
	//每页记录数 默认10
	private int pageSize = 10;

	public String getDbAdapter() {
		return dbAdapter;
	}

	public void setDbAdapter(String dbAdapter) {
		this.dbAdapter = dbAdapter;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
