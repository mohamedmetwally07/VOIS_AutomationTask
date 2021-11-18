package com.automationpractice.tests;

import Data.JSONDataReader;
import com.automationpractice.pages.AuthenticationPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class RegistrationTest extends BaseTest {

    public RegistrationTest() throws IOException {
        super();
    }

    Faker faker = new Faker();                              //Generate fake mail for Registration
    public String email = faker.internet().emailAddress();

    @Test(priority = 1)
    public void CreateNewAccount() throws IOException, ParseException {

        HomePage homeObj = PageFactory.initElements(driver, HomePage.class);
        homeObj.openLoginPage();

        AuthenticationPage authObj = PageFactory.initElements(driver, AuthenticationPage.class);
        authObj.send_email_to_create_new_account(email);

        RegistrationPage regObj = PageFactory.initElements(driver, RegistrationPage.class);
        regObj.genderSelect();

        JSONDataReader jsonReader = new JSONDataReader();
        jsonReader.JsonReader();

        regObj.RegisterNewUser(jsonReader.firstname, jsonReader.lastname, email, jsonReader.password, jsonReader.address, jsonReader.city, jsonReader.postalCode, jsonReader.mobile);

        Assert.assertTrue(homeObj.signOutBtn.isDisplayed());

        homeObj.signOutFunc();
    }
}