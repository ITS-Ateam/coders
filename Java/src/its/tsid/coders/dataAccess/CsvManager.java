package its.tsid.coders.dataAccess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import its.tsid.coders.analysis.Category.category;
import its.tsid.coders.analysis.GeoArea;
import its.tsid.coders.analysis.Parameter;
import its.tsid.coders.analysis.AreaCode.areaCode;

public class CsvManager {
	/**
	 * 
	 * @param file
	 * @param splitter
	 * @return
	 */
	public List<GeoArea> importFile(String file, String splitter) {
		List<GeoArea> areas = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = null;
			int i = 1;
			while ((line = reader.readLine()) != null) {
				String[] input = line.split(splitter);
				if (checkFormat(input, 5)) {
					areas.add(createGeoArea(areaCode.valueOf(input[0]), createParameter(input)));
					System.out.println(String.format("Line %i processed successfully", i));
				} else {
					System.out.println(String.format("Could not process line%i\n\t%s\n", i, input.toString()));
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return areas;
	}

	private boolean checkFormat(String[] input, int expectedLength) {
		try {
			@SuppressWarnings("unused")
			areaCode ac = areaCode.valueOf(input[0]);
			@SuppressWarnings("unused")
			category c = category.valueOf(input[1]);
		} catch (IllegalArgumentException iae) {
			return false;
		}
		if (input.length != expectedLength) {
			return false;
		}

		return true;
	}

	private Parameter createParameter(String[] input) {
		category cat = category.valueOf(input[1]);
		String param = input[2];
		Double value = Double.parseDouble(input[3]);
		Double weight = Double.parseDouble(input[4]);
		Parameter p = new Parameter(cat, param, value, weight);
		return p;
	}

	private GeoArea createGeoArea(areaCode ac, Parameter p) {
		GeoArea ga = new GeoArea(ac);
		ga.addParameter(p);
		return ga;
	}
}
