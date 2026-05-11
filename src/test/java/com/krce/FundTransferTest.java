package com.krce;


import com.krce.pages.FundTransferPage;
import com.krce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FundTransferTest extends LoginTest {

    @Test
    public void validTransfer() {

        LoginPage login = new LoginPage(driver);
        login.login("mngr661030", "pysabyj");

        FundTransferPage ft = new FundTransferPage(driver);
        ft.openFundTransfer();

        // USE DEMO VALUES (not real accounts)
        ft.transfer("10001", "10002", "500", "Test transfer");

        String alert = ft.getAlertText();

        System.out.println("Alert: " + alert);

        // FIX ASSERT
        Assert.assertTrue(alert != null && alert.contains("success"));
    }
}

