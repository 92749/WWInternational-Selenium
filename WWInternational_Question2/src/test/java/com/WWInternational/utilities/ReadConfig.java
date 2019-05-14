package com.WWInternational.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig()
	{
		File src = new File("./Configurationfiles/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) 
		{
			System.out.println("***Exception is "+e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getFirefoxPath()
	{
		String ffpath = prop.getProperty("firefoxpath");
		return ffpath;
	}
	
	public String getMeeting()
	{
		String meetingid = prop.getProperty("meetingid");
		return meetingid;
	}
	
	public String meetingsearchURL()
	{
		String meetingsearchurl = prop.getProperty("meetingsearchURL");
		return meetingsearchurl;
	}

}
