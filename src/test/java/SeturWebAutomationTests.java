/*
 * Author: Sinan Yağsağan
 * Date: 31.12.2023
 * Description: Bu proje, Selenium, JUnit ve Log4J kütüphanelerini kullanarak bir web uygulamasında
 * otomasyon testlerini gerçekleştirmek amacıyla oluşturulmuştur. Proje, Java programlama dili ve
 * Maven projesi olarak geliştirilmiştir.
 */

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.testinium.pages.HomeFormPage;
import org.testinium.pages.SearchFormPage;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeturWebAutomationTests extends BaseTest{

    private static final Logger log = LogManager.getLogger(SeturWebAutomationTests.class);

    public HomeFormPage homeFormPage;

    public SearchFormPage searchFormPage;

    CsvRead csvRead = new CsvRead();

    @BeforeEach
    public void getAll(){
        homeFormPage = new HomeFormPage(driver);
        searchFormPage = new SearchFormPage(driver);
    }

    @Test
    @DisplayName("Test Case 1 : testGoToWebSite()")
    @Order(1)
    public void testGoToWebSite(){
        try {
            log.info("Test case 1 started ");
            log.info("Successfully navigated to the website.");
            log.info("Test Case 1 completed.");
        }catch (Exception e){
            log.error("An error occurred during Test Case 1: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test Case 2 : testIsUrlCorrect()")
    @Order(2)
    public void testIsUrlCorrect(){
        try {
            log.info("Test Case 2 started.");
            Assertions.assertEquals(homeFormPage.getCurrentUrl(), Constants.SETUR_URL);
            log.info("URL verification successful.");
            log.info("Test Case 2 completed.");
        } catch (Exception e){
            log.error("An error occurred during Test Case 2: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test Case 3 : testIsHotelTabDefaultSelected()")
    @Order(3)
    public void testIsHotelTabDefaultSelected() {
        try {
            log.info("Test Case 3 started.");
            Assertions.assertTrue(homeFormPage.IsHotelTabDefaultSelected().contains(Constants.DEFAULT_HOTEL_TAB));
            log.info("Hotel tab default selection verification successful.");
            log.info("Test Case 3 completed.");
        }catch (Exception e){
            log.error("An error occurred during Test Case 3: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test Case 4 : testSelectAntalyaFromDropdown()")
    @Order(4)
    public void testSelectAntalyaFromDropdown() throws InterruptedException, IOException {
        try{
            log.info("Test Case 4 started.");
            homeFormPage.setHotelNameOrLocation(csvRead.readData());
            log.info("Antalya selection from dropdown successful.");
            log.info("Test Case 4 completed.");
        }catch (IOException | InterruptedException e){
            log.error("An error occurred during Test Case 4: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test Case 5 : testSelectDataPicker()")
    @Order(5)
    public void testSelectDataPicker() {
        try {
            log.info("Test Case 5 started.");
            homeFormPage.setDatePicker();
            log.info("Date picker selection successful.");
            log.info("Test Case 5 completed.");
        }catch (Exception e) {
            log.error("An error occurred during Test Case 5: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test Case 6 : testIncreaseAdultAndCheckAdultNumber()")
    @Order(6)
    public void testIncreaseAdultAndCheckAdultNumber(){
        try {
            log.info("Test Case 6 started.");
            homeFormPage.setIncreaseAdult();
            Assertions.assertTrue(homeFormPage.checkAdult());
            log.info("Adult number increase and verification successful.");
            log.info("Test Case 6 completed.");
        }catch (Exception e){
            log.error("An error occurred during Test Case 6: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test Case 7 : testCheckedSubmitButtonAndClicked()")
    @Order(7)
    public void testCheckedSubmitButtonAndClicked(){
        try {
            log.info("Test Case 7 started.");
            homeFormPage.testCheckedSubmitButtonAndClicked();

            log.info("Submit button checked and clicked successfully.");
            log.info("Test Case 7 completed.");
        }catch (Exception e){
            log.error("An error occurred during Test Case 7: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test Case 8 : testSearchPageUrlContainAntalya() ")
    @Order(8)
    public void testSearchPageUrlContainAntalya() throws InterruptedException {
        try {
            log.info("Test Case 8 started.");
            Assertions.assertTrue(searchFormPage.searchPageUrlContainAntalya().contains(Constants.CONTAIN_URL_ANTALYA));
            log.info("Search page URL contains 'Antalya' verification successful.");
            log.info("Test Case 8 completed.");
        }catch (Exception e){
            log.error("An error occurred during Test Case 8: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test Case 9 : testSaveNumberWithRandomClickMethodInShowAnotherLocation()")
    @Order(9)
    public void testSaveNumberWithRandomClickMethodInShowAnotherLocation() throws InterruptedException {
        try {
            log.info("Test Case 9 started.");
            searchFormPage.saveNumberWithRandomClickMethodInShowAnotherLocation();
            log.info("Number saved with random click method in 'Show Another Location' successful.");
            log.info("Test Case 9 completed.");
        }catch (Exception e) {
            log.error("An error occurred during Test Case 9: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test Case 10 : testRelatedFieldScrollAndCheckValue()")
    @Order(10)
    public void testRelatedFieldScrollAndCheckValue() throws InterruptedException {
        try {
            log.info("Test Case 10 started.");
            Assertions.assertTrue(searchFormPage.relatedFieldScrollAndCheckValue());
            log.info("Related field scroll and check value verification successful.");
            log.info("Test Case 10 completed.");
        }catch (Exception e) {
            log.error("An error occurred during Test Case 10: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
