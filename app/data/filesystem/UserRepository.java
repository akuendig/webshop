package data.filesystem;

import model.User;
import data.IUserRepository;

public class UserRepository extends BaseRepository<User> implements IUserRepository {

	public UserRepository() {
		super("tblUser", User.class);
	}

	@Override
	public boolean contains(User user) {

		for (User entry: entries) {
			if (entry.getUsername().equalsIgnoreCase(user.getUsername()) /*&&  // User-names should be unique. Otherwise the function User getReg(username)
				entry.getPassword().equalsIgnoreCase(user.getPassword())*/) {  // will return the first entry it finds. Which may not be the logged in user
																				// but the one that has registered first under that name.
				return true;
			}
		}
		
		return false;
	}

	@Override
	public User getUser(User user) {
		
		for (User entry: entries) {
			if (entry.getUsername().equalsIgnoreCase(user.getUsername()) &&
				entry.getPassword().equalsIgnoreCase(user.getPassword())) {
				return entry;
			}
		}
		
		return null;
	}

	@Override
	public User getUserReg(String username) {
		
		for (User entry: entries) {
			if (entry.getUsername().equalsIgnoreCase(username)) {
				return entry;
			}
		}
		
		return null;
	}

	@Override
	public User createUser(User user) {

		if (create(user)){
			return user;
		} else {
			return null;
		}
	}

}
