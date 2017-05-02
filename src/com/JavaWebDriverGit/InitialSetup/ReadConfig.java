package com.JavaWebDriverGit.InitialSetup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class ReadConfig {
	//https://www.slideshare.net/eneldoserrata/git-49020118
	//https://git-scm.com/book/en/v2/
	//https://git-scm.com/book/en/v2/Getting-Started-First-Time-Git-Setup
	String result = "";
	static String projPath = System.getProperty("user.dir");
	FileInputStream fis;

	//InputStream inputStream;

	public String getPropValues() throws IOException {

		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";

			//inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			fis = new FileInputStream(projPath + "/resources/config.properties");

			if (fis != null) {
				prop.load(fis);
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
			fis.close();
		}
		return result;
	}

}
