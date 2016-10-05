package com.vaizn.common.vo;

import java.io.Serializable;
import java.util.List;

public class TreeVo implements Serializable {

	private static final long serialVersionUID = 5852295130551120108L;

	private String id;
	
	private String parentId;
	
	private String name;
	
	private String code;
	
	private String permissionCode;
	
	private String url;
	
	private List<TreeVo> childrens;

	public TreeVo(String id, String parentId, String name,
			String code, String permissionCode, String url, List<TreeVo> childrens) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.code = code;
		this.permissionCode = permissionCode;
		this.url = url;
		this.childrens = childrens;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<TreeVo> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<TreeVo> childrens) {
		this.childrens = childrens;
	}
}
