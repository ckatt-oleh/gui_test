package pageobject.pages;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.*;
import utils.page_object.CorePage;

public class LoginPage extends CorePage {

    private By usernameLocator = By.xpath("//input[@id=\"login-email\"]");
    private By passwordLocator = By.xpath("//input[@id=\"login-password\"]");
    private By loginButtonLocator = By.xpath("//form[@name=\"loginForm\"]//button[@type=\"submit\"]");
    private By errorMsg = By.xpath("//div[@data-ng-show=\"errorMsg\"]//p");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open(String url) {
        this.driver.get(url + "/#/signin");
        this.wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));

        return this;
    }

    private LoginPage typeUsername(String username) {
        WebElement loginField = this.driver.findElement(this.usernameLocator);
        loginField.sendKeys(username);

        return this;
    }

    private LoginPage typePassword(String password) {
        WebElement passField = this.driver.findElement(this.passwordLocator);
        passField.sendKeys(password);

        return this;
    }

    private HomePage submitLogin() {
        WebElement passField = this.driver.findElement(this.passwordLocator);
        passField.submit();

        return new HomePage(driver);
    }

    public HomePage loginAs(String username, String password) {
        this.typePassword(password)
                .typeUsername(username)
                .submitLogin();

        return new HomePage(this.driver);
    }

    public LoginPage checkLoginPage () {

        wait.until(ExpectedConditions.visibilityOfElementLocated(this.errorMsg));
        WebElement errorBlock = this.driver.findElement(this.errorMsg);

        Assert.assertEquals("WRONG PAGE", "Некорректны пароль или email", errorBlock.getText());

        return this;
    }
}