package module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.inject.*;

public class Dependencies implements Module {

	public static final String USERNAME = "introdb";
	public static final String PASSWORD = "1234";
	public static final String HOSTNAME = "localhost";
	public static final int PORT = 3306;
	public static final String DATABASE = "introdb2012";

	public void configure(Binder binder) {
	}

	@Provides
	Connection provideConnection() {

		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://" + HOSTNAME
					+ ":" + PORT + "/" + DATABASE, USERNAME, PASSWORD);

		} catch (final SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {

			/**
			 * Make sure that we really see this error.
			 */
			System
				.err
				.println("Could not connect to MYSQL. Is the server running?");
			
			e.printStackTrace();

		}

		return connection;
	}
}
