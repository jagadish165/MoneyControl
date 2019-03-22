package Selenium.MoneyControl.PageObjects;

public class MutualFundsPage {
	
public static final String MutualFundsNav = "//ul[@class='nav']/li/a";
//public static final String MutualFunddata = "//table[@class='gry_t thdata']/tbody/tr/td/a[contains(@href,'mutual-funds')]/ancestor::td/following-sibling::td";
public static final String MutualFunds = "//table[@class='gry_t thdata']/tbody/tr/td/a[contains(@href,'mutual-funds')]";
public static final String MutualFundStocks = "//*[@id= 'portfolioEquityTable']//td[@class = 'robo_medium']";
public static final String MutualFunddata = "./ancestor::td/following-sibling::td";
public static final String MutualFundStocksdata = "./following-sibling::td";
}
