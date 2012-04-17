package data;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import model.Comment;


public class CommentRepository extends BaseRepository<Comment> {

	public CommentRepository() {
		super(Comment.class);
	}

	public final List<Comment> getAllForProduct(int productId) {

		return getResults(
				"SELECT * " +
				"FROM tblcomment AS c " +
				"WHERE c."+Comment.COMMENT_PRODUCT_ID+"="+ productId + " " +
				"ORDER BY c.CommentTime ");
	}

	public final void create(String comment, int productId, int userId) {

		long timeNow = Calendar.getInstance().getTimeInMillis();
		Timestamp ts = new Timestamp(timeNow);

		String query =
				"INSERT INTO tblcomment (`Comment_ID` ,`CommentTime` ,`CommentText`, `Comment_User_ID`, `Comment_Product_ID`) " +
				"VALUES (NULL, '" + ts + "', '" + comment + "', '" + userId + "', '" + productId + "')";

		execute(query);
	}

}
