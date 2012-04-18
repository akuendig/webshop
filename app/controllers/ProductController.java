package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.product.detail;
import views.html.product.list;

import com.google.inject.Inject;

import data.*;
import model.*;

public class ProductController extends Controller {
	
	@Inject
	static CategoryRepository categoryRepo;
	
	@Inject
	static ProductRepository productRepo;
	
	@Inject
	static BrandRepository brandRepo;

	@Inject
	static OriginRepository originRepo;

	@Inject
	static CommentRepository commentRepo;
	
	@Inject
	static LikeRepository likeRepo;
	
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
		Product product = productRepo.getById(id.intValue());

		return ok(
				detail.render(
						product,
						brandRepo.getById(product.getBrandId()),
						originRepo.getById(product.getOriginId()), 
						commentRepo.getAllForProduct(product.getId()),
						request().username()));
	}
	
	public static Result like(Long id) {
		Like like = likeRepo.get(userId, id);
		
		if (like == null) {
			likeRepo.create(userId, id);
			flash("success", "Your like has been registered!");
		} else {
			flash("message", "Your already liked this product!");
		}
		
		return redirect(routes.ProductController.get(id));
	}

}
