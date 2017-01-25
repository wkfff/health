package com.vaizn.data.busi.service.permission.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vaizn.common.vo.TreeVo;
import com.vaizn.data.busi.dal.entity.SysPrivilege;
import com.vaizn.data.busi.dal.entity.SysUser;
import com.vaizn.data.busi.dal.entity.SysUserRole;
import com.vaizn.data.busi.dal.mapper.SysPrivilegeMapper;
import com.vaizn.data.busi.dal.mapper.SysUserRoleMapper;
import com.vaizn.data.busi.dal.mapper.permission.PermissionMapper;
import com.vaizn.data.busi.service.permission.IPermissionService;
import com.vaizn.data.dto.permission.PermissionRequestDto;
import com.vaizn.data.dto.permission.PrivilegeRequestDto;
import com.vaizn.utils.CommonUtils;
import com.vaizn.utils.LoginUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class PermissionService implements IPermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private SysUserRoleMapper userRoleMapper;
	@Autowired
	private SysPrivilegeMapper privilegeMapper;
	
	@Override
	public PageInfo<SysUser> getRoleUsers(PermissionRequestDto requestDto) throws Exception {
		PageHelper.startPage(requestDto.getPageNum(), requestDto.getPageSize());
		return new PageInfo<SysUser>(permissionMapper.getRoleUsers(requestDto.getRoleId()));
	}

	@Override
	public void exeSaveRoleUser(SysUserRole sysUserRole) throws Exception {
		if (StringUtils.isNotBlank(sysUserRole.getUserId())) {
			String[] userIds = sysUserRole.getUserId().split(",");
			for (String id : userIds) {
				userRoleMapper.insertSelective(new SysUserRole(id, sysUserRole.getRoleId()));
			}
		}
	}

	@Override
	public void exeDeleteRoleUser(SysUserRole sysUserRole) throws Exception {
		if (StringUtils.isNotBlank(sysUserRole.getUserRoleId()))
			userRoleMapper.delete(sysUserRole);
		else {
			String[] userIds = sysUserRole.getUserId().split(",");
			List<String> ids = Arrays.asList(userIds);
			Example example = new Example(SysUserRole.class, false);
			Criteria criteria = example.createCriteria();
			criteria.andEqualTo("roleId", sysUserRole.getRoleId());
			criteria.andIn("userId", ids);
			userRoleMapper.deleteByExample(example);
		}
	}

	@Override
	public List<TreeVo> getAllMenus() throws Exception {
		return CommonUtils.treeProcess(permissionMapper.getResourcePermission(), "-1");
	}

	@Override
	public void exeSavePrivilegeData(PrivilegeRequestDto requestDto) throws Exception {
		String[] accessCodes = requestDto.getAccessCode().split(",");
		SysUser user = LoginUtils.currentLoginUser();
		//先删除再新增
		Example example = new Example(SysPrivilege.class, false);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("privilegeMaster", requestDto.getPrivilegeMaster());
		criteria.andEqualTo("masterCode", requestDto.getMasterCode());
		privilegeMapper.deleteByExample(example);
		
		for (String code : accessCodes) {
			SysPrivilege privilege = new SysPrivilege();
			privilege.setPrivilegeMaster(requestDto.getPrivilegeMaster());
			privilege.setMasterCode(requestDto.getMasterCode());
			privilege.setPrivilegeAccess(requestDto.getPrivilegeAccess());
			privilege.setAccessCode(code);
			privilege.setPrivilegeOperator(requestDto.getPrivilegeOperator());
			privilege.setPrivilegeCreator(user.getUserAccount());
			privilege.setCreateDate(new Date());
			privilege.setPrivilegeModitor(user.getUserAccount());
			privilege.setModiDate(new Date());
			privilegeMapper.insertSelective(privilege);
		}
	}

	@Override
	public List<SysPrivilege> getRolePrivilege(String roleId) throws Exception {
		Example example = new Example(SysPrivilege.class, false);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("privilegeMaster", "11");
		criteria.andEqualTo("masterCode", roleId);
		return privilegeMapper.selectByExample(example);
	}

}
