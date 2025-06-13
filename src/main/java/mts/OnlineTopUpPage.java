package mts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnlineTopUpPage {
    private WebDriver driver;

    public OnlineTopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By serviceTypeDropdown = By.id("pay");
    private By phoneNumberField = By.id("connection-phone");
    private By amountField = By.id("connection-sum");
    private By emailField = By.id("connection-email");
    private By continueButton = By.xpath("//form[@id='pay-connection']//button[@type='submit']");

    private By internetPhoneField = By.id("internet-phone");
    private By internetAmountField = By.id("internet-sum");
    private By internetEmailField = By.id("internet-email");

    private By instalmentScoreField = By.id("score-instalment");
    private By instalmentAmountField = By.id("instalment-sum");
    private By instalmentEmailField = By.id("instalment-email");

    private By arrearsScoreField = By.id("score-arrears");
    private By arrearsAmountField = By.id("arrears-sum");
    private By arrearsEmailField = By.id("arrears-email");

    // Методы для взаимодействия с элементами
    public void selectServiceType(String serviceType) {
        driver.findElement(serviceTypeDropdown).sendKeys(serviceType);
    }

    public void fillPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void fillAmount(String amount) {
        driver.findElement(amountField).sendKeys(amount);
    }

    public void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public String getPhoneNumber() {
        return driver.findElement(phoneNumberField).getAttribute("value");
    }

    public String getAmount() {
        return driver.findElement(amountField).getAttribute("value");
    }

    // Методы для других форм
    public void fillInternetFields(String phone, String amount, String email) {
        driver.findElement(internetPhoneField).sendKeys(phone);
        driver.findElement(internetAmountField).sendKeys(amount);
        driver.findElement(internetEmailField).sendKeys(email);
    }

    public void fillInstalmentFields(String score, String amount, String email) {
        driver.findElement(instalmentScoreField).sendKeys(score);
        driver.findElement(instalmentAmountField).sendKeys(amount);
        driver.findElement(instalmentEmailField).sendKeys(email);
    }

    public void fillArrearsFields(String score, String amount, String email) {
        driver.findElement(arrearsScoreField).sendKeys(score);
        driver.findElement(arrearsAmountField).sendKeys(amount);
        driver.findElement(arrearsEmailField).sendKeys(email);
    }
}