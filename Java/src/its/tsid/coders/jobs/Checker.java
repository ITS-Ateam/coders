package its.tsid.coders.jobs;

public class Checker {
	protected static String checkArgs(String[] input) {
		String message = "";
		if (input.length == 0) {
			message = "Error, need to pass username and password for the db!";
		} else {
			if (input.length != 2) {
				message = String.format("Error, expected 2 parameters! %nGot %d parameters instead!", input.length);
			}
		}
		return message;
	}
}
