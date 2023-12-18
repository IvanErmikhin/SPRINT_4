package ru.yandex.praktikum.pageobject;

import driver.UseWebDriver;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ScooterButtonTest extends UseWebDriver {
    private static final String expectedResultUrl = "https://qa-scooter.praktikum-services.ru/";
    @Test
    public void clickScooterFromAboutRenterPage() {
        HomePage homePage = new HomePage(driver);
        AboutRenter aboutRenter = new AboutRenter(driver);

        homePage.waitForLoadHomePage()
                .clickUpOrderButton();

        aboutRenter.waitForLoadOrderPage()
                .clickScooter();

        new WebDriverWait(driver, Duration.ofSeconds(5));

        assertEquals(expectedResultUrl, driver.getCurrentUrl());
    }

    @Test
    public void clickScooterFromAboutScooterPage() {
        HomePage homePage = new HomePage(driver);
        AboutRenter aboutRenter = new AboutRenter(driver);
        AboutScooter aboutScooter = new AboutScooter(driver);

        homePage.waitForLoadHomePage()
                .clickUpOrderButton();

        aboutRenter.waitForLoadOrderPage()
                .inputName("Имя")
                .inputSurname("Фамилия")
                .inputAddress("Адрес")
                .changeStateMetro(77)
                .inputTelephone("+79999999999")
                .clickNextButton();

        aboutScooter.waitAboutRentHeader()
                .clickScooter();

        new WebDriverWait(driver, Duration.ofSeconds(5));

        assertEquals(expectedResultUrl, driver.getCurrentUrl());
    }

    @Test
    public void clickScooterFromOrderStatusPage() {
        HomePage homePage = new HomePage(driver);
        OrderStatus orderStatus = new OrderStatus(driver);

        homePage.waitForLoadHomePage()
                .clickOrderState()
                .inputOrderNumber("12345")
                .clickGo();

        orderStatus.waitLoadOrderStatusPade()
                .clickScooter();

        new WebDriverWait(driver, Duration.ofSeconds(5));

        assertEquals(expectedResultUrl, driver.getCurrentUrl());
    }

}
