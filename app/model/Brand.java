package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class represents a Brand of products (i.e. Nestle, Barilla etc)
 */
public final class Brand {

	public static final String BRAND_ID = "Brand_ID";
	public static final String BRAND_NAME = "BrandName";

	private int id;
	private String name;

	public Brand() {
	}

	public Brand(final ResultSet rs) throws SQLException {
		this.id = rs.getInt(BRAND_ID);
		this.name = rs.getString(BRAND_NAME);
	}

	public final String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}
