package ru.yandex.praktikum.pageObject;

import driver.UseWebDriver;
import org.junit.Test;

public class OrderStatusTest extends UseWebDriver {
    private final String numberOrder = "12345";


    @Test
    public void orderStatusWithoutNumber() {
        new HomePage(driver)
                .waitForLoadHomePage()
                .clickOrderState()
                .inputOrderNumber(numberOrder)
                .clickGo();
        new OrderStatus(driver)
                .waitLoadOrderStatusPade();
    }
}
