package data;

import model.User;


public class UserRepository extends BaseRepository<User> implements IUserRepository {

	public UserRepository() {
		super(User.class);
	}
	
	/* (non-Javadoc)
	 * @see data.IUserRepository#contains(model.User)
	 */
	@Override
	public final boolean contains(User user) {

		return
			null != getResult(
				"SELECT * " +
				"FROM tbluser " +
				"WHERE " + User.USER_NAME + "='" + user.getUsername() + "' " +
				"AND " + User.USER_PASSWORD + "='" + user.getPassword() + "'");
	}
	
	/* (non-Javadoc)
	 * @see data.IUserRepository#getUser(model.User)
	 */
	@Override
	public final User getUser(User user) {
		
		return
				getResult(
				"SELECT * " +
				"FROM tbluser " +
				"WHERE " + User.USER_NAME + "='" + user.username + "' " +
				"AND " + User.USER_PASSWORD + "='" + user.password + "'");
	}

	/* (non-Javadoc)
	 * @see data.IUserRepository#getUserReg(java.lang.String)
	 */
	@Override
	public final User getUserReg(String username) {

		return
			getResult(
				"SELECT * " +
				"FROM tbluser " +
				"WHERE " + User.USER_NAME + "='" + username + "' ");
	}


	/* (non-Javadoc)
	 * @see data.IUserRepository#createUser(model.User)
	 */
	@Override
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
