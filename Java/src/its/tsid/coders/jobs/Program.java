package its.tsid.coders.jobs;

public class Program {

	public static void main(String[] args) {
		String message = "";
		if (args.length == 0) {
			message = "Error, need to pass username and password for the db!";
		} else {
			if (args.length != 2) {
				message = String.format("Error, expected 2 parameters! " + "Got %i parameters!", args.length);
			}
		}
		System.out.println(message);
	}

}
