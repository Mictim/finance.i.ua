package comparison.finance.i.ua;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ComparisonTest {
	//Parameters:
	//SITE_URL - URL to site destination
	//bank - Name of the bank for which difference will be calculated.
	//currency - Currency Exchange.
	public static final String SITE_URL = "http://finance.i.ua";
	public static final String bank		= "Аркада"; 
	public static final String currency = "USD";
  @Test
  public void currencyPrintout() {
	  FinancePage fp = new FinancePage(SITE_URL);
	  fp.selectCurrency(currency);
	  List<String> bankNames = fp.getListOfElements(FinancePage.XPATH_COMM_BANKS).subList(0, fp.getListOfElements(FinancePage.XPATH_COMM_BANKS).size()-4);
	  List<String> buyExchangeRate = fp.getListOfElements(FinancePage.XPATH_COMM_BUY_RATE).subList(0, fp.getListOfElements(FinancePage.XPATH_COMM_BANKS).size()-4);
	  List<String> sellExchangeRate = fp.getListOfElements(FinancePage.XPATH_COMM_SELL_RATE).subList(0, fp.getListOfElements(FinancePage.XPATH_COMM_BANKS).size()-4);
	  
	  List<BanksExchangeRates> darkMarketCurrencyExchange = fp.getBanksExchange(FinancePage.XPATH_DARK_CURRENCY, FinancePage.XPATH_DARK_BUY_RATE, FinancePage.XPATH_DARK_SELL_RATE);
	  
	  BanksExchangeRates.printData(fp.getBanksExchange(bankNames, buyExchangeRate, sellExchangeRate));
	  List<BanksExchangeRates> darkCurrencyRates = BanksExchangeRates.calcDiffDarkVSComm(fp.getBanksExchange(bankNames, buyExchangeRate, sellExchangeRate), BanksExchangeRates.getSimpleClassElement(darkMarketCurrencyExchange, currency));
	  BanksExchangeRates.printData(darkCurrencyRates, "flag");
	  darkCurrencyRates = BanksExchangeRates.calcDiffDarkVSComm(fp.getBanksExchange(bankNames, buyExchangeRate, sellExchangeRate), BanksExchangeRates.getSimpleClassElement(darkMarketCurrencyExchange, currency), bank);
	  BanksExchangeRates.printData(darkCurrencyRates, "flag");
	  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
	  Driver.getInstance().close();
  }

}
