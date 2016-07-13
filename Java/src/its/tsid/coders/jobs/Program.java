package its.tsid.coders.jobs;

import java.sql.ResultSet;
import java.sql.SQLException;

import its.tsid.coders.dataAccess.*;

public class Program {

	public static void main(String[] args) throws SQLException {
		System.out.println(Checker.checkArgs(args));
		
		DbAccess dba = new DbAccess("jdbc:postgresql://localhost:5432/test", args[0], args[1]);
		
		ResultSet rs = dba.query("SELECT * FROM retrieved");
		rs.close();
		
	}

	

}
