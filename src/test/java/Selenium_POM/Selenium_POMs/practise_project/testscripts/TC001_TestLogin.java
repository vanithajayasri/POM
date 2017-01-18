package Selenium_POM.Selenium_POMs.practise_project.testscripts;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Selenium_POM.Selenium_POMs.practise_project.pageLibrary.SignIn;
import Selenium_POM.Selenium_POMs.practise_project.testbase.ReusableMethods;

public class TC001_TestLogin extends ReusableMethods{
	
	SignIn signIn;
	
	
	@BeforeClass
	public void setUp() throws IOException{
		init();
	}

	@Test
	public void testLogin() throws InterruptedException{
		signIn = new SignIn(driver);
		signIn.loginToAccount();
		
		
	}
	
	/*@AfterClass
	public void quitBrowser(){
		closeBrowser();
	}*/
}
