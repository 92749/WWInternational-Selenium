package com.WWInternational.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	//Create driver object
	WebDriver ldriver;
	
	//Constructor to initiate webdriver
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
}
