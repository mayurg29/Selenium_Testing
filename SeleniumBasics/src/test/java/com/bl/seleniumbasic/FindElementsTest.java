package com.bl.seleniumbasic;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Mayur Gotad
 *
 */
public class FindElementsTest extends Base{
	
	@SuppressWarnings("static-access")
	@Test
	public void find_Elements() {
		try {
			utility.initializeDriver();
			utility.actiTimeLogin();
			Thread.sleep(2000);
			
			List<WebElement> allLinks = webDriver.findElements(By.tagName("a"));
			int totalLinks = allLinks.size();
			System.out.println("Number of links: " + totalLinks);
			
			int visibleLinkCount = 0;
			int hiddenLinkCount = 0;
			for (WebElement link : allLinks) {
				if (link.isDisplayed()) {
					visibleLinkCount++;
					System.out.println("Visible link: " + link.getText());
				} else {
					hiddenLinkCount++;
				}
			}
			
			System.out.println("Visible links :" + visibleLinkCount); 
			System.out.println("Hidden links :" + hiddenLinkCount);
			
			utility.closeDriver();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
