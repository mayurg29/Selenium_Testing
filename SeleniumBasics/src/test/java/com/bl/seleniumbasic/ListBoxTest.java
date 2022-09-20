package com.bl.seleniumbasic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ListBoxTest extends Base{
	
	@SuppressWarnings("static-access")
	@Test
	public void listBox() {
		try {
			utility.initializeDriver();
			
			webDriver.get(System.getProperty("user.dir") + 
						  "\\src\\main\\resources\\repository\\ListBox_Breakfast.html");
			WebElement list = webDriver.findElement(By.id("mtr"));
			Select s = new Select(list);
			
			List<WebElement> options = s.getOptions();
			int size = options.size();
			System.out.println("Number of elements present inside the listbox : " + size);
			
			for (WebElement webElement : options) { 
				String text = webElement.getText();
				System.out.println(text);
			}
			
			System.out.println("--------------------------------------------");
			
			s.selectByIndex(0);
			s.selectByIndex(3);
			s.selectByValue("m");
			s.selectByVisibleText("SAMOSA");
			
			List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
			int size2 = allSelectedOptions.size();
			System.out.println("Number of items selected in the list box : " + size2);
			for (WebElement webElement : allSelectedOptions) {
				System.out.println(webElement.getText());
			}
			
			System.out.println("--------------------------------------------");
			
			s.deselectByIndex(0);
			WebElement firstSelectedOption1 = s.getFirstSelectedOption();
			System.out.println("After deselect: ");
			System.out.println(firstSelectedOption1.getText() + " is the first selected item");
			
			System.out.println("--------------------------------------------");
			
			s.deselectByValue("u");
			WebElement firstSelectedOption2 = s.getFirstSelectedOption();
			System.out.println("After deselect: ");
			System.out.println(firstSelectedOption2.getText() + " is the first selected item");
			
			utility.closeDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void printListValues_SortedOrder() {
		try {
			utility.initializeDriver();
			webDriver.get(System.getProperty("user.dir") + 
						  "\\src\\main\\resources\\repository\\ListBox_Breakfast.html");
			WebElement listElement = webDriver.findElement(By.id("mtr"));
			Select s = new Select(listElement);
			
			List<WebElement> allOptions = s.getOptions();
			int count = allOptions.size();
			System.out.println("Number of elements in the listbox" + count);
			
			ArrayList<String> list = new ArrayList<String>();
			for (WebElement option : allOptions) {
				String text = option.getText();
				System.out.println(text);
				list.add(text);
			}
			
			System.out.println("--------------------------------------------");
			
			Collections.sort(list);
			System.out.println("After sorting: ");
			for (String value : list) {
				System.out.println(value);
			}

			utility.closeDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
