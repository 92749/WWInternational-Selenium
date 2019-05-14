package com.WWInternational.testCases;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.WWInternational.pageObjects.FindStudio;
import com.WWInternational.pageObjects.HomePage;

import junit.framework.Assert;

public class Test_001 extends BaseClass
{
	@Test
	public void verifyPage() throws InterruptedException
	{
		driver.get(baseUrl);
		FindStudio fs = new FindStudio(driver);
		
		if(driver.getTitle().equals("WW (Weight Watchers): Weight Loss & Wellness Help"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	
		//to search for a studio in a given location
		driver.findElement(By.linkText("Find a Studio")).click();
		Thread.sleep(10000);
	
		if(driver.getTitle().contains("Find WW"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	
		fs.searchMeeting(meetingid);
		driver.findElement(By.name("meetingSearch")).submit();
		driver.get(baseUrl+meetingsearchUrl+meetingid);
		Thread.sleep(5000);
		List list = driver.findElements(By.xpath("//div[@class='meeting-locations-list__item']"));
		Thread.sleep(5000);
		//to get nearest location details
		System.out.println("This page contains : "+list.size()+" locations");
	
		if(list.size() > 0)
		{
			String locationID = driver.findElement(By.xpath("//div[@class='meeting-locations-list__item']")).getAttribute("id");
			String locationName =  driver.findElement(By.xpath("//div[@class='meeting-locations-list__item']")).getAttribute("location__name");
			String distance =  driver.findElement(By.xpath("//div[@class='meeting-locations-list__item']")).getAttribute("location__distance");
			System.out.println("Nearest Location is : "+ locationName+" It is "+distance+" away from "+meetingid);
			driver.findElement(By.xpath("//div[@id='"+locationID+"']")).click();
			Calendar calendar = Calendar.getInstance();
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			//to print schedule
			String h=driver.findElement(By.cssSelector("#content > div > div > ui-view > ui-view > div.meeting-detail > "
			+ "div.meeting-detail-bottom-container.container-fluid > div > div > div.meeting-detail-bottom-top > "
			+ "div > div > schedule-detailed > div > div:nth-child("+dayOfWeek+") > "
			+ "div.schedule-detailed-day-meetings")).getText();
			System.out.println("schedule:" + h);

		}
	}
	
}
