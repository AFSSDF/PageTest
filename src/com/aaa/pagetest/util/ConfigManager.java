package com.aaa.pagetest.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author Li
 *	读取配置文件类
 */
public class ConfigManager {
	private static ConfigManager configManager;
	private static Properties properties;
	
	private ConfigManager(){
		String fileName="database.properties";
		properties=new Properties();
		InputStream is=ConfigManager.class.getClassLoader().getResourceAsStream(fileName);
		try {
			properties.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ConfigManager getInstance() {
        if(configManager==null){  
            configManager = new ConfigManager();  
        }  
        return configManager ;
	}
	static{
		getInstance();
	}
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
