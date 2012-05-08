package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import play.data.validation.Constraints.Required;

/**
 * Object that represents a registered in user.
 */
public final class User extends EntityBase {

    public static final String USER_NAME = "UserName";
    public static final String USER_PASSWORD = "UserPassword";
    public static final String USER_ID = "User_ID";

    @Required
    public String username;
    @Required
    public String password;

    public User() {
        username = "";
        password = "";
    }

    public User(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public User(final ResultSet rs) throws SQLException {
        this.id = rs.getInt(USER_ID);
        this.username = rs.getString(USER_NAME);
        this.password = rs.getString(USER_PASSWORD);
    }

    public String getUsername() {
        return username;
    }

	public void setUsername(String username) {
		this.username = username;
	}

    public String getPassword() {
        return password;
    }

	public void setPassword(String password) {
		this.password = password;
	}

}
