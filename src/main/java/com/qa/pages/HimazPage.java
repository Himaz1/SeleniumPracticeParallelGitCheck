package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.testbase.TestBase;

import java.time.Duration;

public class HimazPage extends TestBase {

    // Web elements on the login page
    @FindBy(xpath = "//button[@id='login']")
    WebElement btn_login;

    @FindBy(xpath = "//input[@id='userName']")
    WebElement tf_username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement tf_password;

    @FindBy(xpath = "//button[@id='login']")
    WebElement btn_loginTwo;

    // Constructor that initializes the page elements using PageFactory
    public HimazPage() {
        // Initialize WebElements for the current page
        PageFactory.initElements(getDriver(), this); // Using getDriver() for thread safety in parallel execution
    }

    // Method to return the title after login
    public String getTitleAfterLogin() {
        return getDriver().getTitle();
    }

    // Login method that accepts username and password
    public HomePage login(String username, String pass) {
        // Wait for the first login button to be clickable, then click it
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(btn_login)).click();

        // Wait for username field to be visible and send username
        wait.until(ExpectedConditions.visibilityOf(tf_username)).sendKeys(username);

        // Wait for password field to be visible and send password
        wait.until(ExpectedConditions.visibilityOf(tf_password)).sendKeys(pass);

        // Wait for the second login button to be clickable, then click it
        wait.until(ExpectedConditions.elementToBeClickable(btn_loginTwo)).click();

        // Return a new HomePage object after login
        return new HomePage();
    }
}

