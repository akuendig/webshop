package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingCartEntry {
	
	public int shoppingCartId;
	
	public int productId;
	
	public int quantity;
	
	public ShoppingCartEntry() { }

	public ShoppingCartEntry(ResultSet rs) throws SQLException{
		this.shoppingCartId = rs.getInt("SC_ID");
		this.productId = rs.getInt("SC_Product_ID");
		this.quantity = rs.getInt("SC_contains_Prd_Quantity");
	}
	
	public int getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(int shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int qunatity) {
		this.quantity = qunatity;
	}
}
