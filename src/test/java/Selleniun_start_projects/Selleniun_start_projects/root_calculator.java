package Selleniun_start_projects.Selleniun_start_projects;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class root_calculator {
	 static WebDriver  browser;
	
	@Before
	  public void setup() {
		 
			  System.setProperty("webdriver.gecko.driver","C:\\Users\\משתמש\\OneDrive\\שולחן העבודה\\לימודים\\שנה ג\\סמסטר א\\אבטחת איכות תוכנה\\geckodriver-v0.35.0-win64\\geckodriver.exe");
		      browser = new FirefoxDriver();
		  	  browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			  String url="https://www.mathportal.org/calculators/polynomials-solvers/polynomial-roots-calculator.php";
		      browser.get(url);
		
	  }
	
	 @Test
		public void Tests1() {
		 browser.findElement(By.id("val1")).sendKeys("x^2+4x+3");
		 browser.findElement(By.id("submitButton")).click();
		 String result= browser.findElements(By.cssSelector("p.dummy_class:nth-child(4)")).toString();
		 System.out.print(result);
	 }
	    	

}
