package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

    @FindBy(className = "standard-checkout")
    public WebElement summary_CheckoutBtn;

    @FindBy(xpath = "//button[@name='processAddress']")
    public WebElement address_CheckoutBtn;

    @FindBy(id = "cgv")
    public WebElement termsCheckbox;

    @FindBy(xpath = "//button[@name='processCarrier']")
    public WebElement shipping_CheckoutBtn;

    @FindBy(className = "bankwire")
    public WebElement payByBankWire;

    @FindBy(css = "button.button.btn.btn-default.button-medium")
    public WebElement confirmMyOrderBtn;

    @FindBy(xpath = "//a[@title='Back to orders']")
    public WebElement backToOrdersBtn;

    @FindBy(css="p.info-title")
    public WebElement ChkOrderHistoryPage;

    public void summaryStep() {
        summary_CheckoutBtn.click();
    }

    public void addressStep() {
        address_CheckoutBtn.click();
    }

    public void termsAndConditionsAgree() {
        termsCheckbox.click();
    }

    public void shippingStep() {
        shipping_CheckoutBtn.click();
    }

    public void bankPayment() {
        payByBankWire.click();
    }

    public void confirmOrder() {
        confirmMyOrderBtn.click();
    }

    public void backToOrderHistoryPage() {
        backToOrdersBtn.click();
    }
}
