package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public final class Recipe {

	public static final String RECIPE_ID = "Recipe_ID";
	public static final String RECIPE_NAME = "RecipeName";
	public static final String RECIPE_PREP_TIME = "RecipePrepTime";
	public static final String RECIPE_TEXT = "RecipeText";
	public static final String TOTAL_COST = "TotalCost";
	
	private final int id;
	private final String name;
	private final Time prep_time;
	private final String text;
	private final Float total_cost;

	public Recipe(final ResultSet rs) throws SQLException {
		this.id = rs.getInt(RECIPE_ID);
		this.name = rs.getString(RECIPE_NAME);
		this.prep_time = rs.getTime(RECIPE_PREP_TIME);
		this.text = rs.getString(RECIPE_TEXT);
		this.total_cost = rs.getFloat(TOTAL_COST);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Time getPrep_time() {
		return prep_time;
	}

	public String getText() {
		return text;
	}
	
	public Float getTotal_cost() {
		return total_cost;
	}
}
