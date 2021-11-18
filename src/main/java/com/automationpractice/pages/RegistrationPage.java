package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_gender1")
    WebElement maleRadioBtn;

    @FindBy(id = "id_gender2")
    WebElement femaleRadioBtn;

    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "days")
    WebElement dayOfBirth;

    @FindBy(id = "months")
    WebElement monthOfBirth;

    @FindBy(id = "years")
    WebElement yearOfBirth;

    @FindBy(id = "firstname")
    WebElement addressFirstName;

    @FindBy(id = "lastname")
    WebElement addressLastName;

    @FindBy(id = "company")
    WebElement companyName;

    @FindBy(id = "address1")
    WebElement addressText;

    @FindBy(id = "city")
    WebElement cityName;

    @FindBy(id = "id_state")
    WebElement stateName;

    @FindBy(id = "postcode")
    WebElement postalCode;

    @FindBy(id = "id_country")
    WebElement countryName;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhone;

    @FindBy(id = "alias")
    WebElement aliasAddress;

    @FindBy(id = "submitAccount")
    WebElement registerBtn;

    public void genderSelect() {
        maleRadioBtn.click();
    }

    public void RegisterNewUser(String fName, String lName, String email, String password, String address, String city, String postal, String phone) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        this.email.clear();
        this.email.sendKeys(email);
        this.password.sendKeys(password);

        Select daySelect = new Select(dayOfBirth);

        dayOfBirth.click();
        daySelect.selectByIndex(10);
        Select monthSelect = new Select(monthOfBirth);
        monthOfBirth.click();
        monthSelect.selectByIndex(5);
        Select yearSelect = new Select(yearOfBirth);
        yearOfBirth.click();
        yearSelect.selectByIndex(4);
        addressText.sendKeys(address);
        cityName.sendKeys(city);

        Select state = new Select(stateName);
        stateName.click();
        state.selectByIndex(5);
        postalCode.sendKeys(postal);
        Select country = new Select(countryName);
        countryName.click();
        country.selectByIndex(1);
        mobilePhone.sendKeys(phone);
        registerBtn.click();
    }
}

