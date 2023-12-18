package ru.yandex.praktikum.pageobject;

import driver.UseWebDriver;
import org.junit.Test;
import ru.yandex.praktikum.pageobject.constants.CreateOrderButton;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.pageobject.constants.CreateOrderButton.DOWN_BUTTON;

public class OrderFormTest extends UseWebDriver {

    private final CreateOrderButton button = DOWN_BUTTON;
    private final String expectedHeader = "Для кого самокат";
    @Test
    public void openingOrderFormDownButton() {
        new HomePage(driver)
                .waitForLoadHomePage()
                .clickCreateOrderButton(button);

        AboutScooter aboutScooter = new AboutScooter(driver);
        assertTrue(aboutScooter.getHeaderAboutScooter().contains(expectedHeader));
    }
}
