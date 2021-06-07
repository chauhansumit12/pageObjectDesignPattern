package com.utility.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {


	public static WebDriver driver;
	public static Properties prop;
	public static String PROJECT_PATH = System.getProperty("user.dir");
	public static long PAGE_LOAD_TIMEOUT = 200;
	public static long IMPLICIT_WAIT = 300;
	
	// Loading of Property File that contins URL , username , password
		public TestBase() {
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(
						// dir of property file
						PROJECT_PATH + "/src/test/java/com/westwing/configs/config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

		
		
		@SuppressWarnings("deprecation")
		public static void initialization(String browserName,String locale) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					PROJECT_PATH + "/src/test/java/com/westwing/configs/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
		    options.addArguments("--lang=" + locale);
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("FF")) {
			//code 
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		WrapperFunctions.waitForTime(2000);

		}

		
		

}




