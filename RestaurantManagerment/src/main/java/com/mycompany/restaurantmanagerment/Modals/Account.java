/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantmanagerment.Modals;

/**
 *
 * @author IO
 */
public class Account {
    
    
    private int Id;
    private String UserName;
    private String Password;
    private boolean  Level;

    public Account() {
    }

    public Account(int Id, String username, String password, boolean level ) {
        this.Id = Id;
        this.UserName = username;
        this.Password = password;
        this.Level = level;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean isLevel() {
        return Level;
    }

    public void setLevel(boolean Level) {
        this.Level = Level;
    }

    
}
