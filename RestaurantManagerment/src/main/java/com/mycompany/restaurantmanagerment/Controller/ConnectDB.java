/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantmanagerment.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;

/**
 *
 * @author FX Long
 */
public class ConnectDB {

    private String database = "restaurant";
    private String username = "sa";
    private String password = "danglong719";;

    private String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                            + "databaseName=" + database
                            + "; user=" + username
                            + ";password=" + password;


    public Connection connect = null;

    public ConnectDB(){

    }

    public void getConnect(){
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(connectionUrl);
            System.out.println("Kết nối thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void closeConnect(){
        if(connect != null) {
            connect = null;
        }
        System.out.println("Đã ngắt kết nối");
    }
    
}
