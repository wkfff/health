package com.vaizn.data.busi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vaizn.data.dto.common.BaseResponseDto;

@ControllerAdvice
public class BaseController {
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public BaseResponseDto handleException(HttpServletRequest request, Exception e) {
		e.printStackTrace();
		return new BaseResponseDto(1001, "服务器请求失败");
	}
	
}
