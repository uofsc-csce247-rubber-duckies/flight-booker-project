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
     * Ran after the readJson() method is called, parses
     * that result and assigns the member variables accordingly.
     *
     * @param jsonObject The JSONObject to parse.
     */
    protected void parse(JSONObject jsonObject) {
        //TODO: implement
    }

    
    /** 
     * Takes in User credentials and returns the User
     * object they correspond to if authenticated, null
     * otherwise.
     *
     * @param username The User's username.
     * @param password The User's password.
     *
     * @return The authenticated User or null.
     */
    public User login(String username, String password){
        // TODO
        return null;
    }

    
    /** 
     * Updates the User's information to the JSON file.
     *
     * @param user Writes the updated User object to the
     *             User's JSON file.
     */
    public void save(User user){
        // TODO
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
