package its.tsid.coders.jobs;

public class Checker {
	protected static String checkArgs(String[] input) {
		if (input.length == 0) {
			return "Error, need to pass username and password for the db!";
		} else {
			if (input.length != 2) {
				return String.format("Error, expected 2 parameters! %nGot %d parameters instead!", input.length);
			}
		}
		return "User name and password acquired, proceeding with db connection";
	}
}
