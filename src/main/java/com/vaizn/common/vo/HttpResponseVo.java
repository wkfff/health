package com.vaizn.common.vo;

import java.io.Serializable;

public class HttpResponseVo implements Serializable {

	private static final long serialVersionUID = -4296791173463804620L;

	private Integer type;
	
	private String response;
	
	private Object data;

	public HttpResponseVo() {
		
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
