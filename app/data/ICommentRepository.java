package data;

import java.util.List;

import model.Comment;

public interface ICommentRepository extends ICrud<Comment> {

	public abstract List<Comment> getAllForProduct(int productId);

	public abstract void create(String comment, int productId, int userId);

}