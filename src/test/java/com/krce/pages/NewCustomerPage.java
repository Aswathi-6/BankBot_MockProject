package com.krce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage {

    WebDriver driver;

    public NewCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    // New Customer Link
    By newCustomerLink = By.linkText("New Customer");

    // Customer Form Fields
    By customerName=By.name("name");
    By genderMale=By.xpath("//input[@value='m']");
    By dob=By.name("dob");
    By address=By.name("addr");
    By city=By.name("city");
    By state=By.name("state");
    By pin=By.name("pinno");
    By mobile=By.name("telephoneno");
    By email=By.name("emailid");
    By password=By.name("password");
    By submitButton=By.name("sub");
    By editCustomerLink=By.linkText("Edit Customer");
    By customerId=By.name("cusid");
    By submitEdit=By.name("AccSubmit");
    By editAddress=By.name("addr");

    public void clickNewCustomer() {
        driver.findElement(newCustomerLink).click();
    }

    public void createCustomer(String cname,String date,String addr,String cityName,String stateName,String pinNo,String phone,String mail,String pass) {

        clickNewCustomer();
        driver.findElement(customerName).sendKeys(cname);
        driver.findElement(genderMale).click();
        driver.findElement(dob).sendKeys(date);
        driver.findElement(address).sendKeys(addr);
        driver.findElement(city).sendKeys(cityName);
        driver.findElement(state).sendKeys(stateName);
        driver.findElement(pin).sendKeys(pinNo);
        driver.findElement(mobile).sendKeys(phone);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(submitButton).click();
    }

    public String getSuccessMessage() {
        return driver.getPageSource();
    }

    public String getCustomerId() {
        String customerText = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
        return customerText;
    }

    public void editCustomerAddress(String custId, String newAddress) {
        driver.findElement(editCustomerLink).click();
        driver.findElement(customerId).sendKeys(custId);
        driver.findElement(submitEdit).click();
        driver.findElement(editAddress).clear();
        driver.findElement(editAddress).sendKeys(newAddress);
        driver.findElement(By.name("sub")).click();
    }
}