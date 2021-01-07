
import com.mysql.jdbc.Statement;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
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
public class Inventroy extends javax.swing.JFrame {

   
    
    
     Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public Inventroy() {
        initComponents();
         
    }
        String pid;
        String newid;
        int id;
        String userName;
        String userType;
     public Inventroy(String pid,int id,String username,String usertype) {
        initComponents();
        con=dbconnect.java_db();
        this.pid=pid;
        this.id=id;
        this.userName=username;
        this.userType=usertype;
        newid=pid;
        jLabel7.setText(pid);
        
    }
    
    public void sale()
    {
        DateTimeFormatter daa =DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now= LocalDateTime.now();
        String date=daa.format(now);
        
        String subtotal=jTextField3.getText();
        String paid=jTextField4.getText();

        String balance=jTextField5.getText();
        int lastinserted =0;
       
         try {
              String query="insert into sales(date,subtotal,paid,balance)values(?,?,?,?)";
             pst=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
             pst.setString(1, date);
             pst.setString(2, subtotal);
             pst.setString(3, paid);
             pst.setString(4, balance);
             pst.executeUpdate();
             
             
             rs= pst.getGeneratedKeys();
             if(rs.next())
             {
                lastinserted=rs.getInt(1);
                
               
             }
             
             int raws=jTable1.getColumnCount();
             String query1="insert into saleproduct(saleid,itemid,saleprice,qty,total)values(?,?,?,?,?)";
             pst=con.prepareStatement(query1);
             String saleid,itemid,itemname;
             
               int  saleprice;
             String qty;
             int total=0;
             for(int i=0;i<jTable1.getRowCount();i++)
             {
                 
                 saleid=(String)jTable1.getValueAt(i,0);
                 itemid=(String)jTable1.getValueAt(i,1);
                 qty=jTable1.getValueAt(i,3).toString();
                 int qty1=Integer.parseInt(qty);
                 saleprice=(int)jTable1.getValueAt(i,4);
                 total=(int)jTable1.getValueAt(i,5);
                 
                 pst.setInt(1, lastinserted);
                 pst.setString(2,itemid);
                 pst.setInt(3,qty1);
                 pst.setInt(4, saleprice);
                 pst.setInt(5, total);
                 
                 
                 pst.executeUpdate();
                 
                 JOptionPane.showMessageDialog(this,"Record added");
             }
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(Inventroy.class.getName()).log(Level.SEVERE, null, ex);
         }
        

        
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back.png"))); // NOI18N
        jButton4.setText("Back");
        jButton4.setIconTextGap(10);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(960, 400, 220, 80);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-home-96.png"))); // NOI18N
        jButton3.setText("Home");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(660, 400, 230, 80);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-add-96.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(90, 400, 230, 80);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-update-64.png"))); // NOI18N
        jButton2.setText("SalesUpdate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(380, 400, 220, 80);

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(jTextField3);
        jTextField3.setBounds(910, 200, 230, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prescription Id", "Drug Code", "Drug Name", "Quantity", "Price", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(60, 500, 1130, 310);

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(jTextField4);
        jTextField4.setBounds(910, 260, 230, 40);

        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(jTextField5);
        jTextField5.setBounds(910, 310, 230, 40);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(220, 200, 300, 40);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 0, 51));
        jLabel8.setText("Total Cost");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(770, 200, 220, 40);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 0, 51));
        jLabel9.setText("Paid");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(770, 260, 220, 40);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 0, 51));
        jLabel10.setText("Balance");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(770, 310, 230, 40);

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(jTextField2);
        jTextField2.setBounds(220, 260, 300, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(220, 130, 210, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 0));
        jLabel3.setText("Prescription Id");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 120, 190, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 0));
        jLabel4.setText("Drug Code");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 200, 170, 40);

        jSpinner1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(jSpinner1);
        jSpinner1.setBounds(220, 322, 100, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 0));
        jLabel5.setText("Drug Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 260, 170, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 0, 0));
        jLabel6.setText("Qunatity");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 320, 160, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Sales");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(550, 0, 210, 130);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/80433269-abstract-blur-background-of-goods-crate-on-metal-shelf-aisle-in-superstore-or-moderntrade-inventory-.jpg"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1300, 840);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        //key pressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            String itemid = jTextField1.getText();
            try {
                pst=con.prepareStatement("select *from item where itemno = ?");
                pst.setString(1, itemid);
                rs= pst.executeQuery();
                
                if(rs.next()==false)
                {
                    JOptionPane.showMessageDialog(this,"Drug is not found");
                }
                else
                {
                    String dname=rs.getString("itemname");
                    jTextField2.setText(dname.trim());
                    jSpinner1.requestFocus();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Inventroy.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // ADD
          String itemid = jTextField1.getText();
            try {
                pst=con.prepareStatement("select *from item where itemno = ?");
                pst.setString(1, itemid);
                rs= pst.executeQuery();
                 int currentqty,sellprice,qty;

                while(rs.next())
                {
             
                   currentqty=rs.getInt("quantity");
                   sellprice=rs.getInt("sellprice");
                   
                   qty=Integer.parseInt(jSpinner1.getValue().toString());
                   
                   int total = sellprice*qty;
                
                if(qty>=currentqty)
                {
                    JOptionPane.showMessageDialog(this,"Quntity is not enough");
                }
                else
                {
                     DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
                    df.addRow(new Object[]
                    {
                     jLabel7.getText(),
                     jTextField1.getText(),
                     jTextField2.getText(),
                     jSpinner1.getValue().toString(),
                     sellprice,
                     total,
                     
                     
      
                    
                    } );
                     int sum=0;
                     for(int i=0;i<jTable1.getRowCount();i++)
                     {
                         sum=sum+Integer.parseInt(jTable1.getValueAt(i,5).toString());
                         
                     }
                     jTextField3.setText(Integer.toString(sum));
                     jTextField1.setText("");
                        jTextField2.setText("");
                           jSpinner1.setValue(0);
                          jTextField1.requestFocus();
                     
                }
               }
           
                
            } catch (SQLException ex) {
                Logger.getLogger(Inventroy.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //salesupdates
        int total,paid,balance;
        total=Integer.parseInt(jTextField3.getText());
        paid =Integer.parseInt(jTextField4.getText());
        balance=total-paid;
        jTextField5.setText(Integer.toString(balance));
        sale();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
  
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // home
        new Home(id,userName,userType).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //
        new viewPrescription(id,userName,userType).setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventroy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
