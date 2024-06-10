/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package homework02sql;

import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SOL
 */
public class frmCustomers extends javax.swing.JFrame {

    /**
     * Creates new form frmCustomers
     */
    Connection con = null;

    public frmCustomers(Connection sqlpass) {
        initComponents();
        con = sqlpass;

        boolean check = isDbConnected(con);
        System.out.println(check);
        if (!check) {
            JOptionPane.showMessageDialog(null, "SQL Connection Failed or Interrupted.");
            return;
        }

        getCustomer(con);
    }

    private void getCustomer(Connection con) {

        DefaultTableModel tableModel = (DefaultTableModel) tblCustomers.getModel();
        try {
            Statement stmt = con.createStatement();
            //change name of schema for your datbase,
            ResultSet rs = stmt.executeQuery("SELECT * FROM new_schema.customers;");

            while (rs.next()) {
                //fetch data from sql datatable
                String id = rs.getString("customer_id");
                String first_Name = rs.getString("customer_first_name");
                String last_Name = rs.getString("customer_last_name");
                String address = rs.getString("customer_address");
                String city = rs.getString("customer_city");
                String state = rs.getString("customer_state");
                String zip = rs.getString("customer_zip");
                String phone = rs.getString("customer_phone");
                String fax = rs.getString("customer_fax");
                //add to table
                tableModel.addRow(new Object[]{id, first_Name, last_Name,
                    address, city, state, zip, phone, fax});
                //close statement on completion
                stmt.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: cannot retrieve the data table");
        }
    }
    
    //see frmMain for details
    public boolean isDbConnected(Connection con) {
        try {
            return con != null && !con.isClosed();
        } catch (SQLException ignored) {
        }

        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Database - Customer Table");

        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "customer_id", "customer_first_name", "customer_last_name", "customer_address", "customer_city", "customer_state", "customer_zip", "customer_phone", "customer_fax"
            }
        ));
        jScrollPane1.setViewportView(tblCustomers);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1124, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments *
     */
    //code from internet modified to check connection just in case it doesnt pass
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCustomers;
    // End of variables declaration//GEN-END:variables
}
