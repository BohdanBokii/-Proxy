package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YouTubeMain {
    private static  String youtubeUrl = "https://youtube.com/";
    private WebDriver driver;
    public YouTubeMain(WebDriver driver) {
        PageFactory.initElements(driver, this);

        this.driver = driver;
    }

    @FindBy(xpath = "//button[contains(@class, 'icon-button') and contains(@class," +
            " 'topbar-menu-button-avatar-button') and contains(@aria-label, 'Поиск на YouTube')]")
    private WebElement search;

    @FindBy(xpath = "//input[contains(@class, 'searchbox-input') and contains(@class, 'title') and contains(@name, 'search')]")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(@class, 'icon-button')  and contains(@aria-label, 'Поиск на YouTube')]")
    private WebElement searchAfterSendKeys;

    public void search() {
        search.click();
        searchField.sendKeys("no war");
        searchAfterSendKeys.click();
    }

    public void goHome() {
        this.driver.get(youtubeUrl);
    }
}


