package com.vaizn.data.dto.permission;

import java.io.Serializable;

public class PrivilegeRequestDto implements Serializable {

	private static final long serialVersionUID = 2863354945521216654L;

	private String privilegeMaster;
	
	private String masterCode;
	
	private String privilegeAccess;
	
	private String accessCode;
	//10-可用 11-不可用
	private String privilegeOperator = "10";

	public PrivilegeRequestDto() {
		
	}

	public String getPrivilegeMaster() {
		return privilegeMaster;
	}

	public void setPrivilegeMaster(String privilegeMaster) {
		this.privilegeMaster = privilegeMaster;
	}

	public String getMasterCode() {
		return masterCode;
	}

	public void setMasterCode(String masterCode) {
		this.masterCode = masterCode;
	}

	public String getPrivilegeAccess() {
		return privilegeAccess;
	}

	public void setPrivilegeAccess(String privilegeAccess) {
		this.privilegeAccess = privilegeAccess;
	}

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public String getPrivilegeOperator() {
		return privilegeOperator;
	}

	public void setPrivilegeOperator(String privilegeOperator) {
		this.privilegeOperator = privilegeOperator;
	}
	
}
