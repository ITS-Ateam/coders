package its.tsid.coders.dataAccess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import its.tsid.coders.analysis.GeoArea;
import its.tsid.coders.analysis.GeoAreaFactory;

public class CsvManager {
	/**
	 * 
	 * @param file
	 * @param splitter
	 * @return
	 */
	public List<GeoArea> importFile(String file, String splitter) {
		List<GeoArea> areas = new ArrayList<>();
		GeoAreaFactory factory;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] param = line.split(splitter);
				factory = new GeoAreaFactory(null);
				if (checkFormat(param, 10)) {
					areas.add(factory.getGeoArea());
					factory = null;
				}
				
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return areas;
	}

	private boolean checkFormat(String[] input, int expectedLength) {
		return true;
	}
}
