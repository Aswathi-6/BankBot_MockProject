package com.krce;

import com.krce.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/V4/");
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void verifyValidLogin() {
        loginPage.login("mngr661030", "pysabyj");
        System.out.println("Login successful");
    }

    @Test(priority = 2)
    public void verifyInvalidLogin() {
        loginPage.login("wrongUser", "wrongPass");
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().accept();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}