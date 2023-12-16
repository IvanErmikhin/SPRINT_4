package ru.yandex.praktikum.pageobject;

import driver.UseWebDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.pageobject.constants.CreateOrderButton;
import ru.yandex.praktikum.pageobject.constants.ScooterColours;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.pageobject.constants.CreateOrderButton.DOWN_BUTTON;
import static ru.yandex.praktikum.pageobject.constants.CreateOrderButton.UP_BUTTON;
import static ru.yandex.praktikum.pageobject.constants.ScooterColours.*;

@RunWith(Parameterized.class)
public class OrderCreateTest extends UseWebDriver {
    private final String name;
    private final String surname;
    private final String address;
    private final int stateMetroNumber;
    private final String telephoneNumber;
    private final String date;
    private final ScooterColours colour;
    private final String comment;
    private final String expectedHeader = "Заказ оформлен";
    private final CreateOrderButton button;

    public OrderCreateTest(CreateOrderButton button, String name, String surname, String address, int stateMetroNumber, String telephoneNumber,
                           String date, ScooterColours colour, String comment) {
        this.button = button;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.stateMetroNumber = stateMetroNumber;
        this.telephoneNumber = telephoneNumber;
        this.date = date;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {UP_BUTTON, "Имя Один", "Фамилия", "Адрес 1", 123, "79991111111", "28.05.2023", GREY, "comments one"},
                {UP_BUTTON, "Имя Два", "Фамилия", "Адрес 2", 7, "79992222222", "28.05.2023", BLACK, "comments two"},
                {UP_BUTTON, "Имя Три", "Фамилия", "Адрес 3", 10, "79993333333", "28.05.2023", BLACK, "comments three"},
                {DOWN_BUTTON, "Имя Один", "Фамилия", "Адрес 1", 123, "79991111111", "28.05.2023", GREY, "comments one"},
                {DOWN_BUTTON, "Имя Два", "Фамилия", "Адрес 2", 7, "79992222222", "28.05.2023", BLACK, "comments two"},
                {DOWN_BUTTON, "Имя Три", "Фамилия", "Адрес 3", 10, "79993333333", "28.05.2023", BLACK, "comments three"},
        };
    }

    @Test
    public void checkOrder() {
        new HomePage(driver)
                .waitForLoadHomePage()
                .clickCreateOrderButton(button);

        new AboutRenter(driver)
                .waitForLoadOrderPage()
                .inputName(name)
                .inputSurname(surname)
                .inputAddress(address)
                .changeStateMetro(stateMetroNumber)
                .inputTelephone(telephoneNumber)
                .clickNextButton();

        new AboutScooter(driver)
                .waitAboutRentHeader()
                .inputDate(date)
                .inputDuration()
                .changeColour(colour)
                .inputComment(comment)
                .clickButtonCreateOrder();

        PopUpWindow popUpWindow = new PopUpWindow(driver);
                popUpWindow.clickButtonYes();

        assertTrue(popUpWindow.getHeaderAfterCreateOrder().contains(expectedHeader));
    }
}
