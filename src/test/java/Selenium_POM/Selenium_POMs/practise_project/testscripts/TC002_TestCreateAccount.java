package Selenium_POM.Selenium_POMs.practise_project.testscripts;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Selenium_POM.Selenium_POMs.practise_project.pageLibrary.SignIn;
import Selenium_POM.Selenium_POMs.practise_project.testbase.ReusableMethods;

public class TC002_TestCreateAccount extends ReusableMethods {
	SignIn createAccount;
	
	
	
	@BeforeClass
	public void setUp() throws IOException{
		init();
	}

	@Test
	public void testCreateAccount() throws InterruptedException{
		createAccount = new SignIn(driver);
		createAccount.CreateAnAcount();
		
		
		
	}
	
	/*@AfterClass
	public void quitBrowser(){
		closeBrowser();
	}*/

}
