package com.vaizn.common.vo;

import java.io.Serializable;

public class SysEnumeVo implements Serializable {

	private static final long serialVersionUID = -5800509993075755081L;
	
	private String id;
	
	private String value;
	
	private String text;

	public SysEnumeVo(String id, String value, String text) {
		this.id = id;
		this.value = value;
		this.text = text;
	}

	public SysEnumeVo() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
