package its.tsid.coders.analysis;

import its.tsid.coders.analysis.Category.category;

public class Parameter {
	private category type;
	private String param;
	private double value;
	private double weight;
	
	/**
	 * Constructor for Parameter class
	 * @param type category of the parameter
	 * @param param name of the parameter
	 * @param value base value of the parameter
	 * @param weight base weight of the parameter
	 */
	public Parameter(category type, String param, double value, double weight){
		this.type = type;
		this.param = param;
		this.value = value;
		this.weight = weight;
	}
	
	public double getValue(){
		return value;
	}
	
	public category getType(){
		return type;
	}
	
	public String getParam(){
		return param;
	}
	
	public double getWeightedValue(){
		return value * weight;
	}
	
	public double getWeightedValue(double weight){
		return value * weight;
	}
	
}
