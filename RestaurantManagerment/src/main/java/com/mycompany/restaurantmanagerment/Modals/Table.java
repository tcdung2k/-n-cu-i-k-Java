/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantmanagerment.Modals;

public class Table {

    private int Id;
    private String name;
    private int status;

    public Table() {
    }

    public Table(int id, String name) {
        Id = id;
        this.name = name;
    }

    public Table(int id, String name, int status) {
        Id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
