package tests;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.MainPage;
import page.OrderClientPage;
import page.ScooterInfoPage;

@RunWith(JUnit4.class)
public class ScooterOrderTest {

    private WebDriver driver;

    @Test
    public void testOrderChrome() {
        driver = new ChromeDriver();
        testOrder();
    }

    @Test
    public void testOrderFirefox() {
        driver = new FirefoxDriver();
        testOrder();
    }

    private void testOrder() {
        MainPage mainPage = new MainPage(driver);
        OrderClientPage orderClientPage = new OrderClientPage(driver);
        ScooterInfoPage scooterInfoPage = new ScooterInfoPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        mainPage.clickOrderButton();
        orderClientPage.fillAndSendForm(
                "Имя",
                "Фамилия",
                "Перовская 66",
                "Перово",
                "+7999999999"
        );
        scooterInfoPage.fillFormAndOrderScooter(
                "24.12.2022",
                0,
                0,
                "Комментарий"
        );
        scooterInfoPage.assertOrderConfirmed();
    }


    @After
    public void after() {
        driver.quit();
    }
}
