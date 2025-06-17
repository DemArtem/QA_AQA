package mts;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Автоматизация тестирования")
@Feature("Онлайн пополнение")
public class OnlineTopUpTests {
    private WebDriver driver;

    @Test
    @Story("Проверка блока онлайн-пополнения")
    @Description("Проверяет корректность отображения заголовка, логотипов платёжных систем, полей ввода и кнопок.")
    @Severity(SeverityLevel.CRITICAL)
    public void testOnlineTopUpBlock() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            closeCookiePopup(wait);
            checkBlockTitle(wait);
            checkPaymentLogos();
            checkMoreInfoLink(wait);
            processPaymentOptions(wait);
            fillPaymentForm(wait);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    @Step("Закрытие всплывающего окна с куками")
    private void closeCookiePopup(WebDriverWait wait) {
        try {
            WebElement cookieCloseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cookie__cancel")));
            if (cookieCloseButton.isDisplayed()) {
                cookieCloseButton.click();
            }
        } catch (TimeoutException e) {
            System.out.println("Кнопка закрытия всплывающего окна не найдена: " + e.getMessage());
        }
    }

    @Step("Проверка заголовка блока")
    private void checkBlockTitle(WebDriverWait wait) {
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(), 'Онлайн пополнение ')]")
        ));
        assertEquals("Онлайн пополнение без комиссии", blockTitle.getText().replaceAll("\\s+", " ").trim(), "Название блока не совпадает");
    }

    @Step("Проверка логотипов платёжных систем")
    private void checkPaymentLogos() {
        assertTrue(driver.findElement(By.xpath("//img[@alt='Visa']")).isDisplayed(), "Логотип Visa не отображается");
    }

    @Step("Проверка работы ссылки 'Подробнее о сервисе'")
    private void checkMoreInfoLink(WebDriverWait wait) {
        WebElement moreInfoLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Подробнее о сервисе")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", moreInfoLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", moreInfoLink);
        wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pay-connection")));
    }

    @Step("Проверка заполнения и надписей в полях оплаты")
    private void processPaymentOptions(WebDriverWait wait) {
        String[] paymentOptions = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};

        for (String option : paymentOptions) {
            WebElement selectHeader = wait.until(ExpectedConditions.elementToBeClickable(By.className("select__header")));
            selectHeader.click();

            WebElement selectedOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='" + option + "']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectedOption);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectedOption);

            WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-email")));
            String placeholderText = inputField.getAttribute("placeholder");

            assertTrue(placeholderText != null && !placeholderText.isEmpty(), "Поле пустое или не содержит надписи для: " + option);
            System.out.println("Надпись в поле для " + option + ": " + placeholderText);
            selectHeader.click();
        }
    }

    @Step("Заполнение формы и нажатие кнопки 'Продолжить'")
    private void fillPaymentForm(WebDriverWait wait) {
        driver.findElement(By.id("connection-phone")).sendKeys("297777777");
        driver.findElement(By.id("connection-sum")).sendKeys("100");
        driver.findElement(By.id("connection-email")).sendKeys("test@example.com");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pay-form#pay-connection .button__default")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
    }
}