package com.WWInternational.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FindStudio {

	//Create driver object
	WebDriver ldriver;
	
	//Constructor to initiate webdriver
	public FindStudio(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="meetingSearch")
	@CacheLookup
	WebElement txtMeetingSearch;
	
	public void searchMeeting(String meeting)
	{
		txtMeetingSearch.sendKeys(meeting);
	}
	
}
