package com.vaizn.data.busi.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vaizn.common.vo.SignInDataVo;
import com.vaizn.data.busi.dal.entity.SysUser;
import com.vaizn.data.busi.service.IUserService;
import com.vaizn.data.dto.common.BaseResponseDto;
import com.vaizn.utils.CommonUtils;

/**
 * 处理登录，登出操作
 * @author 关志伟
 */
@Controller
@RequestMapping("/signin")
@SessionAttributes("user")
public class SignController extends BaseController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(path = "/page", method={RequestMethod.POST,RequestMethod.GET})
	public String signInPage() throws Exception {
		return "/common/signIn";
	}
	
	@RequestMapping(path = "/doSignIn", method=RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto signIn(@RequestBody SignInDataVo signInData, Model model)
												throws Exception {
		BaseResponseDto response = new BaseResponseDto();
		String userAccount = signInData.getUserAccount();
		String userPassword = signInData.getUserPassword();
		if (StringUtils.isBlank(userAccount) || StringUtils.isBlank(userPassword)) {
			response.setCode("1001");
			response.setMessage("账号和密码不能为空！");
		} else {
			signInData.setUserPassword(CommonUtils.encodeMD5(signInData.getUserPassword()));
			SysUser user = userService.checkSignInUser(signInData);
			if (null == user) {
				response.setCode("1001");
				response.setMessage("账号或密码错误！");
			} else {
				model.addAttribute("user", user);
				response.setCode("1000");
				response.setMessage("登录成功！");
			}
		}
		
		return response;
	}
}
