package com.vaizn.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtils implements ApplicationContextAware {

	private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		ApplicationContextUtils.context = ctx;
	}
	
	public static <T> T getBean(Class<T> cls) {
		return context.getBean(cls);
	}

}
