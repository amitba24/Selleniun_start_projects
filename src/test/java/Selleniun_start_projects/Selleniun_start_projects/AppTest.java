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
public class AppTest {
	 
	
	 static WebDriver  browser;
	 
	 @Before
	  public void setup() {
		 
			  System.setProperty("webdriver.gecko.driver","C:\\Users\\משתמש\\OneDrive\\שולחן העבודה\\לימודים\\שנה ג\\סמסטר א\\אבטחת איכות תוכנה\\geckodriver-v0.35.0-win64\\geckodriver.exe");
		      browser = new FirefoxDriver();
		  	  browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
		      browser.get("https://testpages.eviltester.com/styled/apps/triangle/triangle001.html");
		
	  }
		

	

	public class TriangleTest {

	    // פונקציה לסיווג סוג המשולש
	    public String classifyTriangle(int a, int b, int c) {
	        if (a + b <= c || a + c <= b || b + c <= a) {
	            return "Not a triangle";
	        } else if (a == b && b == c) {
	            return "equilateral";
	        } else if (a == b || b == c || a == c) {
	            return "isosceles";
	        } else {
	            return "scalene";
	        }
	    }

	    @Test
	    public void testTriangleClassificationOnWebsite() {
	        // טבלת מקרי הבדיקה
	        Object[][] testCases = {
	            {"Not a triangle", 1, 1, 2, "#1"},
	            {"Not a triangle", 1, 2, 1, "#2"},
	            {"Not a triangle", 2, 1, 1, "#3"},
	            {"equilateral", 2, 2, 2, "#4"},
	            {"isosceles", 1, 2, 2, "#5"},
	            {"isosceles", 2, 1, 2, "#6"},
	            {"isosceles", 2, 2, 1, "#7"},
	            {"scalene", 5, 4, 3, "#8"}
	        };

	        for (Object[] testCase : testCases) {
	            String expectedResult = (String) testCase[0];
	            int a = (int) testCase[1];
	            int b = (int) testCase[2];
	            int c = (int) testCase[3];
	            String testCaseId = (String) testCase[4];

	            // שליחת הנתונים לשדות באתר
	            WebElement sideA = browser.findElement(By.id("triangle_side1"));
	            WebElement sideB = browser.findElement(By.id("triangle_side2"));
	            WebElement sideC = browser.findElement(By.id("triangle_side3"));

	            sideA.clear();
	            sideB.clear();
	            sideC.clear();

	            sideA.sendKeys(String.valueOf(a));
	            sideB.sendKeys(String.valueOf(b));
	            sideC.sendKeys(String.valueOf(c));

	            // לחיצה על כפתור החישוב
	            browser.findElement(By.id("calculate")).click();

	            // קריאת התוצאה
	            WebElement resultElement = browser.findElement(By.id("triangle_type"));
	            String actualResult = resultElement.getText();

	            // השוואה בין התוצאה הצפויה לתוצאה בפועל
	            assertEquals(expectedResult, actualResult, "Test " + testCaseId + " failed.");
	        }
	    }
	}

	
}