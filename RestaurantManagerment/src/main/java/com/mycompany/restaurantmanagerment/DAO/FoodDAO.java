package com.mycompany.restaurantmanagerment.DAO;

import com.mycompany.restaurantmanagerment.Controller.ConnectDB;
import com.mycompany.restaurantmanagerment.Modals.Category;
import com.mycompany.restaurantmanagerment.Modals.Food;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FoodDAO {

    ConnectDB conn;

    public FoodDAO() {
        conn = new ConnectDB();
    }

    //get food by name

    public List<Food> searchFood(String sql){

        List<Food> lstFood = new ArrayList<>();
        conn.getConnect();

        try {

            Statement stmt = conn.connect.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Food food = new Food();
                food.setId(rs.getInt(1));
                food.setName(rs.getString(2));
                food.setCategory(rs.getInt(3));
                food.setCategoryName(rs.getString(4));
                food.setPrice(rs.getInt(5));
                food.setDescription(rs.getString(6));
                food.setImage(rs.getString(7));

                lstFood.add(food);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }

        return lstFood;
    }

    public  List<Food> getAllFood(){

        List<Food> lstFood = new ArrayList<>();
        conn.getConnect();

        try {

            String query = "SELECT A.Id, A.Name , B.Id, B.Name, Price, description, Image " +
                    "FROM Foods A JOIN Categories B ON A.Category = B.Id " ;

            Statement stmt = conn.connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Food food = new Food();
                food.setId(rs.getInt(1));
                food.setName(rs.getString(2));
                food.setCategory(rs.getInt(3));
                food.setCategoryName(rs.getString(4));
                food.setPrice(rs.getInt(5));
                food.setDescription(rs.getString(6));
                food.setImage(rs.getString(7));

                lstFood.add(food);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }

        return lstFood;
    }

    public Food searchFoodById(int id){
        conn.getConnect();
        Food food = new Food();
        try {

            String query = "SELECT A.Id, A.Name , B.Id, B.Name, Price, description, Image " +
                    "FROM Foods A JOIN Categories B ON A.Category = B.Id " +
                    "WHERE A.Id = " + id;

            Statement stmt = conn.connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                food.setId(rs.getInt(1));
                food.setName(rs.getString(2));
                food.setCategory(rs.getInt(3));
                food.setCategoryName(rs.getString(4));
                food.setPrice(rs.getInt(5));
                food.setDescription(rs.getString(6));
                food.setImage(rs.getString(7));

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }
        return food;
    }

    public List<Food> searchFoodByName(String name){

        List<Food> lstFood = new ArrayList<>();
        conn.getConnect();

        try {

            String query = "SELECT A.Id, A.Name , B.Id, B.Name, Price, description, Image " +
                    "FROM Foods A JOIN Categories B ON A.Category = B.Id " +
                    "WHERE A.Name LIKE N'%" + name+ "%'";

            Statement stmt = conn.connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Food food = new Food();
                food.setId(rs.getInt(1));
                food.setName(rs.getString(2));
                food.setCategory(rs.getInt(3));
                food.setCategoryName(rs.getString(4));
                food.setPrice(rs.getInt(5));
                food.setDescription(rs.getString(6));
                food.setImage(rs.getString(7));

                lstFood.add(food);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }

        return lstFood;
    }

    //get food by category
    public List<Food> searchFoodByCategory(int id){

        List<Food> lstFood = new ArrayList<>();
        conn.getConnect();

        try {

            String query = "SELECT A.Id, A.Name , B.Id, B.Name, Price, description, Image " +
                    "FROM Foods A JOIN Categories B ON A.Category = B.Id " +
                    "WHERE B.Id = " + id;

            Statement stmt = conn.connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Food food = new Food();
                food.setId(rs.getInt(1));
                food.setName(rs.getString(2));
                food.setCategory(rs.getInt(3));
                food.setCategoryName(rs.getString(4));
                food.setPrice(rs.getInt(5));
                food.setDescription(rs.getString(6));
                food.setImage(rs.getString(7));

                lstFood.add(food);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }

        return lstFood;
    }

    //Insert Food

    public boolean insertFood(Food food){

        conn.getConnect();

        try {

            String query = "INSERT  INTO Foods VALUES(?,?,?,?,?)";

            PreparedStatement stmt = conn.connect.prepareStatement(query);

            stmt.setString(1, food.getName());
            stmt.setInt(2, food.getCategory());
            stmt.setInt(3,food.getPrice());
            stmt.setString(4, food.getDescription());
            stmt.setString(5,food.getImage());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }

        return  false;
    }

    public boolean updateFood(Food food){

        conn.getConnect();

        try {

            String query = "UPDATE Foods SET Name = ? , Category = ? , Price = ? , Image = ?, " +
                    " description = ? " +
                    "WHERE  Id = ?";

            PreparedStatement stmt = conn.connect.prepareStatement(query);

            stmt.setString(1, food.getName());
            stmt.setInt(2, food.getCategory());
            stmt.setInt(3,food.getPrice());
            stmt.setString(4,food.getImage());
            stmt.setString(5, food.getDescription());
            stmt.setInt(6,food.getId());


            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }

        return false;
    }

    public boolean deleteFood(int id){

        conn.getConnect();

        try {

            String query = "DELETE FROM Foods " +
                    "WHERE  Id = ?";

            PreparedStatement stmt = conn.connect.prepareStatement(query);
            stmt.setInt(1,id);

            stmt.executeUpdate();

            System.out.println("Deleted: " + id);

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi truy vấn");
        } finally {
            conn.closeConnect();
        }
        return false;
    }

}
