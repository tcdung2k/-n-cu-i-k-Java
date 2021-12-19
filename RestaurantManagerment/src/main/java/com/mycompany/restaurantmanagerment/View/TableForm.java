/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.restaurantmanagerment.View;

import com.mycompany.restaurantmanagerment.DAO.TableDAO;
import com.mycompany.restaurantmanagerment.Modals.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FX Long
 */
public class TableForm extends javax.swing.JFrame {

    public List<Table> lstTable = new ArrayList<>();
    public TableDAO tableDAO = new TableDAO();

    /**
     * Creates new form NewJFrame
     */
    public TableForm() {
        initComponents();
        lstTable = tableDAO.getAllTables();
        showListButtonTable();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTbForm = new javax.swing.JPanel();
        pnBtnForm = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pnInputTable = new javax.swing.JPanel();
        javax.swing.JLabel lnIdTable = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbTableStatus = new javax.swing.JLabel();
        lbTableName = new javax.swing.JLabel();
        btnSearchTable = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnUpdateTable = new javax.swing.JButton();
        btnDeleteTable = new javax.swing.JButton();
        txtTableName = new javax.swing.JTextField();
        txtTableId = new javax.swing.JTextField();
        txtStatusTable = new javax.swing.JTextField();
        btnAddTable1 = new javax.swing.JButton();
        pnTable = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tabel Managerment");

        pnTbForm.setBackground(new java.awt.Color(255, 255, 255));

        pnBtnForm.setBackground(new java.awt.Color(102, 153, 255));

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Home");

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("Customer");

        javax.swing.GroupLayout pnBtnFormLayout = new javax.swing.GroupLayout(pnBtnForm);
        pnBtnForm.setLayout(pnBtnFormLayout);
        pnBtnFormLayout.setHorizontalGroup(
            pnBtnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBtnFormLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnBtnFormLayout.setVerticalGroup(
            pnBtnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBtnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(jButton3))
        );

        jLabel2.setFont(new java.awt.Font("Yu Mincho Light", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 204, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TABLE");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        pnInputTable.setBackground(new java.awt.Color(153, 255, 255));
        pnInputTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 0), new java.awt.Color(0, 255, 0), null, new java.awt.Color(51, 51, 0)));

        lnIdTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lnIdTable.setText("Id:");

        jLabel1.setBackground(new java.awt.Color(255, 102, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lbTableStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTableStatus.setText("Status:");

        lbTableName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTableName.setText("Name: ");

        btnSearchTable.setBackground(new java.awt.Color(204, 204, 255));
        btnSearchTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSearchTable.setText("Search");
        btnSearchTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchTableActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(102, 255, 102));
        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRefresh.setText("Add");
        btnRefresh.setToolTipText("");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnUpdateTable.setBackground(new java.awt.Color(153, 153, 255));
        btnUpdateTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdateTable.setText("Update");
        btnUpdateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTableActionPerformed(evt);
            }
        });

        btnDeleteTable.setBackground(new java.awt.Color(255, 153, 153));
        btnDeleteTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDeleteTable.setText("Delete");
        btnDeleteTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTableActionPerformed(evt);
            }
        });

        txtTableName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtTableId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtStatusTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnAddTable1.setBackground(new java.awt.Color(153, 255, 153));
        btnAddTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAddTable1.setText("Refresh");
        btnAddTable1.setToolTipText("");
        btnAddTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTable1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnInputTableLayout = new javax.swing.GroupLayout(pnInputTable);
        pnInputTable.setLayout(pnInputTableLayout);
        pnInputTableLayout.setHorizontalGroup(
            pnInputTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInputTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInputTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInputTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnInputTableLayout.createSequentialGroup()
                            .addGroup(pnInputTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lnIdTable, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbTableStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addGroup(pnInputTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTableId, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtStatusTable, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1))
                        .addComponent(btnUpdateTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearchTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddTable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnInputTableLayout.createSequentialGroup()
                        .addComponent(lbTableName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnInputTableLayout.setVerticalGroup(
            pnInputTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInputTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInputTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInputTableLayout.createSequentialGroup()
                        .addGap(0, 31, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(281, 281, 281))
                    .addGroup(pnInputTableLayout.createSequentialGroup()
                        .addGroup(pnInputTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lnIdTable, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTableId, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnInputTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTableStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnInputTableLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtStatusTable, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnInputTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSearchTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddTable1)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateTable)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteTable)
                        .addContainerGap())))
        );

        pnTable.setBackground(new java.awt.Color(204, 255, 255));
        pnTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 204), 3, true));

        javax.swing.GroupLayout pnTbFormLayout = new javax.swing.GroupLayout(pnTbForm);
        pnTbForm.setLayout(pnTbFormLayout);
        pnTbFormLayout.setHorizontalGroup(
            pnTbFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBtnForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnTbFormLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(pnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnTbFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTbFormLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(pnInputTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnTbFormLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        pnTbFormLayout.setVerticalGroup(
            pnTbFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTbFormLayout.createSequentialGroup()
                .addComponent(pnBtnForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnTbFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTbFormLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnInputTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTbForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTbForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public void showListButtonTable(){

        pnTable.removeAll();

        ImageIcon icon = new ImageIcon("src/main/java/images/pngwing.com.png");

        System.out.println(lstTable.size());
        for(Table table : lstTable){

            System.out.println("add new table : " + table.getId());

            JButton btnTable = new JButton(table.getName());
            btnTable.setIcon(icon);

            if(table.getStatus() == 1){
                btnTable.setBackground(Color.yellow);
            }

            btnTable.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e){
                    txtTableName.setText(table.getName());
                    txtStatusTable.setText(table.getStatus() + "");
                    txtTableId.setText(table.getId()+"");

                }
            });

            pnTable.add(btnTable);

        }

        pnTable.invalidate();
        pnTable.validate();
        pnTable.repaint();
    }

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed

        String name = " Table" + (lstTable.size() + 1);

        int select = JOptionPane.showConfirmDialog(this, "Do you want to Insert table?",
                                                "confirm", JOptionPane.YES_NO_OPTION);

        if(select == JOptionPane.YES_OPTION){

            Table table = new Table(name);
            if(tableDAO.insertTable(table)){
                JOptionPane.showMessageDialog(this,"Inserted Table : " + table.getName());

                lstTable = tableDAO.getAllTables();
                showListButtonTable();
            }
            else{
                JOptionPane.showMessageDialog(this,"Instert fail : " + table.getName());
            }

        }

    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnDeleteTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTableActionPerformed

        int id = Integer.parseInt(txtTableId.getText());

        //table status = 1 => not delete
        if(Integer.parseInt(txtStatusTable.getText()) == 1 ){
            JOptionPane.showMessageDialog(this,"Cannot delete a table with guests");
        }
        else {
            //create yes no message
            int choose = JOptionPane.showConfirmDialog(this, "Do you want to Delete table"
                            + id,
                    "confirm", JOptionPane.YES_NO_OPTION);

            //delete action
            if (choose == JOptionPane.YES_OPTION) {
                if (tableDAO.deleteTableById(id)) {
                    JOptionPane.showMessageDialog(this, "Deleted Table : " + id);

                    lstTable = tableDAO.getAllTables();
                    showListButtonTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Delete fail : " + id);
                }

            }
        }

    }//GEN-LAST:event_btnDeleteTableActionPerformed

    private void btnSearchTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchTableActionPerformed

        lstTable = tableDAO.searchTableByName(txtTableName.getText());
        
        System.out.println(lstTable);
        showListButtonTable();
    }//GEN-LAST:event_btnSearchTableActionPerformed

    private void btnUpdateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTableActionPerformed
        int id = Integer.parseInt(txtTableId.getText());
        String name = txtTableName.getText();

        int choose = JOptionPane.showConfirmDialog(this, "Do you want to UPdate table"
                        + id,
                "confirm", JOptionPane.YES_NO_OPTION);

        //delete action
        if (choose == JOptionPane.YES_OPTION) {
            if (tableDAO.updateTableByName(id,name)) {
                JOptionPane.showMessageDialog(this, "Updated Table : " + id);

                lstTable = tableDAO.getAllTables();
                showListButtonTable();
            } else {
                JOptionPane.showMessageDialog(this, "Update fail : " + id);
            }
        }

       
    }//GEN-LAST:event_btnUpdateTableActionPerformed

    private void btnAddTable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTable1ActionPerformed
        
        lstTable = tableDAO.getAllTables();
        showListButtonTable();
    }//GEN-LAST:event_btnAddTable1ActionPerformed

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
            java.util.logging.Logger.getLogger(TableForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTable1;
    private javax.swing.JButton btnDeleteTable;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearchTable;
    private javax.swing.JButton btnUpdateTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbTableName;
    private javax.swing.JLabel lbTableStatus;
    private javax.swing.JPanel pnBtnForm;
    private javax.swing.JPanel pnInputTable;
    private javax.swing.JPanel pnTable;
    private javax.swing.JPanel pnTbForm;
    private javax.swing.JTextField txtStatusTable;
    private javax.swing.JTextField txtTableId;
    private javax.swing.JTextField txtTableName;
    // End of variables declaration//GEN-END:variables
}