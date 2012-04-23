package controllers;

import model.User;

import com.google.inject.Inject;

import data.UserRepository;

import play.mvc.*;
import play.mvc.Http.Context;

public class UserStore implements IUserStore {

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

    /* (non-Javadoc)
     * @see controllers.IUserStore#authenticate(model.User)
     */
    @Override
    public boolean authenticate(User user) {

        if (userRepo.contains(user)) {
            ctx().session().put("userid", String.valueOf(user.getId()));
            ctx().session().put("username", user.getUsername());

            return true;
        } else {
            return false;
        }
    }

    /* (non-Javadoc)
     * @see controllers.IUserStore#register(model.User)
     */
    @Override
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
