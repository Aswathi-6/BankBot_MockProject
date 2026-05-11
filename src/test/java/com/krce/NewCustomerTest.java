package com.krce;

import com.krce.pages.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewCustomerTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/V4/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("mngr661030", "pysabyj");
    }


    // CREATE NEW CUSTOMER TEST

    @Test(priority = 1)
    public void createCustomerTest() {
        driver.findElement(By.linkText("New Customer")).click();
        driver.findElement(By.name("name")).sendKeys("Ashwathy");
        driver.findElement(By.xpath("//input[@value='f']")).click();
        driver.findElement(By.name("dob")).sendKeys("10-10-2002");
        driver.findElement(By.name("addr")).sendKeys("Chennai");
        driver.findElement(By.name("city")).sendKeys("Chennai");
        driver.findElement(By.name("state")).sendKeys("Tamil Nadu");
        driver.findElement(By.name("pinno")).sendKeys("600001");
        driver.findElement(By.name("telephoneno")).sendKeys("9876543210");
        String email = "ashu" + System.currentTimeMillis() + "@gmail.com";
        driver.findElement(By.name("emailid")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("test123");
        driver.findElement(By.name("sub")).click();

        String successMsg=driver.findElement(By.xpath("//p[@class='heading3']")).getText();

        Assert.assertTrue(successMsg.contains("Customer Registered Successfully"));

        String customerId=driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();

        System.out.println("Customer ID Generated : " +customerId);
        System.out.println("Success message verified");
    }



    // ==============================
    // DUPLICATE EMAIL TEST
    // ==============================

    @Test(priority = 2)
    public void duplicateEmailTest() {

        driver.findElement(By.linkText("New Customer")).click();

        driver.findElement(By.name("name")).sendKeys("Kumar");

        driver.findElement(By.xpath("//input[@value='m']")).click();

        driver.findElement(By.name("dob")).sendKeys("12-12-2000");

        driver.findElement(By.name("addr")).sendKeys("Madurai");

        driver.findElement(By.name("city")).sendKeys("Madurai");

        driver.findElement(By.name("state")).sendKeys("Tamil Nadu");

        driver.findElement(By.name("pinno")).sendKeys("625001");

        driver.findElement(By.name("telephoneno")).sendKeys("9876543211");

        // Use already registered email
        driver.findElement(By.name("emailid"))
                .sendKeys("alreadyused@gmail.com");

        driver.findElement(By.name("password")).sendKeys("test123");

        driver.findElement(By.name("sub")).click();

        try {

            Alert alert = driver.switchTo().alert();

            String alertMessage = alert.getText();

            System.out.println("Alert Message : " + alertMessage);

            Assert.assertTrue(alertMessage.contains("Email Address Already Exist"));

            alert.accept();

        } catch (Exception e) {

            System.out.println("Duplicate email validation not displayed");
        }
    }

    // ==============================
    // SUCCESS MESSAGE TEST
    // ==============================

    @Test(priority = 3)
    public void successMessageTest() {

        driver.findElement(By.linkText("New Customer")).click();

        driver.findElement(By.name("name")).sendKeys("Arun");

        driver.findElement(By.xpath("//input[@value='m']")).click();

        driver.findElement(By.name("dob")).sendKeys("01-01-2001");

        driver.findElement(By.name("addr")).sendKeys("Coimbatore");

        driver.findElement(By.name("city")).sendKeys("Coimbatore");

        driver.findElement(By.name("state")).sendKeys("Tamil Nadu");

        driver.findElement(By.name("pinno")).sendKeys("641001");

        driver.findElement(By.name("telephoneno")).sendKeys("9999999999");

        String email = "fresh" + System.currentTimeMillis() + "@gmail.com";

        driver.findElement(By.name("emailid")).sendKeys(email);

        driver.findElement(By.name("password")).sendKeys("abc123");

        driver.findElement(By.name("sub")).click();

        String msg =
                driver.findElement(By.xpath("//p[@class='heading3']")).getText();

        Assert.assertEquals(msg, "Customer Registered Successfully!!!");

        System.out.println("Success message displayed correctly");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}