package com.vaizn.data.busi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 处理登录，登出操作
 * @author 关志伟
 */
@Controller
@RequestMapping("/signin")
@SessionAttributes("user")
public class SignController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(SignController.class);
}
