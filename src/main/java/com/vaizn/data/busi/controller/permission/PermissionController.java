package com.vaizn.data.busi.controller.permission;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vaizn.data.busi.controller.BaseController;
import com.vaizn.data.busi.dal.entity.SysUserRole;
import com.vaizn.data.busi.service.permission.IPermissionService;
import com.vaizn.data.dto.common.BaseResponseDto;
import com.vaizn.data.dto.permission.PermissionRequestDto;
import com.vaizn.data.dto.permission.PrivilegeRequestDto;

@Controller
@RequestMapping("/permission")
public class PermissionController extends BaseController {

	protected static Logger logger = LoggerFactory.getLogger(PermissionController.class);
	
	@Autowired
	private IPermissionService permissionService;
	
	@RequestMapping(path = "/getRoleUser", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto getRoleUser(@RequestBody PermissionRequestDto requestDto) throws Exception {
		return new BaseResponseDto("1000", "查询成功！", permissionService.getRoleUsers(requestDto));
	}
	
	@RequestMapping(path = "/addRoleUser", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto addRoleUser(@RequestBody SysUserRole userRole) throws Exception {
		try {
			permissionService.exeSaveRoleUser(userRole);
			return new BaseResponseDto("1000", "保存成功！", null);
		} catch(Exception e) {
			logger.error("保存用户角色出错！", e);
			return new BaseResponseDto("1001", "保存失败！", null);
		}
	}
	
	@RequestMapping(path = "/delRoleUser", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto delRoleUser(@RequestBody SysUserRole userRole) throws Exception {
		try {
			permissionService.exeDeleteRoleUser(userRole);
			return new BaseResponseDto("1000", "删除成功！", null);
		} catch(Exception e) {
			logger.error("删除角色用户出错！", e);
			return new BaseResponseDto("1001", "删除失败！", null);
		}
	}
	
	@RequestMapping(path = "/getAllMenus", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto getAllMenus() throws Exception {
		return new BaseResponseDto("1000", "", permissionService.getAllMenus());
	}
	
	@RequestMapping(path = "/getRolePrivilege", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto getRolePrivilege(String roleId) throws Exception {
		return new BaseResponseDto("1000", "查询成功！", permissionService.getRolePrivilege(roleId));
	}
	
	@RequestMapping(path = "/savePrivilege", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto savePrivilegeData(@RequestBody PrivilegeRequestDto requestDto) throws Exception {
		permissionService.exeSavePrivilegeData(requestDto);
		return new BaseResponseDto("1000", "保存成功！", null);
	}
}
