package com.vaizn.data.busi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

	@RequestMapping(path = "/promotion", method={RequestMethod.POST,RequestMethod.GET})
	public String promotionListPage() throws Exception {
		return "/products/promotionList";
	}
}
