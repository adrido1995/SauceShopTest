package pl.testeroprogramowania.pages;

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

    public ShopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public BikeLightPage openProductBikeLight() {

        bikeLightLink.click();
        return new BikeLightPage(driver);
    }

    public FleeceJacketPage openProductFleeceJacket() {

        fleeceJacketLink.click();
        return new FleeceJacketPage(driver);
    }

    public List<String> AtoZProductList() {
        sortContainer.click();
        azOption.click();
        return getProductNameList();

    }

    public List<String> ZtoAProductList() {
        sortContainer.click();
        zaOption.click();
        return getProductNameList();
    }

    public List<String> LowToHighProductList() {
        sortContainer.click();
        lowToHighOption.click();
        return getProductPriceList();
    }

    public List<String> HighToLowProductList() {
        sortContainer.click();
        highToLowOption.click();
        return getProductPriceList();
    }


    public WebElement LogInCheck() {
        return productName;
    }

    public WebElement getError() {
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
