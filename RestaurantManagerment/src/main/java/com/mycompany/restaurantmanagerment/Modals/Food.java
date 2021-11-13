/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantmanagerment.Modals;

/**
 *
 * @author FX Long
 */
public class Food {
    
    private int Id;
    private String Name;
    private int Price;
    private int Categoty;
    private String Image;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getCategoty() {
        return Categoty;
    }

    public void setCategoty(int Categoty) {
        this.Categoty = Categoty;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
    
    

    public Food(int Id, String Name, int Price, int Categoty) {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
        this.Categoty = Categoty;
    }

    public Food(int Id, String Name, int Price, int Categoty, String Image) {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
        this.Categoty = Categoty;
        this.Image = Image;
    }

    public Food() {
    }

   
    
}
