package data;

import java.util.List;

import model.RecipeContainsProduct;

public interface IRecipeProductRepository {
	List<RecipeContainsProduct> getByRecipe(int recipeId);
}
