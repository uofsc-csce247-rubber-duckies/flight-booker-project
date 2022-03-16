/**
 * @author james-thurlow
 */

package test.java.org.rubberduckies;

import java.util.ArrayList;

public class UserController {
    private ArrayList<User> users;

    public UserController(){
        System.out.println("UserController constructor");
    }

    public User login(String username, String password){
        System.out.println("UserController.login");
        return null;
    }

    public void save(User user){
        System.out.println("UserController.save");
    }

    public UserData getData(String username){
        System.out.println("UserController.getData");
        return null;
    }

    public UserPreferences getPreferences(String username){
        ystem.out.println("UserController.getPreferences");
        return null;
    }

    private String hash(String plainText){
        System.out.println("UserController.hash");
        return null;
    }
}
