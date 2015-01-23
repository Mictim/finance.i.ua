package comparison.finance.i.ua;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class CommonFunctions {

	/*
	 * TODO description for methods.
	 */
	
	//Converts List<WebElement> to List<String>
	public List<String> convertToStringList (List<WebElement> listValues){
		List<String> arrayString = new ArrayList<String>();
		for (WebElement value : listValues) {
			arrayString.add(value.getText());
		}
		return arrayString;
	}
	
	//Calculation Middle Value (Sum of all Value divided by Count of List items)
	public double calcMidValue(List<String> list){
		double midValue = 0;
		for (String listValue: list){
			midValue += Double.parseDouble(listValue);
		}
		return midValue/list.size();
	}
	
	//Comparison of two double values.
	public boolean comparisonDouble(double value1, double value2){
		if(Double.compare(value1, roundDouble(value2)) == 0){
			System.out.println("Values are identical: " + value1);
			return true;
		} else {
			System.out.println("Values are different: " + value1 + " didn't equal " + roundDouble(value2));
			return false;
		}
	}
	
	//Round Double value to #.#### format.
	public static double roundDouble (double value){
		DecimalFormat df = new DecimalFormat("#.####");
		return Double.valueOf(df.format(value));
	}
	
}
