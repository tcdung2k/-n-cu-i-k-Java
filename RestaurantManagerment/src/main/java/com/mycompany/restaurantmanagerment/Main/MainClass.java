/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantmanagerment.Main;



import com.mycompany.restaurantmanagerment.View.Home;
import com.mycompany.restaurantmanagerment.View.LoginApp;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author FX Long
 */
public class MainClass {
    
    public static void main(String args[])  {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginApp().setVisible(true);
            }
        });

    }
}
