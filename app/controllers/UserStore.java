package controllers;

import model.User;

import com.google.inject.Inject;

import data.UserRepository;

import play.mvc.*;
import play.mvc.Http.Context;

public class UserStore {
	
	@Inject
	static UserRepository userRepo;

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
	
	public static boolean authenticate(String username, String password) {
		User user = userRepo.getUser(username, password);
		
		if (user == null) {
			return false;
		}
		
		ctx().session().put("userid", String.valueOf(user.getId()));
		ctx().session().put("username", user.getUsername());
		
		return true;
	}
	
	public static boolean register(String username, String password) {
		User user = userRepo.getUser(username, password);
		
		if (user == null) {
			user = userRepo.createUser(username, password);
		} else {
			return false;
		}
		
		ctx().session().put("userid", String.valueOf(user.getId()));
		ctx().session().put("username", user.getUsername());
		
		return true;
	}

    private static Context ctx() {
        return Http.Context.current();
    }
}
