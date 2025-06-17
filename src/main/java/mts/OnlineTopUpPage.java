package mts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnlineTopUpPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы
    private By blockTitle = By.xpath("//h2[contains(text(), 'Онлайн пополнение ')]");
    private By serviceOption = By.cssSelector(".service-option"); // Пример селектора для вариантов оплаты
    private By continueButton = By.cssSelector(".button__default");
    private By phoneField = By.id("connection-phone");
    private By sumField = By.id("connection-sum");
    private By emailField = By.id("connection-email");

    public OnlineTopUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Исправлено
    }

    public String getBlockTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle)).getText();
    }

    public void selectServiceOption(String option) {
        // Логика для выбора варианта оплаты
        WebElement optionElement = driver.findElement(By.xpath("//div[text()='" + option + "']"));
        optionElement.click();
    }

    public void fillFields(String phone, String sum, String email) {
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(sumField).sendKeys(sum);
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public String getPlaceholderForField(By fieldLocator) {
        return driver.findElement(fieldLocator).getAttribute("placeholder");
    }
}
