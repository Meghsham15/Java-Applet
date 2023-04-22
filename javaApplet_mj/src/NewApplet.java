/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Applet.java to edit this template
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author admin
 */
public class NewApplet extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void paint(Graphics g) {
        // TODO start asynchronous download of heavy resources
        g.fillRoundRect(50, 50, 150, 50, 30, 30);
        g.setColor(Color.red);
        Font myFont = new Font("Courier", Font.BOLD, 20);
        g.setFont(myFont);
        g.drawString("Meghsham", 80, 80);

    }

    // TODO overwrite start(), stop() and destroy() methods
}
