package com.vaizn.data.dto.product;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DescInfoRequest implements Serializable {

	private static final long serialVersionUID = 7202777169231527464L;

	private String descTitle;
	
	private String descCategory;
	
	private Integer descStatus;
	
	private String createBeginDate;
	
	private String createEndDate;
	
	private int page = 1;
	
	private int pageSize = 10;

	public DescInfoRequest() {
		
	}

	public String getDescTitle() {
		return descTitle;
	}

	public void setDescTitle(String descTitle) {
		this.descTitle = descTitle;
	}

	public String getDescCategory() {
		return descCategory;
	}

	public void setDescCategory(String descCategory) {
		this.descCategory = descCategory;
	}

	public Integer getDescStatus() {
		return descStatus;
	}

	public void setDescStatus(Integer descStatus) {
		this.descStatus = descStatus;
	}

	public String getCreateBeginDate() {
		return createBeginDate;
	}

	public void setCreateBeginDate(String createBeginDate) {
		this.createBeginDate = createBeginDate;
	}

	public String getCreateEndDate() {
		return createEndDate;
	}

	public void setCreateEndDate(String createEndDate) {
		this.createEndDate = createEndDate;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
