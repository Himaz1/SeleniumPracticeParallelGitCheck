package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.lib.ExcelDataConfig;
import com.qa.pages.HimazPage;
import com.qa.testbase.TestBase;

public class ChromeTest extends TestBase{
	HimazTestPage himazTestPage;
	HimazPage himazPage;

    public ChromeTest() {
        super(); // Initialize properties from TestBase
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser) {
        // Ensure the browser is passed from the TestNG XML
        //prop.setProperty("browser", browser); // Dynamically set the browser
        initialization(browser); // Initialize WebDriver based on the browser in the config fil	e
        himazTestPage = new HimazTestPage();
		himazPage = new HimazPage(); // Initialize the page object
    }

    @Test(dataProvider = "userDetails")
    public void verifyLogin(String username, String pass) throws InterruptedException {
        // Perform login and verify the title after successful login
    	himazTestPage = new HimazTestPage();
		himazPage = new HimazPage();
		himazPage.login(username, pass);
		Thread.sleep(3000);
		String afterLoginTitle = himazPage.getTitleAfterLogin();
        Assert.assertEquals(afterLoginTitle, "DEMOQA", "Title Not Found after Login");
    }

    @DataProvider(name = "userDetails")
    public Object[][] passContactDetails() throws Exception {
        // Fetch test data from the Excel file
        ExcelDataConfig config = new ExcelDataConfig("D:\\HimPrac\\ProOneClone\\HimDemo\\gitcheck\\src\\main\\java\\com\\qa\\testdata\\testData.xlsx");
        int rows = config.getRowCount(0);
        Object[][] arrUserDetails = new Object[rows][2];

        for (int i = 0; i < rows; i++) {
            arrUserDetails[i][0] = config.getData(0, i, 0); // Username
            arrUserDetails[i][1] = config.getData(0, i, 1); // Password
        }
        return arrUserDetails;
    }
    
    @Test
    public void testMethodOne()
    {
    	System.out.println("Test method one");
    }
    
    @Test
    public void testMethodTwo()
    {
    	System.out.println("Test method two");
    }
    
    @Test
    public void testMethodThree()
    {
    	System.out.println("Test method three");
    }
    
    @Test
    public void testMethodFour()
    {
    	System.out.println("Test method four");
    }
    
    @Test
    public void testMethodFive()
    {
    	System.out.println("Test method five");
    }
    
    @Test
    public void testMethodSix()
    {
    	System.out.println("Test method six");
    }
    
    @Test
    public void testMethodSeven()
    {
    	System.out.println("Test method seven");
    }
    
    @Test
    public void testMethodEight()
    {
    	System.out.println("Test method eight");
    }
    
    @Test
    public void testMethodNine()
    {
    	System.out.println("Test method nine");
    }
    
    @Test
    public void testMethodTen()
    {
    	System.out.println("Test method ten");
    }

    @AfterMethod
    public void cleanUp() {
        // Close the browser after each test method
    	if (driver.get() != null) {
            driver.get().quit(); // Quit driver instance properly after each test
            driver.remove(); // Remove the ThreadLocal reference to prevent memory leaks
        }
    }

}
