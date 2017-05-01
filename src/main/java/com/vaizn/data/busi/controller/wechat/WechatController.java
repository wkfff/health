package com.vaizn.data.busi.controller.wechat;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vaizn.data.busi.controller.BaseController;
import com.vaizn.utils.SHAUtils;

@Controller
@RequestMapping("/wechat")
public class WechatController extends BaseController {

	protected static Logger logger = LoggerFactory.getLogger(WechatController.class);
	
	private String Token = "OurHealth";
	
	/**
	 * 验证微信服务器
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @throws Exception
	 */
	@RequestMapping(path = "/sourceValidate", method = RequestMethod.GET)
	@ResponseBody
	public String msgSourceValidate(@RequestParam String signature,
								@RequestParam String timestamp,
								@RequestParam String nonce,
								@RequestParam String echostr) throws Exception {
		logger.info("检查信息来源 signature:{},timestamp:{},nonce:{},echostr:{}",signature,timestamp,nonce,echostr);
		String[] strarry = {Token, timestamp, nonce};
		//字典排序
		Arrays.sort(strarry);
		String bigStr = strarry[0] + strarry[1] + strarry[2];
		String endcodeStr = SHAUtils.shaEndcode(bigStr);
		logger.info("加密后字符串:{}",endcodeStr);
		if (endcodeStr.equals(signature.toUpperCase()))
			return echostr;
		else
			return null;
	}
	
	@RequestMapping(path = "/shortBuyPage", method = RequestMethod.GET)
	public String shortBuyPage() throws Exception {
		return "/wechat/shortBuy";
	}
}
