package com.vaizn.data.busi.service.promotion.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vaizn.common.BaseException;
import com.vaizn.data.busi.dal.entity.DescriptionInfo;
import com.vaizn.data.busi.dal.mapper.DescriptionInfoMapper;
import com.vaizn.data.busi.service.BaseService;
import com.vaizn.data.busi.service.promotion.IDescriptionService;
import com.vaizn.data.dto.common.BaseResponseDto;
import com.vaizn.data.dto.product.DescInfoRequest;
import com.vaizn.data.dto.product.DescSaveRequest;

@Service
public class DescriptionService extends BaseService<DescriptionInfo> implements IDescriptionService {

	protected static Logger logger = LoggerFactory.getLogger(DescriptionService.class);
	
	@Autowired
	private DescriptionInfoMapper descriptionInfoMapper;
	
	@Override
	public Mapper<DescriptionInfo> getMapper() {
		return this.descriptionInfoMapper;
	}

	@Override
	public PageInfo<DescriptionInfo> queryDescInfoByPage(DescInfoRequest request) throws Exception {
		Example example = new Example(DescriptionInfo.class, false);
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(request.getDescTitle()))
			criteria.andLike("descTitle", request.getDescTitle());
		if (StringUtils.isNotBlank(request.getDescCategory()))
			criteria.andEqualTo("descCategory", request.getDescCategory());
		if (null != request.getDescStatus())
			criteria.andEqualTo("descStatus", request.getDescStatus());
		if (StringUtils.isNotBlank(request.getCreateBeginDate()))
			criteria.andGreaterThanOrEqualTo("createDate", request.getCreateBeginDate());
		if (StringUtils.isNotBlank(request.getCreateEndDate()))
			criteria.andLessThanOrEqualTo("createDate", request.getCreateEndDate());
		
		PageHelper.startPage(request.getPage(), request.getPageSize());
		List<DescriptionInfo> list = descriptionInfoMapper.selectByExample(example);
		
		return new PageInfo<DescriptionInfo>(list);
	}

	@Override
	public BaseResponseDto exeSaveDescInfoData(DescSaveRequest request) throws BaseException {
		BaseResponseDto response = new BaseResponseDto("1000", "保存成功");
		DescriptionInfo record = new DescriptionInfo();
		record.setDescTitle(request.getDescTitle());
		record.setDescSource(request.getDescSource());
		record.setDescCategory(request.getDescCategory());
		record.setDescDetail(request.getDescDetail());
		try {
			if (StringUtils.isBlank(request.getDescId())) {
				record.setDescStatus("10");
				record.setCreateDate(new Date());
				descriptionInfoMapper.insertSelective(record);
			} else {
				record.setDescId(request.getDescId());
				descriptionInfoMapper.updateByPrimaryKey(record);
			}
		} catch(Exception e) {
			logger.error("保存信息文章出错", e);
			throw new BaseException("1001", "保存信息文章出错", e);
		}
		
		return response;
	}

	@Override
	public BaseResponseDto exeDelDescInfoData(String... ids) throws BaseException {
		BaseResponseDto response = null;
		if (null != ids && ids.length > 0) {
			try {
				descriptionInfoMapper.deleteDescByIds(ids);
				response = new BaseResponseDto("1000", "删除成功");
			} catch(Exception e) {
				logger.error("删除信息文章出错", e);
				throw new BaseException("1001", "删除信息文章出错", e);
			}
		} else
			response = new BaseResponseDto("1001", "没有要删除的数据");
		return response;
	}

	@Override
	public BaseResponseDto exePublishDescInfo(DescSaveRequest request) throws BaseException {
		BaseResponseDto response = null;
		if (null != request.getDescIds() && request.getDescIds().length > 0) {
			try {
				descriptionInfoMapper.updateDescStatusByIds(request);
				response = new BaseResponseDto("1000", "操作成功");
			} catch(Exception e) {
				logger.error("删除信息文章出错", e);
				throw new BaseException("1001", "更新信息文章状态出错", e);
			}
		} else
			response = new BaseResponseDto("1001", "没有要更新的数据");
		return response;
	}

}
