package DriverConfig;
import Models.AGENTS;
import Models.UserAgents;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class DriverFactory {
    public static WebDriver getDriver(BROWSER browser) {
        WebDriver driver = null;
        switch (browser) {
            case CHROME:
                driver = initChrome();
                break;
            case FIREFOX:
                driver = initFirefox();
                break;
            case CHROMEPROXY:
                driver = initChromeProxy();
                break;
        }
        return driver;
    }

    private static WebDriver initChromeProxy() {
        BrowserMobProxyServer server = new BrowserMobProxyServer();
        server.setTrustAllServers(true);

        server.start();

        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(server);
        AGENTS.setUserIphone(server);


        String hostIp = null;
        try {
            hostIp = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        seleniumProxy.setHttpProxy(hostIp + ":" + server.getPort());
        seleniumProxy.setSslProxy(hostIp + ":" + server.getPort());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

        capabilities.setAcceptInsecureCerts(true); //very important string, selenium-java in pom ver. 3.141.59

        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);

        String proxyOption = "--proxy-server=" + seleniumProxy.getHttpProxy();
        options.addArguments(proxyOption);

        WebDriver driver = new ChromeDriver(options);
        BaseClass.server = server;
        return driver;
    }

    private static WebDriver initFirefox() {
        return new FirefoxDriver();
    }

    private static WebDriver initChrome() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\stan_\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        return new ChromeDriver(options);
    }
}
