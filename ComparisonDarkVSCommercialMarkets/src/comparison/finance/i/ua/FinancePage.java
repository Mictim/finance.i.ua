package comparison.finance.i.ua;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FinancePage extends Page {
	
	public static final By XPATH_DARK_CURRENCY 	= By.xpath(".//*[@class='Right']/*[@class='block_gamma_dark'][1]//*/descendant::tr/td[1]");
	public static final By XPATH_DARK_BUY_RATE 	= By.xpath(".//*[@class='Right']/*[@class='block_gamma_dark'][1]//*/descendant::tr/td[2]/big");
	public static final By XPATH_DARK_SELL_RATE = By.xpath(".//*[@class='Right']/*[@class='block_gamma_dark'][1]//*/descendant::tr/td[3]/big");
	public static final By XPATH_COMM_CURRENCY 	= By.xpath(".//*[@id='feMain2']/ul/descendant::li/i/a");
	public static final By XPATH_COMM_BUY_RATE 	= By.xpath(".//*[@id='feMain2']/table/tbody/descendant::tr/td[2]");
	public static final By XPATH_COMM_SELL_RATE = By.xpath(".//*[@id='feMain2']/table/tbody/descendant::tr/td[3]");
	public static final By XPATH_COMM_BANKS 	= By.xpath(".//*[@id='feMain2']/table/tbody/descendant::tr/td[1]/a");
	//public static final String currencyName 	= "USD";
	
	private CommonFunctions cf = new CommonFunctions(); 
	
	protected FinancePage(String url) {
		super(url);
		Driver.getInstance().get(url);
		// TODO Auto-generated constructor stub
	}
	
	protected List<String> getListOfElements (By xPath){
		new WebDriverWait(Driver.getInstance(), 10).until(ExpectedConditions.presenceOfElementLocated(By.id("feMain2")));
		List<WebElement> allValues = Driver.getInstance().findElements(xPath);
		List<String> strAllValues = cf.convertToStringList(allValues);
		return strAllValues;
	}
	
	public CurrencyRate selectCurrency (String currencyName){
		List<WebElement> listCurrency = Driver.getInstance().findElements(XPATH_COMM_CURRENCY);
		WebElement currencyLocatorValue = null;
		for (WebElement currencyLocator : listCurrency){
			if (currencyLocator.getText().equals(currencyName)){
				currencyLocatorValue = currencyLocator;
			}
		}
		return new CurrencyRate(currencyLocatorValue);
	}
	
	public List<BanksExchangeRates> getBanksExchange(By xpathCurrency, By xpathBuyRate, By xpathSellRate){
		List<BanksExchangeRates> darkMarketExchange = new ArrayList<BanksExchangeRates>();
		for (int i = 0; i < getListOfElements(xpathCurrency).size(); i++){
			darkMarketExchange.add(new BanksExchangeRates(getListOfElements(xpathCurrency).get(i),Double.parseDouble(getListOfElements(xpathBuyRate).get(i)), Double.parseDouble(getListOfElements(xpathSellRate).get(i))));
		}
		return darkMarketExchange;
	}
	
	public List<BanksExchangeRates> getBanksExchange(List<String> strCurrency, List<String> strBuyRate, List<String> strSellRate){
		List<BanksExchangeRates> darkMarketExchange = new ArrayList<BanksExchangeRates>();
		for (int i = 0; i < strCurrency.size(); i++){
			darkMarketExchange.add(new BanksExchangeRates(strCurrency.get(i),Double.parseDouble(strBuyRate.get(i)), Double.parseDouble(strSellRate.get(i))));
		}
		return darkMarketExchange;
	}
	
	
	
	
}
