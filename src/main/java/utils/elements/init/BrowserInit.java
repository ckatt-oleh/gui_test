package utils.elements.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class BrowserInit {

    private static WebDriver driver;

    public static void initializeDriver(HashMap<String, String> configsDriver) {

        if (configsDriver.get("browser").toLowerCase().equals("chrome")) {

            System.setProperty("webdriver.chrome.driver", configsDriver.get("driverPath"));
            BrowserInit.driver = new ChromeDriver();

        } else if (configsDriver.get("browser").toLowerCase().equals("firefox")) {

            System.setProperty("webdriver.firefox.driver", configsDriver.get("driverPath"));
            BrowserInit.driver = new FirefoxDriver();

        }

    }

    public static WebDriver setPropertyWindow() {
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

}

