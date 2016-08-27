package com.vaizn.data.busi.controller;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
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
import com.vaizn.data.busi.dal.entity.SysAttachments;
import com.vaizn.data.busi.service.IAttachmentsService;
import com.vaizn.data.busi.service.ISysEnumeService;
import com.vaizn.data.dto.common.BaseResponseDto;
import com.vaizn.utils.CommonUtils;

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
		return new BaseResponseDto(1000, null, map);
	}
	
	@RequestMapping(path = "/fileUpload", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto fileUpload(HttpServletRequest request, String savePath,
			@RequestParam(value="file",required=false) MultipartFile[] files) throws Exception {
		if (StringUtils.isNotBlank(savePath))
			savePath = AES.decode(savePath);
		else
			savePath = "/attachment/";
		SysAttachments attachment = null;
		Date current = new Date();
		List<String> allowType = Arrays.asList("xls","xlsx","doc","docx","rar","text","pdf","chm");
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				//文件类型
				String fileType = file.getContentType();
				//文件名
				String fileName = file.getOriginalFilename();
				//文件后缀
				String suffixes = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
				//新文件名
				String newFileName = CommonUtils.getUUID() + "." + suffixes;
				logger.info("==================上传的文件名称：{},文件类型：{},保存路径：{}==================",
																		fileName, fileType, savePath);
				if (allowType.contains(suffixes)) {
					attachment = new SysAttachments();
					attachment.setAttachmentType("20");
					attachment.setFilePath(savePath + newFileName);
					attachment.setOldFileName(fileName);
					attachment.setNewFileName(newFileName);
					attachment.setFileSize(file.getSize());
					attachment.setUploadDate(current);
					attachmentsService.insertSelective(attachment);
					//保存文件
					file.transferTo(new File(savePath + newFileName));
				} else {
					return new BaseResponseDto(1001, "不允许上传" + suffixes + "文件", null);
				}
			}
		}
		
		return new BaseResponseDto(1000, "文件上传成功", null);
	}
	
	@RequestMapping(path = "/imgUpload", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto imgUpload(HttpServletRequest request, String savePath,
			@RequestParam(value="file",required=false) MultipartFile[] files) throws Exception {
		if (StringUtils.isNotBlank(savePath))
			savePath = AES.decode(savePath);
		else
			savePath = "/attachment/";
		SysAttachments attachment = null;
		Date current = new Date();
		List<String> allowType = Arrays.asList("image/jpeg","image/png","image/gif");
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				//文件类型
				String fileType = file.getContentType();
				//文件名
				String fileName = file.getOriginalFilename();
				//文件后缀
				String suffixes = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
				//新文件名
				String newFileName = CommonUtils.getUUID() + "." + suffixes;
				logger.info("==================上传的文件名称：{},文件类型：{},保存路径：{}==================",
																		fileName, fileType, savePath);
				if (allowType.contains(fileType)) {
					attachment = new SysAttachments();
					attachment.setAttachmentType("10");
					attachment.setFilePath(savePath + newFileName);
					attachment.setOldFileName(fileName);
					attachment.setNewFileName(newFileName);
					attachment.setFileSize(file.getSize());
					attachment.setUploadDate(current);
					attachmentsService.insertSelective(attachment);
					//保存文件
					file.transferTo(new File(savePath + newFileName));
				} else {
					return new BaseResponseDto(1001, "不允许上传" + suffixes + "文件", null);
				}
			}
		}
		
		return new BaseResponseDto(1000, "文件上传成功", null);
	}
}
