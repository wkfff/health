package com.vaizn.data.busi.service.impl;

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
import com.vaizn.data.busi.dal.entity.SysResource;
import com.vaizn.data.busi.dal.entity.SysRole;
import com.vaizn.data.busi.dal.entity.SysUser;
import com.vaizn.data.busi.dal.mapper.SysPrivilegeMapper;
import com.vaizn.data.busi.dal.mapper.SysResourceMapper;
import com.vaizn.data.busi.dal.mapper.SysRoleMapper;
import com.vaizn.data.busi.dal.mapper.SysUserMapper;
import com.vaizn.data.busi.service.ICommonService;
import com.vaizn.data.dto.common.RoleRequestDto;
import com.vaizn.data.dto.common.UserRequestDto;
import com.vaizn.utils.CommonUtils;
import com.vaizn.utils.LoginUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class CommonService implements ICommonService {

	@Autowired
	private SysPrivilegeMapper privilegeMapper;
	@Autowired
	private SysResourceMapper resourceMapper;
	@Autowired
	private SysUserMapper userMapper;
	@Autowired
	private SysRoleMapper roleMapper;
	
	@Override
	public List<TreeVo> getUserMenus() throws Exception {
		SysUser user = LoginUtils.currentLoginUser();
		return CommonUtils.treeProcess(privilegeMapper.getUserPrivilege(user.getUserId()), "-1");
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

	@Override
	public PageInfo<SysUser> getUsers(UserRequestDto dto) throws Exception {
		Example example = new Example(SysUser.class, false);
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(dto.getUserName()))
			criteria.andLike("userName", "%"+dto.getUserName()+"%");
		if (StringUtils.isNotBlank(dto.getUserAccount()))
			criteria.andLike("userAccount", "%"+dto.getUserAccount()+"%");
		if (StringUtils.isNotBlank(dto.getUserStatus()))
			criteria.andEqualTo("userStatus", dto.getUserStatus());
		example.orderBy("createDate").asc();
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		return new PageInfo<SysUser>(userMapper.selectByExample(example));
	}

	@Override
	public void exeSaveUser(SysUser vo) throws Exception {
		if (StringUtils.isNoneBlank(vo.getUserId()))
			userMapper.updateByPrimaryKeySelective(vo);
		else {
			vo.setUserId(CommonUtils.getUUID());
			vo.setUserPassword("c4ca4238a0b923820dcc509a6f75849b");
			vo.setCreateDate(new Date());
			userMapper.insert(vo);
		}
	}

	@Override
	public void exeDelUser(String... ids) throws Exception {
		List<String> userIds = Arrays.asList(ids);
		Example privilegeExample = new Example(SysPrivilege.class, false);
		Criteria privilegeCriteria = privilegeExample.createCriteria();
		privilegeCriteria.andEqualTo("privilegeMaster", "10");
		privilegeCriteria.andIn("masterCode", userIds);
		privilegeMapper.deleteByExample(privilegeExample);
		
		Example example = new Example(SysUser.class, false);
		Criteria criteria = example.createCriteria();
		criteria.andIn("userId", userIds);
		userMapper.deleteByExample(example);
	}
	
	@Override
	public PageInfo<SysRole> getRoles(RoleRequestDto dto) throws Exception {
		Example example = new Example(SysRole.class, false);
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(dto.getRoleName()))
			criteria.andLike("roleName", "%"+dto.getRoleName()+"%");
		example.orderBy("createDate").asc();
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		return new PageInfo<SysRole>(roleMapper.selectByExample(example));
	}

	@Override
	public void exeSaveRole(SysRole vo) throws Exception {
		if (StringUtils.isNoneBlank(vo.getRoleId()))
			roleMapper.updateByPrimaryKeySelective(vo);
		else {
			vo.setRoleId(CommonUtils.getUUID());
			vo.setCreateDate(new Date());
			roleMapper.insert(vo);
		}
	}

	@Override
	public void exeDelRole(String... ids) throws Exception {
		List<String> roleIds = Arrays.asList(ids);
		Example privilegeExample = new Example(SysPrivilege.class, false);
		Criteria privilegeCriteria = privilegeExample.createCriteria();
		privilegeCriteria.andEqualTo("privilegeMaster", "11");
		privilegeCriteria.andIn("masterCode", roleIds);
		privilegeMapper.deleteByExample(privilegeExample);
		
		Example example = new Example(SysRole.class, false);
		Criteria criteria = example.createCriteria();
		criteria.andIn("roleId", roleIds);
		roleMapper.deleteByExample(example);
	}

}
