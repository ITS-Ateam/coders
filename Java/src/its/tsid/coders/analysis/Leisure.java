package its.tsid.coders.analysis;

import java.util.Dictionary;

public class Leisure {
	private Dictionary<String, Double> activities;
	private Dictionary<String, Double> associations;

	public Leisure (Dictionary<String, Double> activities, Dictionary<String, Double> associations){
		this.activities = activities;
		this.associations = associations;
	}

	public Dictionary<String, Double> getLeisure() throws Exception {
		if (activities.isEmpty() || associations.isEmpty()) {
			throw new Exception("Err Analysis06 activities or associations can't be empty");
		}
		return null;
	}
}
