package cihangul.com.employechecker.Adapters;

import cihangul.com.employechecker.Models.User;

/**
 * Created by tuzlabim on 17.10.2017.
 */

public class UserController {
    private User currentUser;


    public static UserController getInstance(){
        return new UserController();
    }

    @SuppressWarnings("return type can be null")
    private User getUser(){
        return getInstance().getCurrentUser();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
