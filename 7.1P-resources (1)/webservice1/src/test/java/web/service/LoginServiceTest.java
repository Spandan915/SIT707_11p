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
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoginSuccess() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\Users\\Spandan\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();		
		System.out.println("Driver info: " + driver);
		
		// Full path where login.html is located.
		// You can click on html file and copy the path shown in your browser.
		//
		driver.navigate().to(
				"file:////C:\\Users\\Spandan\\Downloads\\7.1P-resources (1)\\pages/login.html");
		sleep(5);
		
		// Find username element
		//
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("spandan");
		
		// Find password element
		//
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("spandan_abc");
		
		WebElement dobElement = driver.findElement(By.id("dob"));
		dobElement.clear();
		dobElement.sendKeys("12-08-2000");
		
		// Find Submit button, and click on button.
		//
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
		
		sleep(5);
		
		/*
		 * On successful login, the title of page changes to 'success',
		 * otherwise, 'fail'.
		 */
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		
		Assert.assertEquals(title, "success");
		
		driver.close();
	}
	
	@Test
	public void testLoginFailure() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Spandan\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("file:////C:\\Users\\Spandan\\Downloads\\7.1P-resources (1)\\pages/login.html");
		sleep(5);
		
		WebElement usernameElement = driver.findElement(By.id("username"));
		usernameElement.clear();
		usernameElement.sendKeys("invalid_user");
		
		WebElement passwordElement = driver.findElement(By.id("passwd"));
		passwordElement.clear();
		passwordElement.sendKeys("invalid_password");
		
		WebElement dobElement = driver.findElement(By.id("dob"));
		dobElement.clear();
		dobElement.sendKeys("12-08-2000"); // Assuming a valid date
		
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
		submitButton.click();
		
		sleep(5);
		
		// Verify that the login fails by checking the page title
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assert.assertEquals("fail", title);
		
		driver.close();
	}
	
	@Test
	public void testRegisterSuccess() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Spandan\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("file:////C:\\Users\\Spandan\\Downloads\\7.1P-resources (1)\\pages/register.html");
		sleep(5);

		WebElement fNameElement = driver.findElement(By.id("fname"));
		fNameElement.clear();
		fNameElement.sendKeys("Virat");

		WebElement lNameElement = driver.findElement(By.id("lname"));
		lNameElement.clear();
		lNameElement.sendKeys("Doe");

		WebElement emailElement = driver.findElement(By.id("email"));
		emailElement.clear();
		emailElement.sendKeys("virat.doe@example.com");

		WebElement dobElement = driver.findElement(By.id("dob"));
		dobElement.clear();
		dobElement.sendKeys("01-01-1990"); // Assuming a valid date

		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
		submitButton.click();

		sleep(5);

		// Assuming the server returns a JSON response with status "ok"
		String response = driver.findElement(By.tagName("body")).getText();
		System.out.println("Response: " + response);
		Assert.assertEquals("{\"status\": \"ok\"}", response);

		driver.close();
	}
	
	@Test
	public void testInvalidUsername() {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Spandan\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();

	    driver.navigate().to("file:////C:\\Users\\Spandan\\Downloads\\7.1P-resources (1)\\pages\\login.html");
	    sleep(5);

	    WebElement usernameElement = driver.findElement(By.id("username"));
	    usernameElement.clear();
	    usernameElement.sendKeys("invalid_username");

	    WebElement passwordElement = driver.findElement(By.id("passwd"));
	    passwordElement.clear();
	    passwordElement.sendKeys("spandan_abc");

	    WebElement dobElement = driver.findElement(By.id("dob"));
	    dobElement.clear();
	    dobElement.sendKeys("12-08-2000"); // Assuming a valid date

	    WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
	    submitButton.click();

	    sleep(5);

	    String title = driver.getTitle();
	    System.out.println("Title: " + title);
	    Assert.assertEquals("fail", title);

	    driver.close();
	}
	
	@Test
	public void testInvalidPassword() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Spandan\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("file:////C:\\Users\\Spandan\\Downloads\\7.1P-resources (1)\\pages/login.html");
		sleep(5);

		WebElement usernameElement = driver.findElement(By.id("username"));
		usernameElement.clear();
		usernameElement.sendKeys("spandan");

		WebElement passwordElement = driver.findElement(By.id("passwd"));
		passwordElement.clear();
		passwordElement.sendKeys("invalid_password");

		WebElement dobElement = driver.findElement(By.id("dob"));
		dobElement.clear();
		dobElement.sendKeys("12-08-2000"); // Assuming a valid date

		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
		submitButton.click();

		sleep(5);

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assert.assertEquals("fail", title);

		driver.close();
	}
	
	@Test
	public void testEmptyFields() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Spandan\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("file:////C:\\Users\\Spandan\\Downloads\\7.1P-resources (1)\\pages/login.html");
		sleep(5);

		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
		submitButton.click();

		sleep(5);

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assert.assertEquals("fail", title);

		driver.close();
	}
	
	@Test
	public void testInvalidDOBFormat() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Spandan\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("file:////C:\\Users\\Spandan\\Downloads\\7.1P-resources (1)\\pages/login.html");
		sleep(5);

		WebElement usernameElement = driver.findElement(By.id("username"));
		usernameElement.clear();
		usernameElement.sendKeys("spandan");

		WebElement passwordElement = driver.findElement(By.id("passwd"));
		passwordElement.clear();
		passwordElement.sendKeys("spandan_pass");

		WebElement dobElement = driver.findElement(By.id("dob"));
		dobElement.clear();
		dobElement.sendKeys("03*03*2000"); // Invalid date format

		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
		submitButton.click();

		sleep(5);

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assert.assertEquals("fail", title);

		driver.close();
	}
	
	@Test
	public void testEmptyDOB() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Spandan\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("file:////C:\\Users\\Spandan\\Downloads\\7.1P-resources (1)\\pages/login.html");
		sleep(5);

		WebElement usernameElement = driver.findElement(By.id("username"));
		usernameElement.clear();
		usernameElement.sendKeys("spandan");

		WebElement passwordElement = driver.findElement(By.id("passwd"));
		passwordElement.clear();
		passwordElement.sendKeys("spandan_abc");

		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
		submitButton.click();

		sleep(5);

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assert.assertEquals("fail", title);

		driver.close();
	}
	
	@Test
	public void testInvalidCredentials() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Spandan\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("file:////C:\\Users\\Spandan\\Downloads\\7.1P-resources (1)\\pages/login.html");
		sleep(5);

		WebElement usernameElement = driver.findElement(By.id("username"));
		usernameElement.clear();
		usernameElement.sendKeys("invalid_username");

		WebElement passwordElement = driver.findElement(By.id("passwd"));
		passwordElement.clear();
		passwordElement.sendKeys("invalid_password");

		WebElement dobElement = driver.findElement(By.id("dob"));
		dobElement.clear();
		dobElement.sendKeys("12-08-2000"); // Assuming a valid date

		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
		submitButton.click();

		sleep(5);

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assert.assertEquals("fail", title);

		driver.close();
	}


}