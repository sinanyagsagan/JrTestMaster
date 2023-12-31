package org.testinium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFormPage extends BasePage{

    public Random random;
    public static String otherRegionNumber;

    public SearchFormPage(WebDriver driver) {super(driver);}

    public String searchPageUrlContainAntalya() throws InterruptedException {
        Thread.sleep(7000);
        return driver.getCurrentUrl();}

    public void saveNumberWithRandomClickMethodInShowAnotherLocation() throws InterruptedException {

        random = new Random();

        WebElement anotherRegion = find(SearchPageTagsConstants.SELECT_ANOTHER_REGION);
        List<WebElement> checkboxes = anotherRegion.findElements(SearchPageTagsConstants.SELECT_RANDOMLY_CHECK_BOX);

        int randomIndex = random.nextInt(checkboxes.size());
        WebElement randomCheckbox = checkboxes.get(randomIndex);


        showYellowElement(randomCheckbox);
        randomCheckbox.click();

        String otherRegionText = randomCheckbox.findElement(SearchPageTagsConstants.ANOTHER_REGION_NUMBER).getText();
        otherRegionNumber = otherRegionText.
                replaceAll(SearchPageTagsConstants.REPLACE_ALL_REGEX, SearchPageTagsConstants.REPLACE_REPLACEMENT);

    }

    public boolean relatedFieldScrollAndCheckValue() throws InterruptedException {

        boolean IsNotFoundRelatedField = true;

        if (20 <= Integer.parseInt(otherRegionNumber)){
            Thread.sleep(5000);
            scrollWithJavaScript(SearchPageTagsConstants.RELATED_FIELD_SCROLL, 5);
            String relatedFieldText = find(SearchPageTagsConstants.RELATED_FIELD_SCROLL).getText();
            showYellowElement(SearchPageTagsConstants.RELATED_FIELD_SCROLL);

            Pattern pattern = Pattern.compile("\\b(\\d+)\\b");
            Matcher matcher = pattern.matcher(relatedFieldText);
            if (matcher.find()){
                String expectedNumber = matcher.group(1);
                return Objects.equals(expectedNumber, otherRegionNumber);
            }
        }
        return IsNotFoundRelatedField;
    }
}
