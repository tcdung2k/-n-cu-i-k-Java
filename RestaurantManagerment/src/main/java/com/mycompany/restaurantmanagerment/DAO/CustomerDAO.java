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


                Customer cus = new Customer(Id, name,age, sex, address, phone, email);

                lstCustomer.add(cus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi truy vấn");
        } finally {
            conn.closeConnect();
        }

        return lstCustomer;
    }
    //     insert Customer
    public void InsertCustomer(String name, int age, int sex, String address, String phone, String email) {

        conn.getConnect();

        try {

            String query = "INSERT INTO Customers VALUES(?,?,?,?,?,?)";

            PreparedStatement stmt = conn.connect.prepareStatement(query);
            stmt.setString(1, name);
            stmt.getInt(2, age);
            stmt.getInt(3, sex);
            stmt.getString(4, address);
            stmt.getString(5, phone);
            stmt.getString(6, email);

            stmt.executeUpdate();

            System.out.println("Inserted: " + name);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi truy vấn");
        } finally {
            conn.closeConnect();
        }

    }
    //    get customer by id
    public Customer getCustomerybyId(int id) {

        conn.getConnect();

        Customer cus = new Customer();

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

                Customer cus = new Customer(Id, name,age, sex, address, phone, email);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi truy vấn");
        } finally {
            conn.closeConnect();
        }

        return cus;
    }

    //    update customer
    public void updateCustomerById(int id, String name, int age, int sex, String address, String phone, String email){

        conn.getConnect();

        try {

            String query = "UPDATE Customers SET  Name = ?, SET Age = ?, SET Gender = ?" +
                    "SET Address = ?, SET Phone = ?, SET Email = ?" +
                    " WHERE Id =  ?";

            PreparedStatement stmt = conn.connect.prepareStatement(query);
            stmt.setString(1,name);
            stmt.getInt(2, age);
            stmt.getInt(3, sex);
            stmt.getString(4, address);
            stmt.getString(5, phone);
            stmt.getString(6, email);
            stmt.executeUpdate();

            System.out.println("Update complete " + name);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi truy vấn");
        } finally {
            conn.closeConnect();
        }

    }
    //    delete customer
    public void deleteCustomerById(int id){
        conn.getConnect();

        try {

            String query = "DELETE FROM Customers WHERE Id =  ?";

            PreparedStatement stmt = conn.connect.prepareStatement(query);

            stmt.setInt(1,id);

            stmt.executeUpdate();

            System.out.println("Deleted: " + id);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi truy vấn");
        } finally {
            conn.closeConnect();
        }
    }

}