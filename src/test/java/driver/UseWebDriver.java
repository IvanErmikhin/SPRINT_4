package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UseWebDriver {
    protected WebDriver driver;
    private static final String URL_HOME_PAGE = "https://qa-scooter.praktikum-services.ru/";
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(URL_HOME_PAGE);
    }

//    @Before
//    public void startUp() {
//        FirefoxOptions options = new FirefoxOptions()
//                .addPreference("browser.startup.page", 3)
//                .addPreference("browser.startup.homepage","https://qa-scooter.praktikum-services.ru/");
//        driver = new FirefoxDriver(options);
//    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
