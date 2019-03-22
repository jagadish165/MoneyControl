package Selenium.MoneyControl.Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Selenium.MoneyControl.PageObjects.MutualFundsPage;

public class HomePageTest {
	
	private ChromeDriver driver;
	public HomePageTest(ChromeDriver driver) {
		this.driver = driver;
		  //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	}
	public void MutualFundsRunner() {
		getMutualFundSectors();
		
	}
	
	
	
	public void getMutualFundSectors() {
		List<WebElement> MFNav = driver.findElements(By.xpath(MutualFundsPage.MutualFundsNav));
		for(int i=0;i<MFNav.size();i++) {
			MFNav = driver.findElements(By.xpath(MutualFundsPage.MutualFundsNav));
			
			System.out.println(MFNav.get(i).getText());
			System.out.println("__________________________________________________________");
			
			MFNav.get(i).click();
			getMutualFunds();
			
		}
	
	}
	public void getMutualFunds() {
		List<WebElement> MFSeg = driver.findElements(By.xpath(MutualFundsPage.MutualFunds));
		for(int i =0;i<MFSeg.size(); i++) {
			MFSeg = driver.findElements(By.xpath(MutualFundsPage.MutualFunds));
			//WebElement MF = MFSeg.get(i);
			String MtlFnd = MFSeg.get(i).getText();
			
			List<WebElement> MFtddata = MFSeg.get(i).findElements(By.xpath(MutualFundsPage.MutualFunddata));
			String strtd = "";
			for(WebElement td: MFtddata) {
				strtd = strtd +"--"+td.getText();
				
			}
			System.out.println(MtlFnd+"-- "+strtd);
			MFSeg.get(i).click();
			getMutualFundsStocks();
		}
		
	
		System.out.println("-----------------------------------------------------------------------------");
	}
	
	public void getMutualFundsStocks() {
		List<WebElement> MFStcks = driver.findElements(By.xpath(MutualFundsPage.MutualFundStocks));
		String strStckdt = "";
		String strStck = null;
		for (WebElement MFSt : MFStcks) {
			strStck = MFSt.getText();
			List<WebElement> MFStckdata = MFSt.findElements(By.xpath(MutualFundsPage.MutualFundStocksdata));
			strStckdt = "";
			for(WebElement MFStdta : MFStckdata) {
				strStckdt = strStckdt + "    "+MFStdta.getText();
			}
			System.out.println(strStck+"---"+strStckdt);
			
		}
		System.out.println("=============================================================================");
		driver.navigate().back();
		
	}
}

