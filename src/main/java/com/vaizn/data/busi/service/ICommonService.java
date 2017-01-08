package com.vaizn.data.busi.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.vaizn.common.vo.TreeVo;
import com.vaizn.data.busi.dal.entity.SysResource;
import com.vaizn.data.busi.dal.entity.SysRole;
import com.vaizn.data.busi.dal.entity.SysUser;
import com.vaizn.data.dto.common.RoleRequestDto;
import com.vaizn.data.dto.common.UserRequestDto;

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
	
	/**
	 * 获取用户
	 * @return
	 * @throws Exception
	 */
	PageInfo<SysUser> getUsers(UserRequestDto dto) throws Exception;
	
	/**
	 * 保存用户
	 * @param vo
	 * @throws Exception
	 */
	void exeSaveUser(SysUser vo) throws Exception;
	
	/**
	 * 删除用户
	 * @param ids
	 * @throws Exception
	 */
	void exeDelUser(String... ids) throws Exception;
	
	/**
	 * 获取角色
	 * @return
	 * @throws Exception
	 */
	PageInfo<SysRole> getRoles(RoleRequestDto dto) throws Exception;
	
	/**
	 * 保存角色
	 * @param vo
	 * @throws Exception
	 */
	void exeSaveRole(SysRole vo) throws Exception;
	
	/**
	 * 删除角色
	 * @param ids
	 * @throws Exception
	 */
	void exeDelRole(String... ids) throws Exception;
}
