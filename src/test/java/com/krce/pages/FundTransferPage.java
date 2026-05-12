package com.krce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FundTransferPage {
    WebDriver driver;

    public FundTransferPage(WebDriver driver) {
        this.driver = driver;
    }

    By fundTransferLink = By.linkText("Fund Transfer");
    By payeeAcc = By.name("payersaccount");
    By payeeName = By.name("payeeaccount");
    By amount = By.name("ammount");
    By desc = By.name("desc");
    By submit = By.name("AccSubmit");

    public void openFundTransfer() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(fundTransferLink)
        );

        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void transfer(String payer, String payee, String amt, String description) {
        driver.findElement(payeeAcc).sendKeys(payer);
        driver.findElement(payeeName).sendKeys(payee);
        driver.findElement(amount).sendKeys(amt);
        driver.findElement(desc).sendKeys(description);
        driver.findElement(submit).click();
    }

    // HANDLE ALERT PROPERLY
    public String handleAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String text = alert.getText();
            alert.accept();
            return text;
        } catch (TimeoutException e) {
            return "No Alert";
        }
    }
}