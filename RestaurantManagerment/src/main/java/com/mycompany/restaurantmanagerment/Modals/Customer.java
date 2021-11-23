/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantmanagerment.Modals;

import java.io.Serializable;

/**
 *
 * @author Computer
 */
public class Customer implements Serializable{ // co the luu toan bo doi tuong lop Customer ra form
    private int customerId;
    private String name;
    private int age;
    private int sex;
    private String address;
    private String phone;
    private String email;

    public Customer(int customerId, String name, int age, int sex, String address, String phone, String email) {
        this.customerId = customerId;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.status = phone;
        this.email = email;

    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
