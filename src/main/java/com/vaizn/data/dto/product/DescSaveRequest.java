package com.vaizn.data.dto.product;

import java.io.Serializable;

public class DescSaveRequest implements Serializable {

	private static final long serialVersionUID = 1087369252276333407L;

	private String descId;
	
	private String[] descIds;
	
	private String descTitle;
	
	private String descSource;
	
	private String descCategory;
	
	private String descStatus;
	
	private String descDetail;

	public DescSaveRequest() {
		
	}

	public String getDescId() {
		return descId;
	}

	public void setDescId(String descId) {
		this.descId = descId;
	}

	public String[] getDescIds() {
		return descIds;
	}

	public void setDescIds(String[] descIds) {
		this.descIds = descIds;
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

	public String getDescStatus() {
		return descStatus;
	}

	public void setDescStatus(String descStatus) {
		this.descStatus = descStatus;
	}

	public String getDescDetail() {
		return descDetail;
	}

	public void setDescDetail(String descDetail) {
		this.descDetail = descDetail;
	}
}
