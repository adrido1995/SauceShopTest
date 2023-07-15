package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {

    @FindBy(xpath = "//h2[@class='complete-header']")
            private WebElement orderNotice;
    WebDriver driver;
    public CheckoutCompletePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public WebElement OrderNoticeCheck(){
        return orderNotice;
    }

}
