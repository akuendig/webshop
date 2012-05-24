package controllers;

import model.User;

import com.google.inject.Inject;

import data.IShoppingCartRepository;
import data.IUserRepository;

import play.mvc.*;
import play.mvc.Http.Context;

public class UserStore {

    IUserRepository userRepo;
    
    IShoppingCartRepository shoppingcartRepo;

    @Inject
    public UserStore(IUserRepository repo, IShoppingCartRepository shoppingcartRepo) {
    	userRepo = repo;
    	this.shoppingcartRepo = shoppingcartRepo;
    }

    public static int getUserId() {
        String userIdString = ctx().session().get("userid");

        if (userIdString == null || userIdString == "") {
            return 0;
        } else {
            return Integer.parseInt(userIdString);
        }
    }

    public static String getUserName() {
        return ctx().session().get("username");
    }

    public boolean login(User user) {

    	user = userRepo.getUser(user);
    	
        if (user != null) {
            ctx().session().put("userid", String.valueOf(user.getId()));
            ctx().session().put("username", user.getUsername());

            return true;
        } else {
            return false;
        }
    }

    public void logout() {

        ctx().session().remove("userid");
        ctx().session().remove("username");
    }

    public boolean register(User user) {

        if (userRepo.contains(user)) {
            return false;
        } else {
            user = userRepo.createUser(user);
            if (user != null) {
            	shoppingcartRepo.create(user.getId());
            }
            ctx().session().put("userid", String.valueOf(user.getId()));
            ctx().session().put("username", user.getUsername());

            return true;
        }
    }

    private static Context ctx() {
        return Http.Context.current();
    }
}
