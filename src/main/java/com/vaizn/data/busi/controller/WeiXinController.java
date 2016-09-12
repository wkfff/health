package com.vaizn.data.busi.controller;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vaizn.common.SHA;

@Controller
@RequestMapping("/weixin")
public class WeiXinController extends BaseController {

	@RequestMapping(path = "/validate", method = RequestMethod.GET)
	@ResponseBody
	public String checkWeixinSignature(
				@RequestParam(value="signature", required=true) String signature,
				@RequestParam(value="timestamp", required=true) String timestamp,
				@RequestParam(value="nonce", required=true) String nonce,
				@RequestParam(value="echostr", required=true) String echostr) throws Exception {
		
		String token = "keephealth";
		String[] order = new String[]{token, timestamp, nonce};
		Arrays.sort(order);
		//按字典排序后转换成字符串
		String str = StringUtils.join(order);
		//SHA1加密
		str = SHA.encrypt(str);
		if (str.equals(signature))
			return echostr;
		else
			return "";
	}
}
