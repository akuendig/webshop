package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Comment extends EntityBase {

	public static final String COMMENT_ID = "Comment_ID";
	public static final String COMMENT_USER_ID = "Comment_User_ID";
	public static final String COMMENT_PRODUCT_ID = "Comment_Product_ID";
	public static final String COMMENT_TEXT = "CommentText";
	public static final String COMMENT_TIME = "CommentTime";

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
		this.creationDate = new Date(rs.getDate(COMMENT_TIME).getTime());
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
