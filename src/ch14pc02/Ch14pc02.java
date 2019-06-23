package ch14pc02;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/**
 * Applet to draw a house where a user can open or close the windows and door
 * 
 * @author frank
 */
public class Ch14pc02 extends Applet implements MouseListener, MouseMotionListener {
    // variables
    private boolean leftWindow, rightWindow, door;
    
    /**
     * Initialize the Applet
     */
    public void init() {
        // Set the values for variables
        leftWindow = false;
        rightWindow = false;
        door = false;
        
        setBackground(Color.WHITE);
        addMouseListener(this);
    }
    
    /**
     * Draw the house
     * @param g Graphics The Graphics object
     */
    public void paint(Graphics g) {
        super.paint(g);
        
        // Draw the house
        g.setColor(Color.BLACK);
        g.drawRect(100, 100, 200, 100);
        
        // Draw the roof
        g.drawLine(80, 100, 320, 100);
        g.drawLine(80, 100, 200, 40);
        g.drawLine(200, 40, 320, 100);
        
        // Draw the left window open.
        g.fillRect(120, 130, 40, 40);
        
        // Draw the right window open.
        g.fillRect(240, 130, 40, 40);
        
        // Draw the door open.
        g.fillRect(180, 130, 40, 70);
        
        if (leftWindow) {
            // Draw the left window closed.
            g.setColor(Color.WHITE);
            g.fillRect(120, 130, 40, 40);
            g.setColor(Color.BLACK);
            g.drawRect(120, 130, 40, 40);
            g.drawLine(140, 130, 140, 170);
            g.drawLine(120, 150, 160, 150);
        }
        
        if (rightWindow) {
           // Draw the right window closed.
           g.setColor(Color.WHITE);
           g.fillRect(240, 130, 40, 40);
           g.setColor(Color.BLACK);
           g.drawRect(240, 130, 40, 40);
           g.drawLine(260, 130, 260, 170);
           g.drawLine(240, 150, 280, 150);
        }
        
        if (door) {
           // Draw the door closed.
           g.setColor(Color.GREEN);
           g.fillRect(180, 130, 40, 70);
           g.setColor(Color.BLACK);
           g.drawRect(180, 130, 40, 70);
           g.fillOval(210, 165, 07, 07);
        }
    }
    
    /**
     * Method when the mouse is clicked
     * @param e MouseEvent The event when the mouse button is clicked
     */
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        boolean WindowLeft = (x >= 120 && x < 160 && y >= 130 && y <= 170);
        if (WindowLeft)
        {
           leftWindow = !leftWindow;
           repaint();               
        }

        boolean WindowRight = (x >= 240 && x < 280 && y >= 130 && y <= 170);
        if (WindowRight)
        {
           rightWindow = !rightWindow;
           repaint(); 
        }

        boolean Door = (x >= 180 && x < 220 && y >= 40 && y <= 200);
        if (Door)
        {            
           door = !door;
           repaint();     
        }
    }
    
    // Non-applicable mouse motion listeners
    public void mouseMoved(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
