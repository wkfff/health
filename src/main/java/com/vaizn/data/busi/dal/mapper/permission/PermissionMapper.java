package com.vaizn.data.busi.dal.mapper.permission;

import java.util.List;

import com.vaizn.common.vo.ResourcePermissionVo;
import com.vaizn.data.busi.dal.entity.SysUser;

public interface PermissionMapper {

	/**
	 * 根据角色标识获取角色对应的用户
	 * @param roleId
	 * @return
	 */
	public List<SysUser> getRoleUsers(String roleId);
	
	/**
	 * 获取所有资源菜单
	 * @return
	 * @throws Exception
	 */
	List<ResourcePermissionVo> getResourcePermission() throws Exception;
}
