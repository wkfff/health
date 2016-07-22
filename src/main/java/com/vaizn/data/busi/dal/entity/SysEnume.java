package com.vaizn.data.busi.dal.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "sys_enume")
public class SysEnume implements Serializable {

	private static final long serialVersionUID = -7643229985426841471L;

	@Id
    @GeneratedValue(generator="UUID")
    private String enumeId;

    private String enumeCode;

    private String enumeDesc;

    private String busiColumn;

    public String getEnumeId() {
        return enumeId;
    }

    public void setEnumeId(String enumeId) {
        this.enumeId = enumeId;
    }

    public String getEnumeCode() {
        return enumeCode;
    }

    public void setEnumeCode(String enumeCode) {
        this.enumeCode = enumeCode;
    }

    public String getEnumeDesc() {
        return enumeDesc;
    }

    public void setEnumeDesc(String enumeDesc) {
        this.enumeDesc = enumeDesc;
    }

	public String getBusiColumn() {
		return busiColumn;
	}

	public void setBusiColumn(String busiColumn) {
		this.busiColumn = busiColumn;
	}
}