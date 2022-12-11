package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.MainPage;

@RunWith(JUnit4.class)
public class FaqTest {

    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
    }

    @Test
    public void testFaqExpansion() {
        MainPage mainPage = new MainPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        mainPage.scrollToFaq();
        mainPage.clickItemsInFaq();
    }

    @After
    public void after() {
        driver.quit();
    }
}
