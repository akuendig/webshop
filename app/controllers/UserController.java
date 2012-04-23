package controllers;

import com.google.inject.Inject;

import model.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class UserController extends Controller {
    
    @Inject
    static IUserStore userStore;
    
    public static Result index() {
        
        int userId = UserStore.getUserId();
        Form<User> userForm = form(User.class);
        
        if (userId == 0) {
            return ok(views.html.user.index.render(userForm));
        } else {
            return ok(views.html.user.index.render(userForm));
        }
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

    public static Result register(String username, String password) {

        Form<User> userForm = form(User.class);
        User user = userForm.bindFromRequest().get();

        if (userStore.register(user)) {
            return redirect(routes.UserController.index());
        } else {
            return unauthorized();
        }
    }
}
