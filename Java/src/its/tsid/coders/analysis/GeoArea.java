package its.tsid.coders.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import its.tsid.coders.analysis.AreaCode.areaCode;
import its.tsid.coders.analysis.Category.category;

public class GeoArea {
	private areaCode code;
	private List<Parameter> parameters;
	private List<category> categories;
	
	
	public GeoArea(areaCode code){
		this.code = code;
		this.parameters = new ArrayList<Parameter>();
		this.categories = new ArrayList<category>();
	}
	
	public Map<category, Double> getValues(){
		Map<category, Double> values = new HashMap<>();
		for (category c : categories){
			values.put(c, getValues(c));
		}
		return values;
	}
	
	private Double getValues(category c){
		double value = 0;
		for (Parameter p : parameters){
			if (p.getType()==c){
				value += p.getValue();
			}
		}
		return value;
	}

	public areaCode getCode() {
		return code;
	}
	
	public void addParameter(Parameter p){
		parameters.add(p);
		if (!categories.contains(p.getType())){
			categories.add(p.getType());
		}
	}

}
