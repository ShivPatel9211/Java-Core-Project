
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spate
 */
public class Patient extends javax.swing.JFrame {

    /**
     * Creates new form Patient
     */
    
     Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public Patient() {
        initComponents();
        // con=dbconnect.java_db();
         //AutoId();
         //patientTable();
    }
    int id;
    String userName;
    String userType;
 public Patient(int id,String username,String usertype) {
        initComponents();
        this.id=id;
        this.userName=username;
        this.userType=usertype;
         con=dbconnect.java_db();
         AutoId();
         patientTable();
    }

 public void AutoId()
 {
         try {
             Statement s=con.createStatement();
             rs=s.executeQuery("select MAX(Patient_No) from Patient");
             rs.next();
             rs.getString("MAX(Patient_No)");
             if( rs.getString("MAX(Patient_No)")==null)
             {
                 jLabel7.setText("PS001");
             }
             
           else
             {
                 long id=Long.parseLong(rs.getString("MAX(Patient_No)").substring(2,rs.getString("MAX(Patient_No)").length()));
                 id++;
                 jLabel7.setText("PS"+String.format("%03d",id));
             }
             
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
         }
 }
    
    public void patientTable()
    {
         try {
             pst=con.prepareStatement("select *from Patient");
             rs=pst.executeQuery();
             ResultSetMetaData r=rs.getMetaData();
             int c;
             c=r.getColumnCount();
             DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
             df.setRowCount(0);
             while(rs.next())
             {
                 Vector v= new Vector();
                 for(int i=1;i<=c;i++)
                 {
                     v.add(rs.getString("Patient_No"));
                     v.add(rs.getString("Name"));
                     v.add(rs.getString("Phone"));
                     v.add(rs.getString("Address"));
                     
                 }
                 df.addRow(v);
             }
            
         } catch (SQLException ex) {
             Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(160, 250, 190, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient_No", "Patient Name", "Phone No", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(510, 250, 780, 350);

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(jTextField2);
        jTextField2.setBounds(160, 320, 240, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/male-user-add (1).png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.setIconTextGap(10);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(20, 720, 140, 50);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-update-64.png"))); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(170, 720, 180, 50);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-delete-bin-64.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(360, 720, 180, 50);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-home-48.png"))); // NOI18N
        jButton4.setText("Home");
        jButton4.setIconTextGap(10);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(550, 720, 160, 50);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(160, 470, 240, 80);

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(jTextField3);
        jTextField3.setBounds(160, 380, 240, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Patient Registation");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 550, 160);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 0));
        jLabel3.setText("Patient No");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 240, 290, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 0));
        jLabel4.setText("Phone No.");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 370, 290, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 0));
        jLabel5.setText("Patient Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 310, 290, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 0));
        jLabel6.setText("Address");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 490, 290, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sick-patient-sitting-bed-hospital-81419684.jpg"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1290, 820);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1292, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //add
        String id,name,address;
        String phone;
        id=jLabel7.getText();
        name=jTextField2.getText();
        phone=jTextField3.getText();
        address=jTextArea1.getText();
         
        try {
            pst=con.prepareStatement("insert into Patient(Patient_No,Name,Phone,Address )values(?,?,?,?)");
            pst.setString(1, id);
             pst.setString(2, name);
              pst.setString(3,phone);
               pst.setString(4, address);
               pst.executeUpdate();
               JOptionPane.showMessageDialog(this, "Patient is inserted");
               
               AutoId();
               
               jTextField2.setText("");
               jTextField3.setText("");
               
               jTextArea1.setText("");
               jTextField2.requestFocus();
               patientTable();
               
        } catch (Exception e) {
           JOptionPane.showMessageDialog(this,e.getMessage());
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        //Mouse Clicked
        DefaultTableModel d1= (DefaultTableModel)jTable1.getModel();
        int index  = jTable1.getSelectedRow();
        jLabel7.setText(d1.getValueAt(index,0).toString());
         jTextField2.setText(d1.getValueAt(index,1).toString());
          jTextField3.setText(d1.getValueAt(index,2).toString());
           jTextArea1.setText(d1.getValueAt(index,3).toString());
           jButton1.setEnabled(false);
           
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ///Update
           String id,name,address;
        String phone;
       
        name=jTextField2.getText();
        phone=jTextField3.getText();
        address=jTextArea1.getText();
          id=jLabel7.getText();
          
          
        try {
            pst=con.prepareStatement("update Patient set Name=?,Phone=?,Address=? where Patient_No=? ");

             pst.setString(1, name);
              pst.setString(2,phone);
               pst.setString(3, address);
                pst.setString(4, id);
                
                
               pst.executeUpdate();
               JOptionPane.showMessageDialog(this, "Patient updated successfully");
               
               AutoId();
               
               jTextField2.setText("");
               jTextField3.setText("");
               
               jTextArea1.setText("");
               jTextField2.requestFocus();
               patientTable();
               jButton1.setEnabled(true);
               
        } catch (Exception e) {
           JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //delete
           String id,name,address;
        String phone;
       
       
          id=jLabel7.getText();
          
          
        try {
            pst=con.prepareStatement("delete from Patient where Patient_No=? ");

           
                pst.setString(1, id);
                
                
               pst.executeUpdate();
               JOptionPane.showMessageDialog(this, "Patient deleted successfully");
               
               AutoId();
               
               jTextField2.setText("");
               jTextField3.setText("");
               
               jTextArea1.setText("");
               jTextField2.requestFocus();
               patientTable();
               jButton1.setEnabled(true);
               
        } catch (Exception e) {
           JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //Exit
         new Home(id,userName,userType).setVisible(true);
        this.dispose();
      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        //outside click
         AutoId();
         jTextField2.setText("");
               jTextField3.setText("");
               
               jTextArea1.setText("");
               jTextField2.requestFocus();
               patientTable();
               jButton1.setEnabled(true);
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
