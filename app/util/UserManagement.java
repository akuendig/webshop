package util;

import javax.servlet.http.HttpSession;

import model.User;


public class UserManagement {

	private final static String SESSION_USER = "LOGGED_IN_USER";
	
	public static final User getCurrentlyLoggedInUser(
		final HttpSession session
	) {
		final Object obj = session.getAttribute(SESSION_USER);
		if (obj == null) {
			return null;
		} else {
			return (User) obj; 
		}
	}
	
	public static final void setCurrentlyLoggedInUser(
			final HttpSession session,
			final User user) {
		session.setAttribute(SESSION_USER, user);
	}
}
