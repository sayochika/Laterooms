package com.laterooms.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.laterooms.helper.Helper;

public class SelectAHotelFromLaterooms 
{
	@Before
	public void Initialize()
	{
		Helper.OpenBrowser();
	}
	
	@After
	public void TearDown()
	{
		Helper.CloseBrowser();
	}
	
	@Test
	public void SelectAHotelFromLateroomsTest() throws Exception
	{
		Helper.GivenINavigateToLateroomsHomepage();
		Helper.AndIAmOnLateroomsHomepage();
		Helper.WhenIEnterADestinationToTheSearchField("Manchester");
		Helper.AndISelectAnOccupanyOption("2 Adults");
		Helper.AndIClickOnSubmitButton();
		Helper.AndISeeDestinationResultPage("Manchester");
	}
}
