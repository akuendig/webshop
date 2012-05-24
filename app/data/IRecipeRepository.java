package data;

import java.util.List;

import model.Recipe;
import model.RecipeEntry;
import model.RecipeOrder;

public interface IRecipeRepository extends ICrud<Recipe> {

	public abstract List<Recipe> getByName(String name, RecipeOrder order);

	public abstract Recipe getById(final int id);

	public abstract List<RecipeEntry> getEngredientsById(final int id);

}