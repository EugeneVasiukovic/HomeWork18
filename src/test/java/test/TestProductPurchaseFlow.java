package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestProductPurchaseFlow {
    @Test
    public void CheckProductPurchaseFlow() {
        System.setProperty("webdriver.chromedriver.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");


        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.sendKeys("standard_user");
        WebElement inputUserPassword = driver.findElement(By.id("password"));
        inputUserPassword.sendKeys("secret_sauce");
        WebElement submitButton = driver.findElement(By.id("login-button"));
        submitButton.click();
        WebElement buttonAddToCart = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        buttonAddToCart.click();
        WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
        shoppingCart.click();
        WebElement nameProduct = driver.findElement(By.className("inventory_item_name"));
        WebElement productPrice = driver.findElement(By.className("inventory_item_price"));



        String actualProductName = nameProduct.getText();
        String actualProductPrice = productPrice.getText().replace("$", "").trim();

        Assert.assertEquals(actualProductName, "Sauce Labs Fleece Jacket");
        Assert.assertEquals(actualProductPrice, "49.99");

        driver.quit();
    }
}