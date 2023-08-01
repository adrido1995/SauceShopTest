package pl.testeroprogramowania.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage {
    @FindBy(linkText = "Sauce Labs Bike Light")
    private WebElement productNameCheck;
    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> productCheckoutList;

    WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement productCheck() {
        logger.info("Checking if the product has been added to the cart");
        return productNameCheck;
    }

    public List<String> getProductCheckoutNameList() {
        return productCheckoutList.stream()
                .map(el -> el.getAttribute("textContent"))
                .collect(Collectors.toList());
    }

    public CheckoutInformationPage checkoutClick() {
        logger.info("Go to the checkout information page");
        checkoutButton.click();
        return new CheckoutInformationPage(driver);
    }


}
