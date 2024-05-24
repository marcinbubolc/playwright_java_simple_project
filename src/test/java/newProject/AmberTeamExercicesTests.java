package newProject;

import POM.Exercise1Page;
import POM.Exercise2Page;
import POM.Exercise3Page;
import org.testng.annotations.Test;

public class AmberTeamExercicesTests extends BaseTest{

    @Test
    public void userShouldBeAbleToSolveAmberTeamExercise1ThreeButtons() {
        Exercise1Page exercise1Page = new Exercise1Page(page);

        mainPage.userOpenGeneralExercises();
        mainPage.userOpenSpecificExercise("1");

        exercise1Page.checkElementsAndClickButtons();
        exercise1Page.clickAndCheckSolution();
    }

    @Test
    public void userShouldBeAbleToSolveAmberTeamExercise2ThreeButtons() {
        Exercise2Page exercise2Page = new Exercise2Page(page);

        mainPage.userOpenGeneralExercises();
        mainPage.userOpenSpecificExercise("2");

        exercise2Page.checkValueAndFill();
        exercise2Page.checkSolution();
    }

    @Test
    public void userShouldBeAbleToSolveAmberTeamExercise3ThreeButtons() {
        Exercise3Page exercise3Page = new Exercise3Page(page);

        mainPage.userOpenGeneralExercises();
        mainPage.userOpenSpecificExercise("3");

        exercise3Page.checkColourAndChoose();
        exercise3Page.checkSolution();
    }
}
