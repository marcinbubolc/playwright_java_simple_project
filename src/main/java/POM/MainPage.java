package POM;

import com.microsoft.playwright.Page;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Slf4j

public class MainPage {
    Page page;
    public String url = "https://antycaptcha.amberteam.pl/";
    private static final Logger log = LoggerFactory.getLogger(MainPage.class);
    public MainPage(Page page) {
        this.page = page;
    }

    public void userOpenGeneralExercises() {
        log.info("User opens AmberTeam General Exercises.");
        page.navigate(url);
        assertThat(page).hasURL("https://antycaptcha.amberteam.pl/");
        page.click("//a[contains(text(),'General intoductory exercises')]");
    }

    public void userOpenSpecificExercise(String exerciseNumber) {
        page.click("//a[contains(text(),'Exercise " + exerciseNumber + "')]");
        System.out.println("Strona 1 testu została załadowana.");
    }

}
