package org.rubberduckies;

import java.util.ArrayList;

public class User {
    
    private String username;
    private String password;
    private UserRole role;
    private UserData data;
    private UserPreferences preferences;
    private ArrayList<Booking> cart;
    private ArrayList<BookingReceipt> history;
    private ArrayList<User> linkedAccounts;
    private ArrayList<UserData> savedPeople;
    private ArrayList<Dog> dogs;
    private boolean isFrequentFlyer;

    public User(String username, String password) {
        this.username = username;
        this.password = password;

        //TODO: default construct variables
    }
  
    /**
     * Creates a User from existing information.
     *
     * @param username
     * @param password
     * @param role
     * @param data
     * @param preferences
     * @param savedPeople
     * @param dogs
     * @param isFrequentFlyer
    */
    // FIXME
    // clean this up, maybe pass an array with specific
    // indecies corresponding to specific object or just
    // one big object the user class can parse.
    // It gets tricky when passing in a JSONObject because
    // of circular dependencies
    public User(
            String username, 
            String password, 
            UserRole role, 
            UserData data, 
            UserPreferences preferences, 
            ArrayList<UserData> savedPeople, 
            ArrayList<Dog> dogs, 
            boolean isFrequentFlyer) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.data = data;
        this.preferences = preferences;
        this.cart = new ArrayList<Booking>();
        this.linkedAccounts = new ArrayList<User>();
        this.history = new ArrayList<BookingReceipt>();
        this.savedPeople = savedPeople;
        this.dogs = dogs;
        this.isFrequentFlyer = isFrequentFlyer;
    }

    /** 
     * Gets username
     *
     * @return String username
     */
    public String getUsername() {
        return this.username;
    }

    public ArrayList<UserData> getSavedPeople() {
        return savedPeople;
    }

    public void addLinkedAccount(User user) {
        this.linkedAccounts.add(user);
    } 
}
