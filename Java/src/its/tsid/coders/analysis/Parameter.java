package its.tsid.coders.analysis;

import its.tsid.coders.analysis.ParamTypes.type;

public class Parameter {
	private type type;
	private double value;
	private double paramWeight;
	
	public double getValue(){
		return value;
	}
	
	public type getType(){
		return type;
	}
	
	public double getWeightedValue(){
		return value * paramWeight;
	}
	
	public double getWeightedValue(double weight){
		return value * weight;
	}
	
}
