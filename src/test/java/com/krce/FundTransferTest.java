package com.krce;


import com.krce.pages.FundTransferPage;
import com.krce.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FundTransferTest extends LoginTest {

    @Test
    public void validTransfer() {

        LoginPage login = new LoginPage(driver);
        login.login("mngr661030", "pysabyj");
        FundTransferPage ft = new FundTransferPage(driver);
        ft.openFundTransfer();

        //use demo values(no real account
        ft.transfer("10001","10002","500","Test transfer");
        String alert = ft.handleAlert();
        System.out.println("Alert: " + alert);
        Assert.assertTrue(alert != null && alert.contains("success"));
    }


}