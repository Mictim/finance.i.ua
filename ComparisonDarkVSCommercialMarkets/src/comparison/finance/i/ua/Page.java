package comparison.finance.i.ua;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Page {
	protected String url;

	protected Page(String url){
		this.url = url;
	}
		
	protected Map<String, Double> mapCreate (List<String> keys, List<String> values){
		Map<String, Double> newMap = new HashMap<String, Double>();
		int counter = 0;
		//checking Lists sizes, they should be equal to each other.
		if (keys.size() > values.size()) {
			counter = values.size();
		} else {
			counter = keys.size();
		}
		for (int i = 0; i < counter; i++){
			newMap.put(values.get(i), Double.parseDouble(values.get(i)));
		}
		return newMap;	
	}
	

}
