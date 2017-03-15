package com.JavaWebDriverGit.InitialSetup;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class ReadConfig {
//https://www.slideshare.net/eneldoserrata/git-49020118
	//https://git-scm.com/book/en/v2/
	//https://git-scm.com/book/en/v2/Getting-Started-First-Time-Git-Setup
	String result = "";
	InputStream inputStream;
 
	public String getPropValues() throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			Date time = new Date(System.currentTimeMillis());
 
			// get the property value and print it out
			String browser = prop.getProperty("browser");
			String url = prop.getProperty("url");
			
			result = "Browser = " + browser + ", URL = " + url;
			System.out.println(result + "\nProgram Ran on " + time);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
		
	}
