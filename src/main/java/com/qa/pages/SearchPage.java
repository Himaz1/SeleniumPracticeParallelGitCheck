package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.testbase.TestBase;

public class SearchPage extends TestBase{
	
	@FindBy (xpath = "//textarea[@title='Search']")
	WebElement tf_textArea;
	
	public SearchPage()
	{
		//PageFactory.initElements(driver, this);
	}
	
	public void enterSearchValue() throws InterruptedException
	{
		tf_textArea.sendKeys("testing tools");
	}

}
