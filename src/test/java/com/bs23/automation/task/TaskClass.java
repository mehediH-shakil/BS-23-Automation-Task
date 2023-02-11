package com.bs23.automation.task;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.bs23.automation.task.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TaskClass {

	public static void main(String[] args) {
		ReadConfig config = new ReadConfig();
		String URL = config.getApplicationURL();
		String email = config.getEmail();
		String pass = config.getPassword();
		String from = config.getFrom();
		String to = config.getTo();
		String DepartureDate = config.getDepartureDate();
		String DepartureTime = config.getDepartureTime();
		String ReturnDate = config.getReturnDate();
		String ReturnTime = config.getReturnTime();
		String tripName = config.getTripName();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		Visit the given URL: https://test.sharebus.co/
		driver.get(URL);
		
//		Navigate to login page by clicking the "Sign in" button
		driver.findElement(By.xpath("//*[@id=\"app\"]/nav/div/ul/li/button")).click();
		
//		Login with email("brainstation23@yopmail.com") and password("Pass@1234")
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/form/div[4]/button")).click();
		
//		Select the user as "Sharelead" from the menu options
		driver.findElement(By.className("p-dropdown-label")).click();
		WebElement dropdown = driver.findElement(By.cssSelector(".p-dropdown-panel"));
		List<WebElement> options = dropdown.findElements(By.cssSelector(".p-dropdown-item"));
		for (WebElement option : options) {
			   if (option.getAttribute("aria-label").equals("sharelead")) {
			      option.click();
			      break;
			   }
			}
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/button")).click();
		
//		Click the "Set Up a ShareBus" button
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/button")).click();
		
		
//		Insert required Trips details and click "Continue" [Please use location address as: From="Oslo, Norway" and To="Kolbotn, Norway"]
		WebElement FromsearchBox = driver.findElement(By.id("startPoint"));
        FromsearchBox.sendKeys(from);
        
        Actions actionsFrom = new Actions(driver);
        actionsFrom.sendKeys(Keys.DOWN).perform();
        actionsFrom.sendKeys(Keys.ENTER).perform();
        
        WebElement TosearchBox = driver.findElement(By.id("destination"));
        TosearchBox.sendKeys(to);
        
        Actions actionsTo = new Actions(driver);
        actionsTo.sendKeys(Keys.DOWN).perform();
        actionsTo.sendKeys(Keys.ENTER).perform();
     
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/div[1]/div/form/div[1]/div[3]/div[1]/div[1]/div/div[1]/span/input")).sendKeys(DepartureDate);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/div[1]/div/form/div[1]/div[3]/div[1]/div[1]/div/div[2]/span/input")).sendKeys(DepartureTime);		
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/div[1]/div/form/div[1]/div[3]/div[2]/div[1]/div/div[1]/span/input")).sendKeys(ReturnDate);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/div[1]/div/form/div[1]/div[3]/div[2]/div[1]/div/div[2]/span/input")).sendKeys(ReturnTime);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/div[1]/div/form/div[2]/button[2]")).click();
		

		
		
		
////		On the Membership page click "Yes" and select "NTNUI" club and click "Continue"
//		driver.findElement(By.xpath("//*[@id="app"]/div[1]/div[1]/div[2]/div[1]/div/div[1]/div[1]/button[1]")).click();
//		driver.findElement(By.xpath("//*[@id="app"]/div[1]/div[1]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div/input")).sendKeys("NTNUI");
//		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/div[1]/div/div[2]/button[2]")).click();
//		
//		
////		Need any ticket for himself? click on the "No" button
//		driver.findElement(By.xpath("//*[@id="app"]/div[1]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/button[2]")).click();
//		
//		
////		Activate ticket discounts? click the "No" button
//		driver.findElement(By.xpath("//*[@id="app"]/div[1]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/button[2]")).click();
//		driver.findElement(By.xpath("//*[@id="app"]/div[1]/div[1]/div[2]/div[2]/div/div[2]/div[5]/button[2]")).click();
//		
//		
////		Click on the "Create ShareBus" button
//		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/div[2]/div/div[2]/div[4]/button[2]")).click();
//		
//		
////		Click on the "Publish" button
//		driver.findElement(By.xpath("//*[@id="app"]/div[1]/div/div[4]/button")).click();
//		
//		
////		Insert data on required fields
//		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/form/div[1]/div/input")).sendKeys(tagName);
//		driver.findElement(By.xpath("//*[@id="sport0"]")).click();
//		
//		
////		Click on the "Review and publish" button
//		driver.findElement(By.xpath("//*[@id="app"]/div[1]/div/form/div[5]/button")).click();
//		
//		
////		Click on the "Publish" button
//		driver.findElement(By.xpath("//*[@id="tripPreviewModal"]/div/div/div[3]/button[2]")).click();
//		
//		
////		Click on "my busses" from the navbar
//		driver.findElement(By.xpath("//*[@id="app"]/nav/div/ul/li[1]/button")).click();
		
	
		
		
////		Verify that the new Trip is displayed on the "My busses" page
//		WebElement card = driver.findElement(By.cssSelector(".body-wrapper"));
//		List<WebElement> cardOpts= card.findElements(By.cssSelector(".card-body"));
//		for (WebElement cardOpt : cardOpts) {
//			   String newCard = cardOpt.getText();
//			   String[] TripNameArray = newCard.split("\n", 5);
//			   
//			   if (TripNameArray[0] == tripName) {
//				   System.out.println("New Trip is displayed.");
//               }else {
//            	   System.out.println("New Trip is not displayed.");
//			   }
//			}
//		
//		driver.close();
	}
}
