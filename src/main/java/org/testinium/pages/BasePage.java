package org.testinium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver){ this.driver = driver;}

    public WebElement find(By locator) {
        if (locator.equals(HomePageTagsConstants.DEFAULT_HOTEL_TAG)){
            showYellowElement(locator);
        }else{
            visibleElement(locator);
        }
        return driver.findElement(locator);
    }
    public void visibleElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    public void showYellowElement(By locator) {
        visibleElement(locator);
        WebElement element = driver.findElement(locator);
        String jsCode = "arguments[0].style.backgroundColor='yellow';";
        ((JavascriptExecutor) driver).executeScript(jsCode, element);
    }
    public void showYellowElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor='yellow'", element);
    }
    public void untilVisibleClick(By locatorOne, By locatorTwo) {
        boolean check = true;
        while (check) {
            try {
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
                wait.until(ExpectedConditions.visibilityOfElementLocated(locatorOne));
                check=false;
            } catch (Exception e) {
                showYellowElement(locatorTwo);
                find(locatorTwo).click();
            }
        }
    }
    public void click(By locator) {
        showYellowElement(locator);
        driver.findElement(locator).click();
    }
    public void scrollWithJavaScript(By locator, int durationInMillis) {
        WebElement element = find(locator);
        String script = "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});";
        ((JavascriptExecutor) driver).executeScript(script, element);
        try {
            Thread.sleep(durationInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
