package com.automationpractice.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected static WebDriver driver;
    public Actions Action;

    public BasePage(WebDriver driver)  //constructor
    {
        PageFactory.initElements(driver, this);
    }

    public BasePage() {

    }

    public static void clickOnButton(WebElement button) //method to click on element
    {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", button);
    }

    public static void setTextElementText(WebElement textElement, String value) //method to send text to element
    {
        textElement.sendKeys(value);
    }
}
