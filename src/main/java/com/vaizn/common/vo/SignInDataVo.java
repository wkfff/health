package com.vaizn.common.vo;

import java.io.Serializable;

public class SignInDataVo implements Serializable {

	private static final long serialVersionUID = -2932359185605133382L;

	private String userAccount;
	
	private String userPassword;

	public SignInDataVo(String userAccount, String userPassword) {
		this.userAccount = userAccount;
		this.userPassword = userPassword;
	}

	public SignInDataVo() {
		
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
