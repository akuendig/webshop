package controllers;

import java.util.Map;

import model.RecipeOrder;
import play.mvc.Controller;
import play.mvc.Result;

import com.google.inject.Inject;

import data.IRecipeRepository;

public class RecipeController extends Controller {
	
	@Inject
	static IRecipeRepository recipeRepo;

	public static Result index() {

		Map<String, String[]> form = request().body().asFormUrlEncoded();
		String filter;
		String name;
		
		if (form == null || form.get("filter") == null) filter = null;
		else filter = form.get("filter")[0];
		
		if (form == null || form.get("name") == null) name = "";
		else name = form.get("name")[0];
		
		if (filter == null) {
			return ok(views.html.recipe.index.render(recipeRepo.getByName(name, RecipeOrder.Name)));
		} else if (filter.equals("sort_name")) {
			return ok(views.html.recipe.index.render(recipeRepo.getByName(name, RecipeOrder.Name)));
		} else if (filter.equals("name")) {
			return ok(views.html.recipe.index.render(recipeRepo.getByName(name, RecipeOrder.Name)));
		} else if (filter.equals("sort_cost")) {
			return ok(views.html.recipe.index.render(recipeRepo.getByName(name, RecipeOrder.TotalCost)));
		} else if (filter.equals("sort_time")) {
			return ok(views.html.recipe.index.render(recipeRepo.getByName(name, RecipeOrder.Time)));
		} else {
			throw new RuntimeException("Code should not be reachable!");
		}
	}
	
	public static Result get(Long id) {
		
		return ok(
				views.html.recipe.detail.render(
						recipeRepo.getById(id.intValue()),
						recipeRepo.getEngredientsById(id.intValue())));
	}
}
