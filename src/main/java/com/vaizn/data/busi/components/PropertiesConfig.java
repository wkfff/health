package com.vaizn.data.busi.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesConfig {

	@Value("#{propertyFactory['jdbc.database']}")
	private String dbAdapter;
	
	@Value("#{propertyFactory['conf.userPicRootPath']}")
	private String userPicRootPath;
	
	@Value("#{propertyFactory['conf.projectPath']}")
	private String projectPath;

	public String getDbAdapter() {
		return dbAdapter;
	}

	public String getUserPicRootPath() {
		return userPicRootPath;
	}

	public String getProjectPath() {
		return projectPath;
	}
}
