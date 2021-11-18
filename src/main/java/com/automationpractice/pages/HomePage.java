package com.automationpractice.pages;

import com.automationpractice.pages.AuthenticationPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AuthenticationPage {

    @FindBy(linkText = "Sign in")
    public WebElement signInBtn;

    @FindBy(linkText = "Sign out")
    public WebElement signOutBtn;

    @FindBy(className = "sf-with-ul")
    public WebElement womenCtg;

    @FindBy(linkText = "Blouses")
    public WebElement blouses;

    public void openLoginPage() //method to open login page
    {
        signInBtn.click();
    }

    public void signOutFunc() //method to open login page
    {
        signOutBtn.click();
    }
}
