package com.krce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage {
    WebDriver driver;
    public NewCustomerPage(WebDriver driver){
        this.driver=driver;

    }

    By customerName=By.name("name");
    By dateofBirth=By.name("dob");
    By address=By.name("addr");
    By city=By.name("city");
    By state=By.name("state");
    By pin=By.name("pinno");
    By mobileno=By.name("telephoneno");
    By emailID=By.name("emailid");
    By password=By.name("password");
    By loginButton=By.name("sub");
    //By resetButton=By.name("res");

    public void entercustomerName(String name) {
        driver.findElement(customerName).sendKeys("Aswathi");
    }

    public void enterDateofBirth(String dob) {
        driver.findElement(dateofBirth).sendKeys("24-06-2005");
    }

    public void enterAddress(String addr) {
        driver.findElement(address).sendKeys("249KamarajNagarThirumandurai");
    }

    public void enterCity(String cityname) {
        driver.findElement(city).sendKeys("Perambalur");
    }

    public void enterState(String statename) {
        driver.findElement(state).sendKeys("TamilNadu");
    }

    public void enterPin(String pinname) {
        driver.findElement(pin).sendKeys("621108");
    }

    public void enterMobile(String name) {
        driver.findElement(mobileno).sendKeys("6381905243");
    }

    public void enterEmail(String ename) {
        driver.findElement(emailID).sendKeys("aswathimurugesan2406@gmail.com");
    }

    public void enterPswd(String pswd) {
        driver.findElement(password).sendKeys("pysabyj");
    }

    public void clickLogin() {
        driver.findElement(loginButton).submit();
    }

//    public void clickReset() {
//        driver.findElement(resetButton).click();
//    }
public void login(String uname,String pwd,String dob,String addr,String city,String state,String pin,String no,String email) {
        entercustomerName(uname);
        enterDateofBirth(dob);
        enterAddress(addr);
        enterCity(city);
        enterState(state);
        enterPin(pin);
        enterMobile(no);
        enterEmail(email);
        enterPswd(pwd);
        clickLogin();
}

}
