/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantmanagerment.Main;

import com.mycompany.restaurantmanagerment.Controller.ConnectDB;

/**
 *
 * @author FX Long
 */
public class MainClass {
    
    public static void main(String args[]){
        ConnectDB con = new ConnectDB();
        con.getConnect();
    }
}
