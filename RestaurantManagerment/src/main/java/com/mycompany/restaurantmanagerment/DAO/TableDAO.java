/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantmanagerment.DAO;

import com.mycompany.restaurantmanagerment.Controller.ConnectDB;
import com.mycompany.restaurantmanagerment.Modals.Category;
import com.mycompany.restaurantmanagerment.Modals.Table;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FX Long
 */
public class TableDAO {

    ConnectDB conn ;

    public TableDAO() {
        this.conn = new ConnectDB();
    }

    public List<Table> getAllTables() {

        conn.getConnect();

        List<Table> lstTable = new ArrayList<>();

        try {
            Statement stmt = conn.connect.createStatement();

            String query = "SELECT * FROM Tables";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int Id = rs.getInt("Id");
                String name = rs.getString("Name");
                int status = rs.getInt("Status");

                Table table = new Table(Id, name, status);

                lstTable.add(table);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return lstTable;
    }

    public boolean insertTable(Table table){

        try{
            conn.getConnect();

            String query = "INSERT INTO Tables (Name) VALUES(?)";

            PreparedStatement stmt = conn.connect.prepareStatement(query);
            stmt.setString(1, table.getName());

            stmt.executeUpdate();

            System.out.println("Inserted table: " +table.getName());
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    public boolean updateTableByName(int idTb, String nameTb){
        try{
            conn.getConnect();

            String query = "UPDATE Tables SET NAME = ? WHERE  Id = ?";

            PreparedStatement stmt = conn.connect.prepareStatement(query);
            stmt.setInt(2, idTb);
            stmt.setString(1, nameTb);

            stmt.executeUpdate();

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    public boolean deleteTableById(int id){


        try{
            conn.getConnect();

            String query = "DELETE Tables WHERE Id = ? ORDER BY Name ASC ";

            PreparedStatement stmt = conn.connect.prepareStatement(query);
            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Inserted table: " + id);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;

    }

    public List<Table> searchTableByName(String tbName){

        conn.getConnect();

        List<Table> lstTable = new ArrayList<>();

        try {
            Statement stmt = conn.connect.createStatement();

            String query = "SELECT * FROM Tables WHERE Name Like \'%" + tbName  + "%\'" ;

            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int Id = rs.getInt("Id");
                String name = rs.getString("Name");
                int status = rs.getInt("Status");

                Table table = new Table(Id, name, status);

                lstTable.add(table);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return lstTable;
    }
     public Table searchTableById(int tbId){
            Table tb = new Table();
       
            conn.getConnect();

        

        try {
            Statement stmt = conn.connect.createStatement();

            String query = "SELECT * FROM Tables WHERE Id = " + tbId  + "" ;

            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int Id = rs.getInt("Id");
                String name = rs.getString("Name");
                int status = rs.getInt("Status");


              
                 tb = new Table(Id, name,status );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tb;
    }



    public boolean updateActiveTable(int idTb){
        try{
            conn.getConnect();

            String query = "UPDATE Tables SET Status = 1  WHERE  Id = ?";

            PreparedStatement stmt = conn.connect.prepareStatement(query);

            stmt.setInt(1, idTb);

            stmt.executeUpdate();

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;

    }

    public boolean tablePayment(int id){

        conn.getConnect();

        try {

            String query = "UPDATE  Tables SET Status = 0 WHERE Id = ? ";

            PreparedStatement stmt = conn.connect.prepareStatement(query);

            stmt.setInt(1,id);

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
