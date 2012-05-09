package data.filesystem;

import model.Origin;
import model.User;
import data.IUserRepository;

public class OriginRepository extends BaseRepository<Origin> implements IUserRepository {

	protected OriginRepository() {
		super("tblOrigin");
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
