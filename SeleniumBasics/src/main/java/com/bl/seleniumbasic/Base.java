package com.bl.seleniumbasic;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

/**
 * @author Mayur Gotad
 *
 */
public class Base {
	
	protected static WebDriver webDriver;
	protected static Properties property;
	protected static FileInputStream file;
	protected static Utility utility;
	
	final static String FILE_PATH = System.getProperty("user.dir") + 
									"\\src\\main\\resources\\repository\\config.properties";
}