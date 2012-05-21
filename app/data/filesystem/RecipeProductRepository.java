package data.filesystem;

import java.util.ArrayList;
import java.util.List;

import model.RecipeContainsProduct;
import data.IRecipeProductRepository;

public class RecipeProductRepository extends Table<RecipeContainsProduct> implements IRecipeProductRepository {

	public RecipeProductRepository() {
		super("tblRecipeContainsProduct", RecipeContainsProduct.class);

	}

	@Override
	public List<RecipeContainsProduct> getByRecipe(int recipeId) {

		ArrayList<RecipeContainsProduct> result = new ArrayList<RecipeContainsProduct>();
		
		for (RecipeContainsProduct entry: entries) {
			if (entry.getRecipeId() == recipeId) {
				result.add(entry);
			}
		}
		
		return result;
	}

}
