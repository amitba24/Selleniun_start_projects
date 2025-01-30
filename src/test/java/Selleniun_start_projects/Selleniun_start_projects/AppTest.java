package Selleniun_start_projects.Selleniun_start_projects;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.After;
import org.junit.Before;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.lang.Thread;
import org.openqa.selenium.support.ui.Select;
public class AppTest {
	 
	
	 static WebDriver  browser;
	 
	 @Before
	  public void setup() {
		 
			  System.setProperty("webdriver.gecko.driver","C:\\Users\\משתמש\\OneDrive\\שולחן העבודה\\לימודים\\שנה ג\\סמסטר א\\אבטחת איכות תוכנה\\geckodriver-v0.35.0-win64\\geckodriver.exe");
		      browser = new FirefoxDriver();
		  	  browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
		      browser.get("https://testpages.eviltester.com/styled/apps/triangle/triangle001.html");
		
	  }
		

	


	    @After
	    public void tearDown() {
	        browser.quit();
	    }

	    @Test
	    public void Tests1() {
	        // מקרי הבדיקה: { a, b, c, expectedResult }
	        String[][] testCases = {
	            {"1", "1", "2", "Not a triangle"},
	            {"1", "2", "1", "Not a triangle"},
	            {"2", "1", "1", "Not a triangle"},
	            {"2", "2", "2", "equilateral"},
	            {"1", "2", "2", "isosceles"},
	            {"2", "1", "2", "isosceles"},
	            {"2", "2", "1", "isosceles"},
	            {"5", "4", "3", "scalene"}
	        };

	        for (String[] testCase : testCases) {
	            // הכנסת הנתונים
	            browser.findElement(By.id("side1")).clear();
	            browser.findElement(By.id("side1")).sendKeys(testCase[0]);

	            browser.findElement(By.id("side2")).clear();
	            browser.findElement(By.id("side2")).sendKeys(testCase[1]);

	            browser.findElement(By.id("side3")).clear();
	            browser.findElement(By.id("side3")).sendKeys(testCase[2]);

	            // לחיצה על כפתור החישוב
	            browser.findElement(By.id("identify-triangle-action")).click();

	            // השהייה קצרה כדי להמתין לתוצאה
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }

	            // קבלת התוצאה
	            String result = browser.findElement(By.id("calculated-display")).getAttribute("value").toString();
	            
	            // הדפסת התוצאה לקונסול
	            System.out.println("Input: " + testCase[0] + ", " + testCase[1] + ", " + testCase[2] +
	                               " | Expected: " + testCase[3] + " | Actual: " + result);

	            // בדיקה שהתוצאה נכונה
	            assertEquals(testCase[3], result);
	        }
	    }
	}

