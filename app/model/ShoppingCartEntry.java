package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingCartEntry {
	private final int shoppingCartId;
	private final int productId;
	private final int quantity;

	public ShoppingCartEntry(ResultSet rs) throws SQLException{
		this.shoppingCartId = rs.getInt("SC_ID");
		this.productId = rs.getInt("SC_Product_ID");
		this.quantity = rs.getInt("SC_contains_Prd_Quantity");
	}

	public int getShoppingCartId() {
		return shoppingCartId;
	}

	public int getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}
}
