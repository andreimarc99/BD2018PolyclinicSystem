package Default;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 1. Install mySql (you could try with xampp - it might be easier)
 * 2. Download MySQL connector for Java (https://dev.mysql.com/downloads/connector/) - Connector/J
 *
 */
public class Database {

	private static Database databaseConnection;

	private Connection connection = null;
	private Statement statement = null;

	protected Database() {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/policlinica2", "user", "password");

			// Statements allow to issue SQL queries to the database
			statement = connection.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet executeStatement(final String sqlQuery) {
		try {
			return statement.executeQuery(sqlQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Connection getConnection() {
		return connection;
	}

	public static Database getInstance() {
		if (databaseConnection == null) {
			databaseConnection = new Database();
		}
		return databaseConnection;
	}
}
