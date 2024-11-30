package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.SearchPage;
import com.qa.testbase.TestBase;

public class SearchPageTest extends TestBase{
	public SearchPage searchPage;
	
	public SearchPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		//initialization();
		searchPage = new SearchPage();
		
	}
	
	@Test
	public void verifySearch() throws InterruptedException
	{
		searchPage.enterSearchValue();
	}
	
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.close();
//	}

}
