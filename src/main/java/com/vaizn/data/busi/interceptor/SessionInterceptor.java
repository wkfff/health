package com.vaizn.data.busi.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.vaizn.data.busi.dal.entity.SysUser;

public class SessionInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
							HttpServletResponse response, Object obj) throws Exception {
		SysUser user = (SysUser)request.getSession().getAttribute("user");
		if (null == user) {
			logger.info("==================登录超时,跳转到登录界面=================");
			request.getRequestDispatcher("/signin/page").forward(request, response);
			return false;
		} else
			return true;
	}
	
	/**
	 * 视图渲染前处理
	 */
	@Override
	public void postHandle(HttpServletRequest request,
							HttpServletResponse response,
							Object object, ModelAndView model) throws Exception {
		
	}
	
	/**
	 * 回调函数，视图渲染完毕时回调
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
								HttpServletResponse response,
								Object object, Exception e) throws Exception {
		
	}

}
