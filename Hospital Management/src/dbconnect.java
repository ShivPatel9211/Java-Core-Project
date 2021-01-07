
import java.sql.*;
import javax.swing.JOptionPane;

public class dbconnect {
    public static Connection java_db()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
}
