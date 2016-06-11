package its.tsid.coders.analysis;

import its.tsid.coders.dataAccess.DbAccess;

public class Program {

	public static void main(String[] args) {
		Analyzer checker = new Analyzer();
		
		DbAccess.processCollections(null, null, null, checker);
		

	}

}
