package sit707_week2;

import java.io.File; 
import java.io.IOException; 
 
import org.apache.commons.io.FileUtils; 
import org.openqa.selenium.By; 
import org.openqa.selenium.OutputType; 
import org.openqa.selenium.TakesScreenshot; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Spandan\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		 driver.manage().window().maximize();
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Spandan");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		WebElement lName = driver.findElement(By.id("lastname")); 
        lName.sendKeys("Das"); 
        WebElement phoneNumber = driver.findElement(By.xpath("//*[@id=\"phoneNumber\"]")); 
        phoneNumber.sendKeys("0404041818"); 
        WebElement email = driver.findElement(By.id("email")); 
        email.sendKeys("spandandas915@gmail.com"); 
        WebElement password = driver.findElement(By.id("password")); 
        password.sendKeys("Spandan123@"); 
        WebElement rPass = driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")); 
        rPass.sendKeys("Spandan123"); 
 
        /* 
         * Identify button 'Create account' and click to submit using Selenium API. 
         */ 
        // Write code 
        WebElement enterKey = driver.findElement(By.xpath( 
                "/html/body/div[2]/div/div[1]/div/div/form/div[12]/button")); 
        enterKey.click(); 
        sleep(3); 
        /* 
         * Take screenshot using selenium API. 
         */ 
        // Write code 
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
        try { 
            FileUtils.copyFile(src, new File( 
                    "C:\\Users\\Spandan\\Desktop\\Selenium SS\\Screen.png")); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
 
        // Sleep a while 
        sleep(2);
		
		
		// close chrome driver
		driver.close();	
	}
	
	
}
