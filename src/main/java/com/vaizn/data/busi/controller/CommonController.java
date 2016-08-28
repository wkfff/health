package com.vaizn.data.busi.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.vaizn.common.AES;
import com.vaizn.common.vo.SysEnumeVo;
import com.vaizn.data.busi.service.IAttachmentsService;
import com.vaizn.data.busi.service.ISysEnumeService;
import com.vaizn.data.dto.common.AttachmentsRequestDto;
import com.vaizn.data.dto.common.BaseResponseDto;

@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {

	protected static Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private ISysEnumeService sysEnumeService;
	@Autowired
	private IAttachmentsService attachmentsService;
	
	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String testPage() throws Exception {
		return "test";
	}
	
	@RequestMapping(path = "/getSysEnume", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponseDto getSysEnumeData() throws Exception {
		Map<String, List<SysEnumeVo>> map = sysEnumeService.getSysEnume();
		return new BaseResponseDto("1000", null, map);
	}
	
	@RequestMapping(path = "/fileUpload", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto fileUpload(HttpServletRequest request, String savePath, String busiId,
			@RequestParam(value="file",required=false) MultipartFile[] files) throws Exception {
		if (StringUtils.isNotBlank(savePath))
			savePath = AES.decode(savePath);
		else
			savePath = "\\attachment\\";
		String rootPath = request.getSession().getServletContext().getRealPath("");
		List<String> allowType = Arrays.asList("xls","xlsx","doc","docx","rar","text","pdf","chm");
		AttachmentsRequestDto dto = new AttachmentsRequestDto();
		dto.setAttachmentType("20");
		dto.setAllowType(allowType);
		dto.setBusiId(busiId);
		dto.setRootPath(rootPath);
		dto.setSavePath(savePath);
		dto.setFiles(files);
		
		return attachmentsService.exeCreateAttachments(dto);
	}
	
	@RequestMapping(path = "/imgUpload", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto imgUpload(HttpServletRequest request, String savePath, String busiId,
			@RequestParam(value="file",required=false) MultipartFile[] files) throws Exception {
		if (StringUtils.isNotBlank(savePath))
			savePath = AES.decode(savePath);
		else
			savePath = "\\attachment\\";
		String rootPath = request.getSession().getServletContext().getRealPath("");
		List<String> allowType = Arrays.asList("image/jpeg","image/png","image/gif");
		AttachmentsRequestDto dto = new AttachmentsRequestDto();
		dto.setAttachmentType("10");
		dto.setAllowType(allowType);
		dto.setBusiId(busiId);
		dto.setRootPath(rootPath);
		dto.setSavePath(savePath);
		dto.setFiles(files);
		
		return attachmentsService.exeCreateAttachments(dto);
	}
}
