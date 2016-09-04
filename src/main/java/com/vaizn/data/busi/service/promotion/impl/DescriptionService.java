package com.vaizn.data.busi.service.promotion.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vaizn.data.busi.dal.entity.DescriptionInfo;
import com.vaizn.data.busi.dal.mapper.DescriptionInfoMapper;
import com.vaizn.data.busi.service.BaseService;
import com.vaizn.data.busi.service.promotion.IDescriptionService;
import com.vaizn.data.dto.product.DescInfoRequest;

@Service
public class DescriptionService extends BaseService<DescriptionInfo> implements IDescriptionService {

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

}
