package com.vaizn.data.busi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vaizn.common.vo.SysEnumeVo;
import com.vaizn.data.busi.service.ISysEnumeService;
import com.vaizn.data.dto.common.BaseResponseDto;

@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {

	@Autowired
	private ISysEnumeService sysEnumeService;
	
	@RequestMapping(path = "/getSysEnume", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponseDto getSysEnumeData() throws Exception {
		Map<String, List<SysEnumeVo>> map = sysEnumeService.getSysEnume();
		return new BaseResponseDto(1000, null, map);
	}
}
