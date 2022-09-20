package com.bl.seleniumbasic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Mayur Gotad
 *
 */
public class Utility extends Base{
	
	/**
	 * Method to initialize the driver
	 */
	public static void initializeDriver() {
		try {
			property = new Properties();
			file = new FileInputStream(FILE_PATH);
			property.load(file);
			
			if (property.getProperty("currentBrowser").equals("chrome")) {
//				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver_win32\\chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				webDriver = new ChromeDriver();
			} else {
				System.setProperty("webdriver.edge.driver", "C:\\Users\\Dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
//				WebDriverManager.edgedriver().setup();
				webDriver = new EdgeDriver();
			}
			
			webDriver.manage().deleteAllCookies();
			webDriver.manage().window().maximize();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method for logging into Amazon
	 */
	public static void login() {
		try {
			webDriver.get("https://www.amazon.in/");
			webDriver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			Thread.sleep(500);
			
			webDriver.findElement(By.name("email")).sendKeys(property.getProperty("email"));
			webDriver.findElement(By.id("continue")).click();
			Thread.sleep(500);
			
			webDriver.findElement(By.name("password")).sendKeys(property.getProperty("password"));
			webDriver.findElement(By.id("signInSubmit")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void actiTimeLogin() {
		try {
			webDriver.get("https://demo.actitime.com/login.do");
			webDriver.findElement(By.name("username")).sendKeys("trainee");
			Thread.sleep(500);
			webDriver.findElement(By.name("pwd")).sendKeys("trainee");
			Thread.sleep(500);
			webDriver.findElement(By.id("loginButton")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to take screenshot
	 */
	public static void takeScreenshot() {
		try {
			String date = new Date().toString().replaceAll(":", "_");
			System.out.println("Date is: " + date);
			
			TakesScreenshot ts = (TakesScreenshot) webDriver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File("\\src\\main\\resources\\screenshot" + date + "HomePage.png");
			FileUtils.copyFile(srcFile, destFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method for switching tabs
	 */
	public static void switchWindow() {
		try {
			String parent = webDriver.getWindowHandle();
			Set<String> windows = webDriver.getWindowHandles();
			System.out.println(windows);
			Iterator<String> i = windows.iterator();
			
			while (i.hasNext()) {
				String childWindow = i.next();
				if (!(parent.equals(childWindow))) {
					webDriver.switchTo().window(childWindow);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to close the driver
	 */
	public static void closeDriver() {
		try {
			webDriver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
