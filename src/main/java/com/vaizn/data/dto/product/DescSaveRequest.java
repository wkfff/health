package com.vaizn.data.dto.product;

import java.io.Serializable;

public class DescSaveRequest implements Serializable {

	private static final long serialVersionUID = 1087369252276333407L;

	private String descTitle;
	
	private String descSource;
	
	private String descCategory;
	
	private String descDetail;

	public DescSaveRequest() {
		
	}

	public String getDescTitle() {
		return descTitle;
	}

	public void setDescTitle(String descTitle) {
		this.descTitle = descTitle;
	}

	public String getDescSource() {
		return descSource;
	}

	public void setDescSource(String descSource) {
		this.descSource = descSource;
	}

	public String getDescCategory() {
		return descCategory;
	}

	public void setDescCategory(String descCategory) {
		this.descCategory = descCategory;
	}

	public String getDescDetail() {
		return descDetail;
	}

	public void setDescDetail(String descDetail) {
		this.descDetail = descDetail;
	}
}
