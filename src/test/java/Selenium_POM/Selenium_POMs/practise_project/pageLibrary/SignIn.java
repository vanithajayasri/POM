package Selenium_POM.Selenium_POMs.practise_project.pageLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Selenium_POM.Selenium_POMs.practise_project.testbase.ReusableMethods;

public class SignIn extends ReusableMethods{
	WebDriver driver;
	static String welcomeMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";
	static String messageOfCreateAccount ="message_forCreateAccount";
	public static Logger log = Logger.getLogger(SignIn.class.getName());
	
	By signInLink = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	By CreateAccount_emailAddress = By.xpath("//*[@id='email_create']");
	By createAccountButton = By.xpath("//*[@id='SubmitCreate']");
	By alreadyRegistered_emailAddress = By.xpath("//*[@id='email']");
	By alreadyregistered_password = By.xpath("//*[@id='passwd']");
	By signIn_button = By.xpath("//*[@id='SubmitLogin']");
	By forgetPassword_link = By.xpath("//*[@id='login_form']/div/p[1]/a");
	By welcomeMessage_AfterCreateAccount = By.xpath("//*[@id='center_column']/p");
	By message_forCreateAccount = By.xpath("//*[@id='noSlide']/h1");
	
	
	/**
	 * This method is a constructor
	 */
	public SignIn(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	 * The method for clicking on signInlink
	 */
	public void clickonSignInLink(){
		log.info("clicking on the signin link in the home page");
		driver.findElement(signInLink).click();
	}
	
	/**
	 * The method for entering the email address field to Create an Account
	 */
	public void enterEmailAddr_ToCreateAccount(String emailAdd){
		log.info("clicking on the signin link in the home page");
		driver.findElement(CreateAccount_emailAddress).sendKeys(emailAdd);
	}
	
	/**
	 * The method for clicking on Create an account button
	 */
	public void click_CreateAnAccountButton(){
		log.info("clicking on 'Create an account button' ");
		driver.findElement(createAccountButton).click();
	}
	
	/**
	 * The method to see  message for creating an account.
	 */
	public void Verify_message_forCreateAccount(){
		String text = driver.findElement(message_forCreateAccount).getText();
		try{
			if(messageOfCreateAccount.equalsIgnoreCase(text))
				System.out.println("Account creation messaage matches");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * The method to see welcome message after creating an account.
	 */
	public void Verify_welcomeMessage_AfterUserLogin(){
		String text = driver.findElement(welcomeMessage_AfterCreateAccount).getText();
		try{
			if(welcomeMessage.equalsIgnoreCase(text))
				System.out.println("welcome messaage matches");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

	/**
	 * The method for entering the email address field for the All Already Registered Account
	 */
	public void enterEmailAddr_AllReadyRegisteredAccount(String emailAdd){
		log.info("entering the email address field for the All Already Registered Account");
		driver.findElement(alreadyRegistered_emailAddress).sendKeys(emailAdd);
	}
	
	/**
	 * The method for entering password field for the All Already Registered Account
	 */
	public void enterPassword_AllReadyRegisteredAccount(String password){
		log.info("entering password field for the All Already Registered Account");
		driver.findElement(alreadyregistered_password).sendKeys(password);
	}
	
	/**
	 * The method for clicking on Sign in button
	 */
	public void click_SignInButton(){
		log.info("clicking  on 'Sign in' button ");
		driver.findElement(signIn_button).click();
	}
	
	/**
	 * This method is for login in to account
	 * @throws InterruptedException 
	 */
	
	public void loginToAccount() throws InterruptedException{
		
		clickonSignInLink();
		enterEmailAddr_AllReadyRegisteredAccount(repository.getProperty("email_forLogin"));
		enterPassword_AllReadyRegisteredAccount(repository.getProperty("password_forLogin"));
		click_SignInButton();
		waitfor(5);
		Verify_welcomeMessage_AfterUserLogin();
	}
	
	/**
	 * This method is to create an account
	 * @throws InterruptedException 
	 * 
	 */
	public void CreateAnAcount() throws InterruptedException{
		clickonSignInLink();
		enterEmailAddr_ToCreateAccount("van1"+System.currentTimeMillis()+"@gmail.com");
		click_CreateAnAccountButton();
		waitfor(5);
		Verify_message_forCreateAccount();
	}
}


