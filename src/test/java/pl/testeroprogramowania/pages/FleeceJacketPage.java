package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FleeceJacketPage {

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addToCartButton;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartLink;
    WebDriver driver;

    public FleeceJacketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CartPage addToCart() {
        addToCartButton.click();
        cartLink.click();
        return new CartPage(driver);
    }
}
