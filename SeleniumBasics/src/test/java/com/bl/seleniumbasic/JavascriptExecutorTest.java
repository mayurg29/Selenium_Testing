package com.bl.seleniumbasic;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * @author Mayur Gotad
 *
 */
public class JavascriptExecutorTest extends Base{
	
	@SuppressWarnings("static-access")
	@Test
	public void script() {
		try {
			utility.initializeDriver();
			webDriver.get("https://www.amazon.in/");
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			
			js.executeScript("document.getElementById('nav-link-accountList-nav-line-1').click()");
			js.executeScript("document.getElementById('ap_email').value='mmg@gmail.com'");
			Thread.sleep(500);
			WebElement next = webDriver.findElement(By.xpath("//input[@type='submit']"));
			js.executeScript("arguments[0].click()", next);
			
			js.executeScript("document.getElementById('ap_password').value='password'");
			WebElement signIn = webDriver.findElement(By.xpath("//input[@type='submit']"));
			js.executeScript("arguments[0].click()", signIn);
			Thread.sleep(1500);
			
			String error = webDriver.findElement(By.xpath("//li/span")).getText();
			System.out.println("Error msg: " + error);
			if (error.equals("To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below.")) {
				System.out.println("Error msg is valid");
			} else {
				System.out.println("Error msg is not valid");
			}
			
			utility.closeDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
