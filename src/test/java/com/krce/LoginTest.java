package com.krce;

import com.krce.pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.File;
import java.nio.file.Files;

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
        loginPage.login("wrongUser", "wrongPassword");
        try{
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
        }catch (Exception e){
            System.out.println("No alert shown - login failed message is on page");
        }
    }


    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

}