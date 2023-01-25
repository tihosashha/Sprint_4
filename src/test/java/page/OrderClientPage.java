package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderClientPage {

    private final WebDriver driver;

    public OrderClientPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By clientName = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    private final By clientSurname = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    private final By clientAddress = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    private final By subwayStation = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input");
    private final By subwaySelectDropdown = By.className("select-search__select");
    private final By clientPhone = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    private final By nextButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");

    public void inputName(String name) {
        driver.findElement(clientName).sendKeys(name);
    }

    public void inputSurname(String surname) {
        driver.findElement(clientSurname).sendKeys(surname);
    }

    public void inputAddress(String address) {
        driver.findElement(clientAddress).sendKeys(address);
    }

    public void chooseStation(String station) {
        driver.findElement(subwayStation).sendKeys(station);
        driver.findElement(subwaySelectDropdown).findElement(By.tagName("ul")).findElements(By.tagName("li")).get(0).click();
    }

    public void inputPhone(String phone) {
        driver.findElement(clientPhone).sendKeys(phone);
    }

    public void submitForm() {
        driver.findElement(nextButton).click();
    }

    public void fillAndSendForm(String name, String surname, String address, String subway, String phone) {
        inputName(name);
        inputSurname(surname);
        inputAddress(address);
        chooseStation(subway);
        inputPhone(phone);
        submitForm();
    }
}
