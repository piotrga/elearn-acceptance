package elearn2nd.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	private WebDriver driver;

	@FindBy(id = "Email")
    private WebElement email;
	
	@FindBy(id = "Passwd")
    private WebElement passwd;
	
	public LoginPage(WebDriver driver) {
	    this.driver = driver;
	}


    public void login(String login, String password) {
    	email.sendKeys(login);
    	passwd.sendKeys(password);
    	passwd.submit();    	
    }

}
