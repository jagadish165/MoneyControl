package Selenium.MoneyControl.Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Selenium.MoneyControl.PageObjects.MutualFundsPage;
import Utility.ExcelOp;

public class HomePageTest {
	
	private ChromeDriver driver;
	private ExcelOp Ex;
	private int n=0;
	private String MtlFnd;
	private ArrayList<String> ArrMFSeg = new ArrayList<String>();
	private ArrayList<String> ArrMF = new ArrayList<String>();
	private ArrayList<String> ArrMFStcks = new ArrayList<String>();
	private ArrayList<String> totalsize = new ArrayList<String>();
	public HomePageTest(ChromeDriver driver) throws IOException {
		this.driver = driver;
		  //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 Ex = new ExcelOp(); 
	}
	public void MutualFundsRunner() throws IOException {
		try {
		getMutualFundSectors();
		}
		catch(IOException e) {
		
	}finally {
		Ex.CloseExcel();
		System.out.println("finally loop");
	}
		
	}
	
	
	
	public void getMutualFundSectors() throws IOException {
		List<WebElement> MFNav = driver.findElements(By.xpath(MutualFundsPage.MutualFundsNav));
		
		
		for(int i=4;i<6;i++) {
			MFNav = driver.findElements(By.xpath(MutualFundsPage.MutualFundsNav));
			String MFSeg = MFNav.get(i).getText();
			
			//System.out.println(MFSeg);
			ArrMFSeg.add(MFSeg);
			//Ex.WriteExcel(n, k, MFNav.get(i).getText());
			//k++;
			//System.out.println("__________________________________________________________");
			
			MFNav.get(i).click();
			getMutualFunds();
			ArrMFSeg.clear();
			
		}
	
	}
	public void getMutualFunds() throws IOException {
		List<WebElement> MFSeg = driver.findElements(By.xpath(MutualFundsPage.MutualFunds));
		for(int i =48;i<MFSeg.size(); i++) {
		//	for(int i =0;i<MFSeg.size(); i++) {
			MFSeg = driver.findElements(By.xpath(MutualFundsPage.MutualFunds));
			//WebElement MF = MFSeg.get(i);
			MtlFnd = MFSeg.get(i).getText();
			ArrMF.add(MtlFnd);
			//Ex.WriteExcel(n, k, MtlFnd);
			
			
			List<WebElement> MFtddata = MFSeg.get(i).findElements(By.xpath(MutualFundsPage.MutualFunddata));
			String strtd = "";
			for(WebElement td: MFtddata) {
				ArrMF.add(td.getText());
				//Ex.WriteExcel(n, k, td.getText());
				strtd = strtd +"--"+td.getText();
				
				
				
			}
			
			//System.out.println(MtlFnd+"-- "+strtd);
			
			MFSeg.get(i).click();
			getMutualFundsStocks();
			ArrMF.clear();
		}
		
	
		//System.out.println("-----------------------------------------------------------------------------");
		
	}
	
	public void getMutualFundsStocks() throws IOException {
		List<WebElement> MFStcks = driver.findElements(By.xpath(MutualFundsPage.MutualFundStocks));
		String strStckdt = "";
		String strStck = null;
		
		for (WebElement MFSt : MFStcks) {
			strStck = MFSt.getText();
			ArrMFStcks.add(strStck);
			//Ex.WriteExcel(n, k, strStck);
			
			List<WebElement> MFStckdata = MFSt.findElements(By.xpath(MutualFundsPage.MutualFundStocksdata));
			strStckdt = "";
			for(WebElement MFStdta : MFStckdata) {
				ArrMFStcks.add(MFStdta.getText());
				strStckdt = strStckdt + "    "+MFStdta.getText();
				
			//	Ex.WriteExcel(n, k, MFStdta.getText());
				
			}
			
			totalsize.addAll(ArrMFSeg);
			totalsize.addAll(ArrMF);
			totalsize.addAll(ArrMFStcks);
			//System.out.println(strStck+"---"+strStckdt);
			for(int z= 0;z<totalsize.size();z++) {
				Ex.WriteExcel(n, z,totalsize.get(z));				
			}
			totalsize.clear();
			ArrMFStcks.clear();
			n++;
		}
		
		
		
		
		//System.out.println("=============================================================================");
		
		driver.navigate().back();
		
	}
}

