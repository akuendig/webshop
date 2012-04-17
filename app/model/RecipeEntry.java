package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeEntry {

	public static final String QUANTITY = "Quantity";
	public static final String RECIPE_ID = "Recipe_ID";
	public static final String PRODUCT_ID = "Product_ID";
	public static final String PRODUCT_PRICE = "ProductPrice";
	public static final String PRODUCT_NAME = "ProductName";
	
	private final int recipe_id;
	private final int product_id;
	private final int quantity;
	private final int price;
	private final String name;

	public RecipeEntry(final ResultSet rs) throws SQLException {
		this.product_id = rs.getInt(PRODUCT_ID);
		this.recipe_id = rs.getInt(RECIPE_ID);
		this.quantity = rs.getInt(QUANTITY);
		this.price = rs.getInt(PRODUCT_PRICE);
		this.name = rs.getString(PRODUCT_NAME);
	}

	public int getQuantity() {
		return quantity;
	}

	public int getProduct_id() {
		return product_id;
	}

	public int getRecipe_id() {
		return recipe_id;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
}
