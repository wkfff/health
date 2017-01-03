package com.vaizn.data.busi.dal.mapper;

import com.vaizn.data.busi.dal.entity.SysResource;
import tk.mybatis.mapper.common.Mapper;

public interface SysResourceMapper extends Mapper<SysResource> {
	
	/**
	 * 删除资源及其子级资源
	 * @param resourceId
	 * @throws Exception
	 */
	void deleteResource(String resourceId) throws Exception;
}