
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class Edit extends javax.swing.JFrame {
DefaultTableModel dtm ;
    /**
     * Creates new form AddUser
     */
    public Edit() {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         dtm = new DefaultTableModel();

        Utility.ConnectToDB();
     dtm.addColumn("id");
     dtm.addColumn("name");
     dtm.addColumn("address");
     dtm.addColumn("phone");
     filltable();
    }
       private void filltable(){
         
              
        try {
            dtm.setRowCount(0);
            String query = "select id, name,address,phone from customer order by id";
            ResultSet rs = Utility.ExecQuery(query);
            
            
            while(rs.next()){
                
                dtm.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)});
                
            }
            tbl_show.setModel(dtm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"failed");
        }
              
                   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form AddUseror.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        cust_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cust_phone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cust_adress = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_show = new javax.swing.JTable();
        save = new javax.swing.JButton();
        show_ALL = new javax.swing.JButton();
        cust_id = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Add Customer");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 860, 11));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        cust_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cust_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cust_nameActionPerformed(evt);
            }
        });
        cust_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cust_nameKeyReleased(evt);
            }
        });
        getContentPane().add(cust_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 300, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Mobile Number");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, -1, -1));

        cust_phone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(cust_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 300, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Id");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Address");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        cust_adress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(cust_adress, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 410, -1));

        update.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        update.setIcon(new javax.swing.ImageIcon("C:\\Users\\my computer\\OneDrive\\Desktop\\icons8-edit-15.png")); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 120, -1));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 800, 260));

        save.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 120, -1));

        show_ALL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        show_ALL.setIcon(new javax.swing.ImageIcon("C:\\Users\\my computer\\Downloads\\icons8-show-20.png")); // NOI18N
        show_ALL.setText("show All");
        show_ALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_ALLActionPerformed(evt);
            }
        });
        getContentPane().add(show_ALL, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 130, -1));

        cust_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(cust_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 300, -1));

        delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon("C:\\Users\\my computer\\Downloads\\icons8-delete-20.png")); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 120, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        dispose();
    }//GEN-LAST:event_closeActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        try {
            String name = cust_name.getText();
            String phone = cust_phone.getText();
            String address = cust_adress.getText();
            PreparedStatement stmt = Utility.con.prepareStatement("update customer set phone = ? , address = ? where name = ?  ");
            stmt.setString(1,phone);
            stmt.setString(2, address);
            stmt.setString(3, name);


            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "edited successfuly");
            filltable();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "failed");
        }
    }//GEN-LAST:event_updateActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        try {
            int id = Integer.parseInt(cust_id.getText());
            String name = cust_name.getText();
            String phone = cust_phone.getText();
            String adress = cust_adress.getText();
            PreparedStatement stmt = Utility.con.prepareStatement("insert into customer (id , name , phone , address ) values (?,?,?,?)");
            stmt.setInt(1,id);
            stmt.setString(2,name);
            stmt.setString(3,phone);
            stmt.setString(4, adress);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Added successfuly");
            filltable();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "failed");
        }
    }//GEN-LAST:event_saveActionPerformed

    private void show_ALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_ALLActionPerformed
        // TODO add your handling code here:
        filltable();
    }//GEN-LAST:event_show_ALLActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        try {
            String name = cust_name.getText();
            PreparedStatement stmt = Utility.con.prepareStatement("delete from customer where name = ?");
            stmt.setString(1,name);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "deleted successfuly");
            filltable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "failed");
        }
    

    }//GEN-LAST:event_deleteActionPerformed

    private void cust_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cust_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cust_nameActionPerformed

    private void cust_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cust_nameKeyReleased
        // TODO add your handling code here:
         if(cust_name.getText()!=null){
         try {
            String search = cust_name.getText();
            dtm.setRowCount(0);
           //String query = String.format("select id, name,price,type,number_of_blisters,current_quantity,min_quantity,drug_class,supplier_id from drug WHERE name = '%s' ", search);
         //   ResultSet rs = Utility.ExecQuery(query);
            PreparedStatement stmt = Utility.con.prepareStatement("select id, name,address,phone from customer WHERE name LIKE ? ");
            stmt.setString(1,"%" +search + "%"); 
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                
                dtm.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)});
                
            }
            tbl_show.setModel(dtm);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        }
    }//GEN-LAST:event_cust_nameKeyReleased

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
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JTextField cust_adress;
    private javax.swing.JTextField cust_id;
    private javax.swing.JTextField cust_name;
    private javax.swing.JTextField cust_phone;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton save;
    private javax.swing.JButton show_ALL;
    private javax.swing.JTable tbl_show;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
