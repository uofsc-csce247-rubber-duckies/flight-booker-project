package com.rubberduckies.flytr;

public class Location {

    private String city;
    private String state;

    public Location(String city, String state) {
        this.city = city;
        this.state = state;
    }

    public Location(String locString) {
        String[] locSplit = locString.trim().split(",");
        if (locSplit.length == 0) {
            city = "NULL";
            state = "NULL";
            return;
        }
        city = locSplit[0].trim();
        if (locSplit.length == 1) {
            state = "NULL";
            return;
        }
        state = locSplit[1].trim();
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

}
