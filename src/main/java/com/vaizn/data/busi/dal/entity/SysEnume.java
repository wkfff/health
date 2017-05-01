package com.vaizn.data.busi.dal.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "sys_enume")
public class SysEnume implements Serializable {

	private static final long serialVersionUID = -7643229985426841471L;

	@Id
    @GeneratedValue(generator="UUID")
    private String enumeId;

	private String enumeValue;

    private String enumeText;

    private String enumeCode;
    
    private String enumeName;

	public String getEnumeId() {
		return enumeId;
	}

	public void setEnumeId(String enumeId) {
		this.enumeId = enumeId;
	}

	public String getEnumeValue() {
		return enumeValue;
	}

	public void setEnumeValue(String enumeValue) {
		this.enumeValue = enumeValue;
	}

	public String getEnumeText() {
		return enumeText;
	}

	public void setEnumeText(String enumeText) {
		this.enumeText = enumeText;
	}

	public String getEnumeCode() {
		return enumeCode;
	}

	public void setEnumeCode(String enumeCode) {
		this.enumeCode = enumeCode;
	}

	public String getEnumeName() {
		return enumeName;
	}

	public void setEnumeName(String enumeName) {
		this.enumeName = enumeName;
	}

}