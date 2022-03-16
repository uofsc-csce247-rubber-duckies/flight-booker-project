package org.rubberduckies;

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
    
    public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.data = new UserData();
        this.preferences = new UserPreferences();
        this.card = new ArrayList<Booking>();
        this.history = new ArrayList<BookingReceipt>();
        this.linkedAccounts = new ArrayList<User>();
        this.savedPeople = new ArrayList<UserData>();
        this.dogs = new ArrayList<Dogs>();
        this.isFrequentFlyer = false;
    }

    public User(String username, String password, UserRole role, UserData data, UserPreferences preferences, 
            ArrayList<Booking> cart, ArrayList<BookingReceipt> history, ArrayList<User> linkedAccounts, 
            ArrayList<UserData> savedPeople, ArrayList<Dog> dogs, boolean isFrequentFlyer) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.data = data;
        this.preferences = new UserPreferences();
        this.card = new ArrayList<Booking>();
        this.history = new ArrayList<BookingReceipt>();
        this.linkedAccounts = new ArrayList<User>();
        this.savedPeople = new ArrayList<UserData>();
        this.dogs = new ArrayList<Dogs>();
        this.isFrequentFlyer = false;
    }

    public String getUsername() {
        
    }
}
