package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class ScooterInfoPage {

    private final WebDriver driver;

    public ScooterInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By arriveDateField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input");
    private final By durationDropdownArrow = By.className("Dropdown-arrow");
    private final By dropdownItem = By.className("Dropdown-option");
    private final By colorCheckbox = By.className("Checkbox_Input__14A2w");
    private final By commentField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");

    private final By orderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");

    private final By confirmOrderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");

    private final By orderConfirmationHeader = By.className("Order_ModalHeader__3FDaJ");

    public void inputDate(String date) {
        driver.findElement(arriveDateField).sendKeys(date);
    }

    public void chooseDuration(int durationIndex) {
        driver.findElement(durationDropdownArrow).click();
        driver.findElements(dropdownItem).get(durationIndex).click();
    }

    public void chooseColor(int colorIndex) {
        driver.findElements(colorCheckbox).get(colorIndex).click();
    }

    public void inputComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickOrder() {
        driver.findElement(orderButton).click();
    }

    public void confirmOrderInModal() {
        driver.findElement(confirmOrderButton).click();
    }

    public void fillFormAndOrderScooter(String date, int durationIndex, int colorIndex, String comment) {
        inputDate(date);
        chooseDuration(durationIndex);
        chooseColor(colorIndex);
        inputComment(comment);
        clickOrder();
        confirmOrderInModal();
    }

    public void assertOrderConfirmed() {
        String orderConfirmationText = driver.findElement(orderConfirmationHeader).getText();
        assertTrue(orderConfirmationText.contains("Заказ оформлен"));
    }
}
