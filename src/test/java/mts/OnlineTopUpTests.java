package mts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlineTopUpTests {
    private WebDriver driver;
    private OnlineTopUpPage onlineTopUpPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://mts.by/online-top-up");
        onlineTopUpPage = new OnlineTopUpPage(driver);
    }

    @Test
    public void testPlaceholdersInPaymentOptions() {
        // Проверка надписей в незаполненных полях для различных вариантов оплаты
        onlineTopUpPage.selectServiceType("Услуги связи");
        assertEquals("Номер телефона", driver.findElement(By.id("connection-phone")).getAttribute("placeholder"));

        onlineTopUpPage.selectServiceType("Домашний интернет");
        assertEquals("Номер абонента", driver.findElement(By.id("internet-phone")).getAttribute("placeholder"));

        onlineTopUpPage.selectServiceType("Рассрочка");
        assertEquals("Номер счета на 44", driver.findElement(By.id("score-instalment")).getAttribute("placeholder"));

        onlineTopUpPage.selectServiceType("Задолженность");
        assertEquals("Номер счета на 2073", driver.findElement(By.id("score-arrears")).getAttribute("placeholder"));
    }

    @Test
    public void testContinueButtonFunctionality() {
        // Заполнение полей и проверка отображения суммы
        onlineTopUpPage.selectServiceType("Услуги связи");
        onlineTopUpPage.fillPhoneNumber("1234567890");
        onlineTopUpPage.fillAmount("100");
        onlineTopUpPage.fillEmail("test@example.com");
        onlineTopUpPage.clickContinue();

        // Проверка корректности отображения суммы и номера телефона
        assertEquals("100", onlineTopUpPage.getAmount());
        assertEquals("1234567890", onlineTopUpPage.getPhoneNumber());
    }

    @Test
    public void testInternetPayment() {
        // Заполнение полей для домашнего интернета
        onlineTopUpPage.selectServiceType("Домашний интернет");
        onlineTopUpPage.fillInternetFields("0987654321", "50", "internet@example.com");
        onlineTopUpPage.clickContinue();

        // Проверка корректности отображаемых данных
        assertEquals("50", driver.findElement(By.id("internet-sum")).getAttribute("value"));
        assertEquals("0987654321", driver.findElement(By.id("internet-phone")).getAttribute("value"));
    }

    @Test
    public void testInstalmentPayment() {
        // Заполнение полей для рассрочки
        onlineTopUpPage.selectServiceType("Рассрочка");
        onlineTopUpPage.fillInstalmentFields("123456", "150", "instalment@example.com");
        onlineTopUpPage.clickContinue();

        // Проверка корректности отображаемых данных
        assertEquals("150", driver.findElement(By.id("instalment-sum")).getAttribute("value"));
        assertEquals("123456", driver.findElement(By.id("score-instalment")).getAttribute("value"));
    }

    @Test
    public void testArrearsPayment() {
        // Заполнение полей для задолженности
        onlineTopUpPage.selectServiceType("Задолженность");
        onlineTopUpPage.fillArrearsFields("789012", "200", "arrears@example.com");
        onlineTopUpPage.clickContinue();

        // Проверка корректности отображаемых данных
        assertEquals("200", driver.findElement(By.id("arrears-sum")).getAttribute("value"));
        assertEquals("789012", driver.findElement(By.id("score-arrears")).getAttribute("value"));
    }
}