
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;

public class form extends Applet {

    public void init() {
        // Set applet size
        setSize(400, 200);
        String url = "jdbc:mysql://localhost/javamj"; // Replace mydatabase with your database name
        String user = "root"; // Replace myusername with your username
        String password = "123456789";
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add components to the JPanel
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(80, 30));
        JButton clearButton = new JButton("Clear");
        clearButton.setPreferredSize(new Dimension(80, 30));

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle paste action
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
                } catch (SQLException ele) {
                    ele.printStackTrace();
                }
                System.out.println("Paste clicked." + emailField.getText() + " " + nameField.getText());
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle paste action
                emailField.setText("");
                nameField.setText("");
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(submitButton);
        panel.add(clearButton);

        // Add the JPanel to the applet content pane
        add(panel);
    }

}
