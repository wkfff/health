package com.vaizn.data.busi.dal.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "sys_user_role")
public class SysUserRole implements Serializable {

	private static final long serialVersionUID = 8373207505325292308L;

	@Id
    @GeneratedValue(generator="UUID")
    private String userRoleId;

    private String userId;

    private String roleId;

    public SysUserRole() {
		
	}

	public SysUserRole(String userId, String roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}

	public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}