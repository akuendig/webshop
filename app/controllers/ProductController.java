package controllers;

import java.util.List;
import java.util.Map;

import model.Product;

import com.google.inject.Inject;

import data.BrandRepository;
import data.CategoryRepository;
import data.ProductRepository;

import play.mvc.*;
import play.mvc.Http.RequestBody;
import scala.annotation.target.param;

import views.html.product.*;

public class ProductController extends Controller {
	
	@Inject
	static CategoryRepository categoryRepo;
	
	@Inject
	static ProductRepository productRepo;
	
	@Inject
	static BrandRepository brandRepo;
	
	public static Result index() {
		return ok(list.render(productRepo.getAll(), categoryRepo.getAll(), brandRepo.getAll(), 0, 0, null));
	}

	public static Result search(Long brandId, Long categoryId, String name) {
		return ok(
				list.render(
						productRepo.getRefined(name, categoryId.intValue(), brandId.intValue()),
						categoryRepo.getAll(),
						brandRepo.getAll(),
						categoryId.intValue(),
						brandId.intValue(),
						name));
	}
	
	public static Result get(Long id) {
		return TODO;
	}
	
	public static Result like(Long id) {
		return TODO;
	}

}
