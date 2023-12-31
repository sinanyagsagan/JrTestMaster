import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testinium.logger.Log;


import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;

    Log log = new Log();

    @BeforeAll
    public void setUp(){
        try {
            log.info("Setting up test environment.");
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-translate");

            driver = new ChromeDriver(chromeOptions);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(Constants.SETUR_URL);

            declineCookies();
            closeAdverts();

            log.info("Test environment setup completed.");
        }catch (Exception e){
            log.error("An error occurred during test environment setup: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void declineCookies(){
        try {
            WebElement elementToClick = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinDeclineAll"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", elementToClick);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void closeAdverts(){
        try {
            WebElement element =  driver.findElement(By.cssSelector("span.ins-close-button"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @AfterAll
    public void tearDown() throws InterruptedException {
        Thread.sleep(20000);
        try {
            log.info("Tests execution finished.");
            log.info("Test cleanup or post-test steps completed.");;
            driver.quit();
        }catch (Exception e){
            log.error("An error occurred during test cleanup: " + e.getMessage());;
        }
        driver.quit();
    }
}
