
package org.FormSeleTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.FormSeleTest.UserRandGen.educationCalc;
import static org.junit.Assert.*;

public class TestButtons {

    private WebDriver driver;

    @Before
            public void setUp() {
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");

                System.setProperty("webdriver.gecko.driver", "C:/Users/Nicholas/Desktop/selenium/geckodriver/geckodriver.exe");
                driver = new FirefoxDriver(options);

                driver.get("https://formy-project.herokuapp.com/form");
            }

    @Test

        public void testForm() {
        WebElement fName = driver.findElement(By.xpath("//input[@id='first-name']"));
        fName.sendKeys("First Name");

        WebElement lName = driver.findElement(By.xpath("//input[@id='last-name']"));
        lName.sendKeys("Last Name");

        WebElement jobName = driver.findElement(By.xpath("//input[@id='job-title']"));
        jobName.sendKeys("Last Name");

        WebElement edu1 = driver.findElement(By.xpath("//input[@id='radio-button-1']"));
        WebElement edu2 = driver.findElement(By.xpath("//input[@id='radio-button-2']"));
        WebElement edu3 = driver.findElement(By.xpath("//input[@id='radio-button-3']"));

        switch (educationCalc()) {
            case 0 -> edu1.click();
            case 1 -> edu2.click();
            case 2 -> edu3.click();
        }

        WebElement gender1 = driver.findElement(By.xpath("//input[@id='checkbox-1']"));
        WebElement gender2 = driver.findElement(By.xpath("//input[@id='checkbox-2']"));
        WebElement gender3 = driver.findElement(By.xpath("//input[@id='checkbox-3']"));

        switch (UserRandGen.genderAssigner()) {
            case 0 -> gender1.click();
            case 1 -> gender2.click();
            case 2 -> gender3.click();
        }

        int expValue = UserRandGen.expAssigner();

        if (expValue < 2) {
            WebElement zeroOne = driver.findElement(By.xpath("//select[@id='select-menu']/option[1]"));
            zeroOne.click();

        } else if (expValue > 2 && expValue < 5) {
            WebElement twoFive = driver.findElement(By.xpath("//select[@id='select-menu']/option[2]"));
            twoFive.click();
        } else if (expValue > 5 && expValue < 10) {
            WebElement fiveTen = driver.findElement(By.xpath("//select[@id='select-menu']/option[3]"));
            fiveTen.click();
        } else {
            WebElement tenPlus = driver.findElement(By.xpath("//select[@id='select-menu']/option[4]"));
            tenPlus.click();
        }

        WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
        date.sendKeys(UserRandGen.dayAssigner() + "/" + UserRandGen.monthAssigner() + "/" + UserRandGen.yearAssigner());

        WebElement submit = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-primary']"));
        submit.click();

        assertEquals("https://formy-project.herokuapp.com/thanks", driver.getCurrentUrl());
    }
    @After
        public void tearDown() {
            driver.quit();
        }

}
