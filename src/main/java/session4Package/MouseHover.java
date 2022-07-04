package session4Package;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.dell.com/en-us");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Test
	public void mouseHoverTest() {
		
		By PRODUCTS_FIELD = By.xpath("//span[contains(text(), 'Products')]");
		By MONITORS_FIELD = By.xpath("//a[contains (text(), 'Monitors')]");
		By FOR_HOME_MONITORS_FIELD = By.xpath("//a[contains (text(), 'Monitors')]/parent::li/descendant::a[3]");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(PRODUCTS_FIELD)).build().perform();
		action.moveToElement(driver.findElement(MONITORS_FIELD)).build().perform();
		
		driver.findElement(FOR_HOME_MONITORS_FIELD).click();
		

}
}
