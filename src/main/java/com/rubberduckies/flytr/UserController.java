package com.rubberduckies.flytr;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class UserController extends Controller {

    private ArrayList<User> users;

    public UserController() {
        users = new ArrayList<User>();
    }

    public User login(String username, String password) {
        return null;
    }

    public void save(User user) {

    }

    public UserData getData(String username) {
        return null;
    }

    public UserPreferences getPreferences(String username) {
        return null;
    }

    private String hash(String plainText) {
        return plainText;
    }

    protected void parse(ArrayList<JSONObject> jsonObjects) {

    }

}
