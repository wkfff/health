package com.vaizn.data.dto.common;

import java.io.Serializable;

public class BaseResponseDto implements Serializable {

	private static final long serialVersionUID = 8240218882758425017L;

	/**
	 * 响应代码<br>
	 * 1000:操作成功<br>
	 * 1001:操作失败
	 */
	private String code;
	
	private String message;
	
	private Object data;

	public BaseResponseDto() {
		
	}

	public BaseResponseDto(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public BaseResponseDto(String code, String message, Object data) {
		this(code, message);
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
