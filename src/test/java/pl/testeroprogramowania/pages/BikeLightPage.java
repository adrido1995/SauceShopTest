package pl.testeroprogramowania.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BikeLightPage {

    @FindBy(xpath = "//button[@data-test='add-to-cart-sauce-labs-bike-light']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartLink;

    @FindBy(id = "back-to-products")
    private WebElement backToProductsButton;
    WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public BikeLightPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CartPage addToCart() {
        logger.info("adding 'Bike Light' to the cart");
        addToCartButton.click();
        cartLink.click();
        return new CartPage(driver);
    }

    public ShopPage addToCartAndBackToProduct() {
        logger.info("adding 'Bike Light' to the cart");
        addToCartButton.click();
        logger.info("Back to products list page");
        backToProductsButton.click();
        return new ShopPage(driver);
    }
}
