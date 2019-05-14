  package com.WWInternational.testCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.WWInternational.utilities.ReadConfig;
  
public class BaseClass {
	//all common code for every testcase
	ReadConfig readconfig = new ReadConfig();
	
	public String baseUrl=readconfig.getApplicationURL();
	public static WebDriver driver;
	public String meetingid=readconfig.getMeeting();
	public String meetingsearchUrl=readconfig.meetingsearchURL();
	
	@BeforeClass
	public void setup()
	{

		System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
		//Instantiate driver
		driver = new FirefoxDriver();
		
		//Maximize browser window
		driver.manage().window().maximize();

	}

	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

	
}
