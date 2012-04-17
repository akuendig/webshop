package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Object that represents a registered in user.
 */
public final class User {

	public static final String USER_NAME = "UserName";
	public static final String USER_PASSWORD = "UserPassword";
	public static final String USER_ID = "User_ID";
	private final int id;
	private final String username;
	private final String password;
	
	public User(
		final String username,
		final String name
	) {
		this.username = username;
		this.password = name;
		this.id = 0;
	}


	public User(
		final ResultSet rs
	) throws SQLException {
		this.username = rs.getString(USER_NAME);
		this.password = rs.getString(USER_PASSWORD);
		this.id = rs.getInt(USER_ID);
	}
		
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}


	public int getId() {
		return id;
	}
	
}
