package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

    @FindBy(className = "lnk_view")
    public WebElement productDetails;

    @FindBy(className = "button-plus")
    WebElement plusBtn;

    @FindBy(id = "group_1")
    WebElement sizeMenu;

    @FindBy(id = "color_8")
    WebElement whiteColor;

    @FindBy(xpath = "//button[@name='Submit']")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutBtn;

    @FindBy(id = "layer_cart_product_title")
    public WebElement addedToCartMsg;

    public void chooseProduct() {
        productDetails.click();
    }

    public void increaseQuantity() {
        plusBtn.click();
    }

    public void selectSize() {
        Select largeSize = new Select(sizeMenu);
        sizeMenu.click();
        largeSize.selectByIndex(2);
    }

    public void changeColor() {
        whiteColor.click();
    }

    public void addToCart() {
        addToCartBtn.click();
    }

    public void proceedToCheckout() {
        proceedToCheckoutBtn.click();
    }
}
