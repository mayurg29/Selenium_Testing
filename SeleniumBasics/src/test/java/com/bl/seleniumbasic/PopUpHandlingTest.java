package com.bl.seleniumbasic;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Mayur Gotad
 *
 */
public class PopUpHandlingTest extends Base{
	
	@Test
	@SuppressWarnings("static-access")
	public void alertPopUp() {
		try {
			
			utility.initializeDriver();
			
			webDriver.get(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\Alert.html");
			webDriver.findElement(By.xpath("//button[text()='Try it']")).click();
			Alert alert = webDriver.switchTo().alert();
			Thread.sleep(1000);
			
			System.out.println("Alert: " + alert.getText());
			
			alert.accept();
			
			utility.closeDriver();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@SuppressWarnings("static-access")
	public void confirmationPopUp() {
		try {
			
			utility.initializeDriver();
			
			webDriver.get(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\Confirmation Popup.html");
			webDriver.findElement(By.xpath("//button[text()='Try it']")).click();
			Alert alert = webDriver.switchTo().alert();
			System.out.println("Alert: " + alert.getText());
			Thread.sleep(1000);
			alert.accept();
			String msgStatus1 = webDriver.findElement(By.xpath("//p[@id='demo']")).getText();
			System.out.println("Alert Ok status: " + msgStatus1);
			Thread.sleep(1000);
			
			webDriver.findElement(By.xpath("//button[text()='Try it']")).click();
			Thread.sleep(1000);
			alert.dismiss();
			String msgStatus2 = webDriver.findElement(By.xpath("//p[@id='demo']")).getText();
			System.out.println("Alert Cancel status: " + msgStatus2);
			Thread.sleep(1000);
			
			utility.closeDriver();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	@SuppressWarnings("static-access")
	public void geolocation() {
		try {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-geolocation");
			options.addArguments("--ignore-certificate-errors");
			
			utility.initializeDriver();
			webDriver.get("https://www.makemytrip.com/");
			webDriver.findElement(By.xpath("//span[@class='langCardClose']")).click();
			
			utility.closeDriver();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void fileUploadPopUp() {
		try {
			utility.initializeDriver();
			
			webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			Thread.sleep(5000);
			webDriver.findElement(By.name("username")).sendKeys("Admin");
			webDriver.findElement(By.name("password")).sendKeys("admin123");
			webDriver.findElement(By.xpath("//button[@type='submit']")).click();
			webDriver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
			Thread.sleep(2000);
			webDriver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\AutoIt.exe");
			Thread.sleep(3000);
			
			webDriver.get(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\File Upload Popup.html");
			Actions actions = new Actions(webDriver);
			WebElement uploadPhotoBtn = webDriver.findElement(By.id("myFile"));
			actions.moveToElement(uploadPhotoBtn).click().perform();
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\AutoIt.exe");
			Thread.sleep(1500);
			webDriver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(3000);
			
			webDriver.get("https://demo.automationtesting.in/Register.html");
			WebElement chooseFileBtn = webDriver.findElement(By.id("imagesrc"));
			actions.moveToElement(chooseFileBtn).click().perform();
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\AutoIt.exe");
			Thread.sleep(3000);
			utility.closeDriver();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
