/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.restaurantmanagerment.View;

import com.mycompany.restaurantmanagerment.DAO.BillDetailDAO;
import com.mycompany.restaurantmanagerment.DAO.CustomerDAO;
import com.mycompany.restaurantmanagerment.DAO.FoodDAO;
import com.mycompany.restaurantmanagerment.DAO.TableDAO;
import com.mycompany.restaurantmanagerment.Modals.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author FX Long
 */
public class Home extends javax.swing.JFrame {

    List<Table> lstTable = new ArrayList<>();
    TableDAO tableDAO = new TableDAO();
    Table currTable = null;

    List<Food> lstFood = new ArrayList<>();
    FoodDAO foodDAO = new FoodDAO();
    Food currFood = null;

    CustomerDAO customerDAO = new CustomerDAO();
    List<Customer> lstCustomer = new ArrayList<>();
    Customer currCustomer = null;

    List<BillDetail> lstBillDetail = null;
    BillDetailDAO billDetailDAO = new BillDetailDAO();

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        lstFood = foodDAO.getAllFood();
        lstTable = tableDAO.getAllTables();
        lstCustomer = customerDAO.getAllCustomer();

        showListButtonTable();
        showFoodData();
        setCBCustomer();
    }

    void setCBCustomer(){

        lstCustomer = customerDAO.getAllCustomer();

        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) cbTenKh.getModel();

        comboBoxModel.removeAllElements();

        comboBoxModel.addElement( new CustomerCombobox(0, "select"));

        for(Customer c : lstCustomer){

            int id = c.getCustomerId();
            String name = c.getName();
            CustomerCombobox cbCate = new CustomerCombobox(id, name);

            comboBoxModel.addElement(cbCate);
        }

    }

    public void showListButtonTable() {

        pnTable.removeAll();

        ImageIcon icon = new ImageIcon("src/main/java/images/pngwing.com.png");

        for (Table table : lstTable) {

            System.out.println(table.toString());

            JButton btnTable = new JButton(table.getName());
            btnTable.setIcon(icon);

            if (table.getStatus() == 1) {
                btnTable.setBackground(Color.yellow);
            }

            btnTable.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    currTable = table;
//                    currBill = billDAO.getBillOnTable(table.getId());

                    lbTableName.setText(table.getName());
//
                    if(table.getStatus() == 1){
                        lbTbStatus.setText("active");
                    }
                    else{
                        lbTbStatus.setText("empty");
                    }

//                    bill = billDAO.getBillOnTable(table.getId());

//                    if(bill != null){
//                        System.out.println(bill.toString());
//
//                        txtIdBill.setText(String.valueOf(bill.getId()));
//                        txtIDKh.setText(String.valueOf(bill.getIdCustomer()));
//
//                        showBillData(bill.getId());
//                    }
//                    else{
//
//                        DefaultTableModel modal = (DefaultTableModel) tbBill.getModel();
//                        int rowCount = modal.getRowCount();
//                        //Remove rows one by one from the end of the table
//                        for (int i = rowCount - 1; i >= 0; i--) {
//                            modal.removeRow(i);
//                        }
//
//                        txtIdBill.setText("");
//                        txtIDKh.setText("");
//                    }
                }
            });

            pnTable.add(btnTable);

            System.out.println("add new table : " + table.getId());
        }

        pnTable.invalidate();
        pnTable.validate();
        pnTable.repaint();
    }

    public void showFoodData(){

        DefaultTableModel modal = (DefaultTableModel) tbFood.getModel();

        modal.setRowCount(0);

        for(Food food : lstFood){

            Vector vector = new Vector();

            vector.add(food.getId());
            vector.add(food.getName());
            vector.add(food.getCategoryName());
            vector.add(food.getPrice());
            vector.add(food.getDescription());
            vector.add(food.getImage());

            modal.addRow(vector);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnTable = new javax.swing.JPanel();
        pnKH = new javax.swing.JPanel();
        txtIdKh = new javax.swing.JTextField();
        txtKhName = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        cbTenKh = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBill = new javax.swing.JLabel();
        btnAddKh = new javax.swing.JButton();
        lbIdBill = new javax.swing.JLabel();
        lbTableName = new javax.swing.JLabel();
        lbTbStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBIll = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbFood = new javax.swing.JTable();
        txtTotalBill = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnOrder = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        btnBook = new javax.swing.JButton();
        btnDeleteOrder = new javax.swing.JButton();
        btnPayment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        pnTable.setBackground(new java.awt.Color(204, 255, 255));
        pnTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 204), 3, true));

        pnKH.setBackground(new java.awt.Color(102, 255, 255));

        txtSdt.setText("jTextField4");

        cbTenKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTenKhActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Table");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Status");

        txtBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBill.setText("Bill:");
        txtBill.setToolTipText("");

        btnAddKh.setText("+");

        lbIdBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbTableName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbTbStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnKHLayout = new javax.swing.GroupLayout(pnKH);
        pnKH.setLayout(pnKHLayout);
        pnKHLayout.setHorizontalGroup(
            pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKHLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKHLayout.createSequentialGroup()
                        .addComponent(txtBill)
                        .addGap(47, 47, 47)
                        .addComponent(lbIdBill))
                    .addGroup(pnKHLayout.createSequentialGroup()
                        .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnKHLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34)
                                .addComponent(lbTableName))
                            .addComponent(txtIdKh, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKhName, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnKHLayout.createSequentialGroup()
                                .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbTenKh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSdt, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddKh))
                            .addGroup(pnKHLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbTbStatus)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnKHLayout.setVerticalGroup(
            pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKHLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBill)
                    .addComponent(lbIdBill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(lbTableName)
                    .addComponent(lbTbStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTenKh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKhName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddKh))
                .addGap(8, 8, 8))
        );

        tbBIll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "Name", "Price", "Quantity", "Total"
            }
        ));
        jScrollPane1.setViewportView(tbBIll);

        tbFood.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Category", "Price"
            }
        ));
        jScrollPane2.setViewportView(tbFood);

        txtTotalBill.setText("0");

        btnOrder.setText("Order");

        jTextField2.setText("jTextField2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        btnBook.setText("Book");

        btnDeleteOrder.setText("Delete");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnBook)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteOrder)
                .addGap(21, 21, 21))
        );

        btnPayment.setText("Payment");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(pnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtTotalBill, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnPayment)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(pnKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPayment)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void cbTenKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTenKhActionPerformed
        // TODO add your handling code here:
        CustomerCombobox cb = (CustomerCombobox) cbTenKh.getSelectedItem();
        txtIdKh.setText(String.valueOf(cb.getId()));
        txtKhName.setText(cb.getName());
        if(cb.getId() != 0){
            currCustomer = customerDAO.getCustomerybyId(cb.getId());
            System.out.println(currCustomer.toString());
        }
        else{
            currCustomer = null;
        }
    }//GEN-LAST:event_cbTenKhActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddKh;
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnDeleteOrder;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnPayment;
    private javax.swing.JComboBox<String> cbTenKh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbIdBill;
    private javax.swing.JLabel lbTableName;
    private javax.swing.JLabel lbTbStatus;
    private javax.swing.JPanel pnKH;
    private javax.swing.JPanel pnTable;
    private javax.swing.JTable tbBIll;
    private javax.swing.JTable tbFood;
    private javax.swing.JLabel txtBill;
    private javax.swing.JTextField txtIdKh;
    private javax.swing.JTextField txtKhName;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTotalBill;
    // End of variables declaration//GEN-END:variables
}
