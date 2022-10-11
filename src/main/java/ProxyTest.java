import DriverConfig.BaseClass;
import Models.AGENTS;
import Models.UserAgents;
import Pages.YouTubeMain;
import gherkin.lexer.Th;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProxyTest extends BaseClass {
    private static YouTubeMain youtube;

    @BeforeClass
    public static void initBeforeTestMobile() {
        AGENTS.AgentType((UserAgents.IPHONE));
        youtube = new YouTubeMain(driver);
    }

    @Test
    public void test1() throws InterruptedException {
        youtube.goHome();
        Thread.sleep(3000);
        youtube.search();
        Thread.sleep(3000);
        Util.ScreenShot.takeScreenShot(driver, "Screen1");
    }
}
