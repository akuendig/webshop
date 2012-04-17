package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Origin {

	public static final String ORIGIN_ID = "Origin_ID";
	public static final String ORIGIN_COUNTRY_NAME = "OriginCountryName";
	
	private final int id;
	private final String countryName;

	public Origin(final ResultSet rs) throws SQLException {
		this.id = rs.getInt(ORIGIN_ID);
		this.countryName = rs.getString(ORIGIN_COUNTRY_NAME);
	}

	public int getId() {
		return id;
	}

	public String getCountryName() {
		return countryName;
	}
}
