package com.vaizn.data.busi.service.permission;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.vaizn.common.vo.TreeVo;
import com.vaizn.data.busi.dal.entity.SysPrivilege;
import com.vaizn.data.busi.dal.entity.SysUser;
import com.vaizn.data.busi.dal.entity.SysUserRole;
import com.vaizn.data.dto.permission.PermissionRequestDto;
import com.vaizn.data.dto.permission.PrivilegeRequestDto;

public interface IPermissionService {

	/**
	 * 根据角色标识获取角色对应的用户
	 * @param roleId
	 * @return
	 */
	public PageInfo<SysUser> getRoleUsers(PermissionRequestDto requestDto) throws Exception;
	
	/**
	 * 保存用户角色
	 * @param sysUserRole
	 * @throws Exception
	 */
	public void exeSaveRoleUser(SysUserRole sysUserRole) throws Exception;
	
	/**
	 * 删除用户角色
	 * @param sysUserRole
	 * @throws Exception
	 */
	public void exeDeleteRoleUser(SysUserRole sysUserRole) throws Exception;
	
	/**
	 * 获取所有菜单
	 * @return
	 * @throws Exception
	 */
	public List<TreeVo> getAllMenus() throws Exception;
	
	/**
	 * 分配相关权限
	 * @param requestDto
	 * @throws Exception
	 */
	public void exeSavePrivilegeData(PrivilegeRequestDto requestDto) throws Exception;
	
	/**
	 * 获取角色已分配的权限
	 * @return
	 * @throws Exception
	 */
	public List<SysPrivilege> getRolePrivilege(String roleId) throws Exception;
}
