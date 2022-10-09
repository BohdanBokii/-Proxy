package Util;

import DriverConfig.BaseClass;
import io.qameta.allure.Allure;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class WatcherByClassTest extends TestWatcher {
    @Override
    protected void failed(Throwable e, Description description) {
        Allure.getLifecycle().addAttachment(
                description.getMethodName(),//Name String
                "image/png",
                "png",
                ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.BYTES)
        );

    }
}
