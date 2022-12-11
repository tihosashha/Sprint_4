package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    }

    public void clickItemsInFaq() {
        List<WebElement> elements = driver.findElement(faqAccordion).findElements(faqItem);
        for (WebElement element : elements) {
            element.click();
            assertTrue(element.isDisplayed());
        }
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
}
