package com.vaizn.common.vo;

import java.io.Serializable;

public class SignInDataVo implements Serializable {

	private static final long serialVersionUID = -2932359185605133382L;

	private String userAccount;
	
	private String password;

	public SignInDataVo(String userAccount, String password) {
		this.userAccount = userAccount;
		this.password = password;
	}

	public SignInDataVo() {
		
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
