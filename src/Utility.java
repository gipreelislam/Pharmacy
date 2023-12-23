
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Utility {

    public static Connection con;
    public static String drugname ;
    public static int customerid  ;
    public static  int employerid ;
    public static int dprice ;
    public static Date ddt ;
   


    // Connection Function To DB pharmacy
    public static void ConnectToDB() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static ResultSet ExecQuery(String query) {
        try {
           ResultSet rs = con.prepareStatement(query).executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    // SHA1 Hashing Function
    public static String sha1(String input) {
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        } // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void set_payment(String drug_name ,int customer_id , int employer_id , int price) {
    drug_name = drugname; 
    customer_id =customerid;
    employer_id = employerid;
    price = dprice;
    
    }
     public static String get_drug_name() {
    return drugname; 
    
    }
      public static int get_cust_id() {
    return customerid; 
    
    }
       public static int get_empl_id() {
    return employerid; 
    
    }
         public static int get_d_price() {
    return dprice; 
    
    }
     public static Date get_date() {
      return ddt; 
    
    }
}
