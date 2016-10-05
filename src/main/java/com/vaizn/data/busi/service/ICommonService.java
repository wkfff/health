package com.vaizn.data.busi.service;

import java.util.List;

import com.vaizn.common.vo.TreeVo;

public interface ICommonService {

	/**
	 * 获取系统菜单
	 * @return
	 */
	List<TreeVo> getUserMenus() throws Exception;
}
