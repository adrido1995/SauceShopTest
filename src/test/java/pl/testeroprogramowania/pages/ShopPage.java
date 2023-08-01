package pl.testeroprogramowania.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ShopPage {

    @FindBy(linkText = "Sauce Labs Backpack")
    private WebElement productName;

    @FindBy(linkText = "Sauce Labs Bike Light")
    private WebElement bikeLightLink;

    @FindBy(linkText = "Sauce Labs Fleece Jacket")
    private WebElement fleeceJacketLink;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> productList;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> priceList;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortContainer;

    @FindBy(xpath = "//option[@value='az']")
    private WebElement azOption;
    @FindBy(xpath = "//option[@value='za']")
    private WebElement zaOption;

    @FindBy(xpath = "//option[@value='lohi']")
    private WebElement lowToHighOption;

    @FindBy(xpath = "//option[@value='hilo']")
    private WebElement highToLowOption;


    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public ShopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public BikeLightPage openProductBikeLight() {
        logger.info("Opening the product page: 'Bike Light'");
        bikeLightLink.click();
        logger.info("Page opened successfully");
        return new BikeLightPage(driver);
    }

    public FleeceJacketPage openProductFleeceJacket() {
        logger.info("Opening the product page: 'FleeceJacket'");
        fleeceJacketLink.click();
        logger.info("Page opened successfully");
        return new FleeceJacketPage(driver);
    }

    public List<String> AtoZProductList() {
        logger.info("Sorting from a to z");
        sortContainer.click();
        azOption.click();
        return getProductNameList();

    }

    public List<String> ZtoAProductList() {
        logger.info("Sorting from z to a");
        sortContainer.click();
        zaOption.click();
        return getProductNameList();
    }

    public List<String> LowToHighProductList() {
        logger.info("Sorting from low to high price");
        sortContainer.click();
        lowToHighOption.click();
        return getProductPriceList();
    }

    public List<String> HighToLowProductList() {
        logger.info("Sorting from high to low price");
        sortContainer.click();
        highToLowOption.click();
        return getProductPriceList();
    }


    public WebElement LogInCheck() {
        logger.info("Checking for correct login");
        return productName;
    }

    public WebElement getError() {
        logger.info("Checking error Message");
        return errorMessage;
    }

    public List<String> getProductNameList() {
        return productList.stream()
                .map(el -> el.getAttribute("textContent"))
                .collect(Collectors.toList());
    }

    public List<String> getProductPriceList() {

        return priceList.stream()
                .map(el -> el.getAttribute("textContent"))
                .collect(Collectors.toList());
    }

}
