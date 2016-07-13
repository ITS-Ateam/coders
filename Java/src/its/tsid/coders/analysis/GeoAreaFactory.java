package its.tsid.coders.analysis;

import java.util.List;

import its.tsid.coders.analysis.AreaCode.areaCode;

public class GeoAreaFactory {
	private GeoArea area;
	
	public GeoAreaFactory(){
		this.area = new GeoArea(null);
	}
	
	public GeoAreaFactory(areaCode code){
		this.area = new GeoArea(code);
	}
	
	public void addParameter(Parameter p){
		area.addParameter(p);
	}
	
	public void addAllParameters(List<Parameter> allParam){
		for (Parameter p : allParam){
			area.addParameter(p);
		}
	}
	
	public GeoArea getGeoArea(){
		return area;
	}
	
	public void reset() {
		area = null;
	}
}
