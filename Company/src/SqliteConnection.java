import java.sql.*;
import javax.swing.*;
public class SqliteConnection {
	//Connection conn = null;
	public static Connection dbConnector() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:E:\\eclipsework\\Company\\db\\EmployeeData.sqlite");
			JOptionPane.showMessageDialog(null, "Connection Established...");
			return conn;
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error in DB Connection.." + e);
			return null;
		}
		
	}
}
