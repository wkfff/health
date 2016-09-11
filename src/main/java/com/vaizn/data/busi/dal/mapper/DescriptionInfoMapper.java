package com.vaizn.data.busi.dal.mapper;

import com.vaizn.data.busi.dal.entity.DescriptionInfo;
import com.vaizn.data.dto.product.DescSaveRequest;

import tk.mybatis.mapper.common.Mapper;

public interface DescriptionInfoMapper extends Mapper<DescriptionInfo> {
	
	/**
	 * 删除指定信息文章
	 * @param ids
	 * @return
	 */
	public int deleteDescByIds(String... ids);
	
	/**
	 * 更新信息文章状态
	 * @param ids
	 * @return
	 */
	public int updateDescStatusByIds(DescSaveRequest request);
	
}