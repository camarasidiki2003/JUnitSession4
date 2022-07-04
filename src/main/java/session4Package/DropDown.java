package session4Package;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

WebDriver driver;
@Before
public void Login() {
	
	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.get("https://www.techfios.com/billing/?ng=login/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}

@Test
public void dropDown() {
	
	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("demo@techfios.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("abc123");
	driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button")).click();
	
	
	By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");

	
//	Assert.assertTrue("Wrong Page!!!", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
	
//	Assert.assertEquals("Dashboard page not found!!", "Dashboard", driver.findElement(DASHBOARD_HEADER_FIELD).getText());
//	System.out.println(driver.findElement(DASHBOARD_HEADER_FIELD).getText());
	
	Assert.assertEquals("Dashboard page not found!!", "Dashboard- iBilling", driver.getTitle());
//	System.out.println(driver.getTitle());
	
	driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]")).click();
	driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")).click();
	
	By COUNTRY_DROPDOWN_FIELD = By.xpath("//select[@id='cid']");
	
	Select sel = new Select(driver.findElement(COUNTRY_DROPDOWN_FIELD));
	sel.selectByVisibleText("Techfios");
	
	//homework
	sel.getOptions();
	
}
	
	
}
