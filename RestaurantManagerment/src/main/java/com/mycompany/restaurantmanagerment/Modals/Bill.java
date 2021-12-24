/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantmanagerment.Modals;

/**
 *
 * @author IO
 */
public class Bill {
    private int id;
    private int idCustomer;
    private int idTable;
    private String date;
    private int total ;
    private int status;

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", idCustomer=" + idCustomer +
                ", idTable=" + idTable +
                ", date='" + date + '\'' +
                ", total=" + total +
                ", status=" + status +
                '}';
    }

    public Bill() {
    }

    public Bill(int id, int idCustomer, int idTable, String date, int total, int status) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.idTable = idTable;
        this.date = date;
        this.total = total;
        this.status = status;
    }

    public Bill(int id, int idCustomer, int idTable, String date, int total) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.idTable = idTable;
        this.date = date;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
