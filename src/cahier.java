
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Gipreel
 */
public class cahier extends javax.swing.JFrame  {

    /**
     * Creates new form cahier
     */
     DefaultTableModel dtm ;
      static String f_name ;
      static String c_n ; 
      static int ccc_id ;
      static boolean check; 

    public cahier() {
        initComponents();
         setLocationRelativeTo(null);
     dtm = new DefaultTableModel();
     Utility.ConnectToDB();
     dtm.addColumn("id");
     dtm.addColumn("name");
     dtm.addColumn("price");
     dtm.addColumn("type");
     dtm.addColumn("number_of_blisters");
     dtm.addColumn("current_quantity");
     dtm.addColumn("min_quantity");
     dtm.addColumn("drug_class");
     dtm.addColumn("supplier_id"); 
      f_name =  (String) d_f_name.getSelectedItem();
      c_n   = (String)c_name.getSelectedItem();
      check = c_check.isSelected();
     filltable();
     filldrugnamecombobox();
     fillcustomernamecombobox();
     fillemployeridcombobox();
     filldrugpricecombobox();
     set_id();

    }
    private void updatequantity(){
        try{
     PreparedStatement stmt = Utility.con.prepareStatement("update drug set current_quantity = current_quantity - 1  where name = ?  ");
            stmt.setString(1, f_name);
            stmt.executeUpdate();
            filltable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "failed");
        }
        
    }
    private void fillemployeridcombobox(){
   
      try {
         //   dtm.setRowCount(0);
            PreparedStatement stmt = Utility.con.prepareStatement("select id from employer where username = ?");
            stmt.setString(1, Login.username);
            ResultSet rs = stmt.executeQuery();
            
            
            

            
            while(rs.next()){
                
                e_id.setText(rs.getString(1));
               
                
            }
            //tbl_show.setModel(dtm);
        } catch (SQLException ex) {
            System.out.println("failed");
        }
     }
    private void set_id(){
    
    try{
    
     PreparedStatement stm = Utility.con.prepareStatement("select id from customer where name = ?");
             stm.setString(1,c_n );
            ResultSet rss = stm.executeQuery();
            
           
            
            while(rss.next()){
                
              ccc_id = (rss.getInt(1));
               
                
            }
    }
    catch(SQLException ex){
        System.out.println("erorr");
    }
    
    }
    
    private void fillcustomernamecombobox(){
   
      try {
         //   dtm.setRowCount(0);
            String query = "select name from customer ORDER BY id";
            ResultSet rs = Utility.ExecQuery(query);
            
            
            while(rs.next()){
                
                c_name.addItem(rs.getString(1));
               
                
            }
            //tbl_show.setModel(dtm);
        } catch (SQLException ex) {
            System.out.println("ffailed");
        }
     }
    
     
    
   
     private void filldrugnamecombobox(){
   
      try {
         //   dtm.setRowCount(0);
            String query = "select name from drug ORDER BY id";
            ResultSet rs = Utility.ExecQuery(query);
            
            
            while(rs.next()){
                
                d_f_name.addItem(rs.getString(1));
               
                
            }
            //tbl_show.setModel(dtm);
        } catch (SQLException ex) {
            System.out.println("ffffffailed");
        }
     }
      private void filldrugpricecombobox(){
   
      try {
         //   dtm.setRowCount(0);
            PreparedStatement stmt = Utility.con.prepareStatement("select price from drug order by id ");
            
            ResultSet rs = stmt.executeQuery();
            
            
            
            while(rs.next()){
                
                d_f_price.addItem(rs.getString(1));
               
                
            }
            //tbl_show.setModel(dtm);
        } catch (SQLException ex) {
            System.out.println("fffffffailed");
        }
     }
    public String get_d_name(){
    
    return (String) d_f_name.getSelectedItem();
    }
     private void filltable(){
         
              
        try {
            dtm.setRowCount(0);
            String query = "select id, name,price,type,number_of_blisters,current_quantity,min_quantity,drug_class,supplier_id from drug order by id";
            ResultSet rs = Utility.ExecQuery(query);
            
            
            while(rs.next()){
                
                dtm.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
                
            }
            tbl_show.setModel(dtm);
        } catch (SQLException ex) {
            System.out.println("faailed");
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_show = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        srch_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        type_txt = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        c_check = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        d_f_name = new javax.swing.JComboBox<>();
        c_name = new javax.swing.JComboBox<>();
        e_id = new javax.swing.JTextField();
        d_f_price = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(153, 153, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(102, 255, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-cashier-30.png"))); // NOI18N
        jLabel1.setText("Cashier Window");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-drug-30.png"))); // NOI18N
        jButton4.setText("Inventory");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(204, 204, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-view-40.png"))); // NOI18N
        jButton5.setText("View Bill");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(204, 204, 255));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-user-40.png"))); // NOI18N
        jButton6.setText("cusotmer");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(204, 204, 255));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 0));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-return-40.png"))); // NOI18N
        jButton7.setText("Return");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(204, 204, 255));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 0, 0));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-info-50.png"))); // NOI18N
        jButton8.setText("Info");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tbl_show.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_show);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Drug Name :");

        srch_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srch_txtActionPerformed(evt);
            }
        });
        srch_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                srch_txtKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Drug Type :");

        type_txt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "injection", "Tablet", "Liquid" }));
        type_txt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                type_txtItemStateChanged(evt);
            }
        });
        type_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_txtActionPerformed(evt);
            }
        });
        type_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                type_txtKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Drug full name  :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Customer name :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Employer Id  :");

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-user-male-30.png"))); // NOI18N
        jButton1.setText("Add customer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-cheque-30.png"))); // NOI18N
        jButton2.setText("Generate Bill");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-cash-register-30.png"))); // NOI18N
        jButton3.setText("Calculator");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        c_check.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        c_check.setForeground(new java.awt.Color(0, 0, 0));
        c_check.setText("New customer");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Drug price  :");

        d_f_name.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                d_f_nameItemStateChanged(evt);
            }
        });

        c_name.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c_nameItemStateChanged(evt);
            }
        });

        e_id.setEnabled(false);

        d_f_price.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(109, 109, 109)
                                        .addComponent(jButton1))
                                    .addComponent(c_check))
                                .addGap(123, 123, 123)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(d_f_name, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(c_name, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(73, 73, 73)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(37, 37, 37)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(e_id)
                                    .addComponent(d_f_price, 0, 220, Short.MAX_VALUE))))
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(srch_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(type_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(srch_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(type_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(d_f_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(d_f_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(c_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(e_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_check)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void type_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_type_txtActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      new Inventory().show();
       dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      new Edit().show();
       dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            new Edit().show();
             dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
          PharmacistDashboard newframe = new PharmacistDashboard();
          newframe.show();
          dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         new calc().show();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void srch_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srch_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srch_txtActionPerformed

    private void srch_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srch_txtKeyReleased
        // TODO add your handling code here:
            if(srch_txt.getText()!=null){
         try {
            String search = srch_txt.getText();
            dtm.setRowCount(0);
           //String query = String.format("select id, name,price,type,number_of_blisters,current_quantity,min_quantity,drug_class,supplier_id from drug WHERE name = '%s' ", search);
         //   ResultSet rs = Utility.ExecQuery(query);
            PreparedStatement stmt = Utility.con.prepareStatement("select id, name,price,type,number_of_blisters,current_quantity,min_quantity,drug_class,supplier_id from drug WHERE name LIKE ? ");
            stmt.setString(1,"%" +search + "%"); 
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                
                dtm.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
                
            }
            tbl_show.setModel(dtm);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        }
    }//GEN-LAST:event_srch_txtKeyReleased

    private void type_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_type_txtKeyReleased
        String search = (String) type_txt.getSelectedItem();  
        if(!"All".equals(search)){
         try {
           
            dtm.setRowCount(0);
           //String query = String.format("select id, name,price,type,number_of_blisters,current_quantity,min_quantity,drug_class,supplier_id from drug WHERE name = '%s' ", search);
         //   ResultSet rs = Utility.ExecQuery(query);
            PreparedStatement stmt = Utility.con.prepareStatement("select id, name,price,type,number_of_blisters,current_quantity,min_quantity,drug_class,supplier_id from drug WHERE type LIKE ? ");
            stmt.setString(1,"%" +search + "%"); 
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                
                dtm.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
                
            }
            tbl_show.setModel(dtm);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        }
        else{
        filltable();
        }
    }//GEN-LAST:event_type_txtKeyReleased

    private void type_txtItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_type_txtItemStateChanged
        // TODO add your handling code here:
          String search = (String) type_txt.getSelectedItem();  
        if(!"All".equals(search)){
         try {
           
            dtm.setRowCount(0);
           //String query = String.format("select id, name,price,type,number_of_blisters,current_quantity,min_quantity,drug_class,supplier_id from drug WHERE name = '%s' ", search);
         //   ResultSet rs = Utility.ExecQuery(query);
            PreparedStatement stmt = Utility.con.prepareStatement("select id, name,price,type,number_of_blisters,current_quantity,min_quantity,drug_class,supplier_id from drug WHERE type LIKE ? ");
            stmt.setString(1,"%" +search + "%"); 
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                
                dtm.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
                
            }
            tbl_show.setModel(dtm);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        }
        else{
        filltable();
        }
    }//GEN-LAST:event_type_txtItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
       f_name =  (String) d_f_name.getSelectedItem();
        c_n   = (String)c_name.getSelectedItem();
        int emp_id = Integer.parseInt( (String)e_id.getText());
         int d_price = Integer.parseInt((String)d_f_price.getSelectedItem());
         //ccc_id =  Integer.parseInt((String)c_idd.getSelectedItem());
         
         if(c_check.isSelected()){
         try {
            PreparedStatement stmt = Utility.con.prepareStatement("insert into payment (employer_id , cost ) values (?,?)");
            stmt.setInt(1,emp_id);
            stmt.setInt(2, d_price);
            stmt.executeUpdate();
            updatequantity();
            JOptionPane.showMessageDialog(this, "Purchased successfully");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "failed");
        }
         }
         else{
       
        try {
            set_id();
            PreparedStatement stmt = Utility.con.prepareStatement("insert into payment (employer_id , customer_id , cost ) values (?,?,?)");
            stmt.setInt(1,emp_id);
            stmt.setInt(2,ccc_id );
            stmt.setInt(3, d_price);
            stmt.executeUpdate();
            updatequantity();
            JOptionPane.showMessageDialog(this, "Purchased successfully");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "failed");
        }
         }
        generatebill newframe = new generatebill();
         newframe.show();
        //new Bill().show();
        //dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
new info().show();
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       new Bill().show();
       dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void d_f_nameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_d_f_nameItemStateChanged
         try {
         
          
            
            PreparedStatement stmt = Utility.con.prepareStatement("select price from drug where name = ?");
            stmt.setString(1, (String) d_f_name.getSelectedItem());
            ResultSet rs = stmt.executeQuery();
            
            
            
            while(rs.next()){
                
               d_f_price.setSelectedItem(rs.getString(1));
                
            }
            //tbl_show.setModel(dtm);
        } catch (SQLException ex) {
            System.out.println("failed");
        }
     
    }//GEN-LAST:event_d_f_nameItemStateChanged

    private void c_nameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_c_nameItemStateChanged
        set_id();
    }//GEN-LAST:event_c_nameItemStateChanged

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
            java.util.logging.Logger.getLogger(cahier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cahier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cahier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cahier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cahier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox c_check;
    private javax.swing.JComboBox<String> c_name;
    private javax.swing.JComboBox<String> d_f_name;
    private javax.swing.JComboBox<String> d_f_price;
    private javax.swing.JTextField e_id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField srch_txt;
    private javax.swing.JTable tbl_show;
    private javax.swing.JComboBox<String> type_txt;
    // End of variables declaration//GEN-END:variables
}
