package data;

import model.User;


public class UserRepository extends BaseRepository<User> {

	public UserRepository() {
		super(User.class);
	}
	
	public final boolean contains(User user) {

		return
			null != getResult(
				"SELECT * " +
				"FROM tbluser " +
				"WHERE " + User.USER_NAME + "='" + user.getUsername() + "' " +
				"AND " + User.USER_PASSWORD + "='" + user.getPassword() + "'");
	}
	
	public final User getUser(String username, String password) {
		final User user = 
				getResult(
				"SELECT * " +
				"FROM tbluser " +
				"WHERE " + User.USER_NAME + "='" + username + "' " +
				"AND " + User.USER_PASSWORD + "='" + password + "'");

		return user;
	}

	public final User getUserReg(String username) {

		return
			getResult(
				"SELECT * " +
				"FROM tbluser " +
				"WHERE " + User.USER_NAME + "='" + username + "' ");
	}


	public final User createUser(User user) {

		execute(
			"INSERT INTO tbluser (`User_ID` ,`UserName` ,`UserPassword`) " +
			"VALUES (NULL, '" + user.getUsername() + "', '" + user.getPassword() + "')");

		return
			getResult(
				"SELECT * " +
				"FROM tbluser " +
				"WHERE " + User.USER_NAME + "='" + user.getUsername() + "' " +
				"AND " + User.USER_PASSWORD + "='" + user.getPassword() + "'");
	}

}
