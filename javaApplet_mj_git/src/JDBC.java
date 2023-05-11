import java.sql.*;

public class JDBC {

   public static void main(String[] args) {

      // JDBC connection variables
      String url = "jdbc:mysql://localhost:3306/javaMJ";
      String user = "root";
      String password = "123456789";

      // SQL query to execute
      String sql = "SELECT * FROM javaDB";

      try (Connection conn = DriverManager.getConnection(url, user, password);
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(sql)) {

         // Process the query results
         while (rs.next()) {
            String name = rs.getString("name");
            int roll = rs.getInt("Roll");
            String branch = rs.getString("Branch");
            int year = rs.getInt("Year");
            System.out.printf("Name - "+name);
            System.out.printf(", Roll - "+roll);
            System.out.printf(", Branch - "+branch);
            System.out.printf(", year - "+year);
            System.out.printf("\n");
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
