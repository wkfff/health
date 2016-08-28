package com.vaizn.data.dto.common;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class AttachmentsRequestDto implements Serializable {

	private static final long serialVersionUID = 1185682006614875578L;

	private MultipartFile[] files;
	
	private List<String> allowType;
	
	private String attachmentType;
	
	private String savePath;
	
	private String busiId;
	
	private String rootPath;

	public AttachmentsRequestDto() {
		
	}

	public AttachmentsRequestDto(MultipartFile[] files, String attachmentType, List<String> allowType,
							String savePath, String busiId, String rootPath) {
		this.files = files;
		this.attachmentType = attachmentType;
		this.allowType = allowType;
		this.savePath = savePath;
		this.busiId = busiId;
		this.rootPath = rootPath;
	}

	public MultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}

	public String getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getBusiId() {
		return busiId;
	}

	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public List<String> getAllowType() {
		return allowType;
	}

	public void setAllowType(List<String> allowType) {
		this.allowType = allowType;
	}
}
