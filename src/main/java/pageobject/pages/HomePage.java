package pageobject.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.page_object.CorePage;

public class HomePage extends CorePage {

    private By pageHeader = By.id("setting");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage checkPage () {

        wait.until(ExpectedConditions.visibilityOfElementLocated(this.pageHeader));
        WebElement avatarForm = this.driver.findElement(this.pageHeader);
        avatarForm.click();

        return this;
    }

}
