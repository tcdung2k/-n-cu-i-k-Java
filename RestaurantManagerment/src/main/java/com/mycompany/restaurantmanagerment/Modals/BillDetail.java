package com.mycompany.restaurantmanagerment.Modals;

public class BillDetail {

    private int id;
    private int idBill;
    private int idFood;
    private String foodName;
    private int foodPrice;
    private int quantity;
    private int total;

    public BillDetail() {
    }

    @Override
    public String toString() {
        return "BillDetail{" +
                "id=" + id +
                ", idBill=" + idBill +
                ", idFood=" + idFood +
                ", foodName='" + foodName + '\'' +
                ", foodPrice=" + foodPrice +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }

    public BillDetail(int id, int idFood, String foodName, int foodPrice, int quantity, int total) {
        this.id = id;
        this.idFood = idFood;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.quantity = quantity;
        this.total = total;
    }

    public BillDetail(int id, int idBill, int idFood, String foodName, int foodPrice, int quantity, int total) {
        this.id = id;
        this.idBill = idBill;
        this.idFood = idFood;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.quantity = quantity;
        this.total = total;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public BillDetail(int id, int idBill, int idFood, int quantity, int total) {
        this.id = id;
        this.idBill = idBill;
        this.idFood = idFood;
        this.quantity = quantity;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}