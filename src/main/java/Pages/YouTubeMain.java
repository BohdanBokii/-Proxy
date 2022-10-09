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

    @FindBy(xpath = "//input[@id = \"search\" ]")
    private WebElement searchField;

    @FindBy(xpath = "//button[@id = \"search-icon-legacy\" ]")
    private WebElement searchButton;

    public void search() {
        searchField.sendKeys("no war");
        searchButton.click();
    }

    public void goHome() {
        this.driver.get(youtubeUrl);
    }
}


