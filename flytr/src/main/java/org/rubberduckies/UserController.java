package org.rubberduckies;

import java.util.ArrayList;
import org.json.simple.JSONObject;

public class UserController extends Controller {
    
    private ArrayList<User> users;


    /**
     * Creates a new user controller
     */
    public UserController(){
        System.out.println("UserController constructor");
        System.out.println("Load users");

        this.users = loadUsers();
    }

    
    /** 
     * Loads users from the database
     * @return ArrayList<User> arraylist of users
     */
    private ArrayList<User> loadUsers() {
        System.out.println("UserController.loadUsers");
        return null;
    }

    
    /** 
     * Reads a JSON file
     * @param filename file to read
     * @return JSONObject loaded JSON object
     */
    protected JSONObject readJSON(String filename) {
        System.out.println("UserController.readJSON");
        return null;
    }

    
    /** 
     * Writes the users to the user database
     * @param filename filename to save to
     * @param json JSONObject to save
     * @return boolean if save is success
     */
    protected boolean writeJSON(String filename, JSONObject json) {
        System.out.println("UserController.writeJSON");
        return false;
    }

    /**
     * Parses JSON object
     * @param jsonObject json object to parse
     */
    protected void parse(JSONObject jsonObject) {
        //TODO: implement
    }

    
    /** 
     * Log in a user
     * @param username
     * @param password
     * @return User
     */
    public User login(String username, String password){
        System.out.println("UserController.login");
        return null;
    }

    
    /** 
     * Saves a single user
     * @param user user to save to database
     */
    public void save(User user){
        System.out.println("UserController.save");
    }

    
    /** 
     * Get user's user data
     * @param username user to get data for
     * @return UserData user data
     */
    public UserData getData(String username){
        System.out.println("UserController.getData");
        return null;
    }

    
    /** 
     * Get user's preferences
     * @param username
     * @return UserPreferences
     */
    public UserPreferences getPreferences(String username){
        System.out.println("UserController.getPreferences");
        return null;
    }

    
    /** 
     * Honestly no idea what this method is for currently, but it's in UML
     * @param plainText
     * @return String
     */
    private String hash(String plainText){
        System.out.println("UserController.hash");
        return null;
    }
}
