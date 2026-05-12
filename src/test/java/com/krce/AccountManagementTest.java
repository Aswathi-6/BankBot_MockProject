package com.krce;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class AccountManagementTest {

    WebDriver driver;
    String customerId;
    String accountId;

    @BeforeClass
    public void setup() {

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/V4/");
    }


    //login test

    @Test(priority = 1)
    public void loginTest() {

        driver.findElement(By.name("uid")).sendKeys("mngr661030");
        driver.findElement(By.name("password")).sendKeys("pysabyj");
        driver.findElement(By.name("btnLogin")).click();
        System.out.println("Login Success");
    }


    //create customer test

    @Test(priority = 2)
    public void createCustomerTest() {

        driver.findElement(By.linkText("New Customer")).click();
        driver.findElement(By.name("name")).sendKeys("Ashwathy");
        driver.findElement(By.xpath("//input[@value='f']")).click();
        driver.findElement(By.name("dob")).sendKeys("24-06-2005");
        driver.findElement(By.name("addr")).sendKeys("Perambalur");
        driver.findElement(By.name("city")).sendKeys("Chennai");
        driver.findElement(By.name("state")).sendKeys("TamilNadu");
        driver.findElement(By.name("pinno")).sendKeys("621108");
        driver.findElement(By.name("telephoneno")).sendKeys("1345267890");
        // unique email id
        String email="ashu" +System.currentTimeMillis() + "@gmail.com";
        driver.findElement(By.name("emailid")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("test123");
        driver.findElement(By.name("sub")).click();
         //handle alert
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
        } catch (Exception e) {
            customerId=driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
            System.out.println("Customer ID : " +customerId);
        }
    }


    //create account test

    @Test(priority = 3)
    public void createAccountTest() {

        driver.findElement(By.linkText("New Account")).click();
        driver.findElement(By.name("cusid")).sendKeys(customerId);
        WebElement accountType=driver.findElement(By.name("selaccount"));
        accountType.sendKeys("Savings");
        driver.findElement(By.name("inideposit")).sendKeys("5000");
        driver.findElement(By.name("button2")).click();
        accountId=driver.findElement(By.xpath("//td[text()='Account ID']/following-sibling::td")).getText();
        System.out.println("Account ID : " + accountId);
    }


    //verify account list

    @Test(priority = 4)
    public void verifyAccountListingTest() {
        String pageSource=driver.getPageSource();

        if(pageSource.contains(accountId)){
            System.out.println("Account available in listing");
        }
        else{
            System.out.println("Account not found");
        }
    }

    //invalid customer id test

    @Test(priority = 5)
    public void invalidCustomerIdTest() {

        driver.findElement(By.linkText("New Account")).click();
        driver.findElement(By.name("cusid")).sendKeys("99999999");
        WebElement accountType=driver.findElement(By.name("selaccount"));
        accountType.sendKeys("Savings");
        driver.findElement(By.name("inideposit")).sendKeys("5000");
        driver.findElement(By.name("button2")).click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}