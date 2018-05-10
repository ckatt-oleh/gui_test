package tests.webdriver;

import org.junit.*;

import pageobject.pages.*;
import utils.elements.init.BrowserInit;
import utils.elements.init.ConfigProcesing;

public class PosNegTest {

    @BeforeClass
    public static void init() {

    }
    @Test
    public void NegativeTest1() {
        LoginPage loginPage = new LoginPage(BrowserInit.getWebDriver());
        loginPage.open(ConfigProcesing.getConfigsApp().get("baseUrl")).loginAs("asdr@dsa.com", "Qwerty123");
        loginPage.checkLoginPage();
    }

    @Test
    public void PositiveTest2() {
        LoginPage loginPage = new LoginPage(BrowserInit.getWebDriver());
        HomePage homePage = loginPage.open(ConfigProcesing.getConfigsApp().get("baseUrl")).loginAs("testuser@test.com", "Qwerty123");
        homePage.checkPage();
    }

    @AfterClass
    public static void close() {
        BrowserInit.getWebDriver().close();
    }

}