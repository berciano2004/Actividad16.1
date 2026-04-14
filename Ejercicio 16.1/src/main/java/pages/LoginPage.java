package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By userField = By.id("user-name");
    private final By passField = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void ingresarUsuario(String user) {
        wait.until(ExpectedConditions.elementToBeClickable(userField)).sendKeys(user);
    }

    public void ingresarPassword(String pass) {
        wait.until(ExpectedConditions.elementToBeClickable(passField)).sendKeys(pass);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public void login(String user, String pass) {
        ingresarUsuario(user);
        ingresarPassword(pass);
        clickLogin();
    }

    public boolean isErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
    }

    public boolean isInventoryPageOpen() {
        return wait.until(ExpectedConditions.urlContains("inventory"));
    }
}