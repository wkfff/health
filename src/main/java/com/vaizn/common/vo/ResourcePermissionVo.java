package com.vaizn.common.vo;

import java.io.Serializable;

public class ResourcePermissionVo implements Serializable {

	private static final long serialVersionUID = -2395335050365118613L;

	private String resourceId;
	
	private String parentId;
	
	private String parentName;
	
	private String resourceCode;
	
	private String resourceName;
	
	private String resourceUrl;
	
	private String resourceStatus;
	
	private Integer resourceOrder;
	
	private String resourceType;
	
	private String moduleCode;

	public ResourcePermissionVo(String resourceId, String parentId,String parentName,
			String resourceCode, String resourceName, String resourceUrl,
			String resourceStatus, Integer resourceOrder, String resourceType, String moduleCode) {
		this.resourceId = resourceId;
		this.parentId = parentId;
		this.parentName = parentName;
		this.resourceCode = resourceCode;
		this.resourceName = resourceName;
		this.resourceUrl = resourceUrl;
		this.resourceStatus = resourceStatus;
		this.resourceOrder = resourceOrder;
		this.resourceType = resourceType;
		this.moduleCode = moduleCode;
	}

	public ResourcePermissionVo() {
		
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

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
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

	public String getResourceStatus() {
		return resourceStatus;
	}

	public void setResourceStatus(String resourceStatus) {
		this.resourceStatus = resourceStatus;
	}

	public Integer getResourceOrder() {
		return resourceOrder;
	}

	public void setResourceOrder(Integer resourceOrder) {
		this.resourceOrder = resourceOrder;
	}
}
