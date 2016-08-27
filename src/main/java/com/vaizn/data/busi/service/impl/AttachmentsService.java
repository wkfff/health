package com.vaizn.data.busi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaizn.data.busi.dal.entity.SysAttachments;
import com.vaizn.data.busi.dal.mapper.SysAttachmentsMapper;
import com.vaizn.data.busi.service.BaseService;
import com.vaizn.data.busi.service.IAttachmentsService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class AttachmentsService extends BaseService<SysAttachments> implements IAttachmentsService {

	@Autowired
	private SysAttachmentsMapper attachmentsMapper;
	
	@Override
	public Mapper<SysAttachments> getMapper() {
		return this.attachmentsMapper;
	}
}
