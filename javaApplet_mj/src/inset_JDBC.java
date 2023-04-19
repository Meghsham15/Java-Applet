import java.sql.*;

public class inset_JDBC {
   public static void main(String[] args) {
      String url = "jdbc:mysql://localhost/javamj"; // Replace mydatabase with your database name
      String user = "root"; // Replace myusername with your username
      String password = "123456789"; // Replace mypassword with your password
      
      try {
         // Register the JDBC driver
         
         // Open a connection
         Connection conn = DriverManager.getConnection(url, user, password);
         
         // Prepare the SQL statement
         String sql = "INSERT INTO javaDB (name, Roll, Branch,Year) VALUES (?, ?, ?, ?)";
         PreparedStatement stmt = conn.prepareStatement(sql);
         
         // Set the parameters
         stmt.setString(1, "Insane");
         stmt.setInt(2, 3219);
         stmt.setString(3, "E&TC");
         stmt.setInt(4, 4);
         // Execute the statement
         int rowsInserted = stmt.executeUpdate();
         System.out.println(rowsInserted + " row(s) inserted.");
         
         // Close the statement and connection
         stmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
