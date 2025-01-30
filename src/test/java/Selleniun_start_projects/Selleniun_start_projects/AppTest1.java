package Selleniun_start_projects.Selleniun_start_projects;

	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.junit.Before;
	import java.time.Duration;
	import io.github.bonigarcia.wdm.WebDriverManager;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.firefox.FirefoxDriver;

	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertNotEquals;

	import java.lang.Thread;
	import org.openqa.selenium.support.ui.Select;
	
	public class AppTest1 {
		 static WebDriver  browser;
		 
		 @Before
		  public void setup() {
			 
				  System.setProperty("webdriver.gecko.driver","C:\\Users\\משתמש\\OneDrive\\שולחן העבודה\\לימודים\\שנה ג\\סמסטר א\\אבטחת איכות תוכנה\\geckodriver-v0.35.0-win64\\geckodriver.exe");
			      browser = new FirefoxDriver();
			  	  browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				
			      browser.get("https://testpages.eviltester.com/styled/apps/7charval/simple7charvalidation.html");
			
		  }
		   @Test

	
		  public void Tests1() {
		   
		   browser.findElement(By.name("characters")).sendKeys("chaya34");

		   browser.findElement(By.name("validate")).click();
		   String result= browser.findElement(By.name("validation_message")).toString();
		   String  Expected="Valid Value";
		   assertEquals(Expected,result);
		   

			
		   }}

