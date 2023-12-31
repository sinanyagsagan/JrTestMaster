package org.testinium.pages;

import org.openqa.selenium.By;

public class HomePageTagsConstants {

    public static final By DEFAULT_HOTEL_TAG =
            By.cssSelector("button.sc-5391ca11-1.crUBM");

    public static final By HOTEL_NAME_OR_LOCATION =
            By.cssSelector("input[placeholder=\"Otel Adı Veya Konum\"]");

    public static final By DROP_DOWN_TOP_LIST =
            By.xpath("//strong[text()='Antalya']");

    public static final By SELECT_DATE_FIELD =
            By.xpath("//div[text()='Giriş - Çıkış Tarihleri']");

    public static final By SELECT_APRIL_MONTH =
            By.xpath("//strong[contains(text(),'Nisan')]");

    public static final By NEXT_MONTH_BUTTON =
            By.cssSelector("button.sc-147d3380-2");

    public static final By FIRST_DATE =
            By.xpath("//td[@aria-label=\"Choose Pazartesi, 1 Nisan 2024 as your check-in date. It’s available.\"]");
    public static final By SECOND_DATE =
            By.xpath("//td[@aria-label=\"Choose Pazar, 7 Nisan 2024 as your check-out date. It’s available.\"]");

    public static final By GUEST =
            By.xpath("//span[contains(text(),'1 Oda, 2 Yetişkin')]");
    public static final By INCREASE_ADULT =
            By.cssSelector("button[data-testid=\"increment-button\"]");
    public static final By CHECK_ADULTS =
            By.xpath("//span[contains(text(),'1 Oda, 3 Yetişkin')]");

    public static final By CHECKED_SUBMIT_BUTTON =
            By.cssSelector("button.sc-8de9de7b-0.dYTYAP");

    public static final String DEFAULT_ADULT_NUMBER = "2 Yetişkin";

}
