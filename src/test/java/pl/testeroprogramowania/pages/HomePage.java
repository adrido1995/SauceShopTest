package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;



    private WebDriver driver;
    public HomePage (WebDriver driver){
    PageFactory.initElements(driver,this);
    this.driver = driver;


}

    public ShopPage LogIn(String username, String password) {
    usernameInput.sendKeys(username);
    passwordInput.sendKeys(password);
    loginButton.click();
    return new ShopPage(driver);
}


}
