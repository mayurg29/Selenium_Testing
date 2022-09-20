package com.bl.seleniumbasic;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Mayur Gotad
 *
 */
public class WebTableTest extends Base{
	
	@SuppressWarnings("static-access")
	@Test
	public void webTable_Example() {
		try {
			utility.initializeDriver();
			
			webDriver.get(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\WebTable.html");
			List<WebElement> rows = webDriver.findElements(By.xpath("//tr"));
			int totalRows = rows.size();
			System.out.println("Total number of rows in the table: " + totalRows);
			
			List<WebElement> columns = webDriver.findElements(By.xpath("//th"));
			int totalColumns = columns.size();
			System.out.println("Total number of columns in the table: " + totalColumns);
			
			List<WebElement> cells = webDriver.findElements(By.xpath("//th|//td")); 
			int totalCells = cells.size(); 
			System.out.println("Total number of cells in the table is: " + totalCells);
			
			int countNumberValue = 0; 
			int sum = 0;
			for (WebElement cell : cells) {
				String cellValue = cell.getText(); 
				try {
					int number = Integer.parseInt(cellValue); 
					System.out.print(number + " "); 
					countNumberValue++;
					sum = sum + number; 
				} catch (Exception e) {
					
				}
			}	 
			
			System.out.println("\nTotal count of numeric values is: " + countNumberValue);
			System.out.println("Sum of all the numeric values is: " + sum);
		
			utility.closeDriver();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
