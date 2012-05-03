package controllers;

import java.util.List;
import java.util.Map;

import model.Comment;
import model.Like;
import model.Product;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.product.detail;
import views.html.product.list;

import com.google.inject.Inject;

import data.IBrandRepository;
import data.ICategoryRepository;
import data.ICommentRepository;
import data.ILikeRepository;
import data.IOriginRepository;
import data.IProductRepository;
import data.IShoppingCartRepository;
import data.IUserRepository;

public class ProductController extends Controller {

    @Inject
    static ICategoryRepository categoryRepo;

    @Inject
    static IProductRepository productRepo;

    @Inject
    static IBrandRepository brandRepo;

    @Inject
    static IOriginRepository originRepo;

    @Inject
    static ICommentRepository commentRepo;

    @Inject
    static ILikeRepository likeRepo;
    
    @Inject
    static UserStore userStore;
    
    @Inject
    static IUserRepository userRepo;
    
    @Inject
    static IShoppingCartRepository shoppingRepo;

    public static Result index() {

        return ok(list.render(
            productRepo.getAll(),
            categoryRepo.getAll(),
            brandRepo.getAll(),
            0,
            0,
            null));
    }

    public static Result search(Long brandId, Long categoryId, String name) {

        return ok(list.render(
            productRepo.getRefined(
                name,
                categoryId.intValue(),
                brandId.intValue()),
            categoryRepo.getAll(),
            brandRepo.getAll(),
            categoryId.intValue(),
            brandId.intValue(),
            name));
    }

    public static Result get(Long id) {

        Product product = productRepo.getById(id.intValue());

        return ok(detail.render(
            product,
            brandRepo.getById(product.getBrandId()),
            originRepo.getById(product.getOriginId()),
            commentRepo.getAllForProduct(product.getId())));
    }

    public static Result popular() {

        List<Product> products = productRepo.getByPopularity();

        return ok(list.render(
            products,
            categoryRepo.getAll(),
            brandRepo.getAll(),
            0,
            0,
            null));
    }

    @Security.Authenticated(Authenticated.class)
    public static Result like(Long id) {

        int userId = UserStore.getUserId();
        Like like = likeRepo.get(userId, id.intValue());

        if (like == null) {
            likeRepo.create(userId, id.intValue());
            flash("success", "Your like has been registered!");
        } else {
            flash("message", "Your already liked this product!");
        }

        return redirect(routes.ProductController.get(id));
    }

    @Security.Authenticated(Authenticated.class)
    public static Result comment(Long id) {

        Comment comment = form(Comment.class).bindFromRequest().get();
        
        commentRepo.create(comment.text, comment.productId, comment.userId);

        return redirect(routes.ProductController.get(id));
    }

    @Security.Authenticated(Authenticated.class)
    public static Result add(Long id) {
    	
    	int quantity = 0;
    	Map<String, String[]> form = request().body().asFormUrlEncoded();
    	
    	try {
    		quantity = Integer.parseInt(form.get("quantity")[0]);
		} catch (NumberFormatException e) { }
    	
		shoppingRepo.add(
    		shoppingRepo.getIdForUser(UserStore.getUserId()),
    		id.intValue(),
    		quantity);
    	
        return redirect(routes.ProductController.get(id));
    }

    @Security.Authenticated(Authenticated.class)
    public static Result remove(Long id) {

    	int quantity = 0;
    	Map<String, String[]> form = request().body().asFormUrlEncoded();
    	
    	try {
    		quantity = Integer.parseInt(form.get("quantity")[0]);
		} catch (NumberFormatException e) { }
    	
    	shoppingRepo.remove(
    		shoppingRepo.getIdForUser(UserStore.getUserId()),
    		id.intValue(),
    		quantity);
    	
        return redirect(routes.UserController.shoppingCart());
    }

}
