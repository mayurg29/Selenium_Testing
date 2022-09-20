package com.bl.seleniumbasic;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Mayur Gotad
 *
 */
public class ActionsClassTest extends Base{
	
	@SuppressWarnings("static-access")
	@Test
	public void mouse_Keyboard_Operations() {
		
		try {
			utility.initializeDriver();
			utility.login();
			
			Actions action = new Actions(webDriver);
			WebElement element = webDriver.findElement(By.id("twotabsearchtextbox"));
			action.contextClick(element).perform();
			
			Robot robot = new Robot();
			for (int i = 0; i < 6; i++) {
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
			}
			Thread.sleep(1500);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			Thread.sleep(2000);
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_I);
			robot.keyRelease(KeyEvent.VK_I);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
				
			utility.closeDriver();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void dragAndDrop() {
		try {
			utility.initializeDriver();
			
			webDriver.navigate().to("https://demoqa.com/droppable/");
			WebElement drag = webDriver.findElement(By.id("draggable"));
			WebElement drop = webDriver.findElement(By.id("droppable"));
			
			Actions action = new Actions(webDriver);
			action.dragAndDrop(drag, drop).build().perform();
			Thread.sleep(3000);
			utility.closeDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
