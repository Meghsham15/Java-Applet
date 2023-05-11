
import java.awt.event.*;
import javax.swing.*;

public class MenuBar {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Example");
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem form = new JMenuItem("Form");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        JTextArea ta = new JTextArea(10, 10);
        JScrollPane scrollPane = new JScrollPane(ta);

        // Add action listeners to menu items
        newItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle new file action
                System.out.println("New file clicked.");
            }
        });

        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle open file action
                System.out.println("Open file clicked.");
            }
        });

        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle save file action
                System.out.println("Save file clicked.");
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle exit action
                System.exit(0);
            }
        });

        cutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle cut action
                ta.cut();
                System.out.println("Cut clicked." + ta.getSelectedText());
            }
        });

        copyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle copy action
                ta.copy();
                System.out.println("Copy clicked." + ta.getSelectedText());
            }
        });

        pasteItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle paste action
                ta.paste();
                System.out.println("Paste clicked." + ta.getSelectedText());
            }
        });

        form.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle paste action
                ta.paste();
                System.out.println("Paste clicked." + ta.getSelectedText());
            }
        });

        // Add menu items to menus
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(form);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // Add menu bar to frame
        frame.add(scrollPane);
        frame.setJMenuBar(menuBar);

        // Set size and visibility of frame
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
