package mts;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnlineTopUpTests {
    private WebDriver driver;

    @Test
    public void testOnlineTopUpBlock() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            // Закрытие всплывающего окна с куками
            try {
                WebElement cookieCloseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cookie__cancel")));
                if (cookieCloseButton.isDisplayed()) {
                    cookieCloseButton.click();
                }
            } catch (TimeoutException e) {
                System.out.println("Кнопка закрытия всплывающего окна не найдена: " + e.getMessage());
            }

            // Проверка названия блока
            WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h2[contains(text(), 'Онлайн пополнение ')]")
            ));
            assertEquals("Онлайн пополнение без комиссии", blockTitle.getText().replaceAll("\\s+", " ").trim(), "Название блока не совпадает");

            // Проверка наличия логотипов платёжных систем
            assertTrue(driver.findElement(By.xpath("//img[@alt='Visa']")).isDisplayed(), "Логотип Visa не отображается");

            // Проверка работы ссылки «Подробнее о сервисе»
            WebElement moreInfoLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Подробнее о сервисе")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", moreInfoLink);

            // Проверка URL после перехода по ссылке
            wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));

            // Возвращаемся на предыдущую страницу
            driver.navigate().back();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pay-connection")));

            // Заполнение полей и нажатие кнопки «Продолжить»
            driver.findElement(By.id("connection-phone")).sendKeys("297777777");
            driver.findElement(By.id("connection-sum")).sendKeys("100");
            driver.findElement(By.id("connection-email")).sendKeys("test@example.com");
            driver.findElement(By.cssSelector(".pay-form#pay-connection .button__default")).click();

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}