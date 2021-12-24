/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.restaurantmanagerment.View;

import com.mycompany.restaurantmanagerment.DAO.*;
import com.mycompany.restaurantmanagerment.Modals.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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

    BillDAO billDAO = new BillDAO();
    Bill  bill ;
    Bill currBill = null;


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

        this.setLocationRelativeTo(null);
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
                    currBill = billDAO.getBillOnTable(table.getId());


                    lbTableName.setText(table.getName());
//
                    if(table.getStatus() == 1){
                        lbTbStatus.setText("active");
                    }
                    else{
                        lbTbStatus.setText("empty");
                    }

                    if(currBill != null){

                        System.out.println(currBill.toString());

                        txtTotalBill.setText(String.valueOf(currBill.getTotal()));
                        lbIdBill.setText(String.valueOf(currBill.getId()));
                        txtIdKh.setText(String.valueOf(currBill.getIdCustomer()));

                        showBillData(currBill.getId());
                    }
                    else{

                        cleanTableBill();

                        lbIdBill.setText("");
                        txtIdKh.setText("");
                    }
                }
            });

            pnTable.add(btnTable);

            System.out.println("add new table : " + table.getId());
        }

        pnTable.invalidate();
        pnTable.validate();
        pnTable.repaint();
    }

    public void cleanTableBill(){

        DefaultTableModel modal = (DefaultTableModel) tbBIll.getModel();
        int rowCount = modal.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            modal.removeRow(i);
        }
    }

    public void showBillData( int billID){


        lstBillDetail = billDetailDAO.getBillDetailByIdBill(billID);

        DefaultTableModel modal = (DefaultTableModel) tbBIll.getModel();

        modal.setRowCount(0);
        int i = 1;

        for(BillDetail b : lstBillDetail){

            Vector vector = new Vector();

            vector.add(i);
            vector.add(b.getFoodName());
            vector.add(b.getFoodPrice());
            vector.add(b.getQuantity());
            vector.add(b.getTotal());

            modal.addRow(vector);

            i++;
        }
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
        btnHome = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
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
        txtQuantity = new javax.swing.JTextField();
        btnBook = new javax.swing.JButton();
        btnDeleteOrder = new javax.swing.JButton();
        btnPayment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Trajan Pro", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 51));
        jLabel3.setText("restaurent");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(317, 317, 317)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        pnTable.setBackground(new java.awt.Color(204, 255, 255));
        pnTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 204), 3, true));

        pnKH.setBackground(new java.awt.Color(102, 255, 255));

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
                                .addComponent(lbTbStatus))))
                    .addGroup(pnKHLayout.createSequentialGroup()
                        .addComponent(txtBill)
                        .addGap(47, 47, 47)
                        .addComponent(lbIdBill)))
                .addContainerGap(20, Short.MAX_VALUE))
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
        tbFood.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFoodMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbFood);

        txtTotalBill.setText("0");

        btnOrder.setText("Order");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        txtQuantity.setText("1");
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        btnBook.setText("Book");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

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
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnBook)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteOrder)
                .addGap(21, 21, 21))
        );

        btnPayment.setText("Payment");
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });

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
                .addContainerGap(36, Short.MAX_VALUE))
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

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void cbTenKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTenKhActionPerformed
        // TODO add your handling code here:
        CustomerCombobox cb = (CustomerCombobox) cbTenKh.getSelectedItem();

        if(cb.getId() != 0){
            txtIdKh.setText(String.valueOf(cb.getId()));
            txtKhName.setText(cb.getName());
            currCustomer = customerDAO.getCustomerybyId(cb.getId());
            System.out.println(currCustomer.toString());
        }
        else{
            currCustomer = null;
        }
    }//GEN-LAST:event_cbTenKhActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed

        if(currTable != null && currCustomer != null){
            if(currTable.getStatus() != 1){
                if(billDAO.insertBill(currCustomer.getCustomerId(), currTable.getId()
                ) ) {

                    tableDAO.updateActiveTable(currTable.getId());
                    lstTable = tableDAO.getAllTables();
                    showListButtonTable();
                    JOptionPane.showMessageDialog(this,"Ready to order for " + currTable.getName() );
                }
                else{
                    JOptionPane.showMessageDialog(this, "Error");
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Cannot Order with table has customer");
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Choose table and choose customer, please");
        }
            // TODO add your handling code here:
    }//GEN-LAST:event_btnBookActionPerformed

    private void tbFoodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFoodMouseClicked

        int  i = tbFood.getSelectedRow();
        TableModel model = tbFood.getModel();

        int id = (int) model.getValueAt(i,0);
        String name = model.getValueAt(i,1).toString();

        int price = (int) model.getValueAt(i,3);

        currFood = new Food(id,name, price);

        System.out.println(currFood.toString());
        // TODO add your handling code here:
    }//GEN-LAST:event_tbFoodMouseClicked

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed

        if(currBill != null && currFood !=null){


            int quantity = 1;
            if(!txtQuantity.getText().isBlank() ){
                if(Integer.parseInt(txtQuantity.getText()) != 0)
                quantity = Integer.parseInt(txtQuantity.getText());
            }
            int total = quantity * currFood.getPrice();

            if(billDetailDAO.insertBillDetail(currBill.getId(), currFood.getId(),quantity,total)){

                int totalPrice = billDetailDAO.getTotalPriceByBill(currBill.getId());
                System.out.println("Price " + totalPrice );

                billDAO.updateBillTotal(currBill.getId(),totalPrice);

                txtTotalBill.setText(String.valueOf(totalPrice));

                txtQuantity.setText("1");
                showBillData(currBill.getId());
                JOptionPane.showMessageDialog(this, "Ordered" + currFood.getName());
            }
            else{
                JOptionPane.showMessageDialog(this,"Error");
            }
        }
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        new MainForm().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {

        int choose = JOptionPane.showConfirmDialog(this, "Do you want to Payment  "
                        + currTable.getName(),
                "confirm", JOptionPane.YES_NO_OPTION);

        //delete action

        if (choose == JOptionPane.YES_OPTION) {

            if(billDAO.billPayment(currBill.getId())){
                if(tableDAO.tablePayment(currTable.getId())){

                    lstTable = tableDAO.getAllTables();
                    showListButtonTable();
                    cleanTableBill();
                    JOptionPane.showMessageDialog(this,"completed: " + currTable.getName()
                                                 + " payment");
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Paying fail : " + currTable.getName());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Paying fail : " + currTable.getName());
        }
    }                                          

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddKh;
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnDeleteOrder;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnPayment;
    private javax.swing.JComboBox<String> cbTenKh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTotalBill;
    // End of variables declaration//GEN-END:variables
}
