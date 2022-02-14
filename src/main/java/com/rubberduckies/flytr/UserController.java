package com.rubberduckies.flytr;

import java.util.ArrayList;
import java.io.File;

import org.json.simple.JSONObject;

public class UserController extends Controller {

    private ArrayList<User> users;

    public UserController() {
        users = new ArrayList<User>();
        File file = new File("./database/");
        File[] files = file.listFiles();
        ArrayList<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        for (File f : files) {
            jsonObjects.add(readJson(f.getPath()));
        }
        parse(jsonObjects);
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
        for (JSONObject json : jsonObjects) {
            String airport = json.get("airport").toString();
            Location from = new Location(json.get("from").toString());
            Location to = new Location(json.get("to").toString());
        }
    }

}
