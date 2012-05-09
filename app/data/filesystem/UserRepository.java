package data.filesystem;

import model.User;
import data.IUserRepository;

public class UserRepository extends BaseRepository<User> implements IUserRepository {

	protected UserRepository() {
		super("tblUser");
	}

	@Override
	public boolean contains(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserReg(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
