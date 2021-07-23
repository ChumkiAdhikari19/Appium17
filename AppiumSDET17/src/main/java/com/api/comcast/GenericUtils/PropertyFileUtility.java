package com.api.comcast.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility  {


		public String ReadDataFromPropertyFile(String key) throws IOException {
			FileInputStream file=new FileInputStream(IPathConstants.PROPERTYFILEPATH);
			Properties pro = new Properties();
			pro.load(file);
			String value=pro.getProperty(key);
			return value;
			
		}
	}

	


