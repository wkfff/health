package com.vaizn.data.dto.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleRequestDto extends BaseRequestDto implements Serializable {

	private static final long serialVersionUID = 7543459050616348028L;

	private String roleName;

	public RoleRequestDto() {
		
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
