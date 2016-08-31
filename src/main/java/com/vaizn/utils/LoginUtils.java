package com.vaizn.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaizn.data.busi.dal.entity.SysUser;

public class LoginUtils {

	protected static Logger logger = LoggerFactory.getLogger(LoginUtils.class);
	
	//创建线程局部变量
	private static ThreadLocal<SysUser> threadLocal = new ThreadLocal<SysUser>();
	
	public static void initLoginUser(SysUser user) {
		threadLocal.set(user);
	}
	
	public static SysUser currentLoginUser() {
		return threadLocal.get();
	}
}
