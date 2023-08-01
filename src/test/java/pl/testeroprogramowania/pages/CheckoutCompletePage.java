package pl.testeroprogramowania.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement orderNotice;
    WebDriver driver;
    private static final Logger logger = LogManager.getLogger();
    public CheckoutCompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement OrderNoticeCheck() {
        logger.info("Checking order notice");
        return orderNotice;
    }

}
