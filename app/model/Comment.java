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

	public int id;
	public int userId;
	public int productId;
	public String text;
	public Date creationDate;
	
	public Comment() {
		
	}

	public Comment(final ResultSet rs) throws SQLException {
		this.id = rs.getInt(COMMENT_ID);
		this.userId = rs.getInt(COMMENT_USER_ID);
		this.productId = rs.getInt(COMMENT_PRODUCT_ID);
		this.text = rs.getString(COMMENT_TEXT);
		this.creationDate = rs.getDate(COMMENT_TIME);
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
