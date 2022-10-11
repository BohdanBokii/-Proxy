package DriverConfig;

import net.lightbody.bmp.BrowserMobProxyServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseClass {
    protected static WebDriver driver;

    public static BrowserMobProxyServer server;
    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public static void initChromeProxy() {
        /*server = new BrowserMobProxyServer();*/
        driver = DriverFactory.getDriver(BROWSER.CHROMEPROXY);
    }

    @AfterClass
    public static void close() {
        if (driver != null)
            driver.close();

        if (server != null)
            server.stop();
    }
}
