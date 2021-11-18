package com.automationpractice.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import com.automationpractice.pages.ProductPage;
import com.automationpractice.pages.HomePage;

public class ProductTest extends BaseTest {

    public ProductTest() throws IOException {
    }

    @Test(priority = 3)
    public void selectProductTest() {
        Actions action = new Actions(driver);
        HomePage homeObj = PageFactory.initElements(driver, HomePage.class);
        ProductPage productObj = PageFactory.initElements(driver, ProductPage.class);

        action.moveToElement(homeObj.womenCtg);
        action.build().perform();

        action.moveToElement(homeObj.blouses);
        action.click().build().perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", productObj.productDetails);
        productObj.chooseProduct();

        productObj.increaseQuantity();
        productObj.selectSize();
        productObj.changeColor();

        js.executeScript("arguments[0].scrollIntoView();", productObj.addToCartBtn);
        productObj.addToCart();
        productObj.proceedToCheckout();
    }
}
