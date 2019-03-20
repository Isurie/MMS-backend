package com.grokonez.jwtauthentication.message.request;

import java.util.Set;

import javax.validation.constraints.*;

public class SignUpForm {
    @NotBlank
    @Size(min = 3, max = 50)
    private String fname;

    @NotBlank
    @Size(min = 3, max = 50)
    private String lname;

    @NotBlank
    @Size(min=3, max = 50)
    private String gender;

    @NotBlank
    @Size(min=3, max = 50)
    private String birthday;

    @NotBlank
    @Size(min=3, max = 100)
    private String address;

    @NotBlank
    @Size(min=3, max = 10)
    private String telephone;

    @NotBlank
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank
    @Size(max = 60)
    @Email
    private String email;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

//    public String getfName() {
//
//        return fname;
//    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

//    public void setfName(String fname) {
//
//        this.fname = fname;
//    }


    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
    	return this.role;
    }
    
    public void setRole(Set<String> role) {
    	this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}