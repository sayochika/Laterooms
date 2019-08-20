package com.laterooms.helper;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Helper 
{
	private static WebDriver driver;
	private static WebElement LateroomsLogo;
	private static WebElement SearchField;
	private static WebElement OccupancySelector;
	private static WebElement SubmitButton;
	private static WebElement SearchResultHeader;
	
	static
	{
		driver = null;
	}
	
	public static void OpenBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void CloseBrowser()
	{
		driver.close();
		driver.quit();
	}
	
	public static void GivenINavigateToLateroomsHomepage() throws Exception
	{
		driver.navigate().to("http://www.laterooms.com/en/home");
		Thread.sleep(5000);
	}
	
	public static void AndIAmOnLateroomsHomepage()
	{
		LateroomsLogo = driver.findElement(By.className("logo"));
		Assert.assertTrue(LateroomsLogo.isDisplayed());
	}
	
	public static void WhenIEnterADestinationToTheSearchField(String destination)
	{
		SearchField = driver.findElement(By.id("destinationSearch"));
		SearchField.sendKeys(destination);
	}
	
	public static void AndISelectAnOccupanyOption(String option) throws Exception
	{
		OccupancySelector = driver.findElement(By.className("occupancy"));
		Select occupancyOption = new Select(OccupancySelector);
		occupancyOption.selectByVisibleText(option);
		Thread.sleep(5000);
	}
	
	public static void AndIClickOnSubmitButton() throws Exception
	{
		SubmitButton = driver.findElement(By.cssSelector(".cta-button.search"));
		SubmitButton.click();
		Thread.sleep(5000);
	}
	
	public static void AndISeeDestinationResultPage(String result)
	{
		SearchResultHeader = driver.findElement(By.className("search-results__heading"));
		String headerText = SearchResultHeader.getText();
		
		Assert.assertTrue(headerText.contains(result));
	}
	
}
