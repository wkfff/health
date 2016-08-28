package com.vaizn.data.busi.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vaizn.common.BaseException;
import com.vaizn.data.busi.dal.entity.SysAttachments;
import com.vaizn.data.busi.dal.mapper.SysAttachmentsMapper;
import com.vaizn.data.busi.service.BaseService;
import com.vaizn.data.busi.service.IAttachmentsService;
import com.vaizn.data.dto.common.AttachmentsRequestDto;
import com.vaizn.data.dto.common.BaseResponseDto;
import com.vaizn.utils.CommonUtils;

import tk.mybatis.mapper.common.Mapper;

@Service
public class AttachmentsService extends BaseService<SysAttachments> implements IAttachmentsService {

	protected static Logger logger = LoggerFactory.getLogger(AttachmentsService.class);
	
	@Autowired
	private SysAttachmentsMapper attachmentsMapper;
	
	@Override
	public Mapper<SysAttachments> getMapper() {
		return this.attachmentsMapper;
	}

	@Override
	public BaseResponseDto exeCreateAttachments(AttachmentsRequestDto dto) throws BaseException {
		SysAttachments attachment = null;
		Date current = new Date();
		List<String> allowType = dto.getAllowType();
		for (MultipartFile file : dto.getFiles()) {
			//文件类型
			String fileType = file.getContentType();
			//文件名
			String fileName = file.getOriginalFilename();
			//文件后缀
			String suffixes = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
			//新文件名
			String newFileName = CommonUtils.getUUID() + "." + suffixes;
			logger.info("==================上传的文件名称：{},文件类型：{},保存路径：{}==================",
																	fileName, fileType, dto.getSavePath());
			if (allowType.contains(fileType)) {
				attachment = new SysAttachments();
				attachment.setAttachmentType(dto.getAttachmentType());
				attachment.setFilePath(dto.getSavePath() + newFileName);
				attachment.setOldFileName(fileName);
				attachment.setNewFileName(newFileName);
				attachment.setBusiId(dto.getBusiId());
				attachment.setFileSize(file.getSize());
				attachment.setUploadDate(current);
				//保存文件
				try {
					file.transferTo(new File(dto.getRootPath() + dto.getSavePath() + newFileName));
					attachmentsMapper.insertSelective(attachment);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
					throw new BaseException("1001", "保存文件出错", e);
				}
			} else
				return new BaseResponseDto("1001", "不允许上传" + suffixes + "文件");
		}
		return new BaseResponseDto("1000", "保存文件成功");
	}
}
