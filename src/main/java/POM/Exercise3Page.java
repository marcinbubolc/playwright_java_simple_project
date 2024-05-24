package POM;

import com.microsoft.playwright.Page;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
@Slf4j
public class Exercise3Page {
    private static final Logger log = LoggerFactory.getLogger(MainPage.class);

    Page page;

    public Exercise3Page(Page page) {
        this.page = page;
    }

    public void checkColourAndChoose(){
        log.info("User open 3 exercise");

        String expectedColour = page.locator("//tbody/tr[2]/td[2]/code").innerText();

        page.selectOption("//select[@id='s13']", expectedColour);
        page.locator("//button[@id='solution']").click();
    }

    public void checkSolution(){
        assertThat(page.locator("//code[@class='wrap']")).hasText("OK. Good answer");
        System.out.println("Wynik prawidłowy!");
    }
}
