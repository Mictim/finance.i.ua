package comparison.finance.i.ua;

import java.util.ArrayList;
import java.util.List;

public class BanksExchangeRates {
	public String bankName;
	public Double buyExchangeRate;
	public Double sellExchangeRate;
	
	public BanksExchangeRates(String bankName, Double buyExchangeRate, Double sellExchangeRate){
		this.bankName = bankName;
		this.buyExchangeRate = buyExchangeRate;
		this.sellExchangeRate = sellExchangeRate;
	}
	
	public String getBankName() {
		return bankName;
	}

	public void setBuyExchangeRate(Double buyExchangeRate) {
		this.buyExchangeRate = buyExchangeRate;
	}

	public void setSellExchangeRate(Double sellExchangeRate) {
		this.sellExchangeRate = sellExchangeRate;
	}

	public Double getBuyExchangeRate() {
		return buyExchangeRate;
	}

	public Double getSellExchangeRate() {
		return sellExchangeRate;
	}

	//printout difference between Dark course and commercial course.
	public static void printData (List<BanksExchangeRates> list, String flag){
		for (BanksExchangeRates value : list){
				System.out.println("Bank: " + value.getBankName() + "\n -- Diff between Dark and Comm BuyRate: " + value.getBuyExchangeRate() + "\n -- Diff between Dark and Comm SellRate: " + value.getSellExchangeRate());
			}
		System.out.println("----------------------------------------------\n");
	}
	
	//printout current commercial course for list of the banks. 
	public static void printData (List<BanksExchangeRates> list){
		for (BanksExchangeRates value : list){
				System.out.println("Bank: " + value.getBankName() + " -- BuyRate: " + value.getBuyExchangeRate() + " -- SellRate: " + value.getSellExchangeRate());
			}
		System.out.println("----------------------------------------------\n");
	} 
	
	//Calculates differences between dark Market Exchange Rates and Commercial Banks Exchange Rates.
	//Third parameter is "bank" - calculates difference for one concrete bank. 
	public static List<BanksExchangeRates> calcDiffDarkVSComm(List<BanksExchangeRates> commBankRates, BanksExchangeRates darkCurrencyRates, String bankName){
		List<BanksExchangeRates> diffCommVSDark = new ArrayList<BanksExchangeRates>();
		for (BanksExchangeRates singleCommBankRate : commBankRates){
			if (bankName.equals(singleCommBankRate.getBankName())){
				diffCommVSDark.add(new BanksExchangeRates(bankName, 
														  CommonFunctions.roundDouble(darkCurrencyRates.getBuyExchangeRate() - singleCommBankRate.getBuyExchangeRate()),
														  CommonFunctions.roundDouble(darkCurrencyRates.getSellExchangeRate() - singleCommBankRate.getSellExchangeRate())));
				break;
			} 
		}
		if (diffCommVSDark.size() == 0){
			diffCommVSDark.add(new BanksExchangeRates("ERROR! Invalid Bank name!!!", 0.0, 0.0));
		}
		return diffCommVSDark;
	}
	
	//Calculates differences between dark Market Exchange Rates and Commercial Banks Exchange Rates for all banks.
	public static List<BanksExchangeRates> calcDiffDarkVSComm(List<BanksExchangeRates> commBankRates, BanksExchangeRates darkCurrencyRates){
		List<BanksExchangeRates> diffCommVSDark = new ArrayList<BanksExchangeRates>();
		for (BanksExchangeRates singleCommBankRate : commBankRates){
				diffCommVSDark.add(new BanksExchangeRates(singleCommBankRate.getBankName(), 
						 								  CommonFunctions.roundDouble(darkCurrencyRates.getBuyExchangeRate() - singleCommBankRate.getBuyExchangeRate()),
						 								  CommonFunctions.roundDouble(darkCurrencyRates.getSellExchangeRate() - singleCommBankRate.getSellExchangeRate())));
			} 
		return diffCommVSDark;
	}
	
	public static BanksExchangeRates getSimpleClassElement(List<BanksExchangeRates> list, String currency){
		BanksExchangeRates singleClassValue = new BanksExchangeRates (null, null, null);
		for (BanksExchangeRates singleValue : list){
			if (currency.equalsIgnoreCase(singleValue.getBankName())){
				singleClassValue =  new BanksExchangeRates(currency, singleValue.getBuyExchangeRate(), singleValue.getSellExchangeRate());
			}
		}
		return singleClassValue; 
	}
	
	
	
}
