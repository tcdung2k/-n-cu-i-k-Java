package com.mycompany.restaurantmanagerment.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Food {
    private JPanel JPFood;
    private JTextField txtCategory;
    private JLabel categories;
    private JLabel price;
    private JLabel description;
    private JTextField txtPrice;
    private JTextField txtDescription;
    private JButton saveButton;
    private JTable tableFood;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JTextField txtID;
    private JTextField txtName;
    private JComboBox cbCategories;
    private JLabel name;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Food");
        frame.setContentPane(new Food().JPFood);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Food() {
       //Ham connect();
   //Ham table_load();
    //Thêm món ăn
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name,category,price,description;
                name = txtName.getText();
                category = cbCategories.getName();
                price = txtPrice.getText();
                description= txtDescription.getText();
        }
    });
        searchButton.addActionListener(new ActionListener() {//Tìm kiếm món ăn
            @Override
            public void actionPerformed(ActionEvent e) {

                String foodid =txtID.getText();



    }
});
        updateButton.addActionListener(new ActionListener() {//Sửa món ăn
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteButton.addActionListener(new ActionListener() {//Xóa món
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }



}