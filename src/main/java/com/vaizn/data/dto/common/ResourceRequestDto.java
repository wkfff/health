package com.vaizn.data.dto.common;

import java.io.Serializable;

public class ResourceRequestDto extends BaseRequestDto implements Serializable {

	private static final long serialVersionUID = -5889565159660265482L;

	private String resourceName;
	
	private String resourceStatus;

	public ResourceRequestDto() {
		
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceStatus() {
		return resourceStatus;
	}

	public void setResourceStatus(String resourceStatus) {
		this.resourceStatus = resourceStatus;
	}
}
