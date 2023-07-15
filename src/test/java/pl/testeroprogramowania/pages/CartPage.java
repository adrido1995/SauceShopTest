package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(linkText = "Sauce Labs Bike Light")
    private WebElement productNameCheck;
    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    WebDriver driver;


    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public WebElement productCheck() {
        return productNameCheck;
    }

    public CheckoutInformationPage checkoutClick() {
        checkoutButton.click();
        return new CheckoutInformationPage(driver);
    }


}
