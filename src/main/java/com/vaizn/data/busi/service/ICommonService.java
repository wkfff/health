package com.vaizn.data.busi.service;

import java.util.List;

import com.vaizn.common.vo.TreeVo;
import com.vaizn.data.busi.dal.entity.SysResource;

public interface ICommonService {

	/**
	 * 获取系统菜单
	 * @return
	 */
	List<TreeVo> getUserMenus() throws Exception;
	
	/**
	 * 保存系统菜单
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	void saveUserMenu(SysResource vo) throws Exception;
	
	/**
	 * 删除指定资源及子级资源
	 * @param resourceId
	 * @throws Exception
	 */
	void exeDelResourceAndChildren(String resourceId) throws Exception;
}
