package data.filesystem;

import java.util.List;

import model.Recipe;
import model.RecipeEntry;
import model.RecipeOrder;
import data.IRecipeRepository;

public class RecipeRepository extends BaseRepository<Recipe> implements IRecipeRepository {

	protected RecipeRepository() {
		super("tblRecipe");
	}
	
	public Recipe getById(int id) {
		return super.getById(id);
	}

	@Override
	public List<Recipe> getByName(String name, RecipeOrder order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecipeEntry> getEngredientsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
