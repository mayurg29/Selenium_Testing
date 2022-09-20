package com.bl.seleniumbasic;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Mayur Gotad
 *
 */
public class AmazonTest extends Base{
	
	@Test
	@SuppressWarnings("static-access")
	public void welcomePage() {
		try {
			utility.initializeDriver();
			utility.login();
			Thread.sleep(500);
			utility.takeScreenshot();
			
			Actions action =  new Actions(webDriver);
			WebElement element = webDriver.findElement(By.xpath("//span[contains(text(),'Account & Lists')]"));
			action.moveToElement(element).perform();
			Thread.sleep(500);
			webDriver.findElement(By.linkText("Your Orders")).click();
			Thread.sleep(1000);
			
			WebElement element2 = webDriver.findElement(By.xpath("//input[@placeholder='Search all orders']"));
			int x = element2.getLocation().getX();
			int y = element2.getLocation().getY();
			System.out.println("X-Coordinate: " + x + " Y-Coordinate: " + y);
			
			int height = element2.getSize().getHeight();
			int width = element2.getSize().getWidth();
			System.out.println("Height of element: " + height + "\nWidth of element: " + width);
			Thread.sleep(1000);
			
			webDriver.navigate().back();
			Thread.sleep(1000);
			webDriver.navigate().forward();
			Thread.sleep(1000);
			webDriver.navigate().refresh();
			Thread.sleep(3000);
			utility.closeDriver();
			
		} catch (Exception e) {
			System.out.println("Cause of error: " + e.getCause());
			System.out.println("Error message: " + e.getMessage());
			e.printStackTrace();
		}
		
	}	
	
	@Test
	@SuppressWarnings("static-access")
	public void verifyHomePageUsingUniqueElement() {
		
		utility.initializeDriver();
		utility.login();
		WebElement logo = webDriver.findElement(By.id("nav-logo-sprites"));
		if (logo.isDisplayed()) {
			System.out.println("Amazon logo is displayed");
		} else {
			System.out.println("Amazon logo is not displayed");
		}
		
		String text = webDriver.findElement(By.xpath("//h3")).getText();
		System.out.println("Text of element: " + text);
		
		String tagName = webDriver.findElement(By.xpath("//h3")).getTagName();
		System.out.println("Tag name: " + tagName);
		
		int y1 = webDriver.findElement(By.linkText("Fresh")).getLocation().getY();
		int height1 = webDriver.findElement(By.linkText("Fresh")).getSize().getHeight();
		
		int y2 = webDriver.findElement(By.linkText("Gift Cards")).getLocation().getY();
		int height2 = webDriver.findElement(By.linkText("Gift Cards")).getSize().getHeight();
		
		if (y1 == y2 && height1 == height2) {
			System.out.println("Equal");
		} else {
			System.out.println("Not equal");
		}
		utility.closeDriver();
	}
	
	@Test
	@SuppressWarnings("static-access")
	public void verifyLoginPage() {
		
		try {
			utility.initializeDriver();
			webDriver.get("https://www.amazon.in/");
			webDriver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			Thread.sleep(500);
			
			webDriver.findElement(By.name("email")).sendKeys("mayur@gmail.com");
			webDriver.findElement(By.id("continue")).click();
			
			WebElement password = webDriver.findElement(By.name("password"));
			password.sendKeys("pwd");
			Thread.sleep(700);
//			password.clear();
			password.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
			
			WebElement checkbox = webDriver.findElement(By.xpath("//input[@type='checkbox']"));
			checkbox.click();
			if (checkbox.isSelected()) {
				System.out.println("Checkbox is selected");
			} else {
				System.out.println("Checkbox is not selected");
			}
			Thread.sleep(1000);

			webDriver.findElement(By.xpath("//a[@role='button']")).click();
			Thread.sleep(1000);
			webDriver.findElement(By.xpath("//button[@data-action='a-popover-close']")).click();
			Thread.sleep(1000);
			
			utility.closeDriver();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
