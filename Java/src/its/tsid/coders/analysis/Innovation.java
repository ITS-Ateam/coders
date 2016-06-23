package its.tsid.coders.analysis;

import java.util.Dictionary;

public class Innovation {
	private Dictionary<String, Double> startups;
	private Dictionary<String, Double> internet;
	private Dictionary<String, Double> computerUse;

	public Innovation(Dictionary<String, Double> startups, Dictionary<String, Double> internet,
			Dictionary<String, Double> computerUse) {
		this.startups = startups;
		this.internet = internet;
		this.computerUse = computerUse;
	}

	public Dictionary<String, Double> getSafety() throws Exception {
		if (startups.isEmpty() || internet.isEmpty() || computerUse.isEmpty()) {
			throw new Exception("Err Analysis05 startups or internet or computerUse can't be empty");
		}
		return null;
	}
}
