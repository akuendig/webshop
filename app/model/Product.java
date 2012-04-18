package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class Product {
	
	public static final String PRODUCT_ID = "Product_id";
	public static final String PRODUCT_NAME = "ProductName";
	public static final String PRODUCT_WEIGHT = "ProductWeight";
	public static final String PRODUCT_PRICE = "ProductPrice";
	public static final String PRODUCT_BRAND_ID = "Product_Brand_ID";
	public static final String PRODUCT_ORIGIN_ID = "Product_Origin_ID";
	/**
	 * TODO The properties of the items should be added here
	 */
	private final int id;
	private final String name;
	private final int weight;
	private final int price;
	private final int brand_id;
	private final int origin_id;
	
	public Product(
		final ResultSet rs
	) throws SQLException {
		this.id = rs.getInt(PRODUCT_ID);
		this.name = rs.getString(PRODUCT_NAME);
		this.weight = rs.getInt(PRODUCT_WEIGHT);
		this.price  = rs.getInt(PRODUCT_PRICE);
		this.brand_id = rs.getInt(PRODUCT_BRAND_ID);
		this.origin_id = rs.getInt(PRODUCT_ORIGIN_ID);
	}

	/**
	 * HINT: In eclipse, use Alt + Shirt + S menu and choose:
	 * "Generate Getters and Setters to auto-magically generate
	 * the getters. 
	 */
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getWeight() {
		return weight;
	}

	public int getPrice() {
		return price;
	}

	public int getBrandId() {
		return brand_id;
	}

	public int getOriginId() {
		return origin_id;
	}
		
}
