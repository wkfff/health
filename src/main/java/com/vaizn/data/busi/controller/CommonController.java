package com.vaizn.data.busi.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.vaizn.common.vo.SysEnumeVo;
import com.vaizn.data.busi.service.ISysEnumeService;
import com.vaizn.data.dto.common.BaseResponseDto;

@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {

	@Autowired
	private ISysEnumeService sysEnumeService;
	
	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String testPage() throws Exception {
		return "test";
	}
	
	@RequestMapping(path = "/getSysEnume", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponseDto getSysEnumeData() throws Exception {
		Map<String, List<SysEnumeVo>> map = sysEnumeService.getSysEnume();
		return new BaseResponseDto(1000, null, map);
	}
	
	@RequestMapping(path = "/fileUpload", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto fileUpload(@RequestParam(value="file",required=false) MultipartFile[] files,
										HttpServletRequest request) throws Exception {
		//应用路径
		String pathRoot = request.getSession().getServletContext().getRealPath("");
		for (MultipartFile file : files) {
			if(!file.isEmpty()){
				//获取文件类型，判断是否需过滤指定文件
				String contentType=file.getContentType();
				//文件后缀
				String fileName=contentType.substring(contentType.indexOf("/")+1);
				//保存文件
				file.transferTo(new File(pathRoot + "." + fileName));
			}
		}
		
		return new BaseResponseDto(1000, null, null);
	}
}
