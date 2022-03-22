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

    public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;

        //TODO: default construct variables
    }
}