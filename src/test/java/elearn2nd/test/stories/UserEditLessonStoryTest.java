package elearn2nd.test.stories;

import elearn2nd.test.bdd.AbstractElearnTest;
import org.openqa.selenium.support.PageFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import elearn2nd.test.pages.CourseGridPage;
import elearn2nd.test.pages.LoginPage;

import static elearn2nd.test.bdd.BDD.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static shouldmatchers.ShouldMatchers.the;


@SuppressWarnings({"LawOfDemeter"})
public class UserEditLessonStoryTest extends AbstractElearnTest {
    static double rand=Math.random()*11111;
    public static final String LESSON_NAME = "lekcja"+rand;
    public static final String LESSON_TOPIC = "temat"+rand;
    public static final String LOGIN= System.getProperty("login");
    public static final String PASSWD=System.getProperty("password");

    CourseGridPage courseGrid = PageFactory.initElements(driver, CourseGridPage.class);

    @Before
    public void before(){
        Before("login");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(LOGIN,PASSWD);
    }
    @After
    public void after(){
        After("logout");
        courseGrid.logout();
    }


    @Test
    public void userAddsNewLesson(){
        Scenario("User adds new lesson."); {
            Given("The Course 1 grid page is displayed."); {
                the(driver.getTitle()).should(not(containsString("Konta Google")));
            }
            When("When user adds new lesson"); {
                courseGrid.clickAddLesson();
            }
            Then("The new lesson is displayed on Course grid"); {
                CourseGridPage.Lesson lastLesson= courseGrid.getLastLesson();
                the(lastLesson.name()).shouldBe("new lesson name...");
                the(lastLesson.topic()).shouldBe("new lesson topic...");
            }
        }
    }

    @Test
    public void userModifiesLessonOnCourseGrid(){
        Scenario("User modifies lesson on course grid."); {
            CourseGridPage.Lesson lesson;
            Given("The new lesson is displayed on Course grid");{
                the(driver.getTitle()).should(not(containsString("Konta Google")));
                courseGrid.clickAddLesson();
                lesson = courseGrid.getLastLesson();
            }
            When("user edits lesson name & topic"); {
                lesson.editName(LESSON_NAME);
                lesson.editTopic(LESSON_TOPIC);
            }
            And("user saves the course"); {
                courseGrid.clickSave();
                lesson = courseGrid.getLastLesson();
            }
            Then("the modified course name is displayed"); {
                the(lesson.name()).shouldBe(LESSON_NAME);
            }
            And("the modified course topic is displayed"); {
                the(lesson.topic()).shouldBe(LESSON_TOPIC);
            }
        }
    }

}