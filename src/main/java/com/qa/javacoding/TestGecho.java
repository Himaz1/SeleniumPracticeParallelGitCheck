package com.qa.javacoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestGecho {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "D:\\backup2\\Softwares\\latestGecho\\geckodriver-v0.35.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

}
