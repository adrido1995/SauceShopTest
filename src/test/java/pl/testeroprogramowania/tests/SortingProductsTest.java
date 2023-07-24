package pl.testeroprogramowania.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

import java.util.List;

public class SortingProductsTest extends BaseTest {

    @Test
    public void AtoZSortingTest() {

        HomePage homePage = new HomePage(driver);
        List<String> productNames = homePage
                .LogIn("standard_user", "secret_sauce")
                .AtoZProductList();

        Assert.assertEquals("Sauce Labs Backpack", productNames.get(0));
        Assert.assertEquals("Sauce Labs Bike Light", productNames.get(1));
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", productNames.get(2));
        Assert.assertEquals("Sauce Labs Fleece Jacket", productNames.get(3));
        Assert.assertEquals("Sauce Labs Onesie", productNames.get(4));
        Assert.assertEquals("Test.allTheThings() T-Shirt (Red)", productNames.get(5));

    }

    @Test
    public void ZtoASortingTest() {
        HomePage homePage = new HomePage(driver);
        List<String> productNames = homePage
                .LogIn("standard_user", "secret_sauce")
                .ZtoAProductList();

        Assert.assertEquals("Test.allTheThings() T-Shirt (Red)", productNames.get(0));
        Assert.assertEquals("Sauce Labs Onesie", productNames.get(1));
        Assert.assertEquals("Sauce Labs Fleece Jacket", productNames.get(2));
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", productNames.get(3));
        Assert.assertEquals("Sauce Labs Bike Light", productNames.get(4));
        Assert.assertEquals("Sauce Labs Backpack", productNames.get(5));


    }

    @Test
    public void LowToHighSortingTest() {
        HomePage homePage = new HomePage(driver);
        List<String> productNames = homePage
                .LogIn("standard_user", "secret_sauce")
                .LowToHighProductList();

        Assert.assertEquals("$7.99", productNames.get(0));
        Assert.assertEquals("$9.99", productNames.get(1));
        Assert.assertEquals("$15.99", productNames.get(2));
        Assert.assertEquals("$15.99", productNames.get(3));
        Assert.assertEquals("$29.99", productNames.get(4));
        Assert.assertEquals("$49.99", productNames.get(5));
    }

    @Test
    public void HighToLowSortingTest() {
        HomePage homePage = new HomePage(driver);
        List<String> productNames = homePage
                .LogIn("standard_user", "secret_sauce")
                .HighToLowProductList();

        Assert.assertEquals("$49.99", productNames.get(0));
        Assert.assertEquals("$29.99", productNames.get(1));
        Assert.assertEquals("$15.99", productNames.get(2));
        Assert.assertEquals("$15.99", productNames.get(3));
        Assert.assertEquals("$9.99", productNames.get(4));
        Assert.assertEquals("$7.99", productNames.get(5));
    }
}
