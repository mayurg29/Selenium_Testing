package com.bl.seleniumbasic;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * @author Mayur Gotad
 *
 */
public class RelativeXpathTest extends Base{
	
	@SuppressWarnings("static-access")
	@Test
	public void xpath() {
		try {
			utility.initializeDriver();
			utility.login();
			WebElement element = webDriver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
			element.sendKeys("mobile");
			element.clear();
			element.sendKeys("laptop");
			element.sendKeys(Keys.ENTER);
			
			WebElement element2 = webDriver.findElement(By.xpath("//span[text()='ASUS VivoBook 15 (2021), 15.6-inch (39.62 cm) HD, Dual Core Intel Celeron N4020, Thin and Light Laptop (4GB RAM/256GB SSD/Integrated Graphics/Windows 11 Home/Transparent Silver/1.8 Kg), X515MA-BR011W']"));
			JavascriptExecutor executor = (JavascriptExecutor) webDriver;
			executor.executeScript("arguments[0].scrollIntoView(true);", element2);
			Thread.sleep(1000);
			element2.click();
			
			utility.switchWindow();
			utility.closeDriver();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
