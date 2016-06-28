package its.tsid.coders.analysis;

import java.util.HashMap;
import java.util.Map;

public class Province {
	private String name;
	private String code;
	private int population;
	private int area;
	private int density;
	private int towns;
	
	private Province(String name,  String code, int population,int area,int density, int towns){
		this.name = name;
		this.code = code;
		this.population = population;
		this.area = area;
		this.density = density;
		this.towns = towns;
	}
	
	public Map<String, Double> getBaseValue (){
		Map<String, Double> output = new HashMap<>();
		output.put(code, baseValue());
		return output;
	}

	private Double baseValue() {
		return (double) population;
	}
	
	public String getName(String code){
		return (code == this.code ? name : "N/D");
	}
	
}
