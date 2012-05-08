package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeEntry extends EntityBase {

	public static final String QUANTITY = "Quantity";
	public static final String RECIPE_ID = "Recipe_ID";
	public static final String PRODUCT_ID = "Product_ID";
	public static final String PRODUCT_PRICE = "ProductPrice";
	public static final String PRODUCT_NAME = "ProductName";
	
	private int recipeId;
	private int productId;
	private int quantity;
	private int price;
	private String name;
	
	public RecipeEntry() {
	}

	public RecipeEntry(final ResultSet rs) throws SQLException {
		this.productId = rs.getInt(PRODUCT_ID);
		this.recipeId = rs.getInt(RECIPE_ID);
		this.quantity = rs.getInt(QUANTITY);
		this.price = rs.getInt(PRODUCT_PRICE);
		this.name = rs.getString(PRODUCT_NAME);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
