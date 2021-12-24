/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.restaurantmanagerment.View;

import com.mycompany.restaurantmanagerment.DAO.CategoriesDAO;
import com.mycompany.restaurantmanagerment.DAO.FoodDAO;
import com.mycompany.restaurantmanagerment.Modals.Category;
import com.mycompany.restaurantmanagerment.Modals.CategoryCombobox;
import com.mycompany.restaurantmanagerment.Modals.Food;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.TableModel;

/**
 *
 * @author FX Long
 */
public class FoodForm extends javax.swing.JFrame {

    List<Food> lstFood = new ArrayList<>();
    FoodDAO foodDAO = new FoodDAO();

    String fileName = null;
    byte[] foodImage = null;

    File selectFile = null;

    final String FILE_PATH  = "src/main/java/images/food/" ;

    /**
     * Creates new form FoodForm
     */
    public FoodForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        setCBCategories();
        getListFood();
        showFoodData();
    }

    public void getListFood(){
        lstFood = foodDAO.getAllFood();
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

    void setCBCategories(){

        List<Category> lstCate = new ArrayList<>();

        CategoriesDAO cateDAO = new CategoriesDAO();

        lstCate = cateDAO.getAllCategories();

        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) cbCategory.getModel();

        comboBoxModel.removeAllElements();

        comboBoxModel.addElement( new CategoryCombobox(0, "select"));

        for(Category cate : lstCate){

            int id = cate.getId();
            String name = cate.getName();
            CategoryCombobox cbCate = new CategoryCombobox(id, name);

            comboBoxModel.addElement(cbCate);
        }

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnFoodForm = new javax.swing.JPanel();
        pnFoodDetail = new javax.swing.JPanel();
        pnFoodInput = new javax.swing.JPanel();
        lbIDFood = new javax.swing.JLabel();
        lbFoodName = new javax.swing.JLabel();
        lbCategory = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();
        lbDes = new javax.swing.JLabel();
        lbId = new javax.swing.JLabel();
        txFoodName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        cbCategory = new javax.swing.JComboBox<>();
        btnChooseFile = new javax.swing.JButton();
        lbFoodImage = new javax.swing.JLabel();
        pnFoodbtn = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFood = new javax.swing.JTable();
        pnTaskBar = new javax.swing.JPanel();
        btnMain = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnTable = new javax.swing.JButton();
        btnCustomer = new javax.swing.JButton();
        btnAccount = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Food Manage");
        setBackground(new java.awt.Color(255, 255, 255));

        pnFoodForm.setBackground(new java.awt.Color(255, 255, 255));

        pnFoodDetail.setBackground(new java.awt.Color(255, 255, 255));
        pnFoodDetail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(51, 51, 255), new java.awt.Color(0, 102, 153), null));

        pnFoodInput.setBackground(new java.awt.Color(204, 204, 255));
        pnFoodInput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        lbIDFood.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbIDFood.setText("ID:");

        lbFoodName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbFoodName.setText("Name");

        lbCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbCategory.setText("Category");

        lbPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbPrice.setText("Price");

        lbDes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDes.setText("Description");

        lbId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txFoodName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        cbCategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbCategory.setToolTipText("");

        btnChooseFile.setText("Choose File");
        btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseFileActionPerformed(evt);
            }
        });

        lbFoodImage.setBackground(new java.awt.Color(102, 51, 255));

        javax.swing.GroupLayout pnFoodInputLayout = new javax.swing.GroupLayout(pnFoodInput);
        pnFoodInput.setLayout(pnFoodInputLayout);
        pnFoodInputLayout.setHorizontalGroup(
            pnFoodInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFoodInputLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pnFoodInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIDFood)
                    .addComponent(lbFoodName)
                    .addComponent(lbCategory)
                    .addComponent(lbPrice)
                    .addComponent(lbDes))
                .addGap(36, 36, 36)
                .addGroup(pnFoodInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFoodInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbId)
                        .addComponent(txtPrice)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(cbCategory, 0, 118, Short.MAX_VALUE))
                    .addComponent(txFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnFoodInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFoodInputLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnChooseFile))
                    .addGroup(pnFoodInputLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lbFoodImage, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        pnFoodInputLayout.setVerticalGroup(
            pnFoodInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFoodInputLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(pnFoodInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFoodInputLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbFoodImage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChooseFile))
                    .addGroup(pnFoodInputLayout.createSequentialGroup()
                        .addGroup(pnFoodInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbIDFood)
                            .addComponent(lbId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnFoodInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFoodName)
                            .addComponent(txFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnFoodInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCategory)
                            .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(pnFoodInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPrice)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnFoodInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDes)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pnFoodbtn.setBackground(new java.awt.Color(153, 204, 255));
        pnFoodbtn.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 0, 153), null));

        btnSearch.setBackground(new java.awt.Color(204, 204, 255));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(153, 204, 255));
        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(204, 255, 204));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnAddActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnEdit.setBackground(new java.awt.Color(51, 255, 255));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnEditActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 102, 102));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFoodbtnLayout = new javax.swing.GroupLayout(pnFoodbtn);
        pnFoodbtn.setLayout(pnFoodbtnLayout);
        pnFoodbtnLayout.setHorizontalGroup(
            pnFoodbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFoodbtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(pnFoodbtnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFoodbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnFoodbtnLayout.setVerticalGroup(
            pnFoodbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFoodbtnLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnRefresh)
                .addGap(28, 28, 28)
                .addComponent(btnSearch)
                .addGap(26, 26, 26)
                .addComponent(btnAdd)
                .addGap(25, 25, 25)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 2, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("O");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.NE_RESIZE_CURSOR));
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 2, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("O");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.NE_RESIZE_CURSOR));
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel4.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 2, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("D");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.NE_RESIZE_CURSOR));
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel5.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 2, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("F");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.NE_RESIZE_CURSOR));
        jLabel5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnFoodDetailLayout = new javax.swing.GroupLayout(pnFoodDetail);
        pnFoodDetail.setLayout(pnFoodDetailLayout);
        pnFoodDetailLayout.setHorizontalGroup(
            pnFoodDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFoodDetailLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnFoodDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnFoodInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnFoodbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnFoodDetailLayout.setVerticalGroup(
            pnFoodDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFoodDetailLayout.createSequentialGroup()
                .addGroup(pnFoodDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFoodDetailLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnFoodDetailLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnFoodDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnFoodInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnFoodbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbFood.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbFood.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbFood.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Category", "Price", "Description", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbFood.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFoodMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbFood);
        if (tbFood.getColumnModel().getColumnCount() > 0) {
            tbFood.getColumnModel().getColumn(0).setHeaderValue("Id");
            tbFood.getColumnModel().getColumn(1).setHeaderValue("Name");
            tbFood.getColumnModel().getColumn(2).setHeaderValue("Category");
            tbFood.getColumnModel().getColumn(3).setHeaderValue("Price");
            tbFood.getColumnModel().getColumn(4).setHeaderValue("Description");
            tbFood.getColumnModel().getColumn(5).setHeaderValue("Image");
        }

        javax.swing.GroupLayout pnFoodFormLayout = new javax.swing.GroupLayout(pnFoodForm);
        pnFoodForm.setLayout(pnFoodFormLayout);
        pnFoodFormLayout.setHorizontalGroup(
            pnFoodFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFoodFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFoodFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnFoodDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        pnFoodFormLayout.setVerticalGroup(
            pnFoodFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFoodFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnFoodDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnTaskBar.setBackground(new java.awt.Color(153, 255, 255));

        btnMain.setText("Main menu");
        btnMain.setActionCommand("");
        btnMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainActionPerformed(evt);
            }
        });

        btnHome.setText("Home");

        btnTable.setText("Table");
        btnTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableActionPerformed(evt);
            }
        });

        btnCustomer.setText("Customer");

        btnAccount.setText("Account");

        javax.swing.GroupLayout pnTaskBarLayout = new javax.swing.GroupLayout(pnTaskBar);
        pnTaskBar.setLayout(pnTaskBarLayout);
        pnTaskBarLayout.setHorizontalGroup(
            pnTaskBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTaskBarLayout.createSequentialGroup()
                .addComponent(btnMain, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnTaskBarLayout.setVerticalGroup(
            pnTaskBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTaskBarLayout.createSequentialGroup()
                .addGroup(pnTaskBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMain)
                    .addComponent(btnHome)
                    .addComponent(btnTable)
                    .addComponent(btnCustomer)
                    .addComponent(btnAccount))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnFoodForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnTaskBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTaskBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnFoodForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbFoodMouseClicked(java.awt.event.MouseEvent evt) {

        CategoriesDAO cateDAO = new CategoriesDAO();

        int  i = tbFood.getSelectedRow();
        TableModel model = tbFood.getModel();

        int id = (int) model.getValueAt(i,0);
        
        lbId.setText(model.getValueAt(i,0).toString());
        txFoodName.setText(model.getValueAt(i,1).toString());

        //set combo box selected category by select row
        String cateName = model.getValueAt(i,2).toString();
        Category cate = cateDAO.getCategorybyName(cateName);
        DefaultComboBoxModel defaultComboBoxModel = (DefaultComboBoxModel) cbCategory.getModel();
        defaultComboBoxModel.setSelectedItem(new CategoryCombobox(cate.getId(),cate.getName()));

        txtPrice.setText(model.getValueAt(i,3).toString());
        if(model.getValueAt(i,4) != null){
            txtDescription.setText(model.getValueAt(i,4).toString());
        }else{
            txtDescription.setText("");
        }

        fileName = model.getValueAt(i,5).toString();

        System.out.println(fileName);

        String path = FILE_PATH + fileName;

        ImageIcon imageIcon = new ImageIcon( new ImageIcon(path)
                .getImage().getScaledInstance(lbFoodImage.getWidth(), lbFoodImage.getHeight(), Image.SCALE_SMOOTH));
        lbFoodImage.setIcon(imageIcon);
        //txtImage.setText(model.getValueAt(i,5).toString());
    }

    public void refreshInput(){
        lbId.setText(null);
        txFoodName.setText(null);
        txtDescription.setText(null);
        txtPrice.setText(null);
        cbCategory.setSelectedIndex(0);
    }

    public boolean validateInput(){

        CategoryCombobox categoryCombobox = (CategoryCombobox) cbCategory.getSelectedItem();

        if(txFoodName.getText().isBlank() || txtPrice.getText().isBlank()|| categoryCombobox.getId() == 0){
            return false;
        }
        return true;
    }

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed

        lbFoodImage.setIcon(null);
        getListFood();
        setCBCategories();
        refreshInput();
        showFoodData();
        fileName = null;
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnChooseFileActionPerformed(java.awt.event.ActionEvent evt) {

        try{
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);

            FileNameExtensionFilter filter = new FileNameExtensionFilter("img", "jpg","jpeg","png");

            fileChooser.addChoosableFileFilter(filter);

            int result = fileChooser.showSaveDialog(null);
             selectFile = fileChooser.getSelectedFile();
            fileName = selectFile.getName();

            if(fileName.endsWith(".png") || fileName.endsWith(".PNG") || fileName.endsWith("jpg")
                    || fileName.endsWith(".jpeg") || fileName.endsWith(".JPEG") || fileName.endsWith("jpg")
                    || fileName.endsWith(".img") || fileName.endsWith(".IMG")){

                String path = selectFile.getAbsolutePath();

                System.out.println(path);

                if(path != null){
                    ImageIcon imageIcon = new ImageIcon( new ImageIcon(path)
                            .getImage().getScaledInstance(lbFoodImage.getWidth(), lbFoodImage.getHeight(), Image.SCALE_SMOOTH));
                    lbFoodImage.setIcon(imageIcon);
                }
                else{
                    JOptionPane.showMessageDialog(this,"Cannot find path, please choose file againt");
                }

            }
            else{
                JOptionPane.showMessageDialog(this,"Choose Image file, Please!");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }                                             

    private void btnTableActionPerformed(java.awt.event.ActionEvent evt) {
        
        new TableForm().setVisible(true);
        this.setVisible(false);
    }                                        

    private void btnMainActionPerformed(java.awt.event.ActionEvent evt) {

        new MainForm().setVisible(true);
        this.setVisible(false);
    }                                       

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {

        String sql = "SELECT A.Id, A.Name , B.Id, B.Name, Price, description, Image \" +\n" +
                "         \"FROM Foods A JOIN Categories B ON A.Category = B.Id WHERE ";

        CategoryCombobox cb = (CategoryCombobox) cbCategory.getSelectedItem();
        int idCate = cb.getId();
        System.out.println(idCate);

        if(!txFoodName.getText().isBlank()){
            sql += " A.Name LIKE N\'%" + txFoodName.getText() + "%\'";

            if(cbCategory.getSelectedIndex() != 0 ){
                sql += " AND A.Category = " + idCate ;
            }
        }
        else{
            if(cbCategory.getSelectedIndex() != 0 ){
                sql += "  A.Category = " + idCate ;
            }
        }

        System.out.println(sql);
        lstFood = foodDAO.searchFood(sql);
        System.out.println(lstFood);
        showFoodData();
        refreshInput();

    }                                         

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) throws IOException {

        if(lbId.getText().isBlank() || !validateInput()){
            JOptionPane.showMessageDialog(this, "Choose food, Please");
        }
        else{

            int choose = JOptionPane.showConfirmDialog(this, "Do you want to Edit food: "
                            + lbId.getText(),
                    "confirm", JOptionPane.YES_NO_OPTION);

            //update action
            int id = Integer.parseInt(lbId.getText());
            if (choose == JOptionPane.YES_OPTION) {

                Food oldFood = foodDAO.searchFoodById(id);
                System.out.println(oldFood.toString());

                CategoryCombobox categoryCombobox = (CategoryCombobox) cbCategory.getSelectedItem();

                Food food = new Food();
                food.setCategory(categoryCombobox.getId());
                food.setId(id);
                food.setName(txFoodName.getText());
                food.setPrice(Integer.parseInt(txtPrice.getText()));
                food.setImage(fileName);
                food.setDescription(txtDescription.getText());

                if (foodDAO.updateFood(food)) {

                    if(selectFile != null) {
                        String newPath = FILE_PATH + fileName;
                        File newFile = new File(newPath);
                        if(newFile.exists()){
                            JOptionPane.showMessageDialog(this, "File is exist, cannot insert this image");
                        }
                        else{

                            //delete old image
                            String oldPath = FILE_PATH + oldFood.getImage();
                            File oldFile = new File(oldPath);
                            if(oldFile.exists()){
                                oldFile.delete();
                                System.out.println("deleted " + oldFood.getImage());
                            }

                            //insert new image
                            Files.copy(selectFile.toPath(), newFile.toPath());
                            System.out.println("copy file " + fileName);
                        }
                    }

                    JOptionPane.showMessageDialog(this, "Updated food : " + id);
                    lstFood = foodDAO.getAllFood();
                    showFoodData();
                    refreshInput();
                } else {
                    JOptionPane.showMessageDialog(this, "Update fail : " + id);
                }
            }
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {

        if(lbId.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Choose food, Please");
        }
        else{

            int choose = JOptionPane.showConfirmDialog(this, "Do you want to Delete food: "
                            + lbId.getText(),
                    "confirm", JOptionPane.YES_NO_OPTION);

            //delete action
            int id = Integer.parseInt(lbId.getText());
            if (choose == JOptionPane.YES_OPTION) {
                if (foodDAO.deleteFood(id)) {

                    String path = FILE_PATH + fileName;
                    File img = new File(path);
                    if(img.exists()){
                        img.delete();
                        System.out.println("image deleted");
                    }

                    JOptionPane.showMessageDialog(this, "Deleted food : " + id);
                    lstFood = foodDAO.getAllFood();
                    showFoodData();
                    refreshInput();
                } else {
                    JOptionPane.showMessageDialog(this, "Delete fail : " + id);
                }
            }
        }

    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) throws IOException {

        if(!validateInput()){
            JOptionPane.showMessageDialog(this,"Name, category, Price must be required");
        }
        else{
            Food food = new Food();

            food.setName(txFoodName.getText()) ;

            CategoryCombobox categoryCombobox = (CategoryCombobox) cbCategory.getSelectedItem();

            food.setCategory(categoryCombobox.getId());
            food.setPrice(Integer.parseInt(txtPrice.getText()));
            food.setDescription(txtDescription.getText());
            food.setImage(fileName);

            System.out.println(food.toString());

            String path = FILE_PATH + fileName;

            File newFile = new File(path);

            if(!newFile.exists() && selectFile != null){

                Files.copy(selectFile.toPath(), newFile.toPath());
            }
            else{
                JOptionPane.showMessageDialog(this, "Somthing went wrong!!!");
            }

            boolean result = foodDAO.insertFood(food);

            if(result){

                lstFood = foodDAO.getAllFood();
                showFoodData();
                JOptionPane.showMessageDialog(this,"Inserted Food Id: " + food.getName());
                refreshInput();
            }
            else {
                JOptionPane.showMessageDialog(this,"Insert Fail");
            }
        }

    }

    /**
     * @param args the command line arguments
     */
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChooseFile;
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnMain;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTable;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCategory;
    private javax.swing.JLabel lbDes;
    private javax.swing.JLabel lbFoodImage;
    private javax.swing.JLabel lbFoodName;
    private javax.swing.JLabel lbIDFood;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JPanel pnFoodDetail;
    private javax.swing.JPanel pnFoodForm;
    private javax.swing.JPanel pnFoodInput;
    private javax.swing.JPanel pnFoodbtn;
    private javax.swing.JPanel pnTaskBar;
    private javax.swing.JTable tbFood;
    private javax.swing.JTextField txFoodName;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
