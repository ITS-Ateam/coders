package its.tsid.coders.analysis;

import java.util.Dictionary;

public class Culture {
	private Dictionary<String, Double> museums;
	private Dictionary<String, Double> libraries;
	
	public Culture (Dictionary<String, Double> museums, Dictionary<String, Double> libraries){
		this.museums = museums;
		this.libraries = libraries;
	}
	
	public Dictionary <String, Double> getCulture() throws Exception {
		if (museums.isEmpty() || libraries.isEmpty()){
			throw new Exception("Err Analysis02 Museums or Libraries can't be empty");
		}
		return null;
	}
}
