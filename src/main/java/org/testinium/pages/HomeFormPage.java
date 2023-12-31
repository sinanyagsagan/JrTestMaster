package org.testinium.pages;

import org.openqa.selenium.WebDriver;

public class HomeFormPage extends BasePage{

    public HomeFormPage(WebDriver driver) {super(driver);}

    public String getCurrentUrl(){return driver.getCurrentUrl();}

    public String IsHotelTabDefaultSelected(){return find(HomePageTagsConstants.DEFAULT_HOTEL_TAG).getText();}

    public void setHotelNameOrLocation(String location) throws InterruptedException {
        find(HomePageTagsConstants.HOTEL_NAME_OR_LOCATION).sendKeys(location);

        click(HomePageTagsConstants.HOTEL_NAME_OR_LOCATION);
        Thread.sleep(3000);
        click(HomePageTagsConstants.DROP_DOWN_TOP_LIST);
    }

    public void setDatePicker() {
        click(HomePageTagsConstants.SELECT_DATE_FIELD);

        untilVisibleClick(HomePageTagsConstants.SELECT_APRIL_MONTH,HomePageTagsConstants.NEXT_MONTH_BUTTON);
        click(HomePageTagsConstants.FIRST_DATE);

        click(HomePageTagsConstants.SECOND_DATE);
    }

    public void setIncreaseAdult(){
        click(HomePageTagsConstants.GUEST);
        click(HomePageTagsConstants.INCREASE_ADULT);

    }

    public boolean checkAdult(){
       return !find(HomePageTagsConstants.CHECK_ADULTS).getText()
                       .equals(HomePageTagsConstants.DEFAULT_ADULT_NUMBER);
    }

    public void testCheckedSubmitButtonAndClicked(){click(HomePageTagsConstants.CHECKED_SUBMIT_BUTTON);}

}
