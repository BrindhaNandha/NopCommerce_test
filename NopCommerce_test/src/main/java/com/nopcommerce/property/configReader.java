package com.nopcommerce.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {

	FileInputStream fi;
	public Properties getTheProperty() {
		File f = new File ("C:\\Users\\snk27\\eclipse-workspace\\NopCommerce_test\\src\\main\\java\\com\\nopcommerce\\property\\config.properties");
		try {
			fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop =new Properties();
		try {
			prop.load(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	public String getBrowser() {
		String browser = getTheProperty().getProperty("browser");
		return browser;
		
	}
	public String getURL() {
		String url = getTheProperty().getProperty("url");
		return url;
	}
	public String getUserName() {
		String name = getTheProperty().getProperty("username");
		return name;
	}
	public String getPwd() {
		String pwd = getTheProperty().getProperty("password");
		return pwd;
	}
	
}
