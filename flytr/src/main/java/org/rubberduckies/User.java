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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return this.role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean isFrequentFlyer() {
        return this.isFrequentFlyer;
    }

    public UserData getData() {
        return this.data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public UserPreferences getPreferences() {
        return this.preferences;
    }

    public void setPreferences(UserPreferences preferences) {
        this.preferences = preferences;
    }

    public ArrayList<Booking> getCart() {
        return this.cart;
    }

    public void setCart(ArrayList<Booking> cart) {
        this.cart = cart;
    }

    public ArrayList<BookingReceipt> getHistory() {
        return this.history;
    }

    public void setHistory(ArrayList<BookingReceipt> history) {
        this.history = history;
    }

    public ArrayList<User> getLinkedAccounts() {
        return this.linkedAccounts;
    }

    public void setLinkedAccounts(ArrayList<User> linkedAccounts) {
        this.linkedAccounts = linkedAccounts;
    }

    public ArrayList<UserData> getSavedPeople() {
        return this.savedPeople;
    }

    public void setSavedPeople(ArrayList<UserData> savedPeople) {
        this.savedPeople = savedPeople;
    }

    public ArrayList<Dog> getDogs() {
        return this.dogs;
    }

    public void setDogs(ArrayList<Dog> dogs) {
        this.dogs = dogs;
    }

    public boolean isIsFrequentFlyer() {
        return this.isFrequentFlyer;
    }

    public boolean getIsFrequentFlyer() {
        return this.isFrequentFlyer;
    }

    public void setIsFrequentFlyer(boolean isFrequentFlyer) {
        this.isFrequentFlyer = isFrequentFlyer;
    }

    public void addLinkedAccount(User user) {
        this.linkedAccounts.add(user);
    } 
}
