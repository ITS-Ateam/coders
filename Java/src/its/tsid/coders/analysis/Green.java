package its.tsid.coders.analysis;

import java.util.Dictionary;

public class Green {
	private Dictionary<String, Double> noisePollution;
	private Dictionary<String, Double> vehiclesUse;
	private Dictionary<String, Double> urbanGreen;
	private Dictionary<String, Double> greenEnergy;

	public Green(Dictionary<String, Double> noisePollution, Dictionary<String, Double> vehiclesUse,
			Dictionary<String, Double> urbanGreen, Dictionary<String, Double> greenEnergy) {
		this.noisePollution = noisePollution;
		this.vehiclesUse = vehiclesUse;
		this.urbanGreen = urbanGreen;
		this.greenEnergy = greenEnergy;
	}

	public Dictionary<String, Double> getGreen() throws Exception {
		if (noisePollution.isEmpty() || vehiclesUse.isEmpty() || urbanGreen.isEmpty() || greenEnergy.isEmpty()) {
			throw new Exception(
					"Err Analysis03 noisePollution or vehiclesUse or urbanGreen or greenEnergy can't be empty");
		}
		return null;
	}
}
