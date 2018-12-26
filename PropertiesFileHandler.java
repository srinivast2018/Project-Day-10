package com.ibm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class PropertiesFileHandler {
	public HashMap<String, String> getPropertiesAsMap(String file) throws IOException {
		HashMap<String, String> magentoMap = new HashMap<String, String>();

		FileInputStream fileIn = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileIn);

		Set<Object> keysProp = prop.keySet();
		for (Object key : keysProp) {
			magentoMap.put(key.toString(), prop.getProperty(key.toString()));
		}
		prop.clear();
		return magentoMap;
	}
	
	public void setKeyAndValue(String file,String key,String value) throws IOException
	{
		FileInputStream fileIn = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileIn);

		prop.setProperty(key, value);

		FileOutputStream fOut=new FileOutputStream(file);
		prop.store(fOut, "Test Result");
		fOut.close();
		fileIn.close();
	}

}
