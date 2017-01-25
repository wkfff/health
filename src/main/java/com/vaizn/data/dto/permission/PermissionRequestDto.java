package com.vaizn.data.dto.permission;

import java.io.Serializable;

import com.vaizn.data.dto.common.BaseRequestDto;

public class PermissionRequestDto extends BaseRequestDto implements Serializable {

	private static final long serialVersionUID = 236530395379284252L;

	private String roleId;
	
	private String userId;
	
	private String menuId;

	public PermissionRequestDto() {
		
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
}
