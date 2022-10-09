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
    public void test1() {
        youtube.goHome();
        youtube.search();
        Util.ScreenShot.takeScreenShot(driver, "Screen1");
    }
}
