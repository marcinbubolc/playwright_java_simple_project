package oldProject;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FirstTest {

    @Test
    public void userShouldBeAbleToOpenPlaywrightWebsite() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(1000)
        );
        Page page = browser.newPage();
        page.navigate("http://playwright.dev");
        System.out.println("Strona o tytule: " + page.title());
        System.out.println("Strona o adresie: " + page.url());
        assertThat(page).hasURL("https://playwright.dev/");
    }
}
