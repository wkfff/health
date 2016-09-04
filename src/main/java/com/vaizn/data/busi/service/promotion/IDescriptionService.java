package com.vaizn.data.busi.service.promotion;

import com.github.pagehelper.PageInfo;
import com.vaizn.data.busi.dal.entity.DescriptionInfo;
import com.vaizn.data.busi.service.IBaseService;
import com.vaizn.data.dto.product.DescInfoRequest;

public interface IDescriptionService extends IBaseService<DescriptionInfo> {

	/**
	 * 分页查询信息文章
	 * @return
	 * @throws Exception
	 */
	PageInfo<DescriptionInfo> queryDescInfoByPage(DescInfoRequest request) throws Exception;
}
