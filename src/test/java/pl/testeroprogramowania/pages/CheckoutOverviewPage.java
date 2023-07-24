package pl.testeroprogramowania.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class CheckoutOverviewPage {

    @FindBy(xpath = "//div[@class='inventory_item_price'] [text()='29.99'] [text() [2]]")
    private List<WebElement> Product1Price;

    @FindBy(xpath = "//div[@class='inventory_item_price'] [text()='49.99'] [text() [2]]")
    private List<WebElement> Product2Price;

    @FindBy(xpath = "//div[@class='summary_tax_label'] [text() [2]]")
    private WebElement taxPrice;
    @FindBy(id = "finish")
    private WebElement finishButton;
    WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public CheckoutCompletePage FinishClick() {
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }

    /* public String CheckPriceTotal(){

        String Product1 = driver.findElement(By.xpath("//div[@class='inventory_item_price'] [text()='9.99'] [text() [2]]")).getText();
        String Product2 = driver.findElement(By.xpath("//div[@class='inventory_item_price'] [text()='49.99'] [text() [2]]")).getText();
        String Tax = driver.findElement(By.xpath("//div[@class='summary_tax_label'] [text() [2]]")).getText();

        double Product1Price = Double.parseDouble(Product1);
        double Product2Price = Double.parseDouble(Product2);
        double TaxPrice = Double.parseDouble(Tax);
        double PriceTotal = Product1Price + Product2Price + TaxPrice;
        String PriceTotalStr = Double.toString(PriceTotal);
        System.out.println(PriceTotalStr);
        return PriceTotalStr;
    } */


}
