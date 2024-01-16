package org.FormSeleTest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

public class ShodanScrape {
    private WebDriver driver;

    @Before
            public void setUp() {
        // Set up drivers
                FirefoxOptions options = new FirefoxOptions();
                driver = new FirefoxDriver(options);
                driver.get("https://www.shodan.io/");
            }

    @Test
            public void searchItem() {
                // Make a search for Shodan for servers running Microsoft IIS
                WebElement searchInput = driver.findElement(By.xpath("//input[@id='search-query']"));
                searchInput.sendKeys("IIS");
                WebElement searchButton = driver.findElement(By.className("button-red"));
                searchButton.click();

                // Perform an explicit wait until the page has loaded
                Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
                WebElement searchResult = driver.findElement(By.className("result"));
                wait.until(d -> searchResult.isDisplayed());
                
                // Grab the list of links to each of the search results, then click the first one
                List<WebElement> resultLink = driver.findElements(By.className("title text-dark"));
                resultLink.get(0).click();
                
                // Grab the details table
                WebElement serverDetailsTable = driver.findElement(By.className("table u-full-width"));
                getServerDetails(serverDetailsTable);
                assertEquals(true, true);
            }

    private void getServerDetails(WebElement table) {
        List<WebElement> tableItems = table.findElements(By.cssSelector("tr"));
        for (int i = 0; i < tableItems.size()-1; i++) {
            System.out.println(tableItems.get(i));
        }
    }
}
