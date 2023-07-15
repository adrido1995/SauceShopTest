package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {

    @FindBy (linkText = "Sauce Labs Backpack")
    private WebElement productName;

    @FindBy (linkText = "Sauce Labs Bike Light")
    private WebElement bikeLightLink;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;


    private WebDriver driver;
    public ShopPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public bikeLightPage openProduct () {

        bikeLightLink.click();
        return new bikeLightPage(driver);
    }

    public WebElement LogInCheck() { return productName; }

    public WebElement getError () {return errorMessage;}



}
