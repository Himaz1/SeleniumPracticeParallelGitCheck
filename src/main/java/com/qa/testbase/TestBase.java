package com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.qa.util.TestUtil;

public class TestBase {
    // Declare the ThreadLocal WebDriver
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static Properties prop;

    // Constructor to load the properties file
    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("D:\\HimPrac\\ProOneClone\\HimDemo\\gitcheck\\src\\main\\java\\com\\qa\\config\\config.property");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 // Correct WebDriver initialization in TestBase.java
    public static void initialization(String browser) {
        String browserName = browser != null ? browser : prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            String chromeDriverPath = prop.getProperty("chrome.driver.path");
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver.set(new ChromeDriver()); // Correct usage of ThreadLocal set method
        } else if (browserName.equalsIgnoreCase("firefox")) {
            String geckoDriverPath = prop.getProperty("gecko.driver.path");
            System.setProperty("webdriver.gecko.driver", geckoDriverPath);
            driver.set(new FirefoxDriver()); // Correct usage of ThreadLocal set method
        } 
//        else if (browserName.equalsIgnoreCase("ie")) {
//            String ieDriverPath = prop.getProperty("ie.driver.path");
//            System.setProperty("webdriver.ie.driver", ieDriverPath);
//
//            // Use InternetExplorerOptions for IE configuration
//            InternetExplorerOptions options = new InternetExplorerOptions();
//            options.ignoreZoomSettings();  // Example option to handle zoom settings in IE
//            driver.set(new InternetExplorerDriver(options)); // Correct usage of ThreadLocal set method
//        } 
        else {
            System.out.println("Browser not supported");
            return;
        }

        // WebDriver configuration
        driver.get().manage().window().maximize();
        driver.get().manage().deleteAllCookies();
        driver.get().manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT);
        driver.get().manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT);
        driver.get().get(prop.getProperty("url"));
    }
    // Add a getter method to retrieve the WebDriver instance in tests
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Cleanup method to quit the driver after tests
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // Clean up the thread-local reference
        }
    }
}
