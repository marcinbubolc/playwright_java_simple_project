package oldProject;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.text.Element;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SecondTest {
    String url = "https://antycaptcha.amberteam.pl/";

    @Test
    public void userShouldBeAbleToSolveAmberTeamExercices() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(500)
        );
        Page page = browser.newPage();
        page.navigate(url);
        assertThat(page).hasURL("https://antycaptcha.amberteam.pl/");

        page.click("//a[contains(text(),'General intoductory exercises')]");
        page.click("//a[contains(text(),'Exercise 1 - Three buttons')]");

        System.out.println("Strona 1 testu została załadowana.");

        String firstValue = page.locator("//tr[2]/td[2]/code").innerText();
        String secondValue = page.locator("//tr[3]/td[2]/code").innerText();
        String thirdValue = page.locator("//tr[4]/td[2]/code").innerText();

        if (firstValue.equals("B1")) {
            page.click("(//button[@class='btn_exercise btn_exercise_answer'])[1]");
        } else {
            page.click("(//button[@class='btn_exercise btn_exercise_answer'])[2]");
        }

        if (secondValue.equals("B1")) {
            page.click("(//button[@class='btn_exercise btn_exercise_answer'])[1]");
        } else {
            page.click("(//button[@class='btn_exercise btn_exercise_answer'])[2]");
        }

        if (thirdValue.equals("B1")) {
            page.click("(//button[@class='btn_exercise btn_exercise_answer'])[1]");
        } else {
            page.click("(//button[@class='btn_exercise btn_exercise_answer'])[2]");
        }

        page.click("//button[@id='solution']");
        assertThat(page.locator("//pre[@id='trail']")).hasText("OK. Good answer");
    }

    @Test
    public void testNumberTwo(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(500)
        );
        Page page = browser.newPage();
        page.navigate(url);
        assertThat(page).hasURL("https://antycaptcha.amberteam.pl/");

        page.click("//a[contains(text(),'General intoductory exercises')]");
        page.click("//a[contains(text(),'Exercise 2')]");

        String textToFill = page.locator("//tr[2]/td[2]/code[1]").innerText();
        page.locator("//input[@id='t14']").fill(textToFill);

        page.locator("//button[@id='btnButton1']").click();
        page.locator("//button[@id='solution']").click();

        assertThat(page.locator("//code[@class='wrap']")).hasText("OK. Good answer");
    }

    @Test
    public void testNumberThree(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(500)
        );
        Page page = browser.newPage();
        page.navigate(url);
        assertThat(page).hasURL("https://antycaptcha.amberteam.pl/");

        page.click("//a[contains(text(),'General intoductory exercises')]");
        page.click("//a[contains(text(),'Exercise 3')]");
        String expectedColour = page.locator("//tbody/tr[2]/td[2]/code").innerText();

        page.selectOption("//select[@id='s13']", expectedColour);
        page.locator("//button[@id='solution']").click();

        assertThat(page.locator("//code[@class='wrap']")).hasText("OK. Good answer");
    }
}
