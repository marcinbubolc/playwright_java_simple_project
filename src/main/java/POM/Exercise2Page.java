package POM;

import com.microsoft.playwright.Page;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
@Slf4j
public class Exercise2Page {
    private static final Logger log = LoggerFactory.getLogger(MainPage.class);

    Page page;

    public Exercise2Page(Page page) {
        this.page = page;
    }

    public void checkValueAndFill(){
        log.info("User open 2 exercise");
        String textToFill = page.locator("//tr[2]/td[2]/code[1]").innerText();
        page.locator("//input[@id='t14']").fill(textToFill);

        page.locator("//button[@id='btnButton1']").click();
        page.locator("//button[@id='solution']").click();
    }

    public void checkSolution(){
        assertThat(page.locator("//code[@class='wrap']")).hasText("OK. Good answer");
        System.out.println("Wynik prawidłowy!");
    }
}
