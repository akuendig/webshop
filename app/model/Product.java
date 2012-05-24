package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class Product extends EntityBase {
	
	public static final String PRODUCT_ID = "Product_id";
	public static final String PRODUCT_NAME = "ProductName";
	public static final String PRODUCT_WEIGHT = "ProductWeight";
	public static final String PRODUCT_PRICE = "ProductPrice";
	public static final String PRODUCT_BRAND_ID = "Product_Brand_ID";
	public static final String PRODUCT_ORIGIN_ID = "Product_Origin_ID";
	private String name;
	private int weight;
	private int price;
	private int brandId;
	private int originId;
	
	public Product() {
	}
	// Creation
	public Product(final String name, final int weight, final int price, 
			final int brandId, final int originId){
		this.name = name;
		this.weight = weight;
		this.price = price;
		this.brandId = brandId;
		this.originId = originId;
	}
	
	public Product(
		final ResultSet rs
	) throws SQLException {
		this.id = rs.getInt(PRODUCT_ID);
		this.name = rs.getString(PRODUCT_NAME);
		this.weight = rs.getInt(PRODUCT_WEIGHT);
		this.price  = rs.getInt(PRODUCT_PRICE);
		this.brandId = rs.getInt(PRODUCT_BRAND_ID);
		this.originId = rs.getInt(PRODUCT_ORIGIN_ID);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brand_id) {
		this.brandId = brand_id;
	}

	public int getOriginId() {
		return originId;
	}

	public void setOriginId(int origin_id) {
		this.originId = origin_id;
	}
		
}
