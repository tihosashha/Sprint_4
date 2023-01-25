package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By faqAccordion = By.className("accordion");
    private final By faqItem = By.className("accordion__item");
    private final By faqItemExpanded = By.className("accordion__panel");
    private final By orderButton = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");

    public void scrollToFaq() {
        scrollToElement(driver.findElement(faqAccordion));
    }

    public void clickAndCheckItemsInFaq() throws InterruptedException {
        List<WebElement> elements = driver.findElement(faqAccordion).findElements(faqItem);
        for (WebElement element : elements) {
            element.click();
            Thread.sleep(500L);
            assertTrue(element.findElement(faqItemExpanded).isDisplayed());
            scrollDown();
        }
    }

    private void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    private void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,150)");
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
}
