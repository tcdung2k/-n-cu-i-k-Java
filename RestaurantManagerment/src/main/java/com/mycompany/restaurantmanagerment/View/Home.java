package com.mycompany.restaurantmanagerment.View;

import javax.swing.*;

public class Home {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTable table1;
    private JButton btnAddFood;
    private JButton btnDeleteFood;
    private JButton btnReset;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Home");
        frame.setSize(850,600);
        frame.setContentPane(new Home().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);
    }
}
