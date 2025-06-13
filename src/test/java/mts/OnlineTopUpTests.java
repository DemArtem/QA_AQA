package mts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnlineTopUpTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://mts.by");
    }

    @Test
    public void testOnlineTopUpBlock() {
        // Проверка названия блока
        WebElement blockTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение без комиссии')]"));
        assertEquals("Онлайн пополнение без комиссии", blockTitle.getText(), "Название блока не совпадает");

        // Проверка наличия логотипов платёжных систем
        assertTrue(driver.findElements(By.xpath("//img[contains(@src, 'payment_system_logo')]")).size() > 0, "Логотипы платёжных систем не найдены");

        // Проверка работы ссылки «Подробнее о сервисе»
        WebElement moreInfoLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        moreInfoLink.click();
        assertTrue(driver.getCurrentUrl().contains("info_service"), "Ссылка 'Подробнее о сервисе' не работает");

        // Возврат на главную страницу
        driver.navigate().back();

        // Заполнение полей и проверка работы кнопки «Продолжить»
        WebElement serviceType = driver.findElement(By.id("pay"));
        serviceType.sendKeys("Услуги связи");

        WebElement phoneNumber = driver.findElement(By.id("connection-phone"));
        phoneNumber.sendKeys("297777777");

        WebElement continueButton = driver.findElement(By.id("pay-connection"));
        continueButton.click();

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}