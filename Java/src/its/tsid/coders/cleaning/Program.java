package its.tsid.coders.cleaning;

import its.tsid.coders.dataAccess.DbAccess;

public class Program {

	public static void main(String[] args) {
		String connectionString = "localhost, 27017";
		String origin = "retrieval";
		String destination = "cleaning";
		DbAccess.processCollections(connectionString, origin, destination, new Cleaner());
		
		
	}

}
