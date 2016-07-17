package com.vaizn.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 自动生成代码
 * @author gzw
 *
 */
public class MybatisGenerator {

	public static void main(String[] args) {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config;
		try(InputStream is = MybatisGenerator.class.getResourceAsStream("/generatorConfig.xml");) {
			config = cp.parseConfiguration(is);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			System.out.println("=========成功执行========");
		} catch (IOException
				| XMLParserException
				| InvalidConfigurationException
				| InterruptedException
				| SQLException e) {
			e.printStackTrace();
		}
		
	}

}
