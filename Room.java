import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.lang.ClassLoader;

public class Office extends JFrame implements MouseListener {
    
    private JFrame frame;
    private BufferedImage image;
    private Container pane;
    private JPanel canvas;
    
    public Office() {
	setTitle("Office");
	setSize(700,900);
	setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = getContentPane();
	try {                
	    image = ImageIO.read(new File("office.jpg"));
	} catch (IOException ex) {
	    System.out.println("oops");
	}
	canvas = new Canvas();
	canvas.update(canvas.getGraphics());
	pane.add(canvas);
	canvas.addMouseListener(this);
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
	int x = e.getX();
	int y = e.getY();
	if ((x < 700 && x > 0) && (y < 700 && y > 0)) {
	    Scramble s = new Scramble();
	    s.setVisible(true);
	    System.out.println("yes");
	}

	
    }
    
    private class Canvas extends JPanel {
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
	}
    }
    
    public static void main(String[] args) {

	Office o = new Office();
	o.setVisible(true);
    }

}
