package org.rubberduckies;

import java.time.LocalDateTime;

public class UserData {
    
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDateTime birthDate;
    private String passport;
    private String address;


    public UserData(String firstName, String lastName, String email, String phoneNumber, LocalDateTime birthDate, String passport, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.passport = passport;
        this.address = address;
    }

    
    /** 
     * Gets first name
     * @return String first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    
    /** 
     * Sets first name
     * @param firstName first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    /** 
     * Gets last name
     * @return String last name
     */
    public String getLastName() {
        return this.lastName;
    }

    
    /** 
     * Sets last name
     * @param lastName last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    /** 
     * Gets email
     * @return String email
     */
    public String getEmail() {
        return this.email;
    }

    
    /** 
     * Sets email
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     * Gets phone number
     * @return String phone number
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    
    /** 
     * Sets phone number 
     * @param phoneNumber phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    /** 
     * Gets birth date
     * @return LocalDateTime birth date
     */
    public LocalDateTime getBirthDate() {
        return this.birthDate;
    }

    
    /** 
     * Sets birth date
     * @param birthDate birth date
     */
    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    
    /** 
     * Gets passport number
     * @return String passport number
     */
    public String getPassport() {
        return this.passport;
    }

    
    /** 
     * Sets passport number
     * @param passport passport number
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    
    /** 
     * Gets address
     * @return String address
     */
    public String getAddress() {
        return this.address;
    }

    
    /** 
     * Sets address
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
