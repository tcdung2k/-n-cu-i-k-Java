/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantmanagerment.DAO;

import com.mycompany.restaurantmanagerment.Controller.ConnectDB;
import com.mycompany.restaurantmanagerment.Modals.Bill;
import com.mycompany.restaurantmanagerment.Modals.Table;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IO
 */
public class BillDAO {
    
    ConnectDB conn ;

    public BillDAO() {
        this.conn = new ConnectDB();
    }

    public List<Bill> getAllBill(){

        List<Bill> lstBill = new ArrayList<>();

        try{
            conn.getConnect();

            Statement stmt = conn.connect.createStatement();

            String query = "SELECT * FROM Orders";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int Id = rs.getInt("Id");
                int idCustom = rs.getInt("CustomerId");
                int idTable = rs.getInt("TableId");
                String day = rs.getString("DayOrder");
                int total = rs.getInt("Total");
                int sttus = rs.getInt("Status");

                Bill bill = new Bill(Id, idCustom,idTable,day,total,sttus);

                lstBill.add(bill);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            conn.closeConnect();
        }
        return lstBill;
    }

    public Bill getBillOnTable(int idTable){

        Bill bill = null;

        try {
            conn.getConnect();

            String query = "select A.id, A.TableId, A.CustomerId, A.DayOrder, A.Status, A.Total " +
                        " from Orders A join Tables B on A.TableId = B.Id " +
                        " where B.Status = 1 and B.Id  = " + idTable;

            Statement stmt = conn.connect.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int Id = rs.getInt("Id");
                int idCustom = rs.getInt("CustomerId");
                int idTb = rs.getInt("TableId");
                String day = rs.getString("DayOrder");
                int total = rs.getInt("Total");
                int sttus = rs.getInt("Status");

                 bill = new Bill(Id, idCustom,idTb,day,total,sttus);

                 System.out.println(bill);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            conn.closeConnect();
        }

        return bill;
    }
    public List<Bill> getAllBillbyCustomer(int id){
        

        List<Bill> lstBill = new ArrayList<>();

        try{
            conn.getConnect();

            Statement stmt = conn.connect.createStatement();

            String query = "SELECT * FROM Orders Where CustomerId = " + id;;

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int Id = rs.getInt("Id");
                int idCustom = rs.getInt("CustomerId");
                int idTable = rs.getInt("TableId");
                String day = rs.getString("DayOrder");
                int total = rs.getInt("Total");
                int sttus = rs.getInt("Status");

                Bill bill = new Bill(Id, idCustom,idTable,day,total,sttus);

                lstBill.add(bill);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            conn.closeConnect();
        }
        return lstBill;
    }
          public List<Bill> getAllBillbyTable(int id){
        

        List<Bill> lstBill = new ArrayList<>();

        try{
            conn.getConnect();

            Statement stmt = conn.connect.createStatement();

            String query = "SELECT * FROM Orders Where TableId = " + id;;

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int Id = rs.getInt("Id");
                int idCustom = rs.getInt("CustomerId");
                int idTable = rs.getInt("TableId");
                String day = rs.getString("DayOrder");
                int total = rs.getInt("Total");
                int sttus = rs.getInt("Status");

                Bill bill = new Bill(Id, idCustom,idTable,day,total,sttus);

                lstBill.add(bill);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            conn.closeConnect();
        }
        return lstBill;
          }

    public boolean insertBill(int customerId, int idTable) {

        conn.getConnect();

        try {

            String query = "INSERT  INTO Orders (CustomerId,TableId,Total) values(?,?, 0)";

            PreparedStatement stmt = conn.connect.prepareStatement(query);

            stmt.setInt(1,customerId);
            stmt.setInt(2,idTable);

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }

        return  false;
    }

    public boolean updateBillTotal(int id ,int total){

        conn.getConnect();

        try {

            String query = "UPDATE  Orders SET Total = ? WHERE Id = ? ";

            PreparedStatement stmt = conn.connect.prepareStatement(query);

            stmt.setInt(1,total);
            stmt.setInt(2,id);

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.closeConnect();
        }

        return  false;
    }

    public boolean billPayment(int id){

        conn.getConnect();

        try {

            String query = "UPDATE  Orders SET Status = 1 WHERE Id = ? ";

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

