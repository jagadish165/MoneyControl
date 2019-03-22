package Selenium.MoneyControl.Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Selenium.MoneyControl.Pages.HomePageTest;


public class AppTest {	
	private ChromeDriver driver;
	@Test				
	public void GetMutualFundsDetails() {
	HomePageTest HomePage = new HomePageTest(driver);
	HomePage.MutualFundsRunner();
		 
		
}
	@BeforeTest
	public void setUp() throws IOException, AWTException {	
		
		
		Runtime rt = Runtime.getRuntime();
		rt.exec("taskkill /im chromedriver.exe /f /t");
		System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	    driver.manage().window().maximize();
	    driver.get("https://www.moneycontrol.com/mutual-funds/performance-tracker/returns/large-cap-fund.html");
	    
	}
	
}