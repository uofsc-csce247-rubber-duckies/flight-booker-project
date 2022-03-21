package org.rubberduckies;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class UserController extends Controller {

    private final String USER_DATABASE = "database/userdata";
    
    private static UserController instance;
    private ArrayList<User> users;


    /**
     * Creates a new user controller
     */
    private UserController() {
        System.out.println("INITIALIZING USER CONTROLLER");
        System.out.println("------------------------");
        System.out.println("Creating list of Users");
        String[] userDirs = getFilesFromDirectory(USER_DATABASE);
        for (String userDir : userDirs) {
            System.out.println("  User Found: " + userDir);
        }
        System.out.println("Verifying User directories");
        ArrayList<JSONObject> userJsonObjects = new ArrayList<JSONObject>();
        for (String userDir : userDirs) {
            System.out.print("  " + userDir + ": ");
            if (verifyUserDir(USER_DATABASE + "/" + userDir)) {
                System.out.println("OK");
                userJsonObjects.add(parseUserDir(USER_DATABASE + "/" + userDir));
            }
            else System.out.println("ERROR");
        }
        System.out.println("Loading Users into memory");
        users = new ArrayList<User>();
        parse(userJsonObjects);
        System.out.println("Linking Accounts");
        for (int i = 0; i < users.size(); i++) {
            linkUserAccounts(users.get(i), userJsonObjects.get(i));
        }
        System.out.println("User Controller Initialized");
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

    public UserData dataFor(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user.getData();
            }
        }
        return null;
    }

    public UserPreferences preferencesFor(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user.getPreferences();
            }
        }
        return null;
    }

    /**
     * Reads in a list of JSONObjects representing Users and loads
     * them into memory as User objects.
     *
     * @param jsonObject The JSONObject to parse.
     */
    @SuppressWarnings("unchecked")
    protected void parse(ArrayList<JSONObject> jsonObjects) {
        for (JSONObject json : jsonObjects) {
            JSONObject dataJson = (JSONObject)json.get("data");
            UserData userData = new UserData(
                    dataJson.get("id").toString(),
                    dataJson.get("firstName").toString(),
                    dataJson.get("lastName").toString(),
                    dataJson.get("email").toString(),
                    dataJson.get("phone").toString(),
                    LocalDateTime.parse(dataJson.get("birthDate").toString()),
                    dataJson.get("passport").toString(),
                    dataJson.get("address").toString()
                    );
            JSONObject preferencesJson = (JSONObject)json.get("preferences");
            ArrayList<Search> userSearches = new ArrayList<Search>();
            // TODO
            // implement loading saved searches for users
            UserPreferences userPreferences = new UserPreferences(
                    userSearches,
                    preferencesJson.get("nickname").toString()
                    );
            UserRole role;
            switch (dataJson.get("role").toString()) {
                case "REGULAR":
                    role = UserRole.REGULAR;
                    break;
                case "ADMIN":
                    role = UserRole.ADMIN;
                    break;
                default:
                    role = UserRole.REGULAR;
                    break;
            }
            // TODO
            // implement setting history for users
            ArrayList<BookingReceipt> userHistory = new ArrayList<BookingReceipt>();
            // TODO
            // implement setting saved people for users
            ArrayList<UserData> userSavedPeople = new ArrayList<UserData>();
            ArrayList<Dog> userDogs = new ArrayList<Dog>();
            for (JSONObject dogJson : (ArrayList<JSONObject>)json.get("dogs")) {
                userDogs.add(new Dog(
                            dogJson.get("name").toString(),
                            dogJson.get("breed").toString(),
                            (int)dogJson.get("weight")
                            ));
            }
            users.add(new User(
                        dataJson.get("username").toString(),
                        dataJson.get("password").toString(),
                        role,
                        userData,
                        userPreferences,
                        userHistory,
                        userSavedPeople,
                        userDogs,
                        (boolean)dataJson.get("isFrequentFlyer")
                        ));
        }
    }       

    // FIXME
    // IDE giving me grief over raw use of these methods,
    // might fix later but right now it just needs to work
    /**
     * Gives a massive JSONObject representing all of the User's properties
     * from their JSON files.
     *
     * @param userDir The directory of the user.
     * @return The JSONObject of the User.
    */
    private JSONObject parseUserDir(String userDir) {
        JSONObject ret = new JSONObject();
        // concat all parts of User json files into one
        ret.put("data", readJson(userDir + "/" + "data.json"));
        ret.put("dogs", readJson(userDir + "/" + "dogs.json").get("dogs"));
        ret.put("preferences", readJson(userDir + "/" + "preferences.json"));
        ret.put("savedPeople", readJson(userDir + "/" + "saved_people.json").get("savedPeople"));
        ArrayList<JSONObject> historyJson = new ArrayList<JSONObject>();
        for (String h : getFilesFromDirectory(userDir + "/history")) {
            historyJson.add(readJson(userDir + "/history/" + h));
        }
        ret.put("history", historyJson.toArray());
        return ret;
    }

    /**
     * Verifies if a diven user directory has the necessary
     * files.
     *
     * @param userDir The directory of the user.
     * @return Whether the user is verified correctly.
    */
    private boolean verifyUserDir(String userDir) {
        List<String> userFiles = Arrays.asList(getFilesFromDirectory(userDir));
        if (!userFiles.contains("data.json")) return false;
        if (!userFiles.contains("dogs.json")) return false;
        if (!userFiles.contains("preferences.json")) return false;
        if (!userFiles.contains("saved_people.json")) return false;
        if (!userFiles.contains("history")) return false;
        return true;
    }

    private void linkUserAccounts(User user, JSONObject userJson) {
        JSONObject data = (JSONObject)userJson.get("data");
        JSONArray linkedUserArray = (JSONArray)data.get("linkedAccounts");
        for (Object linkedUserObject : linkedUserArray) {
            String linkedUsername = linkedUserObject.toString();
            for (User u : users) {
                if (u == user) continue;
                if (u.getUsername().equals(linkedUsername)) {
                    user.addLinkedAccount(u);
                }
            }
        }
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
