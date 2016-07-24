package com.vaizn.data.busi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.vaizn.common.vo.LigerPageVo;
import com.vaizn.data.busi.dal.entity.DescriptionInfo;
import com.vaizn.data.busi.service.promotion.IDescriptionService;
import com.vaizn.data.dto.promotion.DescInfoRequest;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {
	@Autowired
	private IDescriptionService descriptionService;
	
	@RequestMapping(path = "/desc", method = RequestMethod.GET)
	public String descInfoListPage() throws Exception {
		return "/products/descInfoList";
	}
	
	@RequestMapping(path = "/descList", method = RequestMethod.POST)
	@ResponseBody
	public LigerPageVo<DescriptionInfo> descList(@RequestBody DescInfoRequest request) throws Exception {
		PageInfo<DescriptionInfo> pages = descriptionService.queryDescInfoByPage(request);
		LigerPageVo<DescriptionInfo> ligerPage = new LigerPageVo<DescriptionInfo>(pages.getList(), pages.getTotal());
		
		return ligerPage;
	}
}
