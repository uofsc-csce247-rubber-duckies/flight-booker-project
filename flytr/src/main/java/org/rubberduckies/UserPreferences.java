package org.rubberduckies;
/**
 * Creates a class to store the Users Preferances
 * @author Tyler Beetle
 */
import java.util.ArrayList;

public class UserPreferences {
    
    private ArrayList<Search> savedSearches;
    private String nickname;

    /**
     * Creates a new user empty user preferences object
     */
    public UserPreferences() {
        this.savedSearches = new ArrayList<Search>();
        this.nickname = "";
    }

    /**
     * Creates user preferences from saved information
     * @param savedSearches previous user searches
     * @param nickname user nickname
     */
    public UserPreferences(ArrayList<Search> savedSearches, String nickname) {
        this.savedSearches = savedSearches;
        this.nickname = nickname;
    }

    
    /** 
     * Gets the user search history
     * @return ArrayList<Search> user search history
     */
    public ArrayList<Search> getSavedSearches() {
        return this.savedSearches;
    }

    
    /** 
     * Sets user search history
     * @param savedSearches user search history
     */
    public void setSavedSearches(ArrayList<Search> savedSearches) {
        this.savedSearches = savedSearches;
    }

    
    /** 
     * Gets user nickname
     * @return String user nickname
     */
    public String getNickname() {
        return this.nickname;
    }

    
    /** 
     * Sets user nickname
     * @param nickname user nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
