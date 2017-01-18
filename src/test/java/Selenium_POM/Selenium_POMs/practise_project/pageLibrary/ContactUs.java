package Selenium_POM.Selenium_POMs.practise_project.pageLibrary;


import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Selenium_POM.Selenium_POMs.practise_project.testbase.ReusableMethods;

public class ContactUs extends ReusableMethods{
	
	WebDriver driver;
	static String message = "Your message has been successfully sent to our team.";
	public static Logger log = Logger.getLogger(ContactUs.class.getName());
	
	By contactUs_link = By.xpath("//a[@title='Contact Us']");
	By dropdown = By.id("id_contact");
	By sendMess_emailAddr = By.xpath("//*[@id='email']");
	By orderRefer = By.xpath("//*[@id='id_order']");
	By attachFile = By.xpath("//*[@id='fileUpload']");
	By enterMessage = By.xpath("//*[@id='message']");
	By send_button = By.xpath("//*[@id='submitMessage']");
	By message_AfterSendingRequest = By.xpath("//*[@id='center_column']/p");
	
	
	/**
	 * This method is a constructor
	 */
	public ContactUs(WebDriver driver){
		this.driver = driver;
	}
	/**
	 * This method is to click the ContactUS link
	 */
	public void click_contactUsLink(){
		log.info("clicking on the the ContactUS link");
		driver.findElement(contactUs_link).click();
	}
	
	/**
	 * This method is to select dropdown menu
	 */
	
	public void dropdown_Selection(){
		log.info("selecting the dropdown");
		WebElement select = driver.findElement(dropdown);
		
		
		List<WebElement> options = select.findElements(By.tagName("option"));
		{
			for (WebElement option : options) {
				if("Customer service".equals(option.getText().trim()))
				option.click();   
			}
	
		}
	}	
	
	/**
	 * This method is enter email address
	 */
	
	public void enterEmailAddress(String email){
		log.info("entering the email address");
		driver.findElement(sendMess_emailAddr).sendKeys(email);
			
	}
	
	/**
	 * This method is enter order reference
	 */
	
	public void enterOrderReference(String order){
		log.info("entering the order reference");
		driver.findElement(orderRefer).sendKeys(order);
			
	}
	/**
	 * This method is attach files
	 */
	
	public void attachFiles(String path){
		log.info("attaching the files");
		driver.findElement(attachFile).sendKeys(path);
			
	}
	
	/**
	 * This method is to enter message.
	 */
	
	public void enterMessage(String text){
		log.info("entering the message");
		driver.findElement(enterMessage).clear();
		driver.findElement(enterMessage).sendKeys(text);
			
	}
	
	/**
	 * This method is to click the send button.
	 */
	
	public void  click_sendButton(){
		log.info("clicking on the the Send button");
		driver.findElement(send_button).click();
		
			
	}
	/**
	 * This method is to verify the message after sending the message to conatctUs people
	 */
	public void verfiyMessage_AfterPostRequest(){
		log.info("verifying the message");
		String text = driver.findElement(message_AfterSendingRequest).getText();
		
		if(text.equalsIgnoreCase(message)){
			System.out.println("message matches after sending the post messaage");
		}
		else{
			System.out.println("message not matches");
		}
	}
	
	/**
	 * This method to send message by using contact us 
	 * @throws InterruptedException 
	 */
	public void ToConactUs() throws InterruptedException{
		
		click_contactUsLink();
		click_contactUsLink();
		dropdown_Selection();
		enterEmailAddress(repository.getProperty("email_forcontactUs"));
		enterMessage(repository.getProperty("message_forcontactUs"));
		click_sendButton();
		waitfor(5);
		verfiyMessage_AfterPostRequest();
	}
}
