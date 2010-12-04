package elearn2nd.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseGridPage {
    private WebDriver driver;

    @FindBy(linkText="logout")
    private WebElement logout;

    @FindBy(xpath = "//*/button[contains(text(),'Add lesson')]")
    private WebElement addLessonButton;

    @FindBy(xpath = "//*/button[contains(text(),'Save')]")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class,'x-grid3-row-last')]/descendant::div[contains(@class,'x-grid3-col-numberer')]")
    private WebElement lastLessonOnGridNo;

    @FindBy(xpath = "//input[@class='x-form-text x-form-field x-form-focus']")
    private WebElement formFocus;

    public void logout() {
        logout.click();
    }

    public CourseGridPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddLesson() {
        addLessonButton.click();
    }

    public void clickSave() {
        saveButton.click();
    }

    public Lesson getLastLesson() {
        return new Lesson(lastLessonOnGridNo.getText());
    }


    public class Lesson {
        private final String id;

        public Lesson(String id) {
            this.id = id;
        }

        public void editName(String newName) {
            WebElement lessonName = getLessonNameByNo(id);
            lessonName.click();
            formFocus.sendKeys(newName);
            formFocus.sendKeys(Keys.ENTER);
        }

        public void editTopic(String newTopic) {
            WebElement lessonTopic = getLessonTopicByNo(id);
            lessonTopic.click();
            formFocus.sendKeys(newTopic);
            formFocus.sendKeys(Keys.ENTER);
        }

        public String name() {
            WebElement lessonName = getLessonNameByNo(id);
            return lessonName.getText();
        }

        public String topic() {
            WebElement lessonTopic = getLessonTopicByNo(id);
            return lessonTopic.getText();
        }

        private WebElement getLessonNameByNo(String lessonNo) {
            WebElement lessonName = driver
                    .findElement(By
                            .xpath("//div[contains(@class,'x-grid3-row ') and position()='"
                                    + lessonNo
                                    + "']/descendant::td[@class='x-grid3-col x-grid3-cell x-grid3-td-name ']"));
            return lessonName;
        }

        private WebElement getLessonTopicByNo(String lessonNo) {
            WebElement lessonTopic = driver
                    .findElement(By
                            .xpath("//div[contains(@class,'x-grid3-row ') and position()='"
                                    + lessonNo
                                    + "']/descendant::td[contains(@class,'x-grid3-td-topic ')]"));
            return lessonTopic;
        }

    }
}
