package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class represents a Like object
 */
public final class Like {

	public static final String USER_ID = "User_ID";
	public static final String PRODUCT_ID = "Product_ID";

	private int userId;
	private int productId;

	public Like() {
	}

	public Like(final ResultSet rs) throws SQLException {
		this.userId = rs.getInt(USER_ID);
		this.productId = rs.getInt(PRODUCT_ID);
	}

	public final int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public final int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}
