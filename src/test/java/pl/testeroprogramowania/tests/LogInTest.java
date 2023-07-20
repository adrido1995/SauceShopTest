package pl.testeroprogramowania.tests;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;


public class LogInTest extends BaseTest {

    @Test

    public void LoginTest() {
        WebElement spanText = new HomePage(driver)
                .LogIn("standard_user", "secret_sauce")
                .LogInCheck();

        Assert.assertEquals(spanText.getText(), "Sauce Labs Backpack");
    }

        @Test
        public void LogInInvalidDataTest () {
        WebElement errorMessage = new HomePage(driver).LogIn("standard_user1", "secret_soude").getError();

        Assert.assertEquals(errorMessage.getText(), "Epic sadface: Username and password do not match any user in this service");
        }

        @Test
    public void performanceGlitchUserTest() {
       WebElement spanText = new HomePage((driver)).LogIn("performance_glitch_user", "secret_sauce").LogInCheck();
        Assert.assertEquals(spanText.getText(),"Sauce Labs Backpack");

        }




    }


