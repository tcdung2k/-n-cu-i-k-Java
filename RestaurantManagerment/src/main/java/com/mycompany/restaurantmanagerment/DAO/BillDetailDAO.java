package com.mycompany.restaurantmanagerment.DAO;

import com.mycompany.restaurantmanagerment.Controller.ConnectDB;
import com.mycompany.restaurantmanagerment.Modals.BillDetail;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BillDetailDAO {

    public ConnectDB conn;

    public BillDetailDAO() {
        conn = new ConnectDB();
    }

    public List<BillDetail> getBillDetailByIdBill(int idBill){

        List<BillDetail> lstBillDetail = new ArrayList<>();

        try{
            conn.getConnect();
            Statement stmt = conn.connect.createStatement();

            String query = "SELECT detail.Id, detail.FoodId, food.Name , " +
                    "food.Price , detail.Quantity, detail.Total " +
                    "FROM OrderDetail detail join Foods food On detail.FoodId = food.Id " +
                    "WHERE detail.OrderId = " + idBill;

            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                int Id = rs.getInt("Id");
                int foodId = rs.getInt("FoodId");
                String name = rs.getString("Name");
                int price = rs.getInt("Price");
                int quantity = rs.getInt("Quantity");
                int total = rs.getInt("Total");

                BillDetail detail = new BillDetail(Id, foodId, name, price, quantity, total);

                lstBillDetail.add(detail);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }

        return lstBillDetail;

    }

    public boolean insertBillDetail(int idBill, int idFood, int quantity, int total){

        conn.getConnect();
        try {

            String query = "INSERT INTO OrderDetail VALUES(?,?,?,?)";

            PreparedStatement stmt = conn.connect.prepareStatement(query);
            stmt.setInt(1, idBill);
            stmt.setInt(2, idFood);
            stmt.setInt(3, quantity);
            stmt.setInt(4, total);

            stmt.executeUpdate();

            System.out.println("Inserted: " + idBill);

            return  true;

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }

        return false;
    }


    public boolean deleteOrderDetail(int id){

        conn.getConnect();

        try {

            String query = "DELETE FROM OrderDetail " +
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

    public BillDetail getDetailById(int id) {

        BillDetail billDetail = null;

        try{
            conn.getConnect();

            Statement stmt = conn.connect.createStatement();

            String query = "SELECT detail.Id, detail.FoodId, food.Name , " +
                    "food.Price , detail.Quantity, detail.Total " +
                    "FROM OrderDetail detail join Foods food On detail.FoodId = food.Id " +
                    "WHERE detail.Id = " + id;

            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                int Id = rs.getInt("Id");
                int foodId = rs.getInt("FoodId");
                String name = rs.getString("Name");
                int price = rs.getInt("Price");
                int quantity = rs.getInt("Quantity");
                int total = rs.getInt("Total");

                 billDetail = new BillDetail(Id, foodId, name, price, quantity, total);

            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            conn.closeConnect();
        }
        return billDetail;
    }

    public boolean updateDetailQuantity(int id, int quan){

        BillDetail detail = this.getDetailById(id);

        conn.getConnect();

        try {

            int total = detail.getFoodPrice() * quan;

            String query = "UPDATE OrderDetail SET Quantity = ? ,Total  = ? " +
                    " WHERE Id = ?";

            PreparedStatement stmt = conn.connect.prepareStatement(query);
            stmt.setInt(1,quan);
            stmt.setInt(2,total);
            stmt.setInt(3,id);

            stmt.executeUpdate();

            System.out.println("Deleted: " + id);

            return true;

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            conn.closeConnect();
        }
        return false;
    }

    public int getTotalPriceByBill(int idBill) {

        int result = 0;

        try {
            conn.getConnect();
            Statement stmt = conn.connect.createStatement();

            String query = "select Total From OrderDetail where OrderId = " + idBill;

            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                int price = rs.getInt("Total");

                result += price;

            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }
        System.out.println("total = " + result);
        return result;
    }

}