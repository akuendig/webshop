package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.ModelFactory;

import model.Recipe;
import model.RecipeEntry;
import model.RecipeOrder;

public class RecipeRepository  extends BaseRepository<Recipe> {

	public RecipeRepository() {
		super(Recipe.class);
	}
	
	public final List<Recipe> getByName(String name, RecipeOrder order) {
		
		String orderString = "";
		
		switch (order) {
		case Name:
			orderString = "ORDER BY RecipeName ASC ";
			break;
		case TotalCost:
			orderString = "ORDER BY TotalCost ASC, RecipeName ASC ";
			break;
		case Time:
			orderString = "ORDER BY RecipePrepTime ASC, RecipeName ASC ";
			break;
		default:
			new RuntimeException("Not reachable");
		}
		
		return
			getResults(
				"SELECT * " +
				"FROM tblrecipe AS r " +
				"LEFT JOIN " +
				"( " +
				"    SELECT sum(ProductPrice*rcp.Quantity) AS TotalCost, rcp.Recipe_ID AS rec_ID " +
				"    FROM recipe_contains_product AS rcp, tblProduct AS p " +
				"    WHERE rcp.Product_ID = p.Product_ID " +
				"    GROUP BY rcp.Recipe_ID " +
				") AS j " +
				"ON r.Recipe_ID = j.rec_ID " +
				"WHERE r.RecipeName LIKE '%" + name + "%' "+
				orderString);
	}

	public final Recipe getById (final int id) {

		return
			getResult(
				"SELECT * " +
				"FROM tblrecipe AS r " +
				"LEFT JOIN ( " +
				"    SELECT sum(ProductPrice*rcp.Quantity) AS TotalCost, rcp.Recipe_ID AS rec_ID " +
				"    FROM recipe_contains_product AS rcp, tblProduct AS p " +
				"    WHERE rcp.Product_ID = p.Product_ID " +
				"    GROUP BY rcp.Recipe_ID " +
				"    ) AS j " +
				"ON r.Recipe_ID = j.rec_ID " +
				"WHERE Recipe_ID = " + id + " ");
	}

	public final List<RecipeEntry> getEngredientsById(final int id) {

		List<RecipeEntry> results = new ArrayList<RecipeEntry>();
		ModelFactory<RecipeEntry> factory = new ModelFactory<>(RecipeEntry.class);
		
		String query =
				"SELECT * " +
				"FROM recipe_contains_product AS rcp " +
				"JOIN tblproduct AS p " +
				"ON p.Product_ID = rcp.Product_ID " +
				"WHERE rcp.Recipe_ID = " + id + " ";

		try (Statement stmt = sqlConnection.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(query)) {
				while (rs.next()) {
					results.add(factory.create(rs));
				}
			}

		} catch (final SQLException ex) {
			ex.printStackTrace();
		}

		return results;
	}

}
