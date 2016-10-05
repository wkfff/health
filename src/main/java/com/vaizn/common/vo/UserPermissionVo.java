package com.vaizn.common.vo;

import java.io.Serializable;

public class UserPermissionVo implements Serializable {

	private static final long serialVersionUID = -2395335050365118613L;

	private String resourceId;
	
	private String parentId;
	
	private String resourceCode;
	
	private String resourceName;
	
	private String resourceUrl;
	
	private String resourceType;
	
	private String moduleCode;

	public UserPermissionVo(String resourceId, String parentId,
			String resourceCode, String resourceName,
			String resourceUrl, String resourceType, String moduleCode) {
		this.resourceId = resourceId;
		this.parentId = parentId;
		this.resourceCode = resourceCode;
		this.resourceName = resourceName;
		this.resourceUrl = resourceUrl;
		this.resourceType = resourceType;
		this.moduleCode = moduleCode;
	}

	public UserPermissionVo() {
		
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}
}
