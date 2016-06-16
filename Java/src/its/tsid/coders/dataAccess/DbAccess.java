package its.tsid.coders.dataAccess;

import java.sql.*;
import its.tsid.coders.dataAccess.Action;

public class DbAccess {
	private static Connection conn = null;
	private static Statement stmt = null;
	private static String db = "jdbc:postgresql://localhost:5432/test";
	private static String user = "postgres";
	private static String pwd = "root";

	public DbAccess(String db, String user, String pwd) {
		DbAccess.db = db;
		DbAccess.user = user;
		DbAccess.pwd = pwd;
	}

	public static void dbAccess(String table, Action action) {

		try {
			Class.forName("org.postgresql.Driver");

			conn = DriverManager.getConnection(db, user, pwd);
			conn.setAutoCommit(false);
			String sql = "SELECT id FROM retrieved;";

			stmt = conn.createStatement();
			stmt.executeUpdate(sql);

			conn.commit();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
