package data.filesystem;

import model.Like;
import model.User;
import data.IUserRepository;

public class LikeRepository extends BaseRepository<Like> implements IUserRepository {

	protected LikeRepository() {
		super("tblLike");
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
