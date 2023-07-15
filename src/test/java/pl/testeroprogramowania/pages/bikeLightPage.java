package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class bikeLightPage {

    @FindBy(xpath = "//button[@data-test='add-to-cart-sauce-labs-bike-light']")
            private WebElement addToCartButton;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
            private WebElement cartLink;
    WebDriver driver;


    public bikeLightPage (WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public CartPage addToCart(){
        addToCartButton.click();
        cartLink.click();
        return new CartPage(driver);
    }
}
