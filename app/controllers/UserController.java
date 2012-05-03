package controllers;

import java.util.HashMap;
import java.util.Map;

import model.Product;
import model.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import com.google.inject.Inject;

import data.IProductRepository;
import data.IShoppingCartRepository;
import data.IUserRepository;

public class UserController extends Controller {
    
    @Inject
    static UserStore userStore;
    
    @Inject
    static IUserRepository userRepo;

    @Inject
    static IProductRepository productRepo;
    
    @Inject
    static IShoppingCartRepository shoppingRepo;
    
    public static Result index() {

        Form<User> userForm = form(User.class);
        
        if (UserStore.getUserId() == 0) {
            return ok(views.html.user.index.render(userForm, null));
        } else {
            return ok(views.html.user.index.render(userForm, userRepo.getUserReg(UserStore.getUserName())));
        }
    }

    @Security.Authenticated(Authenticated.class)
    public static Result shoppingCart() {
    	
    	int shoppingCartId = shoppingRepo.getIdForUser(UserStore.getUserId());
    	Map<Integer, Product> products = new HashMap<Integer, Product>();
    	
    	for (Product product : productRepo.getProductsInShoppingCart(shoppingCartId)) {
    		products.put(product.getId(), product);
    	}
    	
    	return ok(views.html.user.shopping.render(
    			userRepo.getUserReg(UserStore.getUserName()),
    			shoppingRepo.getEntries(shoppingCartId),
    			products));
    }

    public static Result login() {

        Form<User> userForm = form(User.class);
        User user = userForm.bindFromRequest().get();

        if (userStore.authenticate(user)) {
            return redirect(routes.UserController.index());
        } else {
            return unauthorized();
        }
    }

    public static Result register() {

        Form<User> userForm = form(User.class);
        User user = userForm.bindFromRequest().get();

        if (userStore.register(user)) {
            return redirect(routes.UserController.index());
        } else {
            return unauthorized();
        }
    }
}
