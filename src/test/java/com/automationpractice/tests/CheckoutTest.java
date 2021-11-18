package com.automationpractice.tests;

import java.io.IOException;

import com.automationpractice.pages.CheckoutPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    public CheckoutTest() throws IOException {
    }

    @Test(priority = 4)
    public void checkoutProcedure() {

        CheckoutPage chkObj = PageFactory.initElements(driver, CheckoutPage.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView();", chkObj.summary_CheckoutBtn);
        chkObj.summaryStep();

        js.executeScript("arguments[0].scrollIntoView();", chkObj.address_CheckoutBtn);
        chkObj.addressStep();

        js.executeScript("arguments[0].scrollIntoView();", chkObj.termsCheckbox);
        chkObj.termsAndConditionsAgree();

        js.executeScript("arguments[0].scrollIntoView();", chkObj.shipping_CheckoutBtn);
        chkObj.shippingStep();

        js.executeScript("arguments[0].scrollIntoView();", chkObj.payByBankWire);
        chkObj.bankPayment();

        js.executeScript("arguments[0].scrollIntoView();", chkObj.confirmMyOrderBtn);
        chkObj.confirmOrder();

        js.executeScript("arguments[0].scrollIntoView();", chkObj.backToOrdersBtn);
        chkObj.backToOrderHistoryPage();

        String expectedResult = "Here are the orders you've placed since your account was created.";
        String actualResult = chkObj.ChkOrderHistoryPage.getText();
        System.out.print(actualResult);
        Assert.assertEquals(actualResult,expectedResult);
    }
}
