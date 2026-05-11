package com.krce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage {

    WebDriver driver;

    public NewCustomerPage(WebDriver driver) {
        this.driver=driver;
    }

    By newCustomer=By.linkText("New Customer");
    By customerName=By.name("name");
    By gender=By.xpath("//input[@value='f']");
    By dateofBirth=By.name("dob");
    By address=By.name("addr");
    By city=By.name("city");
    By state=By.name("state");
    By pin=By.name("pinno");
    By mobileno=By.name("telephoneno");
    By emailID=By.name("emailid");
    By password=By.name("password");
    By submitButton=By.name("sub");

    public void enterCustomerName(String name) {
        driver.findElement(customerName).sendKeys(name);
    }

    public void selectGender() {
        driver.findElement(gender).click();
    }

    public void enterDateofBirth(String dob) {
        driver.findElement(dateofBirth).sendKeys(dob);
    }

    public void enterAddress(String addr) {
        driver.findElement(address).sendKeys(addr);
    }
    public void enterCity(String cityname) {
        driver.findElement(city).sendKeys(cityname);
    }
    public void enterState(String statename) {
        driver.findElement(state).sendKeys(statename);
    }
    public void enterPin(String pinname) {
        driver.findElement(pin).sendKeys(pinname);
    }
    public void enterMobile(String mobile) {
        driver.findElement(mobileno).sendKeys(mobile);
    }
    public void enterEmail(String email) {
        driver.findElement(emailID).sendKeys(email);
    }
    public void enterPassword(String pswd) {
        driver.findElement(password).sendKeys(pswd);
    }
    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
    public void createCustomer(String name,String dob,String addr,String cityname,String statename,String pinname,String mobile,String email,String pswd) {
        driver.findElement(newCustomer).click();
        enterCustomerName(name);
        selectGender();
        enterDateofBirth(dob);
        enterAddress(addr);
        enterCity(cityname);
        enterState(statename);
        enterPin(pinname);
        enterMobile(mobile);
        enterEmail(email);
        enterPassword(pswd);
        clickSubmit();
    }
}