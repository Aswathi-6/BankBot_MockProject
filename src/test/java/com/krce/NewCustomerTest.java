package com.krce;

import com.krce.pages.LoginPage;
import com.krce.pages.NewCustomerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.krce.LoginTest.driver;

public class NewCustomerTest extends LoginTest {
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/V4/index.php");
    }


    @Test
    public void createLogin(String uname,String pwd,String dob,String addr,String city,String state,String pin,String no,String email){
        NewCustomerPage login=new NewCustomerPage(driver);
        login.login(uname,pwd,dob,addr,city,state,pin,no,email);
            NewCustomerPage customer=new NewCustomerPage(driver);
            customer.login(uname,pwd,dob,addr,city,state,pin,no,email);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
