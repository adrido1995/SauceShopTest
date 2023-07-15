package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.models.Customer;

public class CheckoutInformationPage {


    @FindBy (id = "first-name")
            private WebElement firstNameInput;
    @FindBy (id = "last-name")
            private WebElement lastNameInput;
    @FindBy (id = "postal-code")
            private WebElement zipCodeInput;

    @FindBy(id = "continue")
            private WebElement continueButton;
    WebDriver driver;
    public CheckoutInformationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public CheckoutOverviewPage fillCustomerDetails (Customer customer) {
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        zipCodeInput.sendKeys(customer.getZipCode());
        continueButton.click();
        return new CheckoutOverviewPage(driver);

    }
}
