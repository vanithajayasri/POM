package Selenium_POM.Selenium_POMs.practise_project.testscripts;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Selenium_POM.Selenium_POMs.practise_project.pageLibrary.ContactUs;
import Selenium_POM.Selenium_POMs.practise_project.pageLibrary.SignIn;
import Selenium_POM.Selenium_POMs.practise_project.testbase.ReusableMethods;

public class TC003_TestContactUs extends ReusableMethods{
	ContactUs contact;
	

	@BeforeClass
	public void setUp() throws IOException{
		init();
	}

	@Test
	public void testContactUs() throws InterruptedException{
		contact = new ContactUs(driver);
	
	
		contact.ToConactUs();

	}
	
	/*@AfterClass
	public void quitBrowser(){
		closeBrowser();
	}*/
	

}
