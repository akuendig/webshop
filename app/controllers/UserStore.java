package controllers;

import model.User;

import com.google.inject.Inject;

import data.UserRepository;

import play.mvc.*;
import play.mvc.Http.Context;

public class UserStore {

    UserRepository userRepo;

    @Inject
    public UserStore(UserRepository repo) {
    	userRepo = repo;
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

    public boolean authenticate(User user) {

    	user = userRepo.getUser(user);
    	
        if (user != null) {
            ctx().session().put("userid", String.valueOf(user.getId()));
            ctx().session().put("username", user.getUsername());

            return true;
        } else {
            return false;
        }
    }

    public boolean register(User user) {

        if (userRepo.contains(user)) {
            return false;
        } else {
            user = userRepo.createUser(user);

            ctx().session().put("userid", String.valueOf(user.getId()));
            ctx().session().put("username", user.getUsername());

            return true;
        }
    }

    private static Context ctx() {
        return Http.Context.current();
    }
}
