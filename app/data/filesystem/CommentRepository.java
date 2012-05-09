package data.filesystem;

import java.util.List;

import model.Comment;
import data.ICommentRepository;

public class CommentRepository extends BaseRepository<Comment> implements ICommentRepository {

	protected CommentRepository() {
		super("tblComment");
	}

	@Override
	public List<Comment> getAllForProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(String comment, int productId, int userId) {
		// TODO Auto-generated method stub
		
	}

}
