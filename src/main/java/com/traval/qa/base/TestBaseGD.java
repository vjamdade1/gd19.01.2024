package com.traval.qa.base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.traval.qa.confiq.ConfigureProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseGD

{
	
	public static WebDriver driver;
	public static String ImpliWait ;
	
	
	public static void implicitewait() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(com.traval.qa.utility.TestUtilGD.IMPLICITE_WAIT));
	}
		@SuppressWarnings("deprecation")
		public static void initialization1()
		
		{
			
			
			driver =  new FirefoxDriver();; 
			//driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts(). pageLoadTimeout(com.traval.qa.utility.TestUtilGD.PAGE_LOAD_TIMEOUT, TimeUnit. SECONDS);
			//ImpliWait	= "driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(com.traval.qa.utility.TestUtilGD.IMPLICITE_WAIT))
			driver.get(ConfigureProperties.URL);	
	}
	
	
}
