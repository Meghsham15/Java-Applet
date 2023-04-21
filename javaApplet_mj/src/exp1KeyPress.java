import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class exp1KeyPress extends Applet implements KeyListener {

    private String status = "";

    public void init() {
        addKeyListener(this);
        setFocusable(true);
    }

    public void paint(Graphics g) {
        g.drawString(status,20,20);
    }

    public void keyPressed(KeyEvent e) {
        status = "Meghsham Key Pressed: " + e.getKeyChar();
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        status = " Meghsham Key Released: " + e.getKeyChar();
        repaint();
    }

    public void keyTyped(KeyEvent e) {
//        status = "Key Typed: " + e.getKeyChar();
        repaint();
    }
}
