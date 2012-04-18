package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Object that represents a category of items (i.e. Food) 
 */
public final class Category {

	public static final String CATEGORY_ID = "Category_ID";
	public static final String CATEGORY_NAME = "CategoryName";
	
	private final int id;
	private final String name;

	public Category(final String name) {
		super();
		this.id = 0;
		this.name = name;
	}

	public Category(final ResultSet rs) throws SQLException {
		this.id = rs.getInt(CATEGORY_ID);
		this.name = rs.getString(CATEGORY_NAME);
	}

	public final String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	
}