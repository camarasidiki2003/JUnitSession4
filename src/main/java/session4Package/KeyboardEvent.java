package session4Package;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEvent {
	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Test
	public void keyboardEventTest() {
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("demo@techfios.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("abc123");
		
		Actions action = new Actions(driver);
//		action.sendKeys(Keys.ENTER).build().perform();
		action.sendKeys(Keys.RETURN).build().perform();
		
}
}