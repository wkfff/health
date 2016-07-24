package com.vaizn.common.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LigerPageVo<T> implements Serializable {

	private static final long serialVersionUID = 4284746525775314206L;

	@JsonProperty("Rows")
	private List<T> rows;
	
	@JsonProperty("Total")
	private long total;

	public LigerPageVo(List<T> rows, long total) {
		this.rows = rows;
		this.total = total;
	}

	public LigerPageVo() {
		
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
