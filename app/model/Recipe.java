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
	
	private int id;
	private String name;
	private Time prepTime;
	private String text;
	private Float totalCost;
	
	public Recipe() {
	}

	public Recipe(final ResultSet rs) throws SQLException {
		this.id = rs.getInt(RECIPE_ID);
		this.name = rs.getString(RECIPE_NAME);
		this.prepTime = rs.getTime(RECIPE_PREP_TIME);
		this.text = rs.getString(RECIPE_TEXT);
		this.totalCost = rs.getFloat(TOTAL_COST);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(Time prepTime) {
		this.prepTime = prepTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public Float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}
}
