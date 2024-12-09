package com.qa.javacoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerExample {
	public static void main(String[] args) {

        // Handling Chrome Driver
//        WebDriverManager.chromedriver().setup();  // Automatically downloads and sets up ChromeDriver
//        WebDriver chromeDriver = new ChromeDriver(); // Initializes ChromeDriver instance
//        chromeDriver.get("https://www.google.com");
//        System.out.println("Chrome Title: " + chromeDriver.getTitle());
//        chromeDriver.quit();

        // Handling Firefox Driver
//        WebDriverManager.firefoxdriver().setup(); // Automatically downloads and sets up GeckoDriver
//        WebDriver firefoxDriver = new FirefoxDriver(); // Initializes FirefoxDriver instance
//        firefoxDriver.get("https://www.google.com");
//        System.out.println("Firefox Title: " + firefoxDriver.getTitle());
//        firefoxDriver.quit();

        // Handling Edge Driver
        WebDriverManager.edgedriver().setup(); // Automatically downloads and sets up EdgeDriver
        WebDriver edgeDriver = new EdgeDriver(); // Initializes EdgeDriver instance
        edgeDriver.get("https://www.google.com");
        System.out.println("Edge Title: " + edgeDriver.getTitle());
        edgeDriver.quit();
    }

}
