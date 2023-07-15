package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {

    @FindBy(id = "finish")
            private WebElement finishButton;
    WebDriver driver;
    public CheckoutOverviewPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;

    }

    public CheckoutCompletePage FinishClick(){
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }
}
