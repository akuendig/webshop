package data;

import model.User;

public interface IUserRepository extends ICrud<User> {

	public abstract boolean contains(User user);

	public abstract User getUser(User user);

	public abstract User getUserReg(String username);

	public abstract User createUser(User user);

}