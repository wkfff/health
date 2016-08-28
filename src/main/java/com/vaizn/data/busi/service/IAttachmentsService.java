package com.vaizn.data.busi.service;

import com.vaizn.common.BaseException;
import com.vaizn.data.busi.dal.entity.SysAttachments;
import com.vaizn.data.dto.common.AttachmentsRequestDto;
import com.vaizn.data.dto.common.BaseResponseDto;

public interface IAttachmentsService extends IBaseService<SysAttachments> {

	/**
	 * 创建附件记录
	 * @param dto
	 * @return
	 * @throws BaseException
	 */
	public BaseResponseDto exeCreateAttachments(AttachmentsRequestDto dto) throws BaseException;
}
