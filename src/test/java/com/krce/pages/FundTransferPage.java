package com.krce.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FundTransferPage {

    WebDriver driver;
    WebDriverWait wait;

    public FundTransferPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By fundTransferLink = By.linkText("Fund Transfer");
    By payerAcc = By.name("payersaccount");
    By payeeAcc = By.name("payeeaccount");
    By amount = By.name("ammount");
    By desc = By.name("desc");
    By submitBtn = By.name("AccSubmit");

    // Open Fund Transfer Page
    public void openFundTransfer() {

        WebElement link = wait.until(
                ExpectedConditions.elementToBeClickable(fundTransferLink)
        );

        try {
            link.click();
        } catch (Exception e) {
            ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", link);
        }
    }

    // Perform transfer
    public void transfer(String payer, String payee, String amt, String details) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(payerAcc)).sendKeys(payer);
        driver.findElement(payeeAcc).sendKeys(payee);
        driver.findElement(amount).sendKeys(amt);
        driver.findElement(desc).sendKeys(details);
        driver.findElement(submitBtn).click();
    }

    // Safe alert handling (IMPORTANT FIX)
    public String getAlertText() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String text = alert.getText();
            alert.accept();
            return text;
        } catch (NoAlertPresentException e) {
            return "No Alert Present";
        } catch (Exception e) {
            return "No Alert Present";
        }
    }
}