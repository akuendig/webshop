package data.filesystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Comment;
import data.ICommentRepository;

public class CommentRepository extends BaseRepository<Comment> implements ICommentRepository {

	public CommentRepository() {
		super("tblComment", Comment.class);
	}

	@Override
	public List<Comment> getAllForProduct(int productId) {
		
		ArrayList<Comment> results = new ArrayList<Comment>();

		for (Comment entry: entries) {
			if (entry.getProductId() == productId) {
				results.add(entry);
			}
		}
		
		return results;
	}

	@Override
	public void create(String comment, int productId, int userId) {

		Comment c = new Comment();
		
		c.setCreationDate(new Date());
		c.setText(comment);
		c.setUserId(userId);
		c.setProductId(productId);
		
		create(c);
	}

}
