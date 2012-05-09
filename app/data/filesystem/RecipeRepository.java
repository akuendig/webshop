package data.filesystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.inject.Inject;

import model.Product;
import model.Recipe;
import model.RecipeContainsProduct;
import model.RecipeEntry;
import model.RecipeOrder;
import data.IProductRepository;
import data.IRecipeProductRepository;
import data.IRecipeRepository;

public class RecipeRepository extends BaseRepository<Recipe> implements IRecipeRepository {
	
	IProductRepository productRepo;
	
	IRecipeProductRepository recipeProductRepo;

	@Inject
	public RecipeRepository(IProductRepository productRepo, IRecipeProductRepository recipeProductRepo) {
		super("tblRecipe");
		
		this.productRepo = productRepo;
		this.recipeProductRepo = recipeProductRepo;
	}
	
	public Recipe getById(int id) {
		return super.getById(id);
	}

	@Override
	public List<Recipe> getByName(String name, RecipeOrder order) {
		
		ArrayList<Recipe> results = new ArrayList<Recipe>();

		for (Recipe entry: entries) {
			if (entry.getName().matches(name)) {
				fillTotalCost(entry);
				results.add(entry);
			}
		}
		
		switch (order) {
		case Name:
			Collections.sort(results,  new Comparator<Recipe>(){
					public int compare(Recipe s1, Recipe s2) {
						return s1.getName().compareToIgnoreCase(s2.getName());
					}
				});
			break;
		case Time:
			Collections.sort(results,  new Comparator<Recipe>(){
				public int compare(Recipe s1, Recipe s2) {
					return s1.getPrepTime().compareTo(s2.getPrepTime());
				}
			});
			break;
		case TotalCost:
			Collections.sort(results,  new Comparator<Recipe>(){
				public int compare(Recipe s1, Recipe s2) {
					return s1.getTotalCost().compareTo(s2.getTotalCost());
				}
			});
			break;
		}
		
		return results;
	}

	@Override
	public List<RecipeEntry> getEngredientsById(int id) {

		ArrayList<RecipeEntry> results = new ArrayList<RecipeEntry>();
		List<RecipeContainsProduct> relations = recipeProductRepo.getByRecipe(id);
		
		for (RecipeContainsProduct relation: relations) {
			
			Product p = productRepo.getById(relation.getProductId());
			RecipeEntry entry = new RecipeEntry();
			
			entry.setId(p.getId());
			entry.setName(p.getName());
			entry.setPrice(p.getPrice());
			entry.setProductId(relation.getProductId());
			entry.setQuantity(relation.getQuantity());
			entry.setRecipeId(relation.getRecipeId());
			
			results.add(entry);
		}
		
		return results;
	}
	
	private void fillTotalCost(Recipe recipe) {
		
		float sum = 0;
		List<RecipeContainsProduct> products = recipeProductRepo.getByRecipe(recipe.getId());
		
		for (RecipeContainsProduct product: products) {
			sum += productRepo.getById(product.getProductId()).getPrice() * product.getQuantity();
		}
		
		recipe.setTotalCost(sum);
	}

}
