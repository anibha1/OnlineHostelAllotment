import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class validateDSW
 {
     public static boolean checkUser(String username,String password) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.cj.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/HostelAllotementDB","root", "saurabh");
         PreparedStatement ps =con.prepareStatement
                             ("select * from dswdetail where dsw_name=? and password=?");
         ps.setString(1, username);
         ps.setString(2, password);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}