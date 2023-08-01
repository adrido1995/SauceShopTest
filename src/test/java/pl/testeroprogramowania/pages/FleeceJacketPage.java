package pl.testeroprogramowania.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger();
    public FleeceJacketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CartPage addToCart() {
        logger.info("adding 'Fleece Jacket' to the cart");
        addToCartButton.click();
        cartLink.click();
        return new CartPage(driver);
    }
}
