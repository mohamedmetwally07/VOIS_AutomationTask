package com.automationpractice.tests;

import Data.JSONDataReader;
import com.automationpractice.pages.AuthenticationPage;
import com.automationpractice.pages.HomePage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AuthenticationTest extends RegistrationTest {

    public AuthenticationTest() throws IOException {
        super();
    }

    @Test(priority = 2)
    public void loginTest() throws IOException, ParseException {

        HomePage homeObj = PageFactory.initElements(driver, HomePage.class);
        homeObj.openLoginPage();

        AuthenticationPage authObj = PageFactory.initElements(driver, AuthenticationPage.class);

        JSONDataReader jsonReader = new JSONDataReader();
        jsonReader.JsonReader();

        authObj.login_user(email, jsonReader.password); //Passing the generated email to log in function
        Assert.assertTrue(homeObj.signOutBtn.isDisplayed());
    }
}
