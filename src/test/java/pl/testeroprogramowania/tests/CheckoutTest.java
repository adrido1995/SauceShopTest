package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.models.Customer;
import pl.testeroprogramowania.pages.CartPage;
import pl.testeroprogramowania.pages.HomePage;

import java.util.List;

public class CheckoutTest extends BaseTest {

    @Test
    public void CheckoutTest (){

        Customer customer = new Customer();

        WebElement productName = new HomePage(driver)
                .LogIn("standard_user", "secret_sauce")
                .openProductBikeLight()
                .addToCart()
                .productCheck();
        Assert.assertEquals(productName.getText(), "Sauce Labs Bike Light");
        WebElement orderNoticeCheck = new CartPage(driver)
                .checkoutClick()
                .fillCustomerDetails(customer)
                .FinishClick()
                .OrderNoticeCheck();

        Assert.assertEquals(orderNoticeCheck.getText(), "Thank you for your order!");


    }

    @Test
    public void CheckoutOnPerformanceGlitchUserTest() {
        Customer customer = new Customer();

        WebElement productName = new HomePage(driver)
                .LogIn("performance_glitch_user", "secret_sauce")
                .openProductBikeLight()
                .addToCart()
                .productCheck();
        Assert.assertEquals(productName.getText(), "Sauce Labs Bike Light");
        WebElement orderNoticeCheck = new CartPage(driver)
                .checkoutClick()
                .fillCustomerDetails(customer)
                .FinishClick()
                .OrderNoticeCheck();

        Assert.assertEquals(orderNoticeCheck.getText(), "Thank you for your order!");


    }

    @Test
    public void CheckoutWithTwoProductsTest () {

        Customer customer = new Customer();

        List<String> productNames = new HomePage(driver)
                .LogIn("standard_user", "secret_sauce")
                .openProductBikeLight()
                .addToCartAndBackToProduct()
                .openProductFleeceJacket()
                .addToCart()
                .getProductCheckoutNameList();
        Assert.assertEquals("Sauce Labs Bike Light", productNames.get(0));
        Assert.assertEquals("Sauce Labs Fleece Jacket", productNames.get(1));

        WebElement orderNoticeCheck = new CartPage(driver)
                .checkoutClick()
                .fillCustomerDetails(customer)
                .FinishClick()
                .OrderNoticeCheck();

        Assert.assertEquals(orderNoticeCheck.getText(), "Thank you for your order!");


    }
}
