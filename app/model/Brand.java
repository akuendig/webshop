package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class represents a Brand of products (i.e. Nestle, Barilla etc)
 */
public final class Brand extends EntityBase {

	public static final String BRAND_ID = "Brand_ID";
	public static final String BRAND_NAME = "BrandName";

	private String name;

	public Brand() {
	}
	
	public Brand(final String name) {
		this.name = name;
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

}
