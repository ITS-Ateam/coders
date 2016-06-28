package its.tsid.coders.analysis;

import java.util.Dictionary;
import java.util.List;

public class Analyzable {
	private List<Dictionary<String, Double>> parameters;
	private Dictionary<String, Double> weights;
	
	public Analyzable(List<Dictionary<String, Double>> parameters, Dictionary<String, Double> weights){
		this.parameters = parameters;
		this.weights = weights;
	}
	
	public List<Dictionary<String, Double>> calculate () throws Exception{
		if(checker()){
			throw new Exception("Invalid analysis for the input");
		}
		return null;
	}
	
	private boolean checker() {
		return checkParam() && checkWeights();
	}
	
	private boolean checkWeights() {
		return (weights.size() == parameters.size());
	}

	private boolean checkParam(){
		for(Dictionary<String, Double> param : parameters){
			if (param.isEmpty()){
				return false;
			}
		}		
		return true;
	}
}
