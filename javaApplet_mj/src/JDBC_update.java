import java.sql.*;

public class JDBC_update {
   public static void main(String[] args) {
      String url = "jdbc:mysql://localhost/javamj"; // Replace mydatabase with your database name
      String user = "root"; // Replace myusername with your username
      String password = "123456789"; // Replace mypassword with your password
      
      try {
         
         // Open a connection
         Connection conn = DriverManager.getConnection(url, user, password);
         
         // Prepare the SQL statement
         String sql = "UPDATE javaDB SET Name = ? WHERE Roll = ?";
         PreparedStatement stmt = conn.prepareStatement(sql);
         
         // Set the parameters
         stmt.setString(1, "Boi");
         stmt.setInt(2, 3219);
         
         // Execute the statement
         int rowsUpdated = stmt.executeUpdate();
         System.out.println(rowsUpdated + " row(s) updated.");
         
         // Close the statement and connection
         stmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
