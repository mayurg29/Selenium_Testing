package com.bl.seleniumbasic;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Mayur Gotad
 *
 */
public class RobotTest extends Base{

	@SuppressWarnings("static-access")
	@Test
	public void keyboardOperations() {
		try {
			utility.initializeDriver();
			utility.login();
			Thread.sleep(1500);
			
			String title = webDriver.getTitle();
			Assert.assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", title);
			
			Robot robot = new Robot();
			robot.mouseMove(684, 145);
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F);
			robot.keyRelease(KeyEvent.VK_F);
			robot.keyRelease(KeyEvent.VK_ALT);
			Thread.sleep(2000);

			utility.closeDriver();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}