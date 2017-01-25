package com.vaizn.data.busi.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.vaizn.common.AES;
import com.vaizn.common.vo.LigerPageVo;
import com.vaizn.common.vo.SysEnumeVo;
import com.vaizn.data.busi.dal.entity.SysResource;
import com.vaizn.data.busi.dal.entity.SysRole;
import com.vaizn.data.busi.dal.entity.SysUser;
import com.vaizn.data.busi.service.IAttachmentsService;
import com.vaizn.data.busi.service.ICommonService;
import com.vaizn.data.busi.service.ISysEnumeService;
import com.vaizn.data.dto.common.AttachmentsRequestDto;
import com.vaizn.data.dto.common.BaseResponseDto;
import com.vaizn.data.dto.common.RoleRequestDto;
import com.vaizn.data.dto.common.UserRequestDto;
import com.vaizn.utils.LoginUtils;

@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {

	protected static Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private ISysEnumeService sysEnumeService;
	@Autowired
	private IAttachmentsService attachmentsService;
	@Autowired
	private ICommonService commonService;
	
	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String testPage() throws Exception {
		return "test";
	}
	
	@RequestMapping(path = "/main", method = RequestMethod.GET)
	public String mainPage() throws Exception {
		return "main";
	}
	
	@RequestMapping(path = "/menuManager", method = RequestMethod.GET)
	public String menuManagerPage() throws Exception {
		return "/common/menuManager";
	}
	
	@RequestMapping(path = "/userManager", method = RequestMethod.GET)
	public String userManagerPage() throws Exception {
		return "/common/userManager";
	}
	
	@RequestMapping(path = "/roleManager", method = RequestMethod.GET)
	public String roleManagerPage() throws Exception {
		return "/common/roleManager";
	}
	
	@RequestMapping(path = "/addEditMenuPage", method = RequestMethod.GET)
	public String addEditMenuPage() throws Exception {
		return "/common/addEditMenu";
	}
	
	@RequestMapping(path = "/addEditUserPage", method = RequestMethod.GET)
	public String addEditUserPage() throws Exception {
		return "/common/addEditUser";
	}
	
	@RequestMapping(path = "/addEditRolePage", method = RequestMethod.GET)
	public String addEditRolePage() throws Exception {
		return "/common/addEditRole";
	}
	
	@RequestMapping(path = "/roleAuthorizePage", method = RequestMethod.GET)
	public String roleAuthorizePage() throws Exception {
		return "/common/roleAuthorize";
	}
	
	@RequestMapping(path = "/userSelectPage/{roleId}", method = RequestMethod.GET)
	public String userSelectPage(@PathVariable String roleId, Model model) throws Exception {
		model.addAttribute("roleId", roleId);
		return "/common/userSelect";
	}
	
	@RequestMapping(path = "/getSysEnume", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponseDto getSysEnumeData() throws Exception {
		Map<String, List<SysEnumeVo>> map = sysEnumeService.getSysEnume();
		return new BaseResponseDto("1000", null, map);
	}
	
	@RequestMapping(path = "/fileUpload", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto fileUpload(HttpServletRequest request, String savePath, String busiId,
			@RequestParam(value="file",required=false) MultipartFile[] files) throws Exception {
		if (StringUtils.isNotBlank(savePath))
			savePath = AES.decode(savePath);
		else
			savePath = "\\attachment\\";
		String rootPath = request.getSession().getServletContext().getRealPath("");
		List<String> allowType = Arrays.asList("xls","xlsx","doc","docx","rar","text","pdf","chm");
		AttachmentsRequestDto dto = new AttachmentsRequestDto();
		dto.setAttachmentType("20");
		dto.setAllowType(allowType);
		dto.setBusiId(busiId);
		dto.setRootPath(rootPath);
		dto.setSavePath(savePath);
		dto.setFiles(files);
		
		return attachmentsService.exeCreateAttachments(dto, request.getContextPath());
	}
	
	@RequestMapping(path = "/imgUpload", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto imgUpload(HttpServletRequest request, String savePath, String busiId,
			@RequestParam(value="file",required=false) MultipartFile[] files) throws Exception {
		if (StringUtils.isNotBlank(savePath))
			savePath = AES.decode(savePath);
		else
			savePath = "\\attachment\\";
		String rootPath = request.getSession().getServletContext().getRealPath("");
		List<String> allowType = Arrays.asList("image/jpeg","image/png","image/gif");
		AttachmentsRequestDto dto = new AttachmentsRequestDto();
		dto.setAttachmentType("10");
		dto.setAllowType(allowType);
		dto.setBusiId(busiId);
		dto.setRootPath(rootPath);
		dto.setSavePath(savePath);
		dto.setFiles(files);
		
		return attachmentsService.exeCreateAttachments(dto, request.getContextPath());
	}
	
	@RequestMapping(path = "/getUserMenus", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto getUserMenus() throws Exception {
		return new BaseResponseDto("1000", "", commonService.getUserMenus());
	}
	
	@RequestMapping(path = "/saveMenu", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto saveMenuData(@RequestBody SysResource vo) throws Exception {
		try {
			String userAccount = LoginUtils.currentLoginUser().getUserAccount();
			vo.setModitor(userAccount);
			vo.setModiDate(new Date());
			commonService.saveUserMenu(vo);
			return new BaseResponseDto("1000", "保存成功！", null);
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("保存菜单出错", e);
			return new BaseResponseDto("1001", "保存失败！", null);
		}
		
	}
	
	@RequestMapping(path = "/deleteMenu", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto deleteMenu(String resourceId) throws Exception {
		if (StringUtils.isNotBlank(resourceId)) {
			try {
				commonService.exeDelResourceAndChildren(resourceId);
			} catch(Exception e) {
				e.printStackTrace();
				logger.error("删除资源出错", e);
				return new BaseResponseDto("1001", "删除失败！", null);
			}
		}
		return new BaseResponseDto("1000", "删除成功！", null);
	}
	
	@RequestMapping(path = "/getUsers", method = RequestMethod.POST)
	@ResponseBody
	public LigerPageVo<SysUser> getUsers(@RequestBody UserRequestDto dto) throws Exception {
		PageInfo<SysUser> page = commonService.getUsers(dto);
		LigerPageVo<SysUser> ligerPage = new LigerPageVo<SysUser>(page.getList(), page.getTotal());
		return ligerPage;
	}
	
	@RequestMapping(path = "/saveUser", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto saveUserData(@RequestBody SysUser vo) throws Exception {
		try {
			commonService.exeSaveUser(vo);
			return new BaseResponseDto("1000", "保存成功！", null);
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("保存用户出错", e);
			return new BaseResponseDto("1001", "保存失败！", null);
		}
		
	}
	
	@RequestMapping(path = "/deleteUser", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto deleteUser(@RequestParam(value = "userId[]") String[] userId) throws Exception {
		if (null != userId && userId.length > 0) {
			try {
				commonService.exeDelUser(userId);
			} catch(Exception e) {
				e.printStackTrace();
				logger.error("删除用户出错", e);
				return new BaseResponseDto("1001", "删除失败！", null);
			}
		}
		return new BaseResponseDto("1000", "删除成功！", null);
	}
	
	@RequestMapping(path = "/getRoles", method = RequestMethod.POST)
	@ResponseBody
	public LigerPageVo<SysRole> getRoles(@RequestBody RoleRequestDto dto) throws Exception {
		PageInfo<SysRole> page = commonService.getRoles(dto);
		LigerPageVo<SysRole> ligerPage = new LigerPageVo<SysRole>(page.getList(), page.getTotal());
		return ligerPage;
	}
	
	@RequestMapping(path = "/saveRole", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto saveRoleData(@RequestBody SysRole vo) throws Exception {
		try {
			commonService.exeSaveRole(vo);
			return new BaseResponseDto("1000", "保存成功！", null);
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("保存角色出错", e);
			return new BaseResponseDto("1001", "保存失败！", null);
		}
		
	}
	
	@RequestMapping(path = "/deleteRole", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto deleteRole(@RequestParam(value = "roleId[]") String[] roleId) throws Exception {
		if (null != roleId && roleId.length > 0) {
			try {
				commonService.exeDelRole(roleId);
			} catch(Exception e) {
				e.printStackTrace();
				logger.error("删除角色出错", e);
				return new BaseResponseDto("1001", "删除失败！", null);
			}
		}
		return new BaseResponseDto("1000", "删除成功！", null);
	}
	
}
