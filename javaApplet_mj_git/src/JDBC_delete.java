import java.sql.*;

public class JDBC_delete {
   public static void main(String[] args) {
      String url = "jdbc:mysql://localhost/javamj"; // Replace mydatabase with your database name
      String user = "root"; // Replace myusername with your username
      String password = "123456789"; // Replace mypassword with your password
      
      try {
         
         // Open a connection
         Connection conn = DriverManager.getConnection(url, user, password);
         
         // Prepare the SQL statement
         String sql = "DELETE FROM javaDB WHERE Roll = ?";
         PreparedStatement stmt = conn.prepareStatement(sql);
         
         // Set the parameter
         stmt.setInt(1, 3224);
         
         // Execute the statement
         int rowsDeleted = stmt.executeUpdate();
         System.out.println(rowsDeleted + " row(s) deleted.");
         
         // Close the statement and connection
         stmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
