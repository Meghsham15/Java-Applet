import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class Pages extends JApplet {
    private JMenuBar menuBar;
    private JMenu pageMenu;
    private JMenuItem page1Item, page2Item;
    private CardLayout cardLayout;
    private JPanel contentPanel;
    String url = "jdbc:mysql://localhost/javamj"; // Replace mydatabase with your database name
    String user = "root"; // Replace myusername with your username
    String password = "123456789";

    public void init() {
        // Create menu bar
        menuBar = new JMenuBar();

        // Create page menu
        pageMenu = new JMenu("Page");
        page1Item = new JMenuItem("Page 1");
        page1Item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "page1");
            }
        });
        page2Item = new JMenuItem("Page 2");
        page2Item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "page2");
            }
        });
        pageMenu.add(page1Item);
        pageMenu.add(page2Item);
        menuBar.add(pageMenu);

        // Create content panel with card layout
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.add(new Page1Panel(), "page1");
        contentPanel.add(new Page2Panel(), "page2");

        // Add components to applet
        setJMenuBar(menuBar);
        getContentPane().add(contentPanel);
    }

    private class Page1Panel extends JPanel {
        public Page1Panel() {
//show result 
            add(new JLabel("Page 1"));
            add(new JLabel("Page 1.1"));
            
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

                add(new JLabel(name,10));
                add(new JLabel(String.valueOf(roll)));
                add(new JLabel(branch));
                add(new JLabel(String.valueOf(year)));
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }
        }
    }

    private class Page2Panel extends JPanel {
        public Page2Panel() {

            JPanel labelPanel = new JPanel(new FlowLayout());
            JLabel nameLabel = new JLabel("Name:");
            JTextField nameField = new JTextField(20);
            labelPanel.add(nameLabel);
            labelPanel.add(nameField);
            JLabel Roll = new JLabel("RollNo:");
            JTextField RollN = new JTextField(20);
            labelPanel.add(Roll);
            labelPanel.add(RollN);
            JLabel Branch = new JLabel("Branch:");
            JTextField Brnh = new JTextField(20);
            labelPanel.add(Branch);
            labelPanel.add(Brnh);
            JLabel Year = new JLabel("Year:");
            JTextField Yr = new JTextField(20);
            labelPanel.add(Year);
            labelPanel.add(Yr);
            add(labelPanel);

            JPanel buttonPanel = new JPanel(new FlowLayout());
            JButton button = new JButton("Submit");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    int Year = Integer.parseInt(Yr.getText());
                    String Branch = Brnh.getText();
                    int Roll = Integer.parseInt(RollN.getText());
                    
                    try {
         // Register the JDBC driver
         
         // Open a connection
                         Connection conn = DriverManager.getConnection(url, user, password);
         
         // Prepare the SQL statement
                        String sql = "INSERT INTO javaDB (name, Roll, Branch,Year) VALUES (?, ?, ?, ?)";
                        PreparedStatement stmt = conn.prepareStatement(sql);
         
         // Set the parameters
                        stmt.setString(1, name);
                        stmt.setInt(2, Roll);
                        stmt.setString(3, Branch);
                        stmt.setInt(4, Year);
         // Execute the statement
                        int rowsInserted = stmt.executeUpdate();
                        System.out.println(rowsInserted + " row(s) inserted.");
         
         // Close the statement and connection
                        stmt.close();
                        conn.close();
                       } catch (SQLException ele) {
                            ele.printStackTrace();
                        }
                    }
                    });
                   buttonPanel.add(button);
                add(buttonPanel, BorderLayout.SOUTH);
        }
    }
}
