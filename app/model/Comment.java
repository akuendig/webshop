package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Comment {

	public static final String COMMENT_ID = "Comment_ID";
	public static final String COMMENT_USER_ID = "Comment_User_ID";
	public static final String COMMENT_PRODUCT_ID = "Comment_Product_ID";
	public static final String COMMENT_TEXT = "CommentText";
	public static final String COMMENT_TIME = "CommentTime";
	
	private final int id;
	private final int user_id;
	private final int product_id;
	private final String text;
	private final Date creationDate;

	public Comment(final ResultSet rs) throws SQLException {
		this.id = rs.getInt(COMMENT_ID);
		this.user_id = rs.getInt(COMMENT_USER_ID);
		this.product_id = rs.getInt(COMMENT_PRODUCT_ID);
		this.text = rs.getString(COMMENT_TEXT);
		this.creationDate = rs.getDate(COMMENT_TIME);
	}

	public int getId() {
		return id;
	}

	public int getUser_id() {
		return user_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public String getText() {
		return text;
	}

	public Date getCreationDate() {
		return creationDate;
	}
}
