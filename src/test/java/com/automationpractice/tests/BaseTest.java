package com.automationpractice.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public static Properties prop;
    static String configPath = System.getProperty("user.dir") + "/configs/config.properties"; // Path for config properties file

    public BaseTest() throws IOException    //Constructor for initialization property file
    {
        prop = new Properties();
        FileInputStream file = new FileInputStream(configPath);
        prop.load(file);
    }

    @Parameters({"browser"})
    @BeforeSuite
    public void startDriver(@Optional("chrome") String browserName)  //Starting driver with specific browser
    {
        if (browserName.equalsIgnoreCase("chrome"))          //Applying chrome driver
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().setPosition(new Point(0, 0));
            driver.manage().window().setSize(new Dimension(1024, 768)); //Set the required dimensions
            driver.get(prop.getProperty("URL"));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else if (browserName.equalsIgnoreCase("firefox"))   //Applying firefox driver
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().setPosition(new Point(0, 0));
            driver.manage().window().setSize(new Dimension(1024, 768));
            driver.get(prop.getProperty("URL"));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else if (browserName.equalsIgnoreCase("internetExplorer")) //Applying Internet Explorer
        {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            driver.manage().window().setPosition(new Point(0, 0));
            driver.manage().window().setSize(new Dimension(1024, 768));
            driver.get(prop.getProperty("URL"));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    @AfterMethod    //Take screenshot in case of failing with method name
    public void takeScreenShotOnFailureAndCloseBrowser(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("errorScreenshots/" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + ".png"));
        }

    }

    @AfterSuite
    public void teardown() {
        driver.quit();

    }
}
