package POM;

import com.microsoft.playwright.Page;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
@Slf4j
public class Exercise1Page {
    private static final Logger log = LoggerFactory.getLogger(MainPage.class);

    Page page;

    public Exercise1Page(Page page) {
        this.page = page;
    }

    public void checkElementsAndClickButtons(){
        log.info("User open 1 exercise");
        String firstValue = page.locator("//tr[2]/td[2]/code").innerText();
        String secondValue = page.locator("//tr[3]/td[2]/code").innerText();
        String thirdValue = page.locator("//tr[4]/td[2]/code").innerText();

        if (firstValue.equals("B1")) {
            userClickButtonB1();
        } else {
            userClickButton2();
        }

        if (secondValue.equals("B1")) {
            userClickButtonB1();
        } else {
            userClickButton2();
        }

        if (thirdValue.equals("B1")) {
            userClickButtonB1();
        } else {
            userClickButton2();
        }
    }

    public void clickAndCheckSolution(){
        page.click("//button[@id='solution']");
        assertThat(page.locator("//pre[@id='trail']")).hasText("OK. Good answer");
        System.out.println("Wynik prawidłowy!");
    }

    private void userClickButton2() {
        page.click("(//button[@class='btn_exercise btn_exercise_answer'])[2]");
    }

    private void userClickButtonB1() {
        page.click("(//button[@class='btn_exercise btn_exercise_answer'])[1]");
    }

}
