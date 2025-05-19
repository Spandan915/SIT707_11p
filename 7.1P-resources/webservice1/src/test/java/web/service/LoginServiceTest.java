package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {
	
	private void sleep(long sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoginSuccess() {
		System.setProperty(
			"webdriver.chrome.driver", "C:\\Users\\Spandan\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe"
		);
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("file:///C:/Users/Spandan/Downloads/7.1P-resources/pages/login.html");
		sleep(2);
		
		WebElement username = driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys("ahsan");   // must match a valid user in LoginService
		
		// Password
		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("ahsan_pass");
		
		// Date of birth
		WebElement dob = driver.findElement(By.id("dob"));
		dob.clear();
		dob.sendKeys("30-08-1995");
		
		WebElement submit = driver.findElement(By.id("submit"));
		submit.click();
		sleep(2);
		
		Assert.assertEquals("success", driver.getTitle());
		driver.quit();
	}


@Test
public void testWelcome() {
	System.setProperty(
		"webdriver.chrome.driver", "C:\\Users\\Spandan\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe"
	);
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://127.0.0.1:8082/");
	sleep(2);
	
	
	
	Assert.assertEquals("", driver.getTitle());
	driver.quit();
}
}
