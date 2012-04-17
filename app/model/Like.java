package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class represents a Like object 
 */
public final class Like {

	public static final String USER_ID = "User_ID";
	public static final String PRODUCT_ID = "Product_ID";
	
	private final int user_id;
	private final int product_id;

	public Like(final ResultSet rs) throws SQLException {
		this.user_id = rs.getInt(USER_ID);
		this.product_id = rs.getInt(PRODUCT_ID);
	}

	public final int getUser_id() {
		return user_id;
	}

	public final int getProduct_id() {
		return product_id;
	}
	
}
