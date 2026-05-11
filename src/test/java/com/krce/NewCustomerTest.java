package com.krce;

import com.krce.pages.LoginPage;
import com.krce.pages.NewCustomerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewCustomerTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/V4/index.php");
    }

    @Test
    public void createCustomerTest() {
        LoginPage login = new LoginPage(driver);
        login.login(
                "mngr661030",
                "pysabyj"
        );

        NewCustomerPage customer =
                new NewCustomerPage(driver);

        customer.createCustomer(
                "Aswathi",
                "24-06-2005",
                "249 Kamaraj Nagar Thirumandurai",
                "Perambalur",
                "Tamil Nadu",
                "621108",
                "6381905243",
                "aswathi"
                        + System.currentTimeMillis()
                        + "@gmail.com",
                "pysabyj"
        );
        System.out.println("Customer Created Successfully");
    }
    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}