package com.vaizn.data.busi.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.vaizn.data.busi.dal.entity.SysUser;
import com.vaizn.utils.LoginUtils;

public class SessionInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);
	
	private List<String> excludedUrls;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
							HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		//不拦截静态资源
		if (uri.endsWith(".js") || uri.endsWith(".css")
				|| uri.endsWith(".jpg")
				|| uri.endsWith(".png")
				|| uri.endsWith(".gif")) {
			return true;
		}
		if (null != excludedUrls && !excludedUrls.isEmpty()) {
			for (String str : excludedUrls) {
				//包含该URI则不拦截当前请求地址
				if (uri.indexOf(str) != -1)
					return true;
			}
		}
		SysUser user = (SysUser)request.getSession().getAttribute("user");
		if (null == user) {
			logger.info("==================登录超时,跳转到登录界面=================");
			request.getRequestDispatcher("/pages/common/signIn.jsp").forward(request, response);
			return false;
		} else {
			LoginUtils.initLoginUser(user);
			return true;
		}
	}
	
	/**
	 * 视图渲染前处理
	 */
	@Override
	public void postHandle(HttpServletRequest request,
							HttpServletResponse response,
							Object handler, ModelAndView model) throws Exception {
		
	}
	
	/**
	 * 回调函数，视图渲染完毕时回调
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
								HttpServletResponse response,
								Object handler, Exception e) throws Exception {
		
	}

	public List<String> getExcludedUrls() {
		return excludedUrls;
	}

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

}
