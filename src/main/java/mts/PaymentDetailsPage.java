package mts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentDetailsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы
    private By amountLabel = By.cssSelector(".amount-label"); // Пример селектора для суммы
    private By phoneLabel = By.cssSelector(".phone-label"); // Пример селектора для номера телефона
    private By cardNumberField = By.id("card-number");
    private By cardExpiryField = By.id("card-expiry");
    private By cardCvcField = By.id("card-cvc");
    private By paymentIcons = By.cssSelector(".payment-icon"); // Пример селектора для иконок платёжных систем

    public PaymentDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Исправлено
    }

    public String getAmount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(amountLabel)).getText();
    }

    public String getPhoneNumber() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneLabel)).getText();
    }

    public String getPlaceholderForField(By fieldLocator) {
        return driver.findElement(fieldLocator).getAttribute("placeholder");
    }

    public boolean arePaymentIconsDisplayed() {
        return driver.findElements(paymentIcons).size() > 0;
    }
}
