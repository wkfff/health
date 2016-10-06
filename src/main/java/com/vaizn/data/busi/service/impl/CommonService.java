package com.vaizn.data.busi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaizn.common.vo.TreeVo;
import com.vaizn.common.vo.UserPermissionVo;
import com.vaizn.data.busi.dal.entity.SysUser;
import com.vaizn.data.busi.dal.mapper.SysPrivilegeMapper;
import com.vaizn.data.busi.service.ICommonService;
import com.vaizn.utils.LoginUtils;

@Service
public class CommonService implements ICommonService {

	@Autowired
	private SysPrivilegeMapper privilegeMapper;
	
	@Override
	public List<TreeVo> getUserMenus() throws Exception {
		SysUser user = LoginUtils.currentLoginUser();
		return treeProcess(privilegeMapper.getUserPrivilege(user.getUserId()), "-1");
	}
	
	/**
	 * 处理树形菜单
	 * @param permissions
	 * @param id
	 * @return
	 */
	protected List<TreeVo> treeProcess(List<UserPermissionVo> permissions, String id) {
		List<TreeVo> trees = new ArrayList<TreeVo>();
		for (UserPermissionVo permission : permissions) {
			if (id.equals(permission.getParentId())) {
				TreeVo tree = new TreeVo();
				String parentId = permission.getParentId();
				tree.setId(permission.getResourceId());
				tree.setParentId(parentId);
				tree.setCode(permission.getResourceCode());
				tree.setName(permission.getResourceName());
				tree.setPermissionCode(permission.getResourceCode());
				tree.setUrl(permission.getResourceUrl());
				tree.setChildrens(treeProcess(permissions, permission.getResourceId()));
				trees.add(tree);
			}
		}
		return trees;
	}

}
