package org.rubberduckies;

import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class UserController extends Controller {

    private final String USER_DATABASE = "database/userdata";
    
    private static UserController instance;
    private ArrayList<User> users;


    /**
     * Creates a new user controller
     */
    private UserController(){
        // TODO

    }

    public static UserController createController() {
        if (instance == null) instance = new UserController();
        return instance;
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
        for (User user : users) {
            if (BCrypt.checkpw(password, user.getPassword())) return user;
        }
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

    public UserData getData(String username) {
        // TODO
        return null;
    }

    public UserPreferences getPreferences(String username) {
        // TODO
        return null;
    }

    /**
     * Ran after the readJson() method is called, parses
     * that result and creates the corresponding User objects.
     *
     * @param jsonObject The JSONObject to parse.
     */
    protected void parse(JSONObject jsonObject) {
        // TODO
    }       

    private ArrayList<JSONObject> readUserDirectory(String userFile) {
        // TODO
        ArrayList<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        return jsonObjects;
    }
    
    /**
     * Reference: https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/crypto/bcrypt/BCrypt.html
     *
     * Helper method that hashes a plain text password
     * and returns the message digest using Bcrypt.
     *
     * @param plainText The plain text to hash.
     *
     * @return The message digest.
     */
    private String hash(String plainText){
        return BCrypt.hashpw(plainText, BCrypt.gensalt());
    }
}
