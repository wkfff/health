package com.vaizn.data.busi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaizn.common.vo.TreeVo;
import com.vaizn.common.vo.UserPermissionVo;
import com.vaizn.data.busi.dal.entity.SysResource;
import com.vaizn.data.busi.dal.entity.SysUser;
import com.vaizn.data.busi.dal.mapper.SysPrivilegeMapper;
import com.vaizn.data.busi.dal.mapper.SysResourceMapper;
import com.vaizn.data.busi.service.ICommonService;
import com.vaizn.utils.CommonUtils;
import com.vaizn.utils.LoginUtils;

@Service
public class CommonService implements ICommonService {

	@Autowired
	private SysPrivilegeMapper privilegeMapper;
	@Autowired
	private SysResourceMapper resourceMapper;
	
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
				tree.setParentName(permission.getParentName());
				tree.setCode(permission.getResourceCode());
				tree.setName(permission.getResourceName());
				tree.setText(permission.getResourceName());
				tree.setPermissionCode(permission.getResourceCode());
				tree.setUrl(permission.getResourceUrl());
				tree.setStatus(permission.getResourceStatus());
				tree.setOrder(permission.getResourceOrder());
				tree.setChildren(treeProcess(permissions, permission.getResourceId()));
				trees.add(tree);
			}
		}
		return trees;
	}

	@Override
	public void saveUserMenu(SysResource vo) throws Exception {
		SysUser user = LoginUtils.currentLoginUser();
		vo.setResourceStatus("10");
		if (StringUtils.isBlank(vo.getResourceId())) {
			vo.setResourceId(CommonUtils.getUUID());
			vo.setCreator(user.getUserAccount());
			vo.setCreateDate(new Date());
			resourceMapper.insert(vo);
		} else {
			vo.setModitor(user.getUserAccount());
			vo.setModiDate(new Date());
			resourceMapper.updateByPrimaryKey(vo);
		}
	}

	@Override
	public void exeDelResourceAndChildren(String resourceId) throws Exception {
		privilegeMapper.deleteResourcePrivilege(resourceId);
		resourceMapper.deleteResource(resourceId);
	}

}
