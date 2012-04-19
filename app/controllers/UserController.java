package controllers;

import play.mvc.*;

public class UserController extends Controller {
	public static Result index(){
		return TODO;
	}
	
	public static Result login (String username, String password) {

		if (UserStore.authenticate(username, password)) {
			return redirect(routes.UserController.index());
		} else {
			return unauthorized();
		}
	}

	public static Result register (String username, String password) {

		if (UserStore.register(username, password)) {
			return redirect(routes.UserController.index());
		} else {
			return unauthorized();
		}
	}
}
