import DriverConfig.BaseClass;
import Models.AGENTS;
import Models.UserAgents;
import Pages.YouTubeMain;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProxyTest extends BaseClass {
    private static YouTubeMain youtube;

    @BeforeClass
    public static void initBeforeTestMobile() {
        youtube = new YouTubeMain(getDriver());
    }

    @Test
    public void test1() throws InterruptedException {
        youtube.goHome();
        youtube.search();
        Thread.sleep(3000);
        Util.ScreenShot.takeScreenShot(driver, "Screen1");
    }
}
