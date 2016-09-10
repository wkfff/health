package com.vaizn.data.busi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.vaizn.common.BaseException;
import com.vaizn.common.vo.LigerPageVo;
import com.vaizn.data.busi.dal.entity.DescriptionInfo;
import com.vaizn.data.busi.service.promotion.IDescriptionService;
import com.vaizn.data.dto.common.BaseResponseDto;
import com.vaizn.data.dto.product.DescInfoRequest;
import com.vaizn.data.dto.product.DescSaveRequest;
import com.vaizn.utils.LoginUtils;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {
	
	protected static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private IDescriptionService descriptionService;
	
	@RequestMapping(path = "/desc", method = RequestMethod.GET)
	public String descInfoListPage() throws Exception {
		return "/products/descInfoList";
	}
	
	@RequestMapping(path = "/desc/addModiPage", method = RequestMethod.GET)
	public String descAddPage(Model model) throws Exception {
		model.addAttribute("userAccount", LoginUtils.currentLoginUser().getUserAccount());
		return "/products/addModiPage";
	}
	
	@RequestMapping(path = "/descList", method = RequestMethod.POST)
	@ResponseBody
	public LigerPageVo<DescriptionInfo> descList(@RequestBody DescInfoRequest request) throws Exception {
		PageInfo<DescriptionInfo> pages = descriptionService.queryDescInfoByPage(request);
		LigerPageVo<DescriptionInfo> ligerPage = new LigerPageVo<DescriptionInfo>(pages.getList(), pages.getTotal());
		
		return ligerPage;
	}
	
	@RequestMapping(path = "/saveProductDesc", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseDto saveProductDesc(@RequestBody DescSaveRequest request) throws Exception {
		BaseResponseDto response = null;
		try {
			response = descriptionService.saveDescInfoData(request);
		} catch(BaseException e) {
			logger.error("保存信息文章时出错", e);
			response = new BaseResponseDto("1001", "保存失败");
		}
		return response;
	}
}
