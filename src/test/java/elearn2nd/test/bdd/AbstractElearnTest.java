package elearn2nd.test.bdd;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import elearn2nd.test.pages.LoginPage;

public abstract class AbstractElearnTest {
	protected static WebDriver driver;
	protected static String URL=System.getProperty("baseUrl", "http://1-0-2.latest.elarn2nd.appspot.com")+"/admin/course/1";

	    @BeforeClass
	    public static void setUp() {
	    	BDD.Before("web driver start");
	    	driver = new FirefoxDriver();
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	driver.get(URL);
	    	
	    }

	    @AfterClass
	    public static void tearDown() {
	    	BDD.After("web driver quit");
	    	driver.quit();
	    }
}
