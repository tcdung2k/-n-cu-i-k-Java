package com.mycompany.restaurantmanagerment.DAO;

import com.mycompany.restaurantmanagerment.Controller.ConnectDB;
import com.mycompany.restaurantmanagerment.Modals.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO {
    Customer customer;
    ConnectDB conn;

    public CustomerDAO() {
        conn = new ConnectDB();
    }

    //    Get all Customer
    public List<Customer> getAllCustomer () {

        List<Customer> lstCustomer = new ArrayList<>();

        conn.getConnect();

        try {
            Statement stmt = conn.connect.createStatement();

            String query = "SELECT * FROM Customers";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int Id = rs.getInt("Id");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                int sex = rs.getInt("Gender");
                String address = rs.getString("Address");
                String phone = rs.getString("Phone");
                String email = rs.getString("Email");


                Customer cus = new Customer(Id, name, age, sex, address, phone, email);

                lstCustomer.add(cus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.closeConnect();
        }

        return lstCustomer;
    }
    //    get customer by id
    public Customer getCustomerybyId(int id) {

        Customer cus = new Customer();
        
        conn.getConnect();
        
        try {
            Statement stmt = conn.connect.createStatement();
            String query = "SELECT * FROM Customers WHERE Id = " + id;

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int Id = rs.getInt("Id");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                int sex = rs.getInt("Gender");
                String address = rs.getString("Address");
                String phone = rs.getString("Phone");
                String email = rs.getString("Email");

                cus = new Customer(Id, name, age, sex, address, phone, email);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.closeConnect();
        }
        return cus;
    }
    //     insert Customer
    public boolean InsertCustomer( String name, int age, int sex, String address, String phone, String email) {

        conn.getConnect();

        try {

            String query = "INSERT INTO Customers VALUES(?,?,?,?,?,?)";

            PreparedStatement stmt = conn.connect.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setInt(3, sex);
            stmt.setString(4, address);
            stmt.setString(5, phone);
            stmt.setString(6, email);

            stmt.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.closeConnect();
        }
        return false;
    }
    //    update customer
    public boolean updateCustomerById(Customer cus){

        conn.getConnect();

        try {

            String query = ("UPDATE Customers SET Name = ?, Age = ?, Gender = ?" +
                    "Address = ?, Phone = ?, Email = ?" +
                    "WHERE Id = ?");

            PreparedStatement stmt = conn.connect.prepareStatement(query);
            stmt.setInt(7, cus.getCustomerId());
            stmt.setString(1, cus.getName());
            stmt.setInt(2, cus.getAge());
            stmt.setInt(3, cus.getSex());
            stmt.setString(4, cus.getAddress());
            stmt.setString(5, cus.getPhone());
            stmt.setString(6, cus.getEmail());
            
            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.closeConnect();
        }
        return false;
    }
    //    delete customer
    public boolean deleteCustomerById(int id){
        conn.getConnect();

        try {

            String query = "DELETE FROM Customers WHERE Id =  ?";

            PreparedStatement stmt = conn.connect.prepareStatement(query);

            stmt.setInt(1,id);

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.closeConnect();
        }
        return false;
    }

}