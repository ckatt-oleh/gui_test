package utils.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.old.Generator;

public class CorePage {

    protected final WebDriver driver;
    protected WebDriverWait wait;
    protected Generator generator;

    public CorePage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);

        this.generator = new Generator();
    }
}
