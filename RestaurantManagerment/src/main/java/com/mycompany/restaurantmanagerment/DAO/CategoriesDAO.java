package com.mycompany.restaurantmanagerment.DAO;

import com.mycompany.restaurantmanagerment.Controller.ConnectDB;
import com.mycompany.restaurantmanagerment.Modals.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAO {

    ConnectDB conn;

    public CategoriesDAO() {
        conn = new ConnectDB();
    }

    //    Get all Category
//    return List Category
    public List<Category>getAllCategories () {

        List<Category> lstCategory = new ArrayList<>();

        conn.getConnect();

        try {
            Statement stmt = conn.connect.createStatement();

            String query = "SELECT * FROM Categories";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int Id = rs.getInt("Id");
                String name = rs.getString("Name");

                Category cate = new Category(Id, name);

                lstCategory.add(cate);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }

        return lstCategory;
    }

    //     insert Category
//    param String name
    public void InsertCategory(String name) {

        conn.getConnect();

        try {

            String query = "INSERT INTO Categories VALUES(?)";

            PreparedStatement stmt = conn.connect.prepareStatement(query);
            stmt.setString(1, name);

            stmt.executeUpdate();

            System.out.println("Inserted: " + name);

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }

    }

    //    get category by id
    public Category getCategorybyId(int id) {

        conn.getConnect();

        Category cate = new Category();

        try {
            Statement stmt = conn.connect.createStatement();
            String query = "SELECT * FROM Categories WHERE Id = " + id;

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int Id = rs.getInt("Id");
                String name = rs.getString("Name");

                cate = new Category(Id, name);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }

        return cate;
    }

    public Category getCategorybyName(String name) {

        conn.getConnect();

        Category cate = new Category();

        try {
            Statement stmt = conn.connect.createStatement();
            String query = "SELECT * FROM Categories WHERE Name = \'" + name + "\'";

            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int Id = rs.getInt("Id");
                String nameCate = rs.getString("Name");

                cate = new Category(Id, nameCate);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }
        return cate;
    }

//    delete category
    public void deleteCategoryById(int id){
        conn.getConnect();

        try {

            String query = "DELETE FROM Categories WHERE Id =  ?";

            PreparedStatement stmt = conn.connect.prepareStatement(query);

            stmt.setInt(1,id);

            stmt.executeUpdate();

            System.out.println("Deleted: " + id);

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }
    }

//    update category

    public void updateCategoryById(int id, String name){

        conn.getConnect();

        try {

            String query = "UPDATE Categories SET  NAME = ? WHERE Id =  ?";

            PreparedStatement stmt = conn.connect.prepareStatement(query);
            stmt.setString(1,name);
            stmt.setInt(2,id);

            stmt.executeUpdate();

            System.out.println("Update complete " + id);

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }

    }

}
