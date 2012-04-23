package controllers;

import model.User;

public interface IUserStore {

    public abstract boolean authenticate(User user);

    public abstract boolean register(User user);

}