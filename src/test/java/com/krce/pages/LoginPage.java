package com.krce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By userName = By.name("uid");
    By password = By.name("password");
    By loginButton = By.name("btnLogin");

    public void enterUserName(String uname) {
        driver.findElement(userName).sendKeys(uname);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String uname,String pswd) {
        enterUserName(uname);
        enterPassword(pswd);
        clickLogin();
    }
}