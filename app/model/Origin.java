package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Origin extends EntityBase {

	public static final String ORIGIN_ID = "Origin_ID";
	public static final String ORIGIN_COUNTRY_NAME = "OriginCountryName";

	private String countryName;

	public Origin() {
	}

	public Origin(final ResultSet rs) throws SQLException {
		this.id = rs.getInt(ORIGIN_ID);
		this.countryName = rs.getString(ORIGIN_COUNTRY_NAME);
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
