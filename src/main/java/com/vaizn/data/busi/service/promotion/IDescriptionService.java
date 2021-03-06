package com.vaizn.data.busi.service.promotion;

import com.github.pagehelper.PageInfo;
import com.vaizn.common.BaseException;
import com.vaizn.data.busi.dal.entity.DescriptionInfo;
import com.vaizn.data.busi.service.IBaseService;
import com.vaizn.data.dto.common.BaseResponseDto;
import com.vaizn.data.dto.product.DescInfoRequest;
import com.vaizn.data.dto.product.DescSaveRequest;

public interface IDescriptionService extends IBaseService<DescriptionInfo> {

	/**
	 * 分页查询信息文章
	 * @return
	 * @throws Exception
	 */
	PageInfo<DescriptionInfo> queryDescInfoByPage(DescInfoRequest request) throws Exception;
	
	/**
	 * 保存信息文章
	 * @return
	 * @throws BaseException
	 */
	BaseResponseDto exeSaveDescInfoData(DescSaveRequest request) throws BaseException;
	
	/**
	 * 删除信息文章
	 * @param ids
	 * @return
	 * @throws BaseException
	 */
	BaseResponseDto exeDelDescInfoData(String... ids) throws BaseException;
	
	/**
	 * 发布信息文章
	 * @param ids
	 * @return
	 * @throws BaseException
	 */
	BaseResponseDto exePublishDescInfo(DescSaveRequest request) throws BaseException;
}
