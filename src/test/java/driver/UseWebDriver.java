package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class UseWebDriver {
    protected WebDriver driver;
    private final String urlHomaPage = "https://qa-scooter.praktikum-services.ru/";
    @Before
    public void startUp() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(urlHomaPage);
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
