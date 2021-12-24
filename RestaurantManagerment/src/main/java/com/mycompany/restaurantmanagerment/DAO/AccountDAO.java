/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantmanagerment.DAO;

import com.mycompany.restaurantmanagerment.Controller.ConnectDB;
import com.mycompany.restaurantmanagerment.Modals.Account;
import com.mycompany.restaurantmanagerment.Modals.Food;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author IO
 */
public class AccountDAO {
    Account account;
    ConnectDB conn;

    public AccountDAO() {
        conn = new ConnectDB();
    }
    public Account getAccount(String UserName, String Password) {

        conn.getConnect();

        Account acc = null;

        try {
            Statement stmt = conn.connect.createStatement();
            String query = "SELECT * FROM Account WHERE  Username = '" +
                    UserName + "\' AND " + "Password = \'" + Password + "\'";

            ResultSet rs = stmt.executeQuery(query);
            
            System.out.println(query);

            if (rs.next()) {
                int Id = rs.getInt("Id");
                boolean level = (Integer.parseInt(rs.getString("Level")) != 0);

                acc = new Account(Id, UserName,Password,level);
                System.out.println(acc.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi truy vấn");
        } finally {
            conn.closeConnect();
        }

        return acc;
    }
    
    public boolean LoginSuccess(String UserName, String Password)
    {
        Account acc = getAccount(UserName,Password);
        
        if (acc == null)
            return false;
        return true;
    }
    public boolean insertAccount(Account account){

        conn.getConnect();

        try {

            String query = "INSERT  INTO Account VALUES(?,?,?)";

            PreparedStatement stmt = conn.connect.prepareStatement(query);

            stmt.setString(1, account.getUserName());
            stmt.setString(2, account.getPassword());
            stmt.setBoolean(3,account.isLevel());


            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }

        return  false;
    }
    
    
}
