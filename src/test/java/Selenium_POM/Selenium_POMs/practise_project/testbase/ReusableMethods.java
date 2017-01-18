package Selenium_POM.Selenium_POMs.practise_project.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReusableMethods {

	public static Properties repository = new Properties();
	public WebDriver driver;
	public File f;
	public FileInputStream fi;
	
	public void init() throws IOException{
		loadFileProperties();
		selectBrowser(repository.getProperty("browser"));
		driver.get(repository.getProperty("url"));
	}
	
	public void loadFileProperties() throws IOException{
		f = new File(System.getProperty("user.dir")+"//src//test//java//Selenium_POM//Selenium_POMs//practise_project//testdata//config.properties");
		fi = new FileInputStream(f);
		repository.load(fi);
	}
	
	/**
	 * This method is to select the browser
	 */
	public WebDriver selectBrowser(String browser){
		if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
			// Here I am setting up the path for my  chromeDriver
			System.setProperty("webdriver.chrome.driver", "C://Users//sudt//Downloads//chromedriver_win32//chromedriver.exe");
			 driver = new ChromeDriver();
			
		}
		else if (browser.equalsIgnoreCase("ie")) { 
			 
			  // Here I am setting up the path for my IEDriver
		 
			  System.setProperty("webdriver.ie.driver", "C://Users//sudt//Downloads//IEDriverServer_x64_2.53.1//IEDriverServer (2).exe");
		 
			  driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
		
	}	
	
	/**
	 * This method is to stop the browser for few milliseconds
	 * @throws InterruptedException 
	 */
	public void waitfor(int time) throws InterruptedException{
		Thread.sleep(time*1000);
	}
	
	/**
	 * This method is to close the browser
	 */
	public void closeBrowser(){
		driver.quit();
	}
}
