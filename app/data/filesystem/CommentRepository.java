package data.filesystem;

import model.Comment;
import model.User;
import data.IUserRepository;

public class CommentRepository extends BaseRepository<Comment> implements IUserRepository {

	protected CommentRepository() {
		super("tblComment");
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
