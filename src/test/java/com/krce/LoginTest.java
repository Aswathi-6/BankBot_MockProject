package com.krce;

import com.krce.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest {

    public static WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/V4/index.php");
    }

    @Test(dataProvider = "loginData")
    public void verifyLogin(String username,String password) {
        LoginPage login=new LoginPage(driver);
        login.login(username, password);
        String title=driver.getTitle();
        Assert.assertTrue(title.contains("Guru99"));
    }



    @DataProvider(name = "loginData")
    public Object[][] getData() {

        return new Object[][]{
                {"mngr661030","pysabyj"}
        };
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
