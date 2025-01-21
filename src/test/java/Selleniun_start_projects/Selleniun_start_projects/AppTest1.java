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
		    public void testPasswordValidation() {
		        // טבלת מקרי הבדיקה
		        Object[][] testCases = {
		            {"Password is valid", "Abc123*", "#1"},
		            {"Password is invalid", "Ab1!@", "#2"},
		            {"Password is invalid", "abc123*", "#3"},
		            {"Password is invalid", "ABC123*", "#4"},
		            {"Password is valid", "Abc123*", "#5"},
		            {"Password is valid", "123*abc", "#6"},
		            {"Password is invalid", "Password123!", "#7"},
		            {"Password is invalid", "Abc@123", "#8"},
		            {"Password is valid", "A12345*", "#9"},
		            {"Password is invalid", "abc$123", "#10"}
		        };

		        for (Object[] testCase : testCases) {
		            String expectedResult = (String) testCase[0];
		            String password = (String) testCase[1];
		            String testCaseId = (String) testCase[2];

		            // שליחת הסיסמה לשדה המתאים באתר
		            WebElement passwordField = browser.findElement(By.id("password"));
		            passwordField.clear();
		            passwordField.sendKeys(password);

		            // לחיצה על כפתור בדיקת הסיסמה
		            browser.findElement(By.id("submitbutton")).click();

		            // קבלת התוצאה שהתקבלה על הסיסמה
		            WebElement resultElement = browser.findElement(By.id("password-result"));
		            String actualResult = resultElement.getText();

		            // השוואת התוצאה הצפויה לתוצאה שהתקבלה בפועל
		            assertEquals(expectedResult, actualResult, "Test " + testCaseId + " failed.");
		        }
		    }

		 
			

}
