package org.rubberduckies;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.json.simple.JSONObject;

public class User {
    
    private String username;
    private String password;
    private UserRole role;
    private UserData data;
    private UserPreferences preferences; private ArrayList<Booking> cart;
    private ArrayList<BookingReceipt> history;
    private ArrayList<User> linkedAccounts;
    private ArrayList<UserData> savedPeople;
    private ArrayList<Dog> dogs;
    private boolean isFrequentFlyer;
    
    /**
     * Creates a new starting user from only username, password, and role
     *
     * @param username
     * @param password
     * @param role 
     */
    public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.data = new UserData();
        this.preferences = new UserPreferences();
        this.cart = new ArrayList<Booking>();
        this.history = new ArrayList<BookingReceipt>();
        this.linkedAccounts = new ArrayList<User>();
        this.savedPeople = new ArrayList<UserData>();
        this.dogs = new ArrayList<Dog>();
        this.isFrequentFlyer = false;
    }

    /**
     * Creates a User from existing information.
     *
     * @param username
     * @param password
     * @param role
     * @param data
     * @param preferences
     * @param history
     * @param linkedAccounts
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
            ArrayList<BookingReceipt> history, 
            ArrayList<UserData> savedPeople, 
            ArrayList<Dog> dogs, 
            boolean isFrequentFlyer) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.data = data;
        this.preferences = preferences;
        this.cart = new ArrayList<Booking>();
        this.history = history;
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

    /** 
     * Sets username
     *  
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /** 
     * Gets password
     *
     * @return String password
     */
    public String getPassword() {
        return this.password;
    }

    
    /** 
     * Sets password
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    /** 
     * Gets user role
     * @return UserRole user role
     */
    public UserRole getRole() {
        return this.role;
    }

    
    /** 
     * Sets user role
     * @param role user role
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    public void addLinkedAccount(User user) {
        this.linkedAccounts.add(user);
    }

    
    /** 
     * Gets user data
     * @return UserData user data
     */
    public UserData getData() {
        return this.data;
    }

    
    /** 
     * Sets user data
     * @param data user data
     */
    public void setData(UserData data) {
        this.data = data;
    }

    
    /**
     * Sets user preferences 
     * @return UserPreferences user preferences
     */
    public UserPreferences getPreferences() {
        return this.preferences;
    }

    
    /** 
     * Sets user preferences
     * @param preferences user preferences
     */
    public void setPreferences(UserPreferences preferences) {
        this.preferences = preferences;
    }

    
    /** 
     * Gets user cart
     * @return ArrayList<Booking> user cart
     */
    public ArrayList<Booking> getCart() {
        return this.cart;
    }

    
    /** 
     * Sets user cart
     * @param cart user cart
     */
    public void setCart(ArrayList<Booking> cart) {
        this.cart = cart;
    }

    
    /** 
     * Gets user booking history
     * @return ArrayList<BookingReceipt> user booking history
     */
    public ArrayList<BookingReceipt> getHistory() {
        return this.history;
    }

    
    /** 
     * Sets user booking history
     * @param history user booking history
     */
    public void setHistory(ArrayList<BookingReceipt> history) {
        this.history = history;
    }

    
    /** 
     * Gets linked accounts
     * @return ArrayList<User> linked accounts
     */
    public ArrayList<User> getLinkedAccounts() {
        return this.linkedAccounts;
    }

    
    /** 
     * Sets linked accounts
     * @param linkedAccounts linked accounts
     */
    public void setLinkedAccounts(ArrayList<User> linkedAccounts) {
        this.linkedAccounts = linkedAccounts;
    }

    
    /** 
     * Gets saved non-account people user data
     * @return ArrayList<UserData> saved non-account people user data
     */
    public ArrayList<UserData> getSavedPeople() {
        return this.savedPeople;
    }

    
    /** 
     * Sets saved non-account people user data
     * @param savedPeople saved non-account people user data
     */
    public void setSavedPeople(ArrayList<UserData> savedPeople) {
        this.savedPeople = savedPeople;
    }

    
    /** 
     * Gets user's dogs
     * @return ArrayList<Dog> user's dogs
     */
    public ArrayList<Dog> getDogs() {
        return this.dogs;
    }

    
    /** 
     * Sets user's dogs
     * @param dogs user's dogs
     */
    public void setDogs(ArrayList<Dog> dogs) {
        this.dogs = dogs;
    }

    
    /** 
     * Gets if the user is a frequent flyer
     * @return boolean if the user is a frequent flyer
     */
    public boolean getIsFrequentFlyer() {
        return this.isFrequentFlyer;
    }

    
    /** 
     * Sets if the user is a frequent flyer
     * @param isFrequentFlyer if the user is a frequent flyer
     */
    public void setIsFrequentFlyer(boolean isFrequentFlyer) {
        this.isFrequentFlyer = isFrequentFlyer;
    }

}
