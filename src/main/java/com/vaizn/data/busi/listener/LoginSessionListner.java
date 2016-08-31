package com.vaizn.data.busi.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaizn.data.busi.dal.entity.SysUser;
import com.vaizn.utils.LoginUtils;

/**
 * 登录会话监听器
 * @author 关志伟
 *
 */
public class LoginSessionListner implements HttpSessionAttributeListener {
	
	protected static Logger logger = LoggerFactory.getLogger(LoginSessionListner.class);
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		if ("user".equals(event.getName())) {
			LoginUtils.initLoginUser((SysUser)event.getValue());
		}
	}
	
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		if ("user".equals(event.getName())) {
			LoginUtils.initLoginUser((SysUser)event.getValue());
		}
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
	}
	
}
