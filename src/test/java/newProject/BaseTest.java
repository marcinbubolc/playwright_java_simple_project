package newProject;

import POM.MainPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    Playwright playwright;
    Browser browser;
    Page page;
    MainPage mainPage;

    @BeforeTest
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(true)
                .setSlowMo(1000));
        page = browser.newPage();
        mainPage = new MainPage(page);
    }

    @AfterTest
    public void closePlaywright() {
        playwright.close();
    }
}
