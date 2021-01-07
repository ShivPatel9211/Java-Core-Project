
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class Channel extends javax.swing.JFrame {

    /**
     * Creates new form Channel
     */
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public Channel() {
        initComponents();
          con=dbconnect.java_db();
          AutoId();
          loadDoctor(); 
          loadPatient();
          ChannelTable();

    }
    String userName;
      String userType;
      int id;
     public Channel(int id,String username,String usertype) {
        initComponents();
        
          this.userName=username;
        this.userType=usertype;
        this.id=id;
          con=dbconnect.java_db();
          AutoId();
          loadDoctor(); 
          loadPatient();
          ChannelTable();

    }
public class Doctor
{
    String id,name;
    public Doctor(String id,String name)
    {
        this.id=id;
        this.name=name;
        
    }
    public String toString()
    {
        return name;
    }
}

public class Patient
{
    String id,name;
    public Patient(String id,String name)
    {
        this.id=id;
        this.name=name;
        
    }
    public String toString()
    {
        return name;
    }
}

public void loadDoctor()
{
        try {
            pst=con.prepareStatement("select* from doctor");
            rs =pst.executeQuery();
            jComboBox1.removeAll();
            while(rs.next())
            {
                jComboBox1.addItem(new Doctor(rs.getString(1),rs.getString(2)));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Channel.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

public void loadPatient()
{
        try {
            pst=con.prepareStatement("select* from patient");
            rs =pst.executeQuery();
            jComboBox2.removeAll();
            while(rs.next())
            {
                jComboBox2.addItem(new Patient(rs.getString(1),rs.getString(2)));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Channel.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}



     public void AutoId()
 {
         try {
             Statement s=con.createStatement();
             rs=s.executeQuery("select MAX(channelno) from channel");
             rs.next();
             rs.getString("MAX(channelno)");
             if( rs.getString("MAX(channelno)")==null)
             {
                 jLabel8.setText("CH001");
             }
             
           else
             {
                 long id=Long.parseLong(rs.getString("MAX(channelno)").substring(2,rs.getString("MAX(channelno)").length()));
                 id++;
                 jLabel8.setText("CH"+String.format("%03d",id));
             }
             
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
         }
 }
     
     
     
      public void ChannelTable()
    {
         try {
             pst=con.prepareStatement("select *from channel");
  
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
                     v.add(rs.getString(1));
                     v.add(rs.getString(2));
                     v.add(rs.getString(3));
                     v.add(rs.getString(4));
                     v.add(rs.getString(5));
                   
                     
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
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-home-48.png"))); // NOI18N
        jButton3.setText("Home");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(460, 720, 170, 50);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Channel No.", "Doctor Name", "Patient name", "Room No", "Channel Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(440, 250, 680, 390);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Channel Date");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(60, 550, 190, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/male-user-add (1).png"))); // NOI18N
        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(50, 720, 160, 50);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-delete-bin-64.png"))); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(250, 720, 170, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Channel No.");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 270, 260, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Doctor Name");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 340, 250, 30);
        jPanel1.add(jDateChooser1);
        jDateChooser1.setBounds(220, 550, 130, 30);

        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(220, 340, 180, 30);

        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(220, 410, 180, 30);
        jPanel1.add(jSpinner1);
        jSpinner1.setBounds(220, 480, 100, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(220, 270, 200, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Patient Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 410, 280, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Room No.");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 480, 240, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("Channel Registation");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 770, 130);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/stock-photo-applicant-filling-in-company-application-form-document-applying-for-job-or-registering-claim-for-544810975.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1250, 830);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1133, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //del
         String id;
       
        id=jLabel8.getText();
       int room=Integer.parseInt(jSpinner1.getValue().toString());
       
        if(room!=0)
        {
           
        
        try {
            pst=con.prepareStatement("delete from channel where channelno=?");
            pst.setString(1, id);
               pst.executeUpdate();
              
               JOptionPane.showMessageDialog(this, "Channel is deleted");
               
               AutoId();
               
             jComboBox1.setSelectedIndex(-1);
             jComboBox2.setSelectedIndex(-1);
             
                  jSpinner1.setValue(0);
            ChannelTable();

              
               
              
               
        } catch (Exception e) {
           JOptionPane.showMessageDialog(this,e.getMessage());
        }
        }
        else
          JOptionPane.showMessageDialog(this, "Please select item first"); 
            
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //add
         String id,doctorname,patientname,room,channeldate;
       
        id=jLabel8.getText();
        doctorname=jComboBox1.getSelectedItem().toString();
        patientname=jComboBox2.getSelectedItem().toString();
           room=jSpinner1.getValue().toString();
           SimpleDateFormat dat=new SimpleDateFormat("yyyy-MM-dd");
           
           channeldate=dat.format(jDateChooser1.getDate());
       
         
        try {
            pst=con.prepareStatement("insert into channel(channelno,doctorname,patientname,room,date )values(?,?,?,?,?)");
            pst.setString(1, id);
             pst.setString(2, doctorname);
              pst.setString(3,patientname);
              pst.setString(4,room);
              pst.setString(5,channeldate);
         
               pst.executeUpdate();
               JOptionPane.showMessageDialog(this, "Channel is Added");
               
               AutoId();
               
             jComboBox1.setSelectedIndex(-1);
             jComboBox2.setSelectedIndex(-1);
             
                  jSpinner1.setValue(0);
            ChannelTable();

              
               
              
               
        } catch (Exception e) {
           JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         DefaultTableModel d1= (DefaultTableModel)jTable1.getModel();
        int index  = jTable1.getSelectedRow();
        jLabel8.setText(d1.getValueAt(index,0).toString());
        jComboBox1.setSelectedItem(d1.getValueAt(index,1).toString());
         jComboBox2.setSelectedItem(d1.getValueAt(index,2).toString());
          jSpinner1.setValue(Integer.parseInt(d1.getValueAt(index,3).toString()));
         
           
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // home
         new Home(id,userName,userType).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Channel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
