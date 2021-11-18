package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage {
    @FindBy(id = "email_create")
    public WebElement createEmail;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountBtn;

    @FindBy(id = "email")
    public WebElement emailAddress;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "SubmitLogin")
    WebElement loginBtn;

    @FindBy(xpath = "//a[@title='View my customer account']")
    public WebElement confirmUserLogin;

    public AuthenticationPage() {
        super();

    }

    public void send_email_to_create_new_account(String email) {
        createEmail.sendKeys(email);
        createAccountBtn.click();
    }

    public void login_user(String email, String password) {
        emailAddress.sendKeys(email);
        this.password.sendKeys(password);
        loginBtn.click();
    }

}
