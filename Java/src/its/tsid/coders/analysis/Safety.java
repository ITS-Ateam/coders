package its.tsid.coders.analysis;

import java.util.Dictionary;

public class Safety {
	private Dictionary<String, Double> roadAccidents;
	private Dictionary<String, Double> felonies;

	public Safety (Dictionary<String, Double> roadAccidents, Dictionary<String, Double> felonies){
		this.roadAccidents = roadAccidents;
		this.felonies = felonies;
	}

	public Dictionary<String, Double> getSafety() throws Exception {
		if (roadAccidents.isEmpty() || felonies.isEmpty()) {
			throw new Exception("Err Analysis04 roadAccidents or felonies can't be empty");
		}
		return null;
	}
}
