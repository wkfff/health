package com.vaizn.common.vo;

import java.io.Serializable;
import java.util.List;

public class TreeVo implements Serializable {

	private static final long serialVersionUID = 5852295130551120108L;

	private String id;
	
	private String parentId;
	
	private String parentName;
	
	private String name;
	
	private String text;
	
	private String code;
	
	private String permissionCode;
	
	private String status;
	
	private Integer order;
	
	private String url;
	
	private List<TreeVo> children;

	public TreeVo(String id, String parentId, String parentName, String name, String code,
			String permissionCode, String url, String status, Integer order, List<TreeVo> children) {
		this.id = id;
		this.parentId = parentId;
		this.parentName = parentName;
		this.name = name;
		this.code = code;
		this.permissionCode = permissionCode;
		this.status = status;
		this.order = order;
		this.url = url;
		this.children = children;
	}

	public TreeVo() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<TreeVo> getChildren() {
		return children;
	}

	public void setChildren(List<TreeVo> children) {
		this.children = children;
	}
}
