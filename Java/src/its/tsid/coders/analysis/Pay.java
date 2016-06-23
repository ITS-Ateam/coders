package its.tsid.coders.analysis;

import java.util.Dictionary;

public class Pay {
	private Dictionary<String, Double> salary;
	private Dictionary<String, Double> lifeCost;
	
	public Pay(Dictionary<String, Double> salary, Dictionary<String, Double> lifeCost){
		this.salary = salary;
		this.lifeCost = lifeCost;
	}
	
	public Dictionary<String, Double> getPay() throws Exception{
		if (salary.isEmpty() || lifeCost.isEmpty()){
			throw new Exception("Err Analysis01 Salary or LifeCost can't be empty");
		}
		//TODO method for return an index based on salary and cost of life in the various areas
		return null;
	}
}
