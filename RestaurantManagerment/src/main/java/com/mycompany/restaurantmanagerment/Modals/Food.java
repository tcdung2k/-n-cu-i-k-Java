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
    private int Category;
    private String CategoryName;
    private String Description;
    private String Image;

    public Food(int id, String name, int price, int category, String categoryName, String description, String image) {
        Id = id;
        Name = name;
        Price = price;
        Category = category;
        CategoryName = categoryName;
        Description = description;
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }


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

    public int getCategory() {
        return Category;
    }

    public void setCategory(int Category) {
        this.Category = Category;
    }

    public String getImage() {
        return Image;
    }

    @Override
    public String toString() {
        return "Food{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", Category=" + Category +
                ", CategoryName='" + CategoryName + '\'' +
                ", Description='" + Description + '\'' +
                ", Image='" + Image + '\'' +
                '}';
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
    
    

    public Food(int Id, String Name, int Price, int Category) {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
        this.Category = Category;
    }

    public Food(int id, String name, int price, int category, String categoryName, String image) {
        Id = id;
        Name = name;
        Price = price;
        Category = category;
        CategoryName = categoryName;
        Image = image;
    }

    public Food(int Id, String Name, int Price, int Category, String Image) {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
        this.Category = Category;
        this.Image = Image;
    }

    public Food() {
    }

   
    
}
